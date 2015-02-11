package sk.upjs.ics.JPMR;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author matusrubicky
 */
public class FMailer implements Runnable {

    String receiver;
    String verifyCode;
    String name;
    String password;

    public FMailer(String receiver, String verifyCode, String name, String password) {
        this.receiver = receiver;
        this.verifyCode = verifyCode;
        this.name = name;
        this.password = password;
    }

    //http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/

    public void sendMail() throws MessagingException {
        final String mailUserName = "jpmrcorp@gmail.com";
        final String mailUserPassword = "kukamefilmyeska";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");

        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailUserName, mailUserPassword);
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Filmarik a Filmuska <" + mailUserName + ">"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject("JPMR - Registračný kód");
        message.setText("Meno užívateľa: " + name + "\nHeslo užívateľa: " + this.password + "\nVerifikačný kód je: " + verifyCode);
        Transport transport = session.getTransport("smtps");
        transport.connect("smtp.gmail.com", 465, mailUserName, mailUserPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    @Override
    public void run() {
        try {
            sendMail();
        } catch (MessagingException ex) {
            Logger.getLogger(FMailer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package sk.upjs.ics.JPMR.DAO;

import java.util.List;
import sk.upjs.ics.JPMR.Message;

public interface MessageDAO {

    List<Message> getUserMessages(int IdU);

    void sendMessage(Message message, int iDSender, int iDReceiver);

    void setiDUser(int iDUser);

    int getUserIdForMessage(String name);

    int getiDUser();

    String getUserNameForMessage(int IdU);

    void deleteMessage(Message message);

    void setMessageToRead(Message message);

    void setMessageToRead(int iDMovie);

    int getNumberOfUnreadMessages(int IdU);

    public void sendRequest(String text, int iDSender, int iDReciever, int iDMovie);

}

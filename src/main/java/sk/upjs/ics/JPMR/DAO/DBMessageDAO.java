package sk.upjs.ics.JPMR.DAO;

import sk.upjs.ics.JPMR.DAO.MessageDAO;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.JPMR.Message;
import sk.upjs.ics.JPMR.User;

public class DBMessageDAO implements MessageDAO {

    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Message> messageMaper = new BeanPropertyRowMapper<>(Message.class);
    private BeanPropertyRowMapper<User> userMaper = new BeanPropertyRowMapper<>(User.class);

    private int iDUser;

    @Override
    public int getiDUser() {
        return iDUser;
    }

    /**
     * konštruktor
     * @param jdbcTemplate 
     */
    public DBMessageDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setiDUser(int iDUser) {
        this.iDUser = iDUser;
    }

    /**
     * načíta všetky prijaté správy pre používateľa zoradené podľa dátumu
     * @param IdU
     * @return 
     */
    @Override
    public List<Message> getUserMessages(int IdU) {
        return jdbcTemplate.query("SELECT * FROM Message M left join Users U on (M.iDSender=U.IdU) WHERE M.iDReceiver=? ORDER BY date DESC",
                messageMaper, IdU);
    }

    /**
     * vloží do databázy správu
     * @param message
     * @param iDSender
     * @param iDReceiver 
     */
    @Override
    public void sendMessage(Message message, int iDSender, int iDReceiver) {
        jdbcTemplate.update("INSERT INTO Message (iDSender, iDReceiver, object, text, date) VALUES(?, ?, ?, ?, DATE_FORMAT(NOW(), '%d-%m-%Y %H:%i:%s'))",
                iDSender, iDReceiver, message.getObject(), message.getText());
    }

    /**
     * posle ziadost o zmenu udajov o filme
     *
     * @param text
     * @param iDSender
     * @param iDReceiver
     * @param iDMovie
     */
    @Override
    public void sendRequest(String text, int iDSender, int iDReceiver, int iDMovie) {
        String object = "Žiadosť o zmenu údajov o filme";
        jdbcTemplate.update("INSERT INTO Message (iDSender, iDReceiver, object, text, date, iDMovie) VALUES(?, ?, ?, ?, DATE_FORMAT(NOW(), '%d-%m-%Y %H:%i:%s'), ?)",
                iDSender, iDReceiver, object, text, iDMovie);
    }

    /**
     * podľa mena nájde ID užívateľa
     * @param name
     * @return 
     */
    @Override
    public int getUserIdForMessage(String name) {
        List<User> l = jdbcTemplate.query("SELECT IdU FROM Users WHERE meno like ?", userMaper, name);
        if (l.isEmpty()) {
            return -1;
        } else {
            return l.get(0).getIdU();
        }
    }

    /**
     * nájde meno podľa ID
     * @param idu
     * @return 
     */
    @Override
    public String getUserNameForMessage(int idu) {
        System.out.println(idu);
        List<User> l = jdbcTemplate.query("SELECT meno FROM Users WHERE IdU = ?", userMaper, idu);
        return l.get(0).getMeno();
    }

    /**
     * zmaže správy ktoré už nehce mať používateľ v zozname
     * @param message 
     */
    @Override
    public void deleteMessage(Message message) {
        jdbcTemplate.update("DELETE FROM Message WHERE object like ? and text like ? and date like ?",
                message.getObject(), message.getText(), message.getDate());
    }

    /**
     * nastaví správu na "PREČÍTANÁ"
     * @param message 
     */
    @Override
    public void setMessageToRead(Message message) {
        System.out.println(message.getiDM());
        jdbcTemplate.update("UPDATE Message set readMess=1 WHERE iDM=?", message.getiDM());
    }

    /**
     * nastaví žiadosť o zmenu údajov o filme na "VYBAVENÁ"
     * @param iDMovie 
     */
    @Override
    public void setMessageToRead(int iDMovie) {
            jdbcTemplate.update("UPDATE Message set readMess=1 WHERE iDMovie=?", iDMovie);
        
    }

    /**
     * počet neprečítaných správa ... v súčasnej verzii nevyužitá
     * @param idu
     * @return 
     */
    @Override
    public int getNumberOfUnreadMessages(int idu) {
        return jdbcTemplate.queryForInt("SELECT count(*) FROM Message WHERE readMess=0 and iDReceiver = ?", idu);
    }

}

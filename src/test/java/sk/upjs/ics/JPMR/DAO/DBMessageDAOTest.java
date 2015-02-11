package sk.upjs.ics.JPMR.DAO;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.JPMR.Message;
import sk.upjs.ics.JPMR.User;

public class DBMessageDAOTest {
    
    private JdbcTemplate jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    private BeanPropertyRowMapper<Message> messageMaper = new BeanPropertyRowMapper<>(Message.class);
    private BeanPropertyRowMapper<User> userMaper = new BeanPropertyRowMapper<>(User.class);
    private MessageDAO messageDAO = DaoFactory.INSTANCE.getMessageDao();
    
    public DBMessageDAOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getUserMessages method, of class DBMessageDAO.
     */
    @Test
    public void testGetUserMessages() {
        System.out.println("getUserMessages");
        int IdU = 0;
        DBMessageDAO instance = null;
        int expResult = 55;
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Message WHERE iDReceiver=1");
        assertEquals(expResult, result);
    }

    /**
     * Test of sendMessage method, of class DBMessageDAO.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Message message = new Message();
        message.setObject("testObject");
        message.setText("testText");
        int iDSender = 1;
        int iDReceiver = 1;
        int expResult = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Message WHERE iDReceiver=1");
        messageDAO.sendMessage(message, iDSender, iDReceiver);
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Message WHERE iDReceiver=1");
        assertEquals(expResult+1, result);
    }

    /**
     * Test of getUserIdForMessage method, of class DBMessageDAO.
     */
    @Test
    public void testGetUserIdForMessage() {
        System.out.println("getUserIdForMessage");
        String name = "admin";
        int expResult = 1;
        int result = messageDAO.getUserIdForMessage(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserNameForMessage method, of class DBMessageDAO.
     */
    @Test
    public void testGetUserNameForMessage() {
        System.out.println("getUserNameForMessage");
        int idu = 1;
        String expResult = "admin";
        String result = messageDAO.getUserNameForMessage(idu);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfUnreadMessages method, of class DBMessageDAO.
     */
    @Test
    public void testGetNumberOfUnreadMessages() {
        System.out.println("getNumberOfUnreadMessages");
        int idu = 0;
        DBMessageDAO instance = null;
        int expResult = 32;
        int result = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Message WHERE iDReceiver=1 AND readMess=0");
        assertEquals(expResult, result);
    }
    
}

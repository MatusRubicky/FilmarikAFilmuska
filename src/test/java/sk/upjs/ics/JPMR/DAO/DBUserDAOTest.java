package sk.upjs.ics.JPMR.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.User;

/**
 *
 * @author Uživateľ
 */
public class DBUserDAOTest {

    private JdbcTemplate jdbcTemplate = DaoFactory.INSTANCE.getJdbcTemplate();
    private BeanPropertyRowMapper<Movie> movieMapper = new BeanPropertyRowMapper<>(Movie.class);
    private BeanPropertyRowMapper<User> mapovacUser = new BeanPropertyRowMapper<>(User.class);
    private int IDUser;

    public DBUserDAOTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of register method, of class DBUserDAO.
     */
    @Test
    public void testRegister() {

        String tName = "testName";
        String tPasswd = "testPasswd";
        
        jdbcTemplate.update("DELETE FROM Users WHERE meno = ? AND Heslo = ?", tName, tPasswd);

        int count1 = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Users");
        Map<String, Object> userValues = new HashMap<>();
        userValues.put("meno", tName);
        userValues.put("Heslo", tPasswd);
        userValues.put("typ", 1);

        SimpleJdbcInsert insertUser = new SimpleJdbcInsert(jdbcTemplate);
        insertUser.setTableName("Users");
        insertUser.execute(userValues);
        
        int count2 = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Users");
        jdbcTemplate.update("DELETE FROM Users WHERE meno = ? AND Heslo = ?", tName, tPasswd);
        
        assertEquals(count1 + 1, count2);        
    }

    /**
     * Test of getUserMovies method, of class DBUserDAO.
     */
    @Test
    public void testGetUserMovies_int() {
        System.out.println("getUserMovies");
        int IdU = 1;
        int testRes = 4;
        List<Movie> result = jdbcTemplate.query("SELECT * FROM Filmy F left join Spoj S on (F.ID=S.IdF)"
                + " where F.ID = S.IdF and S.IdU = ?", movieMapper, IdU);
        assertEquals(testRes, result.size());
    }  

    /**
     * Test of getAllUsers method, of class DBUserDAO.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        int testRes = 5;
        List<User> result = jdbcTemplate.query("SELECT * FROM Users", mapovacUser);
        assertEquals(testRes, result.size());
    }

}

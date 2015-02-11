package sk.upjs.ics.JPMR.DAO;

import sk.upjs.ics.JPMR.DAO.UserDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.JPMR.FMailer;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.User;

public class DBUserDAO implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Movie> movieMapper = new BeanPropertyRowMapper<>(Movie.class);
    private BeanPropertyRowMapper<User> mapovacUser = new BeanPropertyRowMapper<>(User.class);
    private int IDUser;

    public DBUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setUser(int User) {
        this.IDUser = User;
    }

    /**
     * insert nového používateľa do databázy
     * @param name
     * @param password
     * @return 
     */
    @Override
    public boolean register(String name, String password) {
        if (isNotUser(name)) {
            Map<String, Object> userValues = new HashMap<>();
            userValues.put("meno", name);
            userValues.put("Heslo", password);
            userValues.put("typ", 1);

            SimpleJdbcInsert insertUser = new SimpleJdbcInsert(jdbcTemplate);
            insertUser.setTableName("Users");
            insertUser.execute(userValues);
            return true;
        }
        return false;
    }

    /**
     * kontrola existencie mena pred registráciou
     * @param name
     * @return 
     */
    private boolean isNotUser(String name) {
        //skontroluje ci sa uz taky user nenachadza v db, ak sa nachadza, tak noveho nezaregistruje
        int p = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Users WHERE meno = ?", name);
        return (p == 0);
    }

    /**
     * načítanie filmov, ktoré má v tabuľke Spoj priradené daný uživateľ
     * @param IdU
     * @return 
     */
    @Override
    public List<Movie> getUserMovies(int IdU) {
        return jdbcTemplate.query("SELECT * FROM Filmy F left join Spoj S on (F.ID=S.IdF)"
                + " where F.ID = S.IdF and S.IdU = ?", movieMapper, IdU);
    }

    /**
     * načítanie filmov, ktoré má v tabuľke Spoj priradené daný uživateľ podľa názvu
     * @param IdU
     * @param movieTitle
     * @return 
     */
    @Override
    public List<Movie> getUserMovies(int IdU, String movieTitle) {
        return jdbcTemplate.query("SELECT * FROM Filmy F left join Spoj S on (F.ID=S.IdF)"
                + " where F.ID = S.IdF and S.IdU = ? and F.meno like ?", movieMapper, IdU, movieTitle);
    }

    /**    
     * @param name
     * @param password
     * @return
     */
    @Override
    public int logIn(String name, String password) {
        List<User> accountList = jdbcTemplate.query(
                "SELECT * FROM Users WHERE meno = ? and Heslo = ?", mapovacUser, name, password
        );
        return accountList.get(0).getIdU();
    }

    @Override
    public int getUser() {
        return IDUser;
    }

    /**
     * odoslanie verifikačného e-mailu
     * @param receiver
     * @param verifyCode
     * @param name
     * @param password
     * @throws MessagingException 
     */
    public void sendMessage(String receiver, String verifyCode, String name, String password) throws MessagingException {
        new Thread(new FMailer(receiver, verifyCode, name, password)).start();
    }

    /**
     * načítanie všetkých užívateľov do zoznamu
     * @param searchedUser
     * @return 
     */
    @Override
    public List<User> getAllUsers(String searchedUser) {
        if (searchedUser == null){
            return jdbcTemplate.query("SELECT * FROM Users", mapovacUser);
        } else {
            return jdbcTemplate.query("SELECT * FROM Users WHERE meno like ? ORDER BY IdU", mapovacUser, searchedUser);
        }
    }
}

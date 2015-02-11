package sk.upjs.ics.JPMR.DAO;

import sk.upjs.ics.JPMR.DAO.MessageDAO;
import sk.upjs.ics.JPMR.DAO.MovieManagerDAO;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DaoFactory {

    INSTANCE;

    private DBMovieManagerDAO dBMovieManagerDAO;
    private DBUserDAO dBUserDAO;
    private DBMessageDAO dBMessageDAO;

    private JdbcTemplate jdbcTemplate;
    
    public MessageDAO getMessageDao(){
        if (this.dBMessageDAO == null) {
            this.dBMessageDAO = new DBMessageDAO(getJdbcTemplate());
        }
        return this.dBMessageDAO;
    }

    public MovieManagerDAO getMovieDao() {
        if (this.dBMovieManagerDAO == null) {
            this.dBMovieManagerDAO = new DBMovieManagerDAO(getJdbcTemplate());
        }
        return this.dBMovieManagerDAO;
    }

    public DBUserDAO getUserDao() {
        if (this.dBUserDAO == null) {
            this.dBUserDAO = new DBUserDAO(getJdbcTemplate());
        }
        return this.dBUserDAO;
    }

    public JdbcTemplate getJdbcTemplate() {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(getDataSource());
        }
        return this.jdbcTemplate;
    }

    public DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://db4free.net:3306/paz1c2014mba");
        dataSource.setUser("paz1c2014mba");
        dataSource.setPassword("paz1c2014mba");

        return dataSource;
    }

}

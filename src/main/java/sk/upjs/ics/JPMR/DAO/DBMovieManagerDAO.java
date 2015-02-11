package sk.upjs.ics.JPMR.DAO;

import java.io.File;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.User;
import sk.upjs.ics.JPMR.UserMovie;

public class DBMovieManagerDAO implements MovieManagerDAO {

    private final BeanPropertyRowMapper<Movie> movieMaper = new BeanPropertyRowMapper<>(Movie.class);
    private final BeanPropertyRowMapper<User> userMaper = new BeanPropertyRowMapper<>(User.class);
    private final BeanPropertyRowMapper<UserMovie> userMovieMaper = new BeanPropertyRowMapper<>(UserMovie.class);
    private JdbcTemplate jdbcTemplate;

    private final UserDao userDao = DaoFactory.INSTANCE.getUserDao();
    private final MessageDAO messageDao = DaoFactory.INSTANCE.getMessageDao();
    private int user;

    /**
     * konštruktor
     *
     * @param jdbcTemplate
     */
    public DBMovieManagerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setUser(int user) {
        this.user = user;
    }

    /**
     * vrati celkovy pocet filmov v databaze
     *
     * @return
     */
    @Override
    public int getMovieNumber() {
        String sql = "Select count(*) from Filmy";
        return jdbcTemplate.queryForInt(sql);
    }

    @Override
    public Movie getLastMovie() {
        //metoda nie je v tejto verzii podporovana
        return null;
    }

    /**
     * vrati vsetky filmy v databaze, namapovane podla nazvov stlpcov a
     * premennych, ktore patria prihlasenemu userovi
     *
     * @param IdU
     * @return
     */
    @Override
    public List<Movie> getUserMoviesList(int IdU) {
        user = IdU;
        return userDao.getUserMovies(IdU);
    }

    /**
     * vrati vsetky filmy v databaze, namapovane podla nazvov stlpvoc a
     * premennych, ktore patria prihlasenemu userovi a nazov obsahuje string
     *
     * @param movieName
     *
     * @param IdU
     * @return
     */
    @Override
    public List<Movie> getUserMoviesList(int IdU, String movieName) {
        user = IdU;
        return userDao.getUserMovies(IdU, movieName);
    }

    
    /**
     * vymaže film zo spojovacej tabuľky ... film ostane v centrálnom zozname
     * @param IdF 
     */
    @Override
    public void deleteMovie(int IdF) {
        int[] types = {Types.INTEGER, Types.INTEGER};
        Object[] values = {user, IdF};
        jdbcTemplate.update("DELETE FROM Spoj WHERE IdU=? AND IdF=?", values, types);
    }

    /**
     * prida film f fo databazy .. ak uz tam je (id!=-1) tak len updatne
     * informacie o filme f
     *
     * @param f
     */
    @Override
    public void addMovie(Movie f) {
        if (f.getId() == -1) {
            Map<String, Object> movieValues = makeMovieValues(f);
            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
            insert.setGeneratedKeyName("id");
            insert.setTableName("Filmy");
            Number id = insert.executeAndReturnKey(movieValues);
            f.setId(id.longValue());

            addMovieDataToSpoj(id, f);

            addMovieFromDBToUser(f);
        } else {
            List<User> l = jdbcTemplate.query("SELECT * FROM Users WHERE typ = 0", userMaper);
            String text = "Meno: " + f.getMeno() + "\n"
                    + "Režisér: " + f.getReziser() + "\n"
                    + "Herci: " + f.getHerci() + "\n"
                    + "Žánre: " + f.getZanre() + "\n"
                    + "Jazyky: " + f.getJazyky() + "\n"
                    + "Titulky: " + f.getTitulky() + "\n"
                    + "Rok: " + f.getRok() + "\n"
                    + "Hodnotenie: " + f.getHodnotenie() + "\n"
                    + "Dĺžka: " + f.getDlzka();
            for (User l1 : l) {
                messageDao.sendRequest(text, user, l1.getIdU(), (int) f.getId());
            }
        }
    }

    /**
     * priradí nový film k užívateľovi v spojoacej tabuľke
     * film bol práve pridaný užívateľom a v centrálnej tabuľke pred tým nebol
     * @param id
     * @param f 
     */
    @Override
    public void addMovieDataToSpoj(Number id, Movie f) {
        Map<String, Object> hodnotySpoj = makeSpojValues(id, f);
        SimpleJdbcInsert insertSpoj = new SimpleJdbcInsert(jdbcTemplate);
        insertSpoj.setTableName("Spoj");
        insertSpoj.execute(hodnotySpoj);
    }

    /**
     * pridadí už existujucú film k užívateľovi
     * film existuje v centrálnej tabuľke a nahrá sa cesta v PC
     * @param f
     * @throws DataAccessException 
     */
    private void addMovieFromDBToUser(Movie f) throws DataAccessException {
        int[] typesForSpoj = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        Object[] paramsForSpoj = new Object[]{
            f.getCesta(),
            user,
            (int) f.getId()
        };
        String sqlSpoj = "UPDATE Spoj SET cesta=?"
                + "WHERE IdU=? AND IdF=?";
        jdbcTemplate.update(sqlSpoj, paramsForSpoj, typesForSpoj);
    }

    private Map<String, Object> makeSpojValues(Number id, Movie f) {
        Map<String, Object> spojValues = new HashMap<>();
        spojValues.put("IdU", user);
        spojValues.put("IdF", id);
        spojValues.put("cesta", f.getCesta());
        return spojValues;
    }

    private Map<String, Object> makeMovieValues(Movie f) {
        Map<String, Object> moviesValues = new HashMap<>();
        moviesValues.put("meno", f.getMeno());
        moviesValues.put("reziser", f.getReziser());
        moviesValues.put("herci", f.getHerci());
        moviesValues.put("zanre", f.getZanre());
        moviesValues.put("jazyky", f.getJazyky());
        moviesValues.put("titulky", f.getTitulky());
        moviesValues.put("dlzka", f.getDlzka());
        moviesValues.put("rok", f.getRok());
        moviesValues.put("hodnotenie", (int) f.getHodnotenie());
        return moviesValues;
    }

    /**
     * konvertuje subor na film
     *
     * @param selectedMovie
     * @return
     */
    @Override
    public Movie castToMovie(File selectedMovie) {
        if (selectedMovie == null) {
            return null;
        }
        String path = selectedMovie.getAbsolutePath();
        Movie f = new Movie();
        f.setCesta(path);

        String name = path.substring(path.lastIndexOf("\\") + 1, path.lastIndexOf("."));
        name = editName(name);

        f.setMeno(name);

        return f;
    }

    private String editName(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length() - 1; i++) {
            if ((name.charAt(i) == '-' || name.charAt(i) == '_') && name.charAt(i + 1) != ' ') {
                sb.append(" ");
            } else {
                sb.append(name.charAt(i));
            }
        }
        sb.append(name.charAt(name.length() - 1));
        return name;
    }

    /**
     * skontroluje existenciu filmu f v databaze, ak ho najde, vrati ho ak nie
     * vrati null
     *
     * @param f
     * @return
     */
    @Override
    public Movie checkMovieExistence(Movie f) {
        if (0 == jdbcTemplate.queryForInt("SELECT COUNT(*) FROM Filmy WHERE meno LIKE ?", "%" + editName(f.getMeno()) + "%")) {
            return null;
        } else {
            List<Movie> l = jdbcTemplate.query("SELECT * FROM Filmy WHERE meno LIKE ?", movieMaper, "%" + editName(f.getMeno()) + "%");
            return l.get(0);
        }
    }

    @Override
    public void uploadMovieInfo(int iDMovie, int iDUser, Object[] params) {
        Movie f = jdbcTemplate.query("SELECT * FROM Filmy WHERE ID = ?", movieMaper, iDMovie).get(0);
        String sqlFilm
                = "UPDATE Filmy SET "
                + "meno=?,"
                + "reziser=?,"
                + "herci=?,"
                + "zanre=?,"
                + "jazyky=?,"
                + "titulky=?,"
                + "rok=?,"
                + "hodnotenie=?,"
                + "dlzka=? "
                + "WHERE ID=?;";

        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER};

        jdbcTemplate.update(sqlFilm, params, types);        
    }
    
    @Override
    public void changeMoviePath(String path, int idF){
        int[] typesForSpoj = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        Object[] paramsForSpoj = new Object[]{
            path,
            user,
            idF
        };
        String sqlSpoj = "UPDATE Spoj SET cesta=?"
                + " WHERE idU=? AND IdF=?";
        jdbcTemplate.update(sqlSpoj, paramsForSpoj, typesForSpoj);
    }
    
    /**
     * metóda používaná na vyhľadávanie filmu medzi ostatnými užívateľmi
     * @param searchedMovie
     * @return 
     */
    @Override
    public List<UserMovie> getListOfUserMovies(String searchedMovie){
        String sql = "SELECT U.meno as userName, F.meno as movieName FROM Users U left join Spoj S ON (U.IdU=S.IdU) left join Filmy F ON (S.IdF=F.ID) WHERE F.meno like ?;";
        return jdbcTemplate.query(sql, userMovieMaper, "%"+searchedMovie+"%");            
    }

}

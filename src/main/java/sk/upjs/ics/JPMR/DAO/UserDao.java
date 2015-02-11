package sk.upjs.ics.JPMR.DAO;

import java.util.List;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.User;

public interface UserDao {

    public List<Movie> getUserMovies(int IDUser);
    
    public List<Movie> getUserMovies(int IDUser, String nazovFilmu);

    int logIn(String meno, String heslo);

    boolean register(String meno, String heslo);

    public int getUser();
    
    public void setUser(int User);

    public List<User> getAllUsers(String searchedUser);
    
}

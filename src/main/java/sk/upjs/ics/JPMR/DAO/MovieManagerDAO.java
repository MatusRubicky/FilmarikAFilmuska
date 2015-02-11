package sk.upjs.ics.JPMR.DAO;

import java.io.File;
import java.util.List;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.UserMovie;

public interface MovieManagerDAO {

    int getMovieNumber();

    Movie getLastMovie();

    List<Movie> getUserMoviesList(int IdU);
    
    List<Movie> getUserMoviesList(int IdU, String nazovFilmu);

    void addMovie(Movie vybranyFilm);
    
    public void setUser(int user);
    
    public void addMovieDataToSpoj(Number id, Movie f);

    void deleteMovie(int IdF);
    
    Movie castToMovie(File vybranyFilm);

    public Movie checkMovieExistence(Movie f);
    
    public void uploadMovieInfo(int iDMovie, int iDUser, Object[] params);
    
    public void changeMoviePath(String path, int idF);
    
    List<UserMovie> getListOfUserMovies(String searchedMovie);
}

/**
 * trieda používaná pri vyhľadávaní filmu medzi ostatnými používateľmi
 */
package sk.upjs.ics.JPMR;

public class UserMovie {
    
    private String userName;
    private String movieName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }        
}

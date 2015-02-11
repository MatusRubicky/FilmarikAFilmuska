package sk.upjs.ics.JPMR;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.JPMR.DAO.DaoFactory;
import sk.upjs.ics.JPMR.DAO.MovieManagerDAO;

public class UserMovieTableModel extends AbstractTableModel {
    
    private List<UserMovie> listOfUserMovies = new LinkedList<>();
    private MovieManagerDAO movieDao = DaoFactory.INSTANCE.getMovieDao();
    
    private static final int COLUMN_NUMBER_USERMOVIE = 2;
    private static final String[] COLUMN_TITLES_USERMOVIE = {"Užívateľ", "Názov filmu"};
    private static final Class[] COLUMN_TYPES_USERMOVIE = {String.class, String.class};

    public void refresh(String searchedMovie){
        listOfUserMovies = movieDao.getListOfUserMovies(searchedMovie);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listOfUserMovies.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NUMBER_USERMOVIE;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserMovie uMovie = listOfUserMovies.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return uMovie.getUserName();
            case 1:
                return uMovie.getMovieName();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_TITLES_USERMOVIE[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES_USERMOVIE[columnIndex];
    }
}

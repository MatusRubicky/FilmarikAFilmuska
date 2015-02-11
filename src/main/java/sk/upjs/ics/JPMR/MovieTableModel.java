package sk.upjs.ics.JPMR;

import sk.upjs.ics.JPMR.DAO.DaoFactory;
import sk.upjs.ics.JPMR.DAO.MovieManagerDAO;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class MovieTableModel extends AbstractTableModel {

    /*zobrazenie filmov*/
    private static final int COLUMN_NUMER_FILM = 5;
    private static final String[] COLUMN_TITLES_FILM = {"Meno", "Hodnotenie", "Jazyky", "Žánre", "Dĺžka"};
    private static final Class[] COLUMN_TYPES_FILM = {
        String.class,
        Integer.class,
        String.class,
        String.class,
        Integer.class
    };
    private List<Movie> movies = new LinkedList<>();

    private MovieManagerDAO movieDAO = DaoFactory.INSTANCE.getMovieDao();    
    
    private boolean isEmpty = false;//premenna indikujuca, ze metoda refresh vratila prazdny zoznam filmov

    @Override
    public int getRowCount() {
            return movies.size();
    }

    @Override
    public int getColumnCount() {
            return COLUMN_NUMER_FILM;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Movie selectedMovie = movies.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return selectedMovie.getMeno();
                case 1:
                    return selectedMovie.getHodnotenie();
                case 2:
                    return selectedMovie.getJazyky();
                case 3:
                    return selectedMovie.getZanre();
                case 4:
                    return selectedMovie.getDlzka() + " min";
                default:
                    return "???";
            }
    }

    public void refresh(int IdU) {
            movies = movieDAO.getUserMoviesList(IdU);
            fireTableDataChanged();
    }

    public void refresh(int IdU, String filter) {
            movies = movieDAO.getUserMoviesList(IdU, filter);
            isEmpty = movies.isEmpty();
            fireTableDataChanged();
    }

    public Object getAccordingToRowNumber(int row) {
            return movies.get(row);
    }

    @Override
    public String getColumnName(int column) {
            return COLUMN_TITLES_FILM[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES_FILM[columnIndex];
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }
}

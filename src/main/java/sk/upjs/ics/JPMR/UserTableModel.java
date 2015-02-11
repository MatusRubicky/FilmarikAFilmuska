package sk.upjs.ics.JPMR;

import sk.upjs.ics.JPMR.DAO.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    
    private List<User> users = new LinkedList<>();
    private MovieManagerDAO movieDao = DaoFactory.INSTANCE.getMovieDao();
    private UserDao userDao = DaoFactory.INSTANCE.getUserDao();
    
    private static final int COLUMN_NUMBER_USER = 1;
    private static final String[] COLUMN_TITLES_USER = {"Užívateľ"};
    private static final Class[] COLUMN_TYPES_USER = {String.class};
    

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NUMBER_USER;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User selectedUser = users.get(rowIndex);

                return selectedUser.getMeno();
        
    }

    public void refresh(String searchedUser) {
        users = userDao.getAllUsers(searchedUser);
        fireTableDataChanged();
    }
    
    public Object getAccordingToRowNumber(int row) {
            return users.get(row);
    }
    
    @Override
    public String getColumnName(int column) {
            return COLUMN_TITLES_USER[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES_USER[columnIndex];
    }
}

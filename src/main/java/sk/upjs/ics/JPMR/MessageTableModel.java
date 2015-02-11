package sk.upjs.ics.JPMR;

import sk.upjs.ics.JPMR.DAO.DaoFactory;
import sk.upjs.ics.JPMR.DAO.MessageDAO;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MessageTableModel extends AbstractTableModel {

    /*zobrazenie sprav*/
    private static final int COLUMN_NUMBER_MESSAGE = 5;
    private static final String[] COLUMN_TITLES_MESSAGE = {"Odosielateľ", "Predmet", "Správa", "Čas", "Stav"};
    private static final Class[] COLUMN_TYPES_MESSAGE = {
        String.class,
        String.class,
        String.class,
        String.class,
        String.class
    };
    private List<Message> messages = new LinkedList<>();

    private final MessageDAO messageDAO = DaoFactory.INSTANCE.getMessageDao();

    @Override
    public int getRowCount() {
        return messages.size();

    }

    @Override
    public int getColumnCount() {
        return COLUMN_NUMBER_MESSAGE;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Message selectedMessage = messages.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return selectedMessage.getMeno();
            case 1:
                return selectedMessage.getObject();
            case 2:
                if (selectedMessage.getText().length() > 50) {
                    return selectedMessage.getText().substring(0, 49) + "...";
                } else {
                    return selectedMessage.getText();
                }
            case 3:
                return selectedMessage.getDate();
            case 4:
                if (selectedMessage.getReadMess() == 0){
                    return "Neprečítaná";                   
                } else {
                    return "Prečítaná";
                }                        
            default:
                return "???";
        }
    }

    public void refresh(int IdU) {
        messages = messageDAO.getUserMessages(IdU);
        fireTableDataChanged();
    }

    public Object getAccordingToRowNumber(int row) {
        return messages.get(row);
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_TITLES_MESSAGE[column];

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES_MESSAGE[columnIndex];

    }

}

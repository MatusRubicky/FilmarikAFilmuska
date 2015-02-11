package sk.upjs.ics.JPMR.GUI;

import sk.upjs.ics.JPMR.DAO.DaoFactory;
import sk.upjs.ics.JPMR.DAO.MessageDAO;
import sk.upjs.ics.JPMR.DAO.MovieManagerDAO;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import sk.upjs.ics.JPMR.Message;
import sk.upjs.ics.JPMR.MessageTableModel;
import sk.upjs.ics.JPMR.Movie;
import sk.upjs.ics.JPMR.MovieTableModel;
import sk.upjs.ics.JPMR.User;
import sk.upjs.ics.JPMR.UserTableModel;

public class SFFrame extends javax.swing.JFrame {

    private static final int MOVIE_SWITCH = 0;
    private static final int MESSG_SWITCH = 1;
    private static final int USER_SWITCH = 2;

    private final MovieManagerDAO sf = DaoFactory.INSTANCE.getMovieDao();
    private final MessageDAO messageDAO = DaoFactory.INSTANCE.getMessageDao();

    private final MovieTableModel tableModel = new MovieTableModel();
    private final MessageTableModel messTableModel = new MessageTableModel();
    private final UserTableModel userTableModel = new UserTableModel();

    private final int IdUser;
    private int switcher = 0;

    private Movie selectedMovie;
    private String searchedMovie;

    private Message selectedMessage;
    private Message selectedMessageForDeleting;
    
    private User selectedUser;
    private String searchedUser;
    
    private final ImageIcon clMovie = new javax.swing.ImageIcon(getClass().getResource("/images/cl_movie.png"));
    private final ImageIcon clMess = new javax.swing.ImageIcon(getClass().getResource("/images/cl_mess.png"));
    private final ImageIcon clUser = new javax.swing.ImageIcon(getClass().getResource("/images/cl_user.png"));
    
    private final ImageIcon notClMess = new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_mess.png"));
    private final ImageIcon notClMovie = new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_movie.png"));
    private final ImageIcon notClUser = new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_user.png"));

    public SFFrame(int IdU) {
        initComponents();
        IdUser = IdU;
        messageDAO.setiDUser(IdU);
        setLocationRelativeTo(null);
        refreshItemList(IdUser);
        tabMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnDeleteMessage.setVisible(false); // nepytajte sa preco
    }

    /**
     * nastavi switcher na filmy alebo spravy
     *
     * @param switcher
     */
    public void setSwitcher(int switcher) {
        this.switcher = switcher;
    }

    public MovieManagerDAO getSf() {
        return sf;
    }

    /**
     * aktualizuje zoznam poloziek polozky: filmy, spravy
     *
     * @param IdU
     */
    private void refreshItemList(int IdU) {
        if (switcher == MOVIE_SWITCH) {
            tabMovies.setModel(tableModel);
            if (searchedMovie == null || searchedMovie.equals("Hľadaj podľa názvu filmu...") || searchedMovie.equals("")) {
                tableModel.refresh(IdU);
            } else {
                tableModel.refresh(IdU, "%" + searchedMovie + "%"); //musia tam byt aj % ako zastupne znaky 
                if (tableModel.isEmpty()) {                    
                    JDSearchInfoOnline jdHladajNaNete = new JDSearchInfoOnline(searchedMovie, this);
                    jdHladajNaNete.setVisible(true);
                }
            }
        } else if (switcher == USER_SWITCH){
            tabMovies.setModel(userTableModel);
            if (searchedUser == null || searchedUser.equals("Hľadaj podľa názvu filmu...") || searchedUser.equals("")){
                userTableModel.refresh(null);
            } else {
                userTableModel.refresh("%"+ searchedUser +"%");
            }
        } else {
            tabMovies.setModel(messTableModel);
            messTableModel.refresh(IdU);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMovies = new javax.swing.JTable();
        txtSearchAccordingToTitle = new javax.swing.JTextField();
        btnSearchAccordingToTitle = new javax.swing.JButton();
        btnDeleteMessage = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnMessages = new javax.swing.JButton();
        btnMovies = new javax.swing.JButton();
        jMBMenu = new javax.swing.JMenuBar();
        jMFile = new javax.swing.JMenu();
        jMINew = new javax.swing.JMenuItem();
        jMIQuit = new javax.swing.JMenuItem();
        jMLogOut = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Správca Filmov");
        setResizable(false);

        tabMovies.setAutoCreateRowSorter(true);
        tabMovies.setModel(tableModel);
        tabMovies.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabMovies.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabMovies);

        txtSearchAccordingToTitle.setText("Hľadaj podľa názvu...");
        txtSearchAccordingToTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearchAccordingToTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchAccordingToTitleActionPerformed(evt);
            }
        });
        txtSearchAccordingToTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchAccordingToTitleKeyTyped(evt);
            }
        });

        btnSearchAccordingToTitle.setText("Hľadaj");
        btnSearchAccordingToTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAccordingToTitleActionPerformed(evt);
            }
        });

        btnDeleteMessage.setText("Vymaž");
        btnDeleteMessage.setEnabled(false);
        btnDeleteMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMessageActionPerformed(evt);
            }
        });

        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_user.png"))); // NOI18N
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUsersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUsersMouseReleased(evt);
            }
        });
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_mess.png"))); // NOI18N
        btnMessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMessagesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMessagesMouseReleased(evt);
            }
        });
        btnMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessagesActionPerformed(evt);
            }
        });

        btnMovies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/not_cl_movie.png"))); // NOI18N
        btnMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMoviesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMoviesMouseReleased(evt);
            }
        });
        btnMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoviesActionPerformed(evt);
            }
        });

        jMFile.setText("Súbor");

        jMINew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMINew.setText("Pridaj film...");
        jMINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINewActionPerformed(evt);
            }
        });
        jMFile.add(jMINew);

        jMIQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMIQuit.setText("Koniec Alt+F4");
        jMIQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIQuitActionPerformed(evt);
            }
        });
        jMFile.add(jMIQuit);

        jMBMenu.add(jMFile);

        jMLogOut.setText("Odhlásiť");
        jMLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMLogOutMouseClicked(evt);
            }
        });
        jMBMenu.add(jMLogOut);

        setJMenuBar(jMBMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchAccordingToTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchAccordingToTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchAccordingToTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchAccordingToTitle)
                    .addComponent(btnDeleteMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMIQuitActionPerformed

    /**
     * tlacidlo pre pridanie jedneho filmu zo adresara
     *
     * @param evt
     */
    private void jMINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINewActionPerformed
        JFileChooser jfc = new JFileChooser();
        String[] possibleFormats = {"webm", "mkv", "flv", "ogv", "ogg", "drc", "mng", "avi", "mov", "qt",
            "wmv", "yuv", "rm", "rmvb", "asf", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv",
            "mpg", "mpeg", "m2v", "m4v", "svi", "3gp", "3g2", "mxf", "roq", "nsv"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Video format", possibleFormats);

        jfc.setFileFilter(filter);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setDialogTitle("Vyberte film");
        jfc.showOpenDialog(new JFrame());

        File selectedMovie = jfc.getSelectedFile();
        if (selectedMovie != null) {
            Movie f = sf.castToMovie(selectedMovie);

            Movie checkedMovie = sf.checkMovieExistence(f);
            if (checkedMovie == null) {
                addNewMovieToDB(f);
            } else {
                int option = JOptionPane.showConfirmDialog(this,
                        "Film " + checkedMovie.getMeno() + " sa už nachádza v databáze.\n"
                        + "Zhoduje sa tento film s Vaším filmom?",
                        "Pridať film",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    sf.addMovieDataToSpoj(checkedMovie.getId(), f);
                } else {
                    addNewMovieToDB(f);
                }
            }
        }
        refreshItemList(IdUser);
    }//GEN-LAST:event_jMINewActionPerformed

    private void addNewMovieToDB(Movie f) throws HeadlessException {
        int option = JOptionPane.showConfirmDialog(this,
                "Naozaj chcete pridať film \n" + f.getMeno() + "\n do svojho zoznamu?",
                "Pridať film",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            sf.addMovie(f);
        }
    }


    /**
     * po dvojkliku otvori detajlform s vybranym filmo z tabulky
     *
     * @param evt
     */
    private void tabMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMoviesMouseClicked
        if (switcher == MOVIE_SWITCH) {
            if (evt.getClickCount() == 2) {
                int selectedRow = tabMovies.getSelectedRow();
                int selectedIndexInTableModel = tabMovies.convertRowIndexToModel(selectedRow);
                selectedMovie = (Movie) tableModel.getAccordingToRowNumber(selectedIndexInTableModel);

                JDEditMovie editMovie
                        = new JDEditMovie(this, selectedMovie, (int) selectedMovie.getId(), sf);
                editMovie.setVisible(true);
                refreshItemList(IdUser);
            }
        } else if (switcher == USER_SWITCH){
            int selectedRow = tabMovies.getSelectedRow();
            if (evt.getClickCount() == 2) {
                int selectedIndexInTableModel = tabMovies.convertRowIndexToModel(selectedRow);
                selectedUser = (User) userTableModel.getAccordingToRowNumber(selectedIndexInTableModel);
                
                JDShowMessage showMessage = new JDShowMessage(this, messageDAO, selectedUser.getMeno(), 0);
                showMessage.setVisible(true);
            }
        } else {
            int selectedRowForDeleting = tabMovies.getSelectedRow();
            selectedMessageForDeleting = (Message) messTableModel.getAccordingToRowNumber(selectedRowForDeleting);
            btnDeleteMessage.setEnabled(true);

            if (evt.getClickCount() == 2) {
                int selectedRow = tabMovies.getSelectedRow();
                int selectedIndexInTableModel = tabMovies.convertRowIndexToModel(selectedRow);
                selectedMessage = (Message) messTableModel.getAccordingToRowNumber(selectedIndexInTableModel);

                JDShowMessage showMessage;
                if (selectedMessage.getiDMovie() != -1) {
                    showMessage = new JDShowMessage(this, selectedMessage, messageDAO, 3, selectedMessage.getiDMovie());
                    messageDAO.setMessageToRead(selectedMessage);
                } else {
                    showMessage = new JDShowMessage(this, selectedMessage, messageDAO, 2);
                    messageDAO.setMessageToRead(selectedMessage.getiDMovie());
                }
                showMessage.setVisible(true);
                refreshItemList(IdUser);
            }
        }
    }//GEN-LAST:event_tabMoviesMouseClicked

    private void jMLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMLogOutMouseClicked
        new JFLogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMLogOutMouseClicked

    private void btnSearchAccordingToTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAccordingToTitleActionPerformed
        if (switcher == MOVIE_SWITCH) {
            searchAccordingTitle();
        } else if (switcher == USER_SWITCH){
            searchAccordingUser();
        } else {
            JDShowMessage showMessage = new JDShowMessage(this, messageDAO, 0);
            showMessage.setVisible(true);
            refreshItemList(IdUser);
        }
    }//GEN-LAST:event_btnSearchAccordingToTitleActionPerformed

    private void searchAccordingTitle() {
        searchedMovie = txtSearchAccordingToTitle.getText();
        refreshItemList(IdUser);
    }
    
    private void searchAccordingUser(){
        searchedUser = txtSearchAccordingToTitle.getText();
        refreshItemList(IdUser);
    }

    private void txtSearchAccordingToTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchAccordingToTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchAccordingToTitleActionPerformed

    private void btnDeleteMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMessageActionPerformed
        messageDAO.deleteMessage(selectedMessageForDeleting);
        refreshItemList(IdUser);
        btnDeleteMessage.setEnabled(false);
    }//GEN-LAST:event_btnDeleteMessageActionPerformed

    private void txtSearchAccordingToTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAccordingToTitleKeyTyped
        if ((int) evt.getKeyChar() == 10) { //ako odrbať system bez keylistenera
            searchAccordingTitle();
        }
    }//GEN-LAST:event_txtSearchAccordingToTitleKeyTyped

    private void btnMessagesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMessagesMousePressed
        this.btnMessages.setIcon(clMess);
    }//GEN-LAST:event_btnMessagesMousePressed
    
    private void btnMessagesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMessagesMouseReleased
        this.btnMessages.setIcon(notClMess);
    }//GEN-LAST:event_btnMessagesMouseReleased
    
    private void btnMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessagesActionPerformed
        this.switcher = MESSG_SWITCH;
        refreshItemList(IdUser);

        txtSearchAccordingToTitle.setVisible(false);
        btnSearchAccordingToTitle.setText("Nová");
        btnDeleteMessage.setVisible(true);
    }//GEN-LAST:event_btnMessagesActionPerformed

    private void btnMoviesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoviesMousePressed
        this.btnMovies.setIcon(clMovie);
    }//GEN-LAST:event_btnMoviesMousePressed
   

    private void btnMoviesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoviesMouseReleased
        this.btnMovies.setIcon(notClMovie);
    }//GEN-LAST:event_btnMoviesMouseReleased
    
    private void btnMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoviesActionPerformed
        this.switcher = MOVIE_SWITCH;
        
        searchedMovie = null;
        txtSearchAccordingToTitle.setText("Hľadaj podľa názvu...");
        refreshItemList(IdUser);

        txtSearchAccordingToTitle.setVisible(true);
        btnSearchAccordingToTitle.setText("Hľadaj");
        btnDeleteMessage.setVisible(false);
    }//GEN-LAST:event_btnMoviesActionPerformed

    private void btnUsersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMousePressed
        this.btnUsers.setIcon(clUser);
    }//GEN-LAST:event_btnUsersMousePressed
    
    private void btnUsersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseReleased
        this.btnUsers.setIcon(notClUser);
    }//GEN-LAST:event_btnUsersMouseReleased
    
    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        this.switcher = USER_SWITCH;
        
        searchedUser = null;       
        txtSearchAccordingToTitle.setText("Hľadaj podľa názvu...");
        refreshItemList(IdUser);
        
        txtSearchAccordingToTitle.setVisible(true);
        btnSearchAccordingToTitle.setText("Hľadaj");
        btnDeleteMessage.setVisible(false);
    }//GEN-LAST:event_btnUsersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteMessage;
    private javax.swing.JButton btnMessages;
    private javax.swing.JButton btnMovies;
    private javax.swing.JButton btnSearchAccordingToTitle;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMBMenu;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenuItem jMINew;
    private javax.swing.JMenuItem jMIQuit;
    private javax.swing.JMenu jMLogOut;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabMovies;
    private javax.swing.JTextField txtSearchAccordingToTitle;
    // End of variables declaration//GEN-END:variables

}

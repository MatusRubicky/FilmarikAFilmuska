/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.JPMR.GUI;

import sk.upjs.ics.JPMR.DAO.MovieManagerDAO;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sk.upjs.ics.JPMR.Movie;

/**
 *
 * @author Uživateľ
 */
public class JDEditMovie extends javax.swing.JDialog {

    private Movie f;
    private int movieID;
    private MovieManagerDAO movieDAO;

    /**
     * Creates new form JDFilm
     *
     * @param parent
     * @param modal
     */
    public JDEditMovie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    /**
     * konstruktor
     *
     * @param parent
     * @param f
     * @param id
     * @param sd
     */
    public JDEditMovie(java.awt.Frame parent, Movie f, int id, MovieManagerDAO sd) {
        this(parent, true);
        this.f = f;
        movieDAO = sd;
        f.setId(id);
        movieID = id;
        this.setTitle(f.getMeno());
        txtName.setText(f.getMeno());
        txtPath.setText(f.getCesta());
        if (f.getReziser() != null) {
            txtDirector.setText(f.getReziser());
        }
        if (f.getHerci() != null) {
            txtActors.setText(f.getHerci());
        }
        if (f.getZanre() != null) {
            txtGenres.setText(f.getZanre());
        }
        if (f.getJazyky() != null) {
            txtLanguages.setText(f.getJazyky());
        }
        if (f.getTitulky() != null) {
            txtSubtitles.setText(f.getTitulky());
        }
        if (f.getRok() != 1800) {
            spnReleaseYear.setValue((Object) f.getRok());
        }
        if (f.getHodnotenie() != 0) {
            spnRating.setValue((Object) f.getHodnotenie());
        }
        if (f.getDlzka() != 0) {
            spnScreenTime.setValue((Object) f.getDlzka());
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

        btnPlay = new javax.swing.JButton();
        btnChangeAttributes = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPath = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        lblDirector = new javax.swing.JLabel();
        txtDirector = new javax.swing.JTextField();
        lblActors = new javax.swing.JLabel();
        txtActors = new javax.swing.JTextField();
        lblGenres = new javax.swing.JLabel();
        txtGenres = new javax.swing.JTextField();
        lblReleaseYear = new javax.swing.JLabel();
        spnReleaseYear = new javax.swing.JSpinner();
        lblRating = new javax.swing.JLabel();
        lblLanguages = new javax.swing.JLabel();
        txtLanguages = new javax.swing.JTextField();
        lblScreenTime = new javax.swing.JLabel();
        spnScreenTime = new javax.swing.JSpinner();
        btnOK = new javax.swing.JButton();
        lblSubtitles = new javax.swing.JLabel();
        txtSubtitles = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnStorno = new javax.swing.JButton();
        spnRating = new javax.swing.JSpinner();
        btnChangePath = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        btnPlay.setText("Play");
        btnPlay.setPreferredSize(new java.awt.Dimension(115, 115));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnChangeAttributes.setText("Uprav film");
        btnChangeAttributes.setPreferredSize(new java.awt.Dimension(115, 115));
        btnChangeAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeAttributesActionPerformed(evt);
            }
        });

        lblName.setText("Názov filmu:");

        txtName.setEditable(false);
        txtName.setText(" ");
        txtName.setPreferredSize(new java.awt.Dimension(561, 28));

        lblPath.setText("Umiestnenie: ");

        txtPath.setEditable(false);
        txtPath.setPreferredSize(new java.awt.Dimension(561, 28));

        lblDirector.setText("Réžia: ");

        txtDirector.setEditable(false);
        txtDirector.setToolTipText("Oddeľujte čiarkou");
        txtDirector.setPreferredSize(new java.awt.Dimension(561, 28));

        lblActors.setText("Herci:");

        txtActors.setEditable(false);
        txtActors.setToolTipText("Oddeľujte čiarkou");
        txtActors.setPreferredSize(new java.awt.Dimension(561, 28));

        lblGenres.setText("Žánre: ");

        txtGenres.setEditable(false);
        txtGenres.setToolTipText("Oddeľujte čiarkou");
        txtGenres.setPreferredSize(new java.awt.Dimension(561, 28));

        lblReleaseYear.setText("Rok: ");

        spnReleaseYear.setModel(new javax.swing.SpinnerNumberModel(2014, 1800, 2500, 1));
        spnReleaseYear.setEnabled(false);

        lblRating.setText("Hodnotenie: ");

        lblLanguages.setText("Dabing: ");

        txtLanguages.setEditable(false);
        txtLanguages.setToolTipText("Oddeľujte čiarkou");
        txtLanguages.setPreferredSize(new java.awt.Dimension(561, 28));

        lblScreenTime.setText("Dĺžka: ");

        spnScreenTime.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnScreenTime.setEnabled(false);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblSubtitles.setText("Titulky: ");

        txtSubtitles.setToolTipText("Oddeľujte čiarkou");
        txtSubtitles.setPreferredSize(new java.awt.Dimension(561, 28));

        btnDelete.setText("Zmaž film");
        btnDelete.setPreferredSize(new java.awt.Dimension(115, 115));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnStorno.setText("Zruš");
        btnStorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStornoActionPerformed(evt);
            }
        });

        spnRating.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        btnChangePath.setText("|>");
        btnChangePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPath)
                            .addComponent(lblName)
                            .addComponent(lblDirector)
                            .addComponent(lblActors))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChangePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtActors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenres)
                            .addComponent(lblLanguages))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenres, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtLanguages, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSubtitles)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblReleaseYear)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(81, 81, 81)
                                        .addComponent(lblRating)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnRating, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(lblScreenTime)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnScreenTime, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSubtitles, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChangeAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnStorno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPath)
                    .addComponent(btnChangePath))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirector)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActors)
                    .addComponent(txtActors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenres)
                    .addComponent(txtGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLanguages)
                    .addComponent(txtLanguages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtitles)
                    .addComponent(txtSubtitles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblReleaseYear)
                        .addComponent(spnReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnScreenTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblScreenTime)
                        .addComponent(spnRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangeAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStorno)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * tlacidlo uprav - odblokuje komponenty pre vkladanie udajov o filme
     *
     * @param evt
     */
    private void btnChangeAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeAttributesActionPerformed
        if (btnChangeAttributes.getText().equals("Uprav film")) {
            enableComponents();
        } else {
            disableComponents();
            f.changeAttributes(txtName.getText(), // film si zmeni vlastnosti
                    txtPath.getText(),
                    txtDirector.getText(),
                    txtActors.getText(),
                    txtGenres.getText(),
                    txtLanguages.getText(),
                    txtSubtitles.getText(),
                    (int) spnReleaseYear.getValue(),
                    (int) spnRating.getValue(),
                    (int) spnScreenTime.getValue());
            movieDAO.addMovie(f);
            showSendingInfo();
        }
    }//GEN-LAST:event_btnChangeAttributesActionPerformed

    private void enableComponents() {
        btnOK.setEnabled(false);
        txtName.setEditable(true);
        txtDirector.setEditable(true);
        txtActors.setEditable(true);
        txtGenres.setEditable(true);
        txtLanguages.setEditable(true);
        txtSubtitles.setEditable(true);
        spnReleaseYear.setEnabled(true);
        spnRating.setEnabled(true);
        spnScreenTime.setEnabled(true);
        btnChangeAttributes.setText("Ulož");
    }

    private void disableComponents() {
        btnOK.setEnabled(true);
        txtName.setEditable(false);
        txtDirector.setEditable(false);
        txtActors.setEditable(false);
        txtGenres.setEditable(false);
        txtLanguages.setEditable(false);
        txtSubtitles.setEditable(false);
        spnReleaseYear.setEnabled(false);
        spnRating.setEnabled(false);
        spnScreenTime.setEnabled(false);
        btnChangeAttributes.setText("Upraviť");
    }

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        try {
            //spusti film v defaultnom prehrávači
            //http://stackoverflow.com/questions/550329/how-to-open-a-file-with-the-default-associated-program
            Desktop.getDesktop().open(new File(f.getCesta()));
        } catch (IOException ex) {
            Logger.getLogger(JDEditMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Súbor sa nenašiel!", "Pozor!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //zdroj - Mgr. Maroš Andrejko
        Toolkit.getDefaultToolkit().beep();
        int tlacidlo = JOptionPane.showConfirmDialog(this,
                "Naozaj odstrániť?",
                "Naozaj chcete odstrániť tento film z databázy?",
                JOptionPane.YES_NO_OPTION
        );
        if (tlacidlo == JOptionPane.YES_OPTION) {
            movieDAO.deleteMovie(movieID);
            this.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnStornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStornoActionPerformed
        dispose();
    }//GEN-LAST:event_btnStornoActionPerformed

    private void btnChangePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePathActionPerformed
        JFileChooser jfc = new JFileChooser();
        String[] possibleFormats = {"webm", "mkv", "flv", "ogv", "ogg", "drc", "mng", "avi", "mov", "qt",
            "wmv", "yuv", "rm", "rmvb", "asf", "mp4", "m4p", "m4v", "mpg", "mp2", "mpeg", "mpe", "mpv",
            "mpg", "mpeg", "m2v", "m4v", "svi", "3gp", "3g2", "mxf", "roq", "nsv"};
        // wikipedia
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Video format", possibleFormats);

        jfc.setFileFilter(filter);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setDialogTitle("Vyberte film");
        jfc.showOpenDialog(new JFrame());

        File selectedMovie = jfc.getSelectedFile();

        movieDAO.changeMoviePath(selectedMovie.getAbsolutePath(), movieID);
        txtPath.setText(selectedMovie.getAbsolutePath());
    }//GEN-LAST:event_btnChangePathActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEditMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDEditMovie dialog = new JDEditMovie(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeAttributes;
    private javax.swing.JButton btnChangePath;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnStorno;
    private javax.swing.JLabel lblActors;
    private javax.swing.JLabel lblDirector;
    private javax.swing.JLabel lblGenres;
    private javax.swing.JLabel lblLanguages;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblReleaseYear;
    private javax.swing.JLabel lblScreenTime;
    private javax.swing.JLabel lblSubtitles;
    private javax.swing.JSpinner spnRating;
    private javax.swing.JSpinner spnReleaseYear;
    private javax.swing.JSpinner spnScreenTime;
    private javax.swing.JTextField txtActors;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtGenres;
    private javax.swing.JTextField txtLanguages;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtSubtitles;
    // End of variables declaration//GEN-END:variables

    private void showSendingInfo() {
        JOptionPane.showMessageDialog(this, "Žiadosť od zmenu údajov bola odoslaná", "Informácia",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
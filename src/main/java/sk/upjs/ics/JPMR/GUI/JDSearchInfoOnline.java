package sk.upjs.ics.JPMR.GUI;

import sk.upjs.ics.JPMR.GUI.JFListOfUsers;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDSearchInfoOnline extends javax.swing.JDialog {

    private String searchedMovie = "";

    public JDSearchInfoOnline(String searchedMovie, java.awt.Frame parent) {
        this(parent, true);
        this.searchedMovie = searchedMovie;   
        this.setTitle("'" + searchedMovie + "'");
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form JDhlladajNaNete
     *
     * @param parent
     * @param modal
     */
    public JDSearchInfoOnline(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNie = new javax.swing.JButton();
        btnAno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaInfo = new javax.swing.JTextArea();
        chbCSFD = new javax.swing.JCheckBox();
        chbIMDb = new javax.swing.JCheckBox();
        chbOnline = new javax.swing.JCheckBox();
        chbDownload = new javax.swing.JCheckBox();
        chbOtherUser = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNie.setText("Nie");
        btnNie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNieActionPerformed(evt);
            }
        });

        btnAno.setText("Áno");
        btnAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnoActionPerformed(evt);
            }
        });

        txtaInfo.setEditable(false);
        txtaInfo.setBackground(new java.awt.Color(240, 240, 240));
        txtaInfo.setColumns(20);
        txtaInfo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtaInfo.setLineWrap(true);
        txtaInfo.setRows(2);
        txtaInfo.setText("Zadaným požiadavkám nevyhovuje žiaden film vo Vašom zozname. Prajete si vyhľadať dostupné informácie on-line alebo u iných používateľov?");
        txtaInfo.setWrapStyleWord(true);
        txtaInfo.setAutoscrolls(false);
        txtaInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtaInfo);

        chbCSFD.setText("CSFD");

        chbIMDb.setText("IMDb");

        chbOnline.setText("On-line");

        chbDownload.setText("Download");

        chbOtherUser.setText("Iní Užívatelia");
        chbOtherUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbOtherUserActionPerformed(evt);
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNie, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chbCSFD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbIMDb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbOnline)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbDownload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbOtherUser)
                                .addGap(20, 20, 20))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbDownload)
                    .addComponent(chbOnline)
                    .addComponent(chbIMDb)
                    .addComponent(chbCSFD)
                    .addComponent(chbOtherUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAno)
                    .addComponent(btnNie))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNieActionPerformed
        dispose();
    }//GEN-LAST:event_btnNieActionPerformed

    private void btnAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnoActionPerformed
        String searchedStatement = editInput(searchedMovie); // zmeni medzery v nazve filmu na "+"
        if (Desktop.isDesktopSupported()) {
            try {
                if (chbOnline.isSelected()) {
                    Desktop.getDesktop().browse(new URI("http://www.google.com/#q=" + searchedStatement + "+watch+online+free"));
                }
                if (chbIMDb.isSelected()) {
                    Desktop.getDesktop().browse(new URI("http://www.imdb.com/find?ref=_nv_sr_fn&q=" + searchedStatement));
                }
                if (chbCSFD.isSelected()) {
                    Desktop.getDesktop().browse(new URI("http://www.csfd.cz/hledat/?q=" + searchedStatement));
                }
                if (chbDownload.isSelected()) {
                    Desktop.getDesktop().browse(new URI("http://www.google.com/#q=" + searchedStatement + "+download+free"));
                }
                if (chbOtherUser.isSelected()) {
                    JFListOfUsers jFListOfUsers = new JFListOfUsers(this.searchedMovie);
                    jFListOfUsers.setVisible(true);
                    jFListOfUsers.setAlwaysOnTop(true);
                }
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(JDSearchInfoOnline.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                dispose();
            }
        }
    }//GEN-LAST:event_btnAnoActionPerformed

    private void chbOtherUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbOtherUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbOtherUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAno;
    private javax.swing.JButton btnNie;
    private javax.swing.JCheckBox chbCSFD;
    private javax.swing.JCheckBox chbDownload;
    private javax.swing.JCheckBox chbIMDb;
    private javax.swing.JCheckBox chbOnline;
    private javax.swing.JCheckBox chbOtherUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtaInfo;
    // End of variables declaration//GEN-END:variables

    private String editInput(String searchedMovie) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchedMovie.length(); i++) {
            if (searchedMovie.charAt(i) == ' ') {
                sb.append('+');
            } else {
                sb.append(searchedMovie.charAt(i));
            }
        }
        return sb.toString().trim();
    }
}

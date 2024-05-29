/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu13257670
 */
public class RestartDialog extends javax.swing.JDialog {
    
    private boolean okConfirmed = false;

    /**
     * Creates new form ConfigDialog
     */
    public RestartDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        playerNameField.setText(ConfigData.getInstance().getPlayerName());
        levelComboBox.setSelectedIndex(ConfigData.getInstance().getLevel());

    }
    
    public String getPlayerName() {
        return playerNameField.getText();
    }
    
    public int getLevel() {
        return levelComboBox.getSelectedIndex();
    }
    
    public boolean isConfirmed() {
        return okConfirmed;
    }
    
    public void setPlayerName(String playerName) {
        playerNameField.setText(playerName);
    }
    
    public void setLastScoreLabel(String scoreString) {
        lastScoreLabel.setText(scoreString);
    }
    
    public void setMessageLabel(String message) {
        messageLabel.setText(message);
    }
    
    public void setConfirmButton (String confirm) {
        confirmButton.setText(confirm);
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        levelLabel = new javax.swing.JLabel();
        levelComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        lastScoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        levelLabel.setText("Select level:");

        levelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Intermediate", "Difficult", " ", " " }));
        levelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelComboBoxActionPerformed(evt);
            }
        });

        confirmButton.setText("OK");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Type your name:");

        playerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameFieldActionPerformed(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        messageLabel.setText("Here goes a message");

        lastScoreLabel.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        lastScoreLabel.setText("here goes last score message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levelLabel)
                    .addComponent(messageLabel)
                    .addComponent(nameLabel)
                    .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastScoreLabel))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lastScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel)
                .addGap(24, 24, 24)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(levelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void levelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelComboBoxActionPerformed
        // TODO add your handling code here:
        switch (levelComboBox.getSelectedIndex()) {
            case 0: //Beginner
                ConfigData.getInstance().setDeltaTime(500);
                ConfigData.getInstance().setLevel(0);
                break;
            case 1: //Intermediate
                ConfigData.getInstance().setDeltaTime(200);
                ConfigData.getInstance().setLevel(1);
                break;
            case 2: //Difficult
                ConfigData.getInstance().setDeltaTime(100);
                ConfigData.getInstance().setLevel(2);
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_levelComboBoxActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        okConfirmed = true;
        setVisible(false);
        //dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void playerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameFieldActionPerformed
        // TODO add your handling code here:
        ConfigData.getInstance().setPlayerName(getPlayerName());
    }//GEN-LAST:event_playerNameFieldActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RestartDialog restartDialog = new RestartDialog(new javax.swing.JFrame(), true);
                restartDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                restartDialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel lastScoreLabel;
    private javax.swing.JComboBox<String> levelComboBox;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField playerNameField;
    // End of variables declaration//GEN-END:variables
}

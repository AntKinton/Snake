/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Timer;

/**
 *
 * @author alu13257670
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        getContentPane().add(board1, java.awt.BorderLayout.CENTER);
        getContentPane().add(scoreBoard1, java.awt.BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        initSettingsDialog();
        pack();
        
    }
    
    public void initSettingsDialog() {
        board1.setPreferredSize(new Dimension(getWidth() * Board.NUM_ROWS, getHeight() * Board.NUM_COLS));
        
        ConfigDialog configDialog = new ConfigDialog(this, true);
        //board1.pauseGame();
        configDialog.setVisible(true);
        board1.requestFocus();
        //board1.initGame();
        board1.newGame();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        newGameButton = new javax.swing.JButton();
        playPauseButton = new javax.swing.JToggleButton();
        scoreBoard1 = new com.mycompany.snake.ScoreBoard();
        board1 = new com.mycompany.snake.Board();
        jMenuBar1 = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        playPauseMenuItem = new javax.swing.JMenuItem();
        restartMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        optionMenu = new javax.swing.JMenu();
        levelMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        newGameButton.setText("New game");
        newGameButton.setFocusable(false);
        newGameButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newGameButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newGameButton);

        playPauseButton.setText("Pause");
        playPauseButton.setFocusable(false);
        playPauseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playPauseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        playPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(playPauseButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(scoreBoard1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(board1, java.awt.BorderLayout.CENTER);

        gameMenu.setText("Game");

        playPauseMenuItem.setText("Play/pause");
        playPauseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(playPauseMenuItem);

        restartMenuItem.setText("Restart");
        restartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(restartMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(exitMenuItem);

        jMenuBar1.add(gameMenu);

        optionMenu.setText("Options");
        optionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMenuActionPerformed(evt);
            }
        });

        levelMenuItem.setText("Level");
        levelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(levelMenuItem);

        aboutMenuItem.setText("About..");
        optionMenu.add(aboutMenuItem);

        jMenuBar1.add(optionMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPauseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseMenuItemActionPerformed
        // TODO add your handling code here:
        board1.pauseGame();
    }//GEN-LAST:event_playPauseMenuItemActionPerformed

    private void playPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseButtonActionPerformed
        // TODO add your handling code here:
        board1.pauseGame();
    }//GEN-LAST:event_playPauseButtonActionPerformed

    private void restartMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartMenuItemActionPerformed
        // TODO add your handling code here:
        board1.initGame();
    }//GEN-LAST:event_restartMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void optionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionMenuActionPerformed

    private void levelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelMenuItemActionPerformed
        // TODO add your handling code here:
        /*ConfigDialog configDialog = new ConfigDialog(this, true);
        board1.pauseGame();
        configDialog.setVisible(true);
        board1.requestFocus();
        board1.initGame();*/
        initSettingsDialog();
    }//GEN-LAST:event_levelMenuItemActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
        board1.newGame();
        board1.initGame();
    }//GEN-LAST:event_newGameButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private com.mycompany.snake.Board board1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem levelMenuItem;
    private javax.swing.JButton newGameButton;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JToggleButton playPauseButton;
    private javax.swing.JMenuItem playPauseMenuItem;
    private javax.swing.JMenuItem restartMenuItem;
    private com.mycompany.snake.ScoreBoard scoreBoard1;
    // End of variables declaration//GEN-END:variables
}

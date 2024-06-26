/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author alu13257670
 */
public class Board extends javax.swing.JPanel {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    snake.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    snake.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    snake.setDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.setDirection(Direction.RIGHT);
                    break;

                case KeyEvent.VK_SPACE:
                    pauseToggleGame();
                    break;
            }
        }
    }

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;
    public static final int NODES_TOGROW = 1;
    public static final int SPECIAL_NODES_TOGROW = 3;
    public static final int FOOD_SCORE = 8;
    public static final int SP_FOOD_SCORE = 24;

    private Snake snake;
    private Food food;
    private SpecialFood sFood;
    private int catchSPCount = 0;
    private static final int SP_FOOD_CATCH_INTERVAL = 20;
    private int respawnSPCount = 0;
    private static final int SP_FOOD_RESPAWN_INTERVAL = 60;
    private MyKeyAdapter keyAdapter;
    private Timer timer;
    private ScoreInterface scoreInterface;
    private JFrame parentFrame;
    private boolean gameStarted = false;


    /**
     * Creates new form Board
     */
    public Board() {
        initComponents();
        //keyAdapter = new MyKeyAdapter();
        //addKeyListener(keyAdapter);
    }

    public void initGame() {
        
        setFocusable(true);
        int deltaTime = ConfigData.getInstance().getDeltaTime();
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(deltaTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tick();
            }
        });
        timer.start();
    }
    
    public void callKeyAdapter() {
        keyAdapter = new MyKeyAdapter();
        addKeyListener(keyAdapter);
    }

    public void pauseToggleGame() {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    public boolean isPaused() {
        return !timer.isRunning();
    }

    public void newGame() {
        snake = new Snake();
        food = genFood();
        initGame();
        doRestartDialog(parentFrame);
        requestFocus();
        repaint();
    }

    public void doRestartDialog(JFrame parentFrame) {
        RestartDialog restartDialog = new RestartDialog(parentFrame, true);
        callKeyAdapter();
        if (!gameStarted) {
            if (!isPaused()) {
                pauseToggleGame();
            }
            restartDialog.setLastScoreLabel("");
            restartDialog.setMessageLabel("Welcome to Snaked!");
            restartDialog.setConfirmButton("Start game..");
        } else {
            if (!isPaused()) {
                pauseToggleGame();
            }
            restartDialog.setLastScoreLabel("Your last score was " + ConfigData.getInstance().getScore() + " points!");
            scoreInterface.resetScorePoints();
            restartDialog.setPlayerName(ConfigData.getInstance().getPlayerName());
            restartDialog.setMessageLabel("Game finished.");
            restartDialog.setConfirmButton("Try again..");
        }
        restartDialog.setVisible(true);
        if (restartDialog.isConfirmed()) {
            if (isPaused()) {
                pauseToggleGame();
            }
            gameStarted = true;
            ConfigData.getInstance().setPlayerName(restartDialog.getPlayerName());
            scoreInterface.setPlayerName(ConfigData.getInstance().getPlayerName());
            ConfigData.getInstance().setLevel(restartDialog.getLevel());
        }
    }

    public void doSettingsDialog(JFrame parentFrame) {
        if (!isPaused()) {
            pauseToggleGame();
        }
        SettingsDialog settingsDialog = new SettingsDialog(parentFrame, true);
        settingsDialog.setVisible(true);
        if (settingsDialog.isConfirmed()) {
            ConfigData.getInstance().setPlayerName(settingsDialog.getPlayerName());
            scoreInterface.setPlayerName(ConfigData.getInstance().getPlayerName());
            ConfigData.getInstance().setLevel(settingsDialog.getLevel());
            pauseToggleGame();
        }
    }

    public void doAboutDialog(JFrame parentFrame) {
        if (!isPaused()) {
            pauseToggleGame();
        }
        AboutDialog aboutDialog = new AboutDialog(parentFrame, true);
        aboutDialog.setVisible(true);
        if (aboutDialog.isConfirmed()) {
            pauseToggleGame();
        }
    }

    public void setScoreInterface(ScoreInterface scoreInterface) {
        this.scoreInterface = scoreInterface;
    }

    private void tick() {
        if (!snake.canMakeMove()) {
            timer.stop();
            
            newGame();
            return;
        }

        if (snake.findsFood(food)) {
            scoreInterface.incrementScorePoints(FOOD_SCORE);
            snake.setNodesToGrow(NODES_TOGROW);
            food = genFood();
        }
        if (snake.findsFood(sFood)) {
            scoreInterface.incrementScorePoints(SP_FOOD_SCORE);
            snake.setNodesToGrow(SPECIAL_NODES_TOGROW);
            sFood = null;

        }
        if (respawnSPCount == SP_FOOD_RESPAWN_INTERVAL) {
            sFood = genSpecialFood();
            respawnSPCount = 0;
            catchSPCount = 0;
        }
        catchSPCount++;
        respawnSPCount++;
        if (catchSPCount == SP_FOOD_CATCH_INTERVAL) {
            sFood = null;
        }
        repaint();
    }

    public Food genFood() {
        return new Food((int) (Math.random() * NUM_ROWS), (int) (Math.random() * NUM_COLS));
    }

    public SpecialFood genSpecialFood() {
        return new SpecialFood((int) (Math.random() * NUM_ROWS), (int) (Math.random() * NUM_COLS));
    }

    public int getSquareWidth() {
        return getWidth() / NUM_COLS;
    }

    public int getSquareHeight() {
        return getHeight() / NUM_ROWS;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() / NUM_COLS * NUM_COLS,
                getHeight() / NUM_ROWS * NUM_ROWS);
        if (!snake.getBody().isEmpty()) {
            snake.paintBody(g, getSquareWidth(), getSquareHeight());
            food.paintNode(g, getSquareWidth(), getSquareHeight());
            if (sFood != null) {
                sFood.paintNode(g, getSquareWidth(), getSquareHeight());
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

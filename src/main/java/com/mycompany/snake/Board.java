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
                    pauseGame();
                    break;
                default:
                    System.out.println("Hello Snake");
                    break;
            }
            //repaint();
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
    private static final int SP_FOOD_CATCH_INTERVAL = 40;
    private int respawnSPCount = 0;
    private static final int SP_FOOD_RESPAWN_INTERVAL = 100;
    //private int currentRow;
    //private int currentCol;
    private MyKeyAdapter keyAdapter;
    private Timer timer;
    private Game game;
    private ScoreBoard scoreBoard;

    /**
     * Creates new form Board
     */
    public Board() {
      initComponents();
    }

    public void initGame() {
        addKeyListener(keyAdapter);
        setFocusable(true);
        //setRequestFocusEnabled(true);
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

    public void pauseGame() {
        if (timer.isRunning() || timer != null) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    public void newGame() {
        snake = new Snake();
        food = genFood();
        sFood = genSpecialFood();
        keyAdapter = new MyKeyAdapter();
        //scoreBoard.reset();
        requestFocus();
        initGame();
        repaint();
    }

    
    private void tick() {
        if (!snake.makeMove()) {
            timer.stop();
            game.initSettingsDialog();
            newGame();
            return;
        }

        if (snake.findsFood(food)) {
            snake.setNodesToGrow(NODES_TOGROW);
            food = genFood();
            scoreBoard.incrementScore(); // Incrementa la puntuación
        } else {
            if (snake.findsFood(sFood)) {
                snake.setNodesToGrow(SPECIAL_NODES_TOGROW);
                sFood = null;
                scoreBoard.incrementScore(); // Incrementa la puntuación                
                if (respawnSPCount == SP_FOOD_RESPAWN_INTERVAL) {
                    sFood = genSpecialFood();
                    respawnSPCount = 0;
                }
            }
            if (catchSPCount == SP_FOOD_CATCH_INTERVAL) {
                catchSPCount = 0;
            }
        }

        catchSPCount++;
        respawnSPCount++;
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
        //g.fillRect(0, 0, getWidth(), getHeight());
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

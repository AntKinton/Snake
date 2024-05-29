/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu13257670
 */
public interface ScoreInterface {
    public void incrementScorePoints(int newFoodPoints);
    public void resetScorePoints();
    public void setPlayerName(String playerName);
    public int getCurrentScore();
}

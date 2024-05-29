/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;


/**
 *
 * @author alu13257670
 */
public class ConfigData {

    private static ConfigData configDataInstance;
    private String playerName;
    private int level;
    private int score;
    private int deltaTime;


    public ConfigData() {
        playerName = "Player1";
        level = 0;
        score = 0;
        deltaTime = 500; //First starts in Beginner level
    }

    public static ConfigData getInstance() {

        if (configDataInstance == null) {
            configDataInstance = new ConfigData();
        }
        return configDataInstance;

    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

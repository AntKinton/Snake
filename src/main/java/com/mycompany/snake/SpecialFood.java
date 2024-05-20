/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alu13257670
 */
public class SpecialFood extends Food {
    
    
    
    public SpecialFood (int row, int col) {
        super(row, col);
    }
    
    public void paintNode (Graphics g, int squareWidth, int squareHeight) {
        Color color = Color.red;
        Util.drawSquare(g, getRow(), getCol(), color, squareWidth, squareHeight);
    }
    
}

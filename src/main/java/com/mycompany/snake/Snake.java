/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alu13257670
 */
public class Snake {
    private List<Node> body;
    private Direction direction;
    private int nodesToGrow;
    
    
    public Snake() {
        body = new ArrayList<Node>();
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 1));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 2));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 3));
        direction = Direction.RIGHT;
        nodesToGrow = 0;
    }
    
    public List<Node> getbody() {
        return body;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    
    public void paint (Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node: body) {
            if (firstNode) {
                color = Color.red;
                firstNode = false;
            } else {
                color = Color.yellow;
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidth, squareHeight);
        }
    }
    
    
}


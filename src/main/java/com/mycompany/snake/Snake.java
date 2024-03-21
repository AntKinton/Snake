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
    
    public List<Node> getBody() {
        return body;
    }
    
    
    public Node getHeadNode() {
        return body.get(0);
    }
    
    public Node getTailNode() {
        return body.get(body.size()-1);
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void move() {
        int headRow = getHeadNode().getRow();
        int headCol = getHeadNode().getCol();
       
        switch (direction) {
            case UP: headRow--;
                break;
            case DOWN: headRow++;
                break;
            case LEFT: headCol--;
                break;
            case RIGHT: headCol++;
                break;
        }
        if (canMove(headRow, headCol)) {
            Node node = new Node (headRow,headCol);
            while (nodesToGrow > 0) {
                body.add(0, node);
                nodesToGrow--;
            }
            System.out.println(body.size());
            removeTailNode();
        }
    }
    
    private void removeTailNode(){
         if (nodesToGrow == 0 && !body.isEmpty()){
           
            body.remove(getTailNode());
        }
        System.out.println(body.size());
    }
    
    public boolean canMove(int headRow, int headCol) {
        if (headRow < 0 || headRow >= Board.NUM_ROWS) {
            return false;
            
        } else {
            if (headCol < 0 || headCol >= Board.NUM_COLS) {
                return false;
            }
        }
        return true;
        
    }
    
    public boolean findsFood(Node node) {
        return (getHeadNode().row == node.row 
                && getHeadNode().col == node.col);
    }
    
    public void setNodesToGrow(int nodesToGrow) {
        this.nodesToGrow = nodesToGrow;
    }
    
    public void paint (Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node: body) {
            if (firstNode) {
                color = Color.green;
                firstNode = false;
            } else {
                color = Color.yellow;
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidth, squareHeight);
        }
    }
    
    
    
}

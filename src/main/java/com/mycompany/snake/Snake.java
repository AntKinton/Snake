/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

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
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 3));
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
        return body.get(body.size() - 1);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /*public boolean canMakeMove() {
        int headRow = getHeadNode().getRow();
        int headCol = getHeadNode().getCol();

        switch (direction) {
            case UP:
                headRow--;
                break;
            case DOWN:
                headRow++;
                break;
            case LEFT:
                headCol--;
                break;
            case RIGHT:
                headCol++;
                break;
        }

        //if (node instanceof Food || node instanceof SpecialFood) {
        //}
        Node currentNode = new Node(headRow, headCol);
        if (checkCollision(headRow, headCol, currentNode)) {
            if (nodesToGrow > 0) {
                nodesToGrow--;
            } else {
                removeTailNode();
            }
            body.add(0, currentNode);
            return true;
        } else {
            return false;
        }
    }*/
    public boolean canMakeMove() {
        int headRow = getHeadNode().getRow();
        int headCol = getHeadNode().getCol();

        // Determina la nueva posición de la cabeza según la dirección actual
        switch (direction) {
            case UP:
                headRow--;
                break;
            case DOWN:
                headRow++;
                break;
            case LEFT:
                headCol--;
                break;
            case RIGHT:
                headCol++;
                break;
        }

        // Verifica si hay una colisión
        if (!checkCollision(headRow, headCol)) {
            Node newHead = new Node(headRow, headCol);
            body.add(0, newHead); // Añade la nueva cabeza al inicio del cuerpo
            if (nodesToGrow > 0) {
                nodesToGrow--; // Decrementa el contador de nodos para crecer
            } else {
                body.remove(body.size() - 1); // Elimina el nodo de la cola
            }
            return true;
        } else {
            return false; // Colisión detectada
        }
    }


    /*   
    Node node = // get the Node object you want to check

if (node instanceof Food) {

    // The node is a Food object

} else {

    // The node is not a Food object

}
     */
 /*public boolean checkCollision(int headRow, int headCol, Node currentNode) {
        if (headRow < 0 || headRow >= Board.NUM_ROWS || headCol < 0 || headCol >= Board.NUM_COLS) {
            return false;
        }

        if (currentNode != null && currentNode.getRow() == headRow && currentNode.getCol() == headCol) {
            return false;
        }
        for (Node node : body) {
            if (node.getRow() == headRow && node.getCol() == headCol) {
                return false;
            }
        }
        if (currentNode != null || currentNode instanceof Food || 
                currentNode instanceof SpecialFood) {
            return false;
        }
        return true;
    }*/
    public boolean checkCollision(int headRow, int headCol) {
        // Verifica si la cabeza de la serpiente está fuera de los límites del tablero
        if (headRow < 0 || headRow >= Board.NUM_ROWS || headCol < 0 || headCol >= Board.NUM_COLS) {
            return true; // Hay colisión con el borde del tablero
        }

        // Verifica si la cabeza de la serpiente colisiona con su propio cuerpo
        for (int i = 1; i < body.size(); i++) { // Comienza en 1 para ignorar la cabeza actual
            Node node = body.get(i);
            if (node.getRow() == headRow && node.getCol() == headCol) {
                return true; // Hay colisión consigo misma
            }
        }

        return false; // No hay colisión
    }

    private void removeTailNode() {
        if (nodesToGrow == 0 && !body.isEmpty()) {
            body.remove(getTailNode());
        }
        //System.out.println(body.size());
    }

    /*public boolean findsFood(Node node) {
        Node head = getHeadNode();
        if (head == null) {
            //System.out.println("Head node is null.");
            return false;
        }

        if (node == null) {
            //System.out.println("Food node is null.");
            return false;
        }

        return head.getRow() == node.getRow() && head.getCol() == node.getCol();
    }*/
    public boolean findsFood(Node node) {
        if (node == null) {
            return false;
        }
        Node head = getHeadNode();
        return head.getRow() == node.getRow() && head.getCol() == node.getCol();
    }

    public void setNodesToGrow(int nodesToGrow) {
        this.nodesToGrow = nodesToGrow;
    }

    public void paintBody(Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node : body) {
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

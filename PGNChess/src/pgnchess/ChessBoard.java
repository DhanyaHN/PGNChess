/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgnchess;

/**
 *
 * @author test
 */
public class ChessBoard {
    ChessPiece[][] board;
    
    public ChessBoard() {
        board = new ChessPiece[8][8];
        initialize();
    }

    private void initialize() {
        // initialize the board
    }
    private void update() {
       // update the board 
    }
    private void display() {
        
    }
}

class ChessPiece {
    char color;
    char name;
    public ChessPiece(char color, char name) {
        this.color = color;
        this.name = name;
    }
}
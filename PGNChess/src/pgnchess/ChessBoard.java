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
        board = new ChessPiece[9][9];
        initialize();
    }

    private void initialize() {
    	initializeFirstRow();
    	for (int i = 2; i <= 7; ++i) {
    		board[2][i] = new ChessPiece('W', 'P', 2, i);
    		board[7][i] = new ChessPiece('B', 'P', 7, i);
    	}
    	for (int i = 3; i <= 6; ++i) {
    		for (int j = 1; j <= 8; ++j) {
    			board[i][j] = null;
    		}
    	}
        // initialize the board
    }
    
    private void initializeFirstRow() {
    	board[1][1] = new ChessPiece('W', 'R', 1, 1);
    	board[1][8] = new ChessPiece('W', 'R', 1, 8);
    	board[1][2] = new ChessPiece('W', 'N', 1, 2);
    	board[1][7] = new ChessPiece('W', 'N', 1, 7);
    	board[1][3] = new ChessPiece('W', 'B', 1, 3);
    	board[1][6] = new ChessPiece('W', 'B', 1, 6);
    	board[1][4] = new ChessPiece('W', 'Q', 1, 4);
    	board[1][5] = new ChessPiece('W', 'K', 1, 5);
    	
    	board[8][1] = new ChessPiece('B', 'R', 8, 1);
    	board[8][8] = new ChessPiece('B', 'R', 8, 8);
    	board[8][2] = new ChessPiece('B', 'N', 8, 2);
    	board[8][7] = new ChessPiece('B', 'N', 8, 7);
    	board[8][3] = new ChessPiece('B', 'B', 8, 3);
    	board[8][6] = new ChessPiece('B', 'B', 8, 6);
    	board[8][4] = new ChessPiece('B', 'K', 8, 4);
    	board[8][5] = new ChessPiece('B', 'Q', 8, 5);
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
    int prev_x;
    int prev_y;
    int cur_x;
    int cur_y;
    public ChessPiece(char color, char name, int prev_x, int prev_y) {
        this.color = color;
        this.name = name;
        this.prev_x = prev_x;
        this.prev_y = prev_y;
        this.cur_x = cur_x;
        this.cur_y = cur_y;
    }
}

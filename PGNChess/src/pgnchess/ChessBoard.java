package pgnchess;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Test
 */
public class ChessBoard {
    
    ChessPiece[][] board;
    Map<String, Position> pieces;
    public ChessBoard() {
        board = new ChessPiece[9][9];
        pieces = new HashMap<>();
        initialize();
    }

    private void initialize() {
    	initializeFirstRow();
    	for (int i = 1; i <= 8; ++i) {
    		board[i][2] = new ChessPiece('W', 'P');
    		board[i][7] = new ChessPiece('B', 'P');
    	}
    	for (int i = 3; i <= 6; ++i) {
    		for (int j = 1; j <= 8; ++j) {
    			board[j][i] = new ChessPiece(' ', ' ');
    		}
    	}
        // initialize the board
    }
    
    private void initializeFirstRow() {
    	board[1][1] = new ChessPiece('W', 'R');
        pieces.put("RW1", new Position(1, 1));
        
    	board[8][1] = new ChessPiece('W', 'R');
        pieces.put("RW2", new Position(1, 8));
    	
        board[2][1] = new ChessPiece('W', 'N');
    	pieces.put("NW1", new Position(1, 2));
        
        board[7][1] = new ChessPiece('W', 'N');
    	pieces.put("NW2", new Position(1, 7));
        
        board[3][1] = new ChessPiece('W', 'B');
    	pieces.put("BW1", new Position(1, 3));
        
        board[6][1] = new ChessPiece('W', 'B');
    	pieces.put("BW2", new Position(1, 6));
        
        board[4][1] = new ChessPiece('W', 'Q');
    	pieces.put("QW", new Position(1, 4));
        
        board[5][1] = new ChessPiece('W', 'K');
    	pieces.put("KW", new Position(1, 5));
        
    	board[1][8] = new ChessPiece('B', 'R');
        pieces.put("RB1", new Position(8, 1));
        
    	board[8][8] = new ChessPiece('B', 'R');
        pieces.put("RB2", new Position(8, 8));
                
    	board[2][8] = new ChessPiece('B', 'N');
        pieces.put("NB1", new Position(8, 2));
                
    	board[7][8] = new ChessPiece('B', 'N');
        pieces.put("NB2", new Position(8, 7));
        
    	board[3][8] = new ChessPiece('B', 'B');
        pieces.put("BB1", new Position(8, 3));
        
    	board[6][8] = new ChessPiece('B', 'B');
        pieces.put("BB2", new Position(8, 2));
        
    	board[4][8] = new ChessPiece('B', 'Q');
        pieces.put("QB", new Position(8, 4));
        
    	board[5][8] = new ChessPiece('B', 'K');
        pieces.put("KB", new Position(8, 5));
    }
    
    public void update(String move,char color ) {
        
        System.out.println(move + "  "+ color);
        // handling a pawn move
        //System.out.println(pieces.get("PW4").cur_x + "   "+ pieces.get("PW4").cur_y);
        if ( move.length() == 2 ){
            
            int x = Integer.parseInt((move.charAt(0) - 96)+"");
            int y = Integer.parseInt(move.charAt(1)+"");
            int num1 = 1;
            int num2 = 2;
            if ( color == 'B') {
                num1 = -1;
                num2 = -2;
            }
           
                    
            //System.out.println(x + " " + y);
            if ( board[x][y - num1].name == 'P' && board[x][y - num1].color == color ) {
                board[x][y] = new ChessPiece(color, 'P');
                board[x][y - 1] = new ChessPiece(' ', ' ');
            }
            else if ( board[x][y - num2].name == 'P' && board[x][y - num2].color == color ) {
                board[x][y] = new ChessPiece(color, 'P');
                board[x][y - 2] = new ChessPiece(' ', ' ');
            }
        }
        display(board);
        
       // update the board 
    }
    public void display(ChessPiece board[][]) {
        for ( int i = 8; i > 0; i--) {
           for( int j = 1; j <= 8 ; j++ ) {
               if (board[i][j].name != ' ') {
                   System.out.print(j+""+i+""+board[i][j].name + " " + board[i][j].color+"\t");
               }
               else {
                   System.out.print(j+""+i+""+"E" + "  "+"\t");
               }
           }
           System.out.println();
        }
    }
}
class ChessPiece {
    public char color;
    public char name;
    
    
    public ChessPiece(char color, char name) {
        this.color = color;
        this.name = name;
        
    }
    public char getColor() {
        return this.color;
    }
    public char getName() {
        return this.name;
    }
}
class Position{
    int prev_x;
    int prev_y;
    int cur_x;
    int cur_y;
    
    public Position(int x, int y)
    {
        this.prev_x = x;
        this.prev_y = y;
        this.cur_x = x;
        this.cur_y = y;
         
    }
    public void move(int next_x,int next_y)
    {
        this.prev_x = this.cur_x;
        this.prev_y = this.cur_y;
        this.cur_x = next_x;
        this.cur_y = next_y;
        
    }
    
    
}

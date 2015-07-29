package pgnchess;

/**
 *
 * @author Test
 */
public class ChessBoard {
    
    ChessPiece[][] board;
    
    public ChessBoard() {
        board = new ChessPiece[8][8];
        initialize();
    }

    private void initialize() {
    	initializeFirstRow();
    	for (int i = 2; i <= 7; ++i) {
    		board[2][i] = new ChessPiece('W', 'P');
    		board[7][i] = new ChessPiece('B', 'P');
    	}
    	for (int i = 3; i <= 6; ++i) {
    		for (int j = 1; j <= 8; ++j) {
    			board[i][j] = null;
    		}
    	}
        // initialize the board
    }
    
    private void initializeFirstRow() {
    	board[1][1] = new ChessPiece('W', 'R');
    	board[1][8] = new ChessPiece('W', 'R');
    	board[1][2] = new ChessPiece('W', 'N');
    	board[1][7] = new ChessPiece('W', 'N');
    	board[1][3] = new ChessPiece('W', 'B');
    	board[1][6] = new ChessPiece('W', 'B');
    	board[1][4] = new ChessPiece('W', 'Q');
    	board[1][5] = new ChessPiece('W', 'K');
    	
    	board[8][1] = new ChessPiece('B', 'R');
    	board[8][8] = new ChessPiece('B', 'R');
    	board[8][2] = new ChessPiece('B', 'N');
    	board[8][7] = new ChessPiece('B', 'N');
    	board[8][3] = new ChessPiece('B', 'B');
    	board[8][6] = new ChessPiece('B', 'B');
    	board[8][4] = new ChessPiece('B', 'K');
    	board[8][5] = new ChessPiece('B', 'Q');
    }
    
    private void update(String move,char color ) {
        
        board[1][7].name = 'R';
        
        
        
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

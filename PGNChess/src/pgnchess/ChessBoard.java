package pgnchess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Test
 */
public class ChessBoard {
    
    ChessPiece[][] board;
    public ChessBoard() {
        board = new ChessPiece[9][9];
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
        
    	board[8][1] = new ChessPiece('W', 'R');
        
        board[2][1] = new ChessPiece('W', 'N');
        
        board[7][1] = new ChessPiece('W', 'N');
        
        board[3][1] = new ChessPiece('W', 'B');
        
        board[6][1] = new ChessPiece('W', 'B');

        board[4][1] = new ChessPiece('W', 'Q');

        board[5][1] = new ChessPiece('W', 'K');

    	board[1][8] = new ChessPiece('B', 'R');

    	board[8][8] = new ChessPiece('B', 'R');
       
    	board[2][8] = new ChessPiece('B', 'N');
        
    	board[7][8] = new ChessPiece('B', 'N');

    	board[3][8] = new ChessPiece('B', 'B');

    	board[6][8] = new ChessPiece('B', 'B');
        
    	board[4][8] = new ChessPiece('B', 'Q');

    	board[5][8] = new ChessPiece('B', 'K');
    }
    
    public void update(String move,char color ) {
        
        //System.out.println(move + "  "+ color);
        
        List<Point> prevPossiblePos = new ArrayList<>();
        // handling a pawn move
        
        if ( move.length() == 2 ){
            
            int x = Integer.parseInt((move.charAt(0) - 96)+"");
            int y = Integer.parseInt(move.charAt(1)+"");
            prevPossiblePos = getPossiblePrevPositions(x, y, 'P', color);
            for( Point p : prevPossiblePos) {
                if ( board[p.x][p.y].name == 'P' && board[p.x][p.y].color == color ) {
                    board[x][y] = new ChessPiece(color, 'P');
                    board[p.x][p.y] = new ChessPiece(' ', ' ');
                }
            }
        }
        else if (move.length() == 3 ) {
            char name = move.charAt(0);
            int x = Integer.parseInt((move.charAt(1) - 96)+"");
            int y = Integer.parseInt(move.charAt(2)+"");
            prevPossiblePos = getPossiblePrevPositions(x, y, name, color);
            for( Point p : prevPossiblePos) {
                if ( board[p.x][p.y].name == name && board[p.x][p.y].color == color ) {
                    board[x][y] = new ChessPiece(color, name);
                    board[p.x][p.y] = new ChessPiece(' ', ' ');
                }
            }
        }
        else if (move.length() == 4 ) {
            int befCapPosX = 0;
            int befCapPosY = 0;
            int x = Integer.parseInt((move.charAt(2) - 96)+"");
            int y = Integer.parseInt(move.charAt(3)+"");
            List<Point> possiblePrevPos = new ArrayList<>();
            
            
            if ( move.charAt(1) == 'x' ) {
                //6 or 4
                if ((move.charAt(0)+"").toLowerCase().equals(move.charAt(0)+""))
                {
                    befCapPosX = Integer.parseInt((move.charAt(0) - 96)+"");
                    if ( color == 'W') {
                    befCapPosY = y - 1;
                    }
                    else {
                        befCapPosY = y + 1;
                    }
                    board[x][y].name = 'P';
                    board[x][y].color = color;
                    board[befCapPosX][befCapPosY].color = ' ';
                    board[befCapPosX][befCapPosY].name = ' ';
                }
                else {
                    char name = move.charAt(0);
                    possiblePrevPos = getPossiblePrevPositions(x, y, name, color);
                    for( Point p : possiblePrevPos) {
                        if ( board[p.x][p.y].name == name && board[p.x][p.y].color == color ) {
                            board[x][y].color = color;
                            board[x][y].name = name;
                            board[p.x][p.y].color = ' ';
                            board[p.x][p.y].name = ' ';
                        }
                    }
                }
            }
            
        }
        if ( "1/2-1/2".equals(move) ) {
            display(board);
        }
        
    }
    public void display(ChessPiece board[][]) {
        for ( int i = 8; i > 0; i--) {
           for( int j = 1; j <= 8 ; j++ ) {
               if (board[i][j].name != ' ') {
                   System.out.print(j+""+i+""+board[i][j].name + " " + board[i][j].color+"\t");
               }
               else {
                   System.out.print(j+""+i+""+"-" + "  "+"\t");
               }
           }
           System.out.println();
        }
    }

    private List<Point> getPossiblePrevPositions(int x, int y, char name, char color) {
        List<Point> possiblePrevPos = new ArrayList<>();
        
        if ( name == 'P') {
            possiblePrevPos = getPawnPos(x, y, color, possiblePrevPos);    
        }
        else if ( name == 'R') {
            possiblePrevPos = getRookPos(x, y, possiblePrevPos);
        }
        else if ( name == 'N') {
            possiblePrevPos = getKnightPos(x, y, possiblePrevPos);
        }
        
        else if ( name == 'K') {
        	possiblePrevPos = getKingPos(x, y, possiblePrevPos);
        }
        
        return possiblePrevPos;
    }

    private List<Point> getPawnPos(int x, int y, char color, List<Point> possiblePrevPos) {
        int num1 = 1;
        int num2 = 2;
        if ( color == 'B') {
            num1 = -1;
            num2 = -2;
        }
        possiblePrevPos.add(new Point(x, y - num1));
        possiblePrevPos.add(new Point(x, y - num2));
        return possiblePrevPos;
    }
   

    private List<Point> getRookPos(int x, int y, List<Point> possiblePrevPos) {
        for(int i=x+1;i<=8;i++)
        {
            possiblePrevPos.add(new Point(x,i));
            possiblePrevPos.add(new Point(i,x));
        }
        for(int i=x-1;i>=1;i--)
        {
            possiblePrevPos.add(new Point(x,i));
            possiblePrevPos.add(new Point(i,x));
        }
        return possiblePrevPos;
    }
    
    private List<Point> getKnightPos(int x, int y, List<Point> possiblePrevPos) {
        int xMove[] = {1, 1, -1, -1, 2, 2, -2, -2};
    	int yMove[] = {2, -2, 2, -2, 1, -1, 1, -1};
    		
    	for (int i = 0;i < 8; ++i) {
    		boolean validXValue = (x + xMove[i] >=1) && (x + xMove[i] <= 8);
    		boolean validYValue = (y + yMove[i] >=1) && (y + yMove[i] <= 8);
    		if(validXValue && validYValue) {
                    possiblePrevPos.add(new Point(x + xMove[i], y + yMove[i]));
    		}
    	}
        return possiblePrevPos;
    }
    
        
    private List<Point> getKingPos(int x, int y, List<Point> possiblePrevPos) {
        int xMove[] = {0, 0, 1, -1, 1, -1, -1, 1};
        int yMove[] = {1, -1, 0, 0, 1, 1, -1, -1};
        
        for (int i = 0; i < 8; ++i) {
        	boolean validXValue = (x + xMove[i] >=1) && (x + xMove[i] <= 8);
    		boolean validYValue = (y + yMove[i] >=1) && (y + yMove[i] <= 8);
    		if(validXValue && validYValue) {
                	possiblePrevPos.add(new Point(x + xMove[i], y + yMove[i]));
    		}
        }
        return possiblePrevPos;
    }

    
    private List<Point> getBishopPos(int x,int y, List<Point> possiblePrevPos){
        
        for(int i=x+1;i<=8;i++)
        {
            possiblePrevPos.add(new Point(i,i));
            if(8 - i > 0) {
                possiblePrevPos.add(new Point(8-i,i));
            }
        }
        for(int i=x-1;i>=1;i--)
        {
           possiblePrevPos.add(new Point(i,i));
            if (8 - i > 0) {
                possiblePrevPos.add(new Point(8-i,i));
            }
                
        }
       return possiblePrevPos;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgnchess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class PGNChess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ChessBoard board = new ChessBoard();
        File file = new File("C:\\Users\\test\\Documents\\NetBeansProjects\\PGNChess\\PGNChess\\src\\pgnchess\\input");
        
            Scanner in = new Scanner(file);
            String move[];
            while ( in.hasNextLine() ) {
                move = getMove(in);
                System.out.println(move[0] + "  "+ move[1]);
            }
            in.close();
    }

    private static String[] getMove(Scanner in) {
        String[] rec;   
        rec = in.nextLine().split(" ");       
        return rec;
    }
    
}

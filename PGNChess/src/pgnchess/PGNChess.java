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
    public static void main(String[] args) {
        // TODO code application logic here
        ChessBoard board = new ChessBoard();
        readInput("C:\\Users\\test\\Documents\\NetBeansProjects\\PGNChess\\PGNChess\\src\\pgnchess\\input");
    }

    private static void readInput(String path) {
        File file = new File(path);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                    String[] rec = in.nextLine().split(" ");
                    System.out.println(rec[0] + "   " + rec[1]);
                    board.update(rec[0], 'W');
                    board.update(rec[1], 'B');

                }
                in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PGNChess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

package controllers;

import com.sun.deploy.security.BlacklistedCerts;
import models.*;
import views.TetrisBoard;
import wheelsunh.users.Rectangle;
import wheelsunh.users.TextBox;

import java.awt.*;
import java.util.Random;

/**
 * TetrisController.java:
 * Class to hold all of the game logic for tetris
 *
 */
public class TetrisController
{
    private final TetrisBoard TETRIS_BOARD;
    public String nShape;



    /**
     * Constructor to take in a tetris board so the controller and the board can communciate
     *
     * @param tetrisBoard A tetris board instance
     */
    public TetrisController( TetrisBoard tetrisBoard )
    {
        this.TETRIS_BOARD = tetrisBoard;
    }

    /**
     * Randomly chooses the next tetronimo and returns it
     *
     * @return The next tetronimo to be played
     */
    public Tetronimo getNextTetromino() {

        Random rNumbers = new Random();
        int nextShape = 1 + rNumbers.nextInt(7);
        Tetronimo tetronimo = null;

        switch (nextShape) {
            case 1:
                tetronimo = new Square();
                 setnShape("square");
                break;

            case 2:
                tetronimo = new RightL();
                setnShape("rightL");
                break;

            case 3:
                tetronimo = new OddShape();
                setnShape("oddShape");
                break;

            case 4:
                tetronimo = new LeftL();
                setnShape("leftL");
                break;

            case 5:
                tetronimo = new RightStep();
                setnShape("rStep");
                break;

            case 6:
                tetronimo = new LeftStep();
                setnShape("lStep");
                break;

            case 7:
                tetronimo = new StraightLine();
                setnShape("straight");
                break;
        }

            tetronimo.setLocation(40 + (5 * Tetronimo.SIZE), 0);

        return tetronimo;

    }

    /**
     * Method to determine if the tetronimo has landed
     *
     * @param tetronimo The tetronimo to evaluate
     * @return True if the tetronimo has landed (on the bottom of the board or another tetronimo), false if it has not
     */
    public boolean tetronimoLanded(Tetronimo tetronimo, Integer[][] isSpotOpen)
    {

        // int value conversions to translate tetronimo piece locations into 2D array coordinates
        int r1xLoc = (tetronimo.r1.getXLocation() / 20) - 2;
        int r2xLoc = (tetronimo.r2.getXLocation() / 20) - 2;
        int r3xLoc = (tetronimo.r3.getXLocation() / 20) - 2;
        int r4xLoc = (tetronimo.r4.getXLocation() / 20) - 2;
        int r1yLoc = (((tetronimo.r1.getYLocation() + 20) / 20) - 1);
        int r2yLoc = (((tetronimo.r2.getYLocation() + 20) / 20) - 1);
        int r3yLoc = (((tetronimo.r3.getYLocation() + 20) / 20) - 1) ;
        int r4yLoc = (((tetronimo.r4.getYLocation() + 20) / 20) - 1) ;
        int nextY = tetronimo.getYLocation() + tetronimo.getHeight() + Tetronimo.SIZE;      // hold value of next Y location

        if (isSpotOpen[r1xLoc][r1yLoc] == 0 || isSpotOpen[r2xLoc][r2yLoc] == 0 || isSpotOpen[r3xLoc][r3yLoc] == 0
                || isSpotOpen[r4xLoc][r4yLoc] == 0)
            return false;

        else
            return nextY <= 480;
    }

    /**
     * sets value of string s to shape name for use in paintBoard method
     * @param s
     */
    public void setnShape(String s){

        this.nShape = s;
    }

    /**
     *  getter method to grab current shape for paintBoard method
     * @return
     */
    public String getnShape(){

        return this.nShape;
    }

}   // end class TetrisController

package views;

import controllers.TetrisController;
import models.Tetronimo;
import wheelsunh.users.*;
import wheelsunh.users.Frame;
import wheelsunh.users.Rectangle;
import wheelsunh.users.AnimationTimer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;


/**
 * TetrisBoard.java:
 * Class to model the tetris board
 *
 *
 * @see java.awt.Color
 * @see java.awt.event.KeyListener
 * @see java.awt.event.KeyEvent
 */
public class TetrisBoard implements KeyListener
{
    /**
     * Constant to represent the width of the board
     */
    public static final int WIDTH = 10;

    /**
     * Constant to represnet the height of the board
     */
    public static final int HEIGHT = 24;
    private final TetrisController CONTROLLER;
    private Tetronimo tetronimo;                // abstract shape
    private Rectangle[][] playingField;         // 2D array model of board for painting purposes
    public Integer[][] isSpotOpen;          // 2d array that stores 1 if spot on board open, 0 if it is full
   // AnimationTimer timer1 = new AnimationTimer(500, Animator());

    private TextBox tB; // labels score board
    private TextBox score; // holds score
    private TextBox status; // current game status


    /**
     * Constructor to initialize the board
     *
     * @param frame The wheelsunh frame (so we can add this class as a key listener for the frame)
     */
    public TetrisBoard(Frame frame)
    {
        this.status = new TextBox();    // status of game
        this.score = new TextBox();     // text field for score
        this.tB = new TextBox();        // labels score
        tB.setLocation(280, 20);
        tB.setSize(65, 40);
        tB.setText("SCORE:");
        score.setLocation(280, 60);
        score.setSize(65, 40);
        score.setText("0");
        status.setLocation(280, 140);
        status.setSize(110,40);
        status.setText("Game in Progess");
        frame.addKeyListener( this );
        this.CONTROLLER = new TetrisController( this );
        this.buildBoard();      // call method to build the board

        this.run();
    }

    /**
     * builds 2D array board to keep track if location is open or occupied
     */
    private void buildTruthTable(){

        this.isSpotOpen = new Integer[ WIDTH][ HEIGHT];
        for ( int i = 0; i < TetrisBoard.WIDTH; i++ )
        {
            for ( int j = 0; j < TetrisBoard.HEIGHT; j++ )
            {

                this.isSpotOpen[ i ][ j ] = 1;
            }
        }
    }


    /**
     * Builds the playing field for tetris
     */
    private void buildBoard()
    {
        this.playingField = new Rectangle[ WIDTH ][ HEIGHT ];

        for ( int i = 0; i < TetrisBoard.WIDTH; i++ )
        {
            for ( int j = 0; j < TetrisBoard.HEIGHT; j++ )
            {
                this.playingField[ i ][ j ] = new Rectangle();
                this.playingField[ i ][ j ].setLocation( i * 20 + 40, j * 20 );
                this.playingField[ i ][ j ].setSize( Tetronimo.SIZE, Tetronimo.SIZE );
                this.playingField[ i ][ j ].setColor( Color.WHITE );
                this.playingField[ i ][ j ].setFrameColor( Color.BLACK );

            }
        }

    }

    /**
     * Starts gameplay and is responsible for keeping the game going (INCOMPLETE)
     */

    public void run()
    {
        this.buildTruthTable();     // method call to build 2D array to keep track of open and filled spots

        for (int i = 0; i < 20 ; i++ ) {
            this.tetronimo = this.CONTROLLER.getNextTetromino();

            while (this.CONTROLLER.tetronimoLanded(this.tetronimo, this.isSpotOpen)) {
                this.tetronimo.setLocation(this.tetronimo.getXLocation(),
                        this.tetronimo.getYLocation() + Tetronimo.SIZE);
                Utilities.sleep(200);
            }
            
            if (!this.CONTROLLER.tetronimoLanded(this.tetronimo,this.isSpotOpen)) {
                this.paintBoard(this.tetronimo, this.playingField);
                this.tetronimo.hide();
            }


            if (this.tetronimo.r1.getYLocation() < 0) {
                this.status.setText("Game Over!");

            }
            this.tetronimo = null;
        }
    } // ends run

    /**
     * Getter method for the array representing the playing field, not used yet but will be needed by the controller later
     *
     * @return The playing field
     */
    public Rectangle[][] getPlayingField()
    {
        return playingField;
    }

    /**
     * This method is not used in this program
     *
     * @param e The key event
     */
    @Override
    public void keyTyped( KeyEvent e )
    {
        //not in use
    }

    /**
     * Handles the key events by the user (INCOMPLETE)
     *
     * @param e The key event
     */
    @Override
    public void keyPressed( KeyEvent e )
    {
        int key = e.getKeyCode();

        if( this.tetronimo == null )
        {
            return;
        }

        switch( key ) {
            case 38:
               // if (this.tetronimo.getXLocation() + this.tetronimo.getWidth() <
                     //   ((TetrisBoard.WIDTH * Tetronimo.SIZE) + 20)){
                    this.tetronimo.rotate();

                break;
            case 37:
                if( this.tetronimo.getXLocation() - Tetronimo.SIZE >= 40 )
                {
                    this.tetronimo.shiftLeft();
                }
                break;
            case 39:
                if( (this.tetronimo.getXLocation() + this.tetronimo.getWidth()) <
                        ((TetrisBoard.WIDTH * Tetronimo.SIZE) + 40))
                {
                    this.tetronimo.shiftRight();
                }
                break;
        }

    }

    /**
     * This method is not used in this program
     *
     * @param e The key event
     */
    @Override
    public void keyReleased( KeyEvent e )
    {
        //not in use
    }

    /**
     *  method paintBoard paints the board where tetronimo landed and updates array to keep track of what is open and not on board
     * @param tetronimo
     * @param playingField
     * @param
     */

    public void paintBoard(Tetronimo tetronimo, Rectangle[][] playingField) {

        int filled = 0;
        this.playingField = playingField;

        // paints board where piece lands
        this.playingField[(tetronimo.r1.getXLocation() / 20) - 2][(tetronimo.r1.getYLocation() + 20) / 20 - 1].setColor(Color.BLACK);
        this.playingField[(tetronimo.r2.getXLocation() / 20) - 2][(tetronimo.r2.getYLocation() + 20) / 20 - 1].setColor(Color.BLACK);
        this.playingField[(tetronimo.r3.getXLocation() / 20) - 2][(tetronimo.r3.getYLocation() + 20) / 20 - 1].setColor(Color.BLACK);
        this.playingField[(tetronimo.r4.getXLocation() / 20) - 2][(tetronimo.r4.getYLocation() + 20) / 20 - 1].setColor(Color.BLACK);

        // updates 2D array as to which spots are open and filled
        isSpotOpen[(tetronimo.r1.getXLocation() / 20) - 2][(tetronimo.r1.getYLocation() + 20) / 20 - 2] = filled;
        isSpotOpen[(tetronimo.r2.getXLocation() / 20) - 2][(tetronimo.r2.getYLocation() + 20) / 20 - 2] = filled;
        isSpotOpen[(tetronimo.r3.getXLocation() / 20) - 2][(tetronimo.r3.getYLocation() + 20) / 20 - 2] = filled;
        isSpotOpen[(tetronimo.r4.getXLocation() / 20) - 2][(tetronimo.r4.getYLocation() + 20) / 20 - 2] = filled;

        checkLineFull(isSpotOpen);

    } // end method paintBoard

    /**
     *  method checks to see if a line on the board is full and updates the score
     * @param isSpotOpen
     */
    public void checkLineFull(Integer[][] isSpotOpen) {

        int totalScore = 0;     // keeps track of score
        int i = 0;              // variable for x coordinate in array
        int fullRow = 0;        // variable to keep track of which row is full
        for (int j = 0; j < 24; j++) {
            if (isSpotOpen[i][j] == 0 && isSpotOpen[i + 1][j] == 0 && isSpotOpen[i + 2][j] == 0 && isSpotOpen[i + 3][j] == 0 && isSpotOpen[i + 4][j] == 0 &&
                    isSpotOpen[i + 5][j] == 0 && isSpotOpen[i + 6][j] == 0 && isSpotOpen[i + 7][j] == 0 && isSpotOpen[i+ 8][j] == 0 && isSpotOpen[i+ 9][j] == 0) {
                fullRow = j;
                System.out.println(fullRow);
                totalScore += 100;      // update score when line is full
                this.score.setText(String.valueOf(totalScore)); //update score text box
                clearLine(fullRow);
            }
        }
    } // end method checkLineFull

    public void clearLine(int fullRow){

        int row = fullRow;
        for (int k = 0; k < 10; k++) {
            this.playingField[k][row + 1].setColor(Color.WHITE);
            this.playingField[k][row + 1].setFrameColor(Color.BLACK);
        }

    }

    } // end class TetrisBoard

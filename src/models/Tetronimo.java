package models;

import views.TetrisBoard;
import wheelsunh.users.Animator;
import wheelsunh.users.Rectangle;
import wheelsunh.users.ShapeGroup;

import java.awt.*;

/**
 * Tetronimo.java:
 * An abstract class to model the base capaabilities of a tetronimo
 *
 *
 * @see java.awt.Color
 */
public abstract class Tetronimo extends ShapeGroup {
    /**
     * Constant to represent the size of the tetronimo
     */
    public static final int SIZE = 20;

    public Rectangle r1;
    public Rectangle r2;
    public Rectangle r3;
    public Rectangle r4;

    public int curRotation = 1;

    /**
     * Generates the four rectangles for the tetronino and puts them on the screen, they are at the default coordinates
     * to start
     */
    public Tetronimo() {
        super();
        this.r1 = new Rectangle();
        this.r1.setSize(Tetronimo.SIZE, Tetronimo.SIZE);
        this.r1.setFrameColor(Color.BLACK);

        this.r2 = new Rectangle();
        this.r2.setSize(Tetronimo.SIZE, Tetronimo.SIZE);
        this.r2.setFrameColor(Color.BLACK);

        this.r3 = new Rectangle();
        this.r3.setSize(Tetronimo.SIZE, Tetronimo.SIZE);
        this.r3.setFrameColor(Color.BLACK);

        this.r4 = new Rectangle();
        this.r4.setSize(Tetronimo.SIZE, Tetronimo.SIZE);
        this.r4.setFrameColor(Color.BLACK);
    }

    /**
     * Increments the rotation of the tetronimo, other classes need to override this to provide the full functionality
     */
    public void rotate() {
        this.curRotation++;
    }

    /**
     * Shifts the tetronimo left one row
     */
    public void shiftLeft() {
        super.setLocation(super.getXLocation() - Tetronimo.SIZE, super.getYLocation());
    }

    /**
     * Shifts the tetronimo right one row
     */
    public void shiftRight() {
        super.setLocation(super.getXLocation() + Tetronimo.SIZE, super.getYLocation());
    }

    /**
     * method to hide tetronimo after it has landed
     */
    public void hide(){
        r1.hide();
        r2.hide();
        r3.hide();
        r4.hide();
    }


}

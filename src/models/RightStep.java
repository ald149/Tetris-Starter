package models;

import java.awt.*;

/**
 * RightStep.java:
 * Creates a right s or right step tetronimo
 *
 * @author andy darby
 * @version 1.0 July 24, 2020
 *
 * @see java.awt.Point
 */
public class RightStep extends Tetronimo {
    /**
     * Creates the tetronimo and puts it in the horizontal orientation
     */
    public RightStep() {
        super.r1.setLocation(Tetronimo.SIZE, 0);
        super.r2.setLocation(Tetronimo.SIZE * 2, 0);
        super.r3.setLocation(0, Tetronimo.SIZE);
        super.r4.setLocation(Tetronimo.SIZE, Tetronimo.SIZE);
        super.r1.setColor(Color.GRAY);
        super.r2.setColor(Color.GRAY);
        super.r3.setColor(Color.GRAY);
        super.r4.setColor(Color.GRAY);
        this.r1.setFrameColor( Color.BLACK );
        this.r2.setFrameColor( Color.BLACK );
        this.r3.setFrameColor( Color.BLACK );
        this.r4.setFrameColor( Color.BLACK );

        super.add(r1);
        super.add(r2);
        super.add(r3);
        super.add(r4);
    }

    /**
     * Rotates the tetronimo
     */
    @Override
    public void rotate() {
        super.rotate();

        Point curLoc = super.getLocation();
        super.setLocation(0, 0);

        if (super.curRotation % 2 == 0) {
            super.r1.setLocation(0, 0);
            super.r2.setLocation(0, Tetronimo.SIZE);
            super.r3.setLocation(Tetronimo.SIZE, Tetronimo.SIZE);
            super.r4.setLocation(Tetronimo.SIZE, Tetronimo.SIZE * 2);
        } else {
            super.r1.setLocation(Tetronimo.SIZE, 0);
            super.r2.setLocation(Tetronimo.SIZE * 2, 0);
            super.r3.setLocation(0, Tetronimo.SIZE);
            super.r4.setLocation(Tetronimo.SIZE, Tetronimo.SIZE);
        }

        super.setLocation(curLoc);
    }

    /**
     * Gets the height of the tetronimo based on the orientation
     *
     * @return The height of the tetronimo
     */
    @Override
    public int getHeight() {
        if (this.curRotation % 2 == 0) {
            return Tetronimo.SIZE * 3;
        } else {
            return Tetronimo.SIZE * 2;
        }
    }     // ends method getHeight

    /**
     * Gets the width of the tetronimo based on the orientation
     *
     * @return The width of the tetronimo
     */
    @Override
    public int getWidth() {
        if (this.curRotation % 2 == 0) {
            return Tetronimo.SIZE * 2;
        } else {
            return Tetronimo.SIZE * 3;
        }
    }   // ends method getWidth
} // ends class RightStep
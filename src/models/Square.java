package models;
import wheelsunh.users.Rectangle;

import java.awt.*;

/**
 * Square.java:
 * Creates square tetronimo
 *
 * @author andy darby
 *
 *
 * @see java.awt.Point
 */
public class Square extends Tetronimo
{
    /**
     * Creates the tetronimo and puts it in the vertical orientation and colors the shape
     */
    public Square()
    {
        super.r1.setLocation( 0, 0 );
        super.r1.setColor(Color.GREEN);
        super.r2.setLocation( 0, Tetronimo.SIZE );
        super.r2.setColor(Color.GREEN);
        super.r3.setLocation(Tetronimo.SIZE, 0);
        super.r3.setColor(Color.GREEN);
        super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE);
        super.r4.setColor(Color.GREEN);
        this.r1.setFrameColor( Color.BLACK );
        this.r2.setFrameColor( Color.BLACK );
        this.r3.setFrameColor( Color.BLACK );
        this.r4.setFrameColor( Color.BLACK );

        super.add( r1 );
        super.add( r2 );
        super.add( r3 );
        super.add( r4 );
    }
    @Override
    public int getHeight()
    {
        return Tetronimo.SIZE * 2;
    }

    /**
     * Gets the width of the tetronimo based on the orientation
     *
     * @return The width of the tetronimo
     */
    @Override
    public int getWidth()
    {
        return Tetronimo.SIZE * 2;
    }

}




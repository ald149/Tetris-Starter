package models;

import java.awt.*;

import wheelsunh.users.Rectangle;

/**
 * RightL.java:
 * Creates right facing L tetronimo
 *
 * @author andy darby
 *
 *
 * @see java.awt.Point
 */
public class RightL extends Tetronimo
{
    /**
     * Creates the tetronimo and puts it in the vertical orientation and colors shape
     */
    public RightL()
    {
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( 0, Tetronimo.SIZE );
        super.r3.setLocation( 0, Tetronimo.SIZE * 2 );
        super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE * 2 );
        super.r1.setColor(Color.ORANGE);
        super.r2.setColor(Color.ORANGE);
        super.r3.setColor(Color.ORANGE);
        super.r4.setColor(Color.ORANGE);
        super.r1.setFrameColor( Color.BLACK );
        super.r2.setFrameColor( Color.BLACK );
        super.r3.setFrameColor( Color.BLACK );
        super.r4.setFrameColor( Color.BLACK );

        super.add( r1 );
        super.add( r2 );
        super.add( r3 );
        super.add( r4 );
    }

    /**
     * Rotates the tetronimo
     */
    @Override
    public void rotate()
    {
        super.rotate();

        Point curLoc = super.getLocation();
        super.setLocation( 0, 0 );

        if( super.curRotation % 4 == 2 )
        {
            super.r1.setLocation( 0, Tetronimo.SIZE);
            super.r2.setLocation( Tetronimo.SIZE, Tetronimo.SIZE );
            super.r3.setLocation( Tetronimo.SIZE * 2, Tetronimo.SIZE );
            super.r4.setLocation( Tetronimo.SIZE * 2, 0);
        }
        else if (super.curRotation % 4 == 3)
        {
            super.r1.setLocation( 0, 0 );
            super.r2.setLocation(  Tetronimo.SIZE, 0);
            super.r3.setLocation( Tetronimo.SIZE, Tetronimo.SIZE );
            super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE * 2 );
        }

        else if (super.curRotation % 4 == 4)
        {
            super.r1.setLocation( 0, 0 );
            super.r2.setLocation( Tetronimo.SIZE, 0 );
            super.r3.setLocation( Tetronimo.SIZE * 2, 0 );
            super.r4.setLocation( 0, Tetronimo.SIZE  );
        }

        else {
            super.r1.setLocation( 0, 0 );
            super.r2.setLocation( 0, Tetronimo.SIZE );
            super.r3.setLocation( 0, Tetronimo.SIZE * 2 );
            super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE * 2 );

        }

        super.setLocation( curLoc );
    }

    /**
     * Gets the height of the tetronimo based on the orientation
     *
     * @return The height of the tetronimo
     */
    @Override
    public int getHeight()
    {
        if( this.curRotation % 4 == 2 )
        {
            return Tetronimo.SIZE * 2;
        }
        else if( this.curRotation % 4 == 3 )
        {
            return Tetronimo.SIZE * 3;
        }

        else if( this.curRotation % 4 == 4 )
        {
            return Tetronimo.SIZE * 2;
        }


        else if( this.curRotation % 4 == 0 )
        {
            return Tetronimo.SIZE * 2;
        }

            return Tetronimo.SIZE * 3;
    }

    /**
     * Gets the width of the tetronimo based on the orientation
     *
     * @return The width of the tetronimo
     */
    @Override
    public int getWidth()
    {
        if( this.curRotation % 4 == 2 )
        {
            return Tetronimo.SIZE * 3;
        }
        else if (this.curRotation % 4 == 3)
        {
            return Tetronimo.SIZE * 2;
        }
        else if (this.curRotation % 4 == 4)
        {
            return Tetronimo.SIZE * 3;
        }
        else if (this.curRotation % 4 == 0)
        {
            return Tetronimo.SIZE * 3;
        }
        else
            return Tetronimo.SIZE * 2;
    }
}


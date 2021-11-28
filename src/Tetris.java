import views.TetrisBoard;

import wheelsunh.users.Frame;
import wheelsunh.users.TextBox;

/**
 * Tetris.java:
 * Main class for tetris, the program starts from here
 *
 */
public class Tetris
{
    /**
     * Function main begins with program execution
     *
     * @param args The command line args (not used in this program)
     */
    public static void main( String[] args )
    {
        Frame f = new Frame();

        TextBox tB;
        new TetrisBoard( f);
    }
}

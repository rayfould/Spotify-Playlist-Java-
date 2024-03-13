package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * Project runner class Runs the whole program
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Main method used to run the program
     * 
     * @param args
     *            - the arguments
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws DailyMixDataException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        DailyMixDataException
    {

        if (args.length == 2)
        {
            new PlaylistReader(args[0], args[1]);
        }
        else
        {
            new PlaylistReader("input.txt", "playlists.txt");
        }
    }

}

package dailymixes;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * Daily Mix exception class Defines the Daily Mix exception
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class DailyMixDataException
    extends Exception
{
    // ----------------------------------------------------------
    /**
     * Create a new DailyMixDataException object.
     * 
     * @param string
     *            - message
     */
    public DailyMixDataException(String string)
    {
        super(string);
    }
}

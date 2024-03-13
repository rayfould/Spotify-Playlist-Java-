package dailymixes;

import student.*;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * GenreSet test class Tests all of the classes inside of GenreSet it
 * represents, and how to use it.
 * 
 * @author rrisl
 * @version Nov 2, 2023
 */
public class GenreSetTest
    extends TestCase
{
    private GenreSet uno;
    private GenreSet dos;
    private GenreSet tres;

    /**
     * setUp method
     */
    public void setUp()
    {
        uno = new GenreSet(10, 20, 30);
        dos = new GenreSet(10, 20, 30);
        tres = new GenreSet(20, 40, 60);
    }


    // ----------------------------------------------------------
    /**
     * Test getter
     */
    public void testGet()
    {
        assertEquals(uno.getPop(), 10);
        assertEquals(uno.getRock(), 20);
        assertEquals(uno.getCountry(), 30);
    }


    /**
     * Tests for lesser and greather methods
     */
    public void testLessandGreater()
    {
        assertTrue(uno.isLessThanOrEqualTo(dos));
        assertTrue(uno.isLessThanOrEqualTo(tres));
        assertFalse(tres.isLessThanOrEqualTo(uno));
        assertTrue(tres.isGreaterThanOrEqualTo(uno));

    }


    /**
     * Tests whether the two are within range
     */
    public void testIsWithinRange()
    {
        GenreSet min = new GenreSet(1, 2, 3);
        GenreSet max = new GenreSet(11, 21, 31);
        assertTrue(uno.isWithinRange(min, max));
        assertFalse(tres.isWithinRange(min, max));
    }


    /**
     * Tests the equals method
     */
    public void testEquals()
    {
        assertTrue(uno.equals(dos));
        assertFalse(uno.equals(tres));
        assertFalse(uno.equals(null));
        assertTrue(uno.equals(uno));
        assertFalse(uno.equals(new Object()));
    }


    /**
     * Tests the compare to method
     */
    public void testCompareTo()
    {
        assertEquals(uno.compareTo(dos), 0);
        assertEquals(tres.compareTo(dos), 1);
        assertEquals(uno.compareTo(tres), -1);
    }


    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        assertEquals(uno.toString(), "Pop:10 Rock:20 Country:30");
        assertEquals(dos.toString(), "Pop:10 Rock:20 Country:30");
        assertEquals(tres.toString(), "Pop:20 Rock:40 Country:60");
    }


    /**
     * Tests if the method getter worked
     */
    public void testSum()
    {
        assertEquals(uno.sumOfGenres(), 60);
    }

}

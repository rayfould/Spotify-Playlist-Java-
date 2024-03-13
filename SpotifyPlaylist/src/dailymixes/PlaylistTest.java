package dailymixes;

import student.TestCase;
import static org.junit.Assert.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * The test class for the playlist class This class will test whether all of the
 * methods inside of the playlist class work correctly.
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class PlaylistTest
    extends TestCase
{
    private Playlist main;
    private Playlist hard;
    private Playlist full;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;

    /**
     * Setup method for the class
     */
    public void setUp()
    {
        main = new Playlist("Main", 10, 10, 10, 50, 50, 50, 12);
        hard = new Playlist("Hard", 20, 20, 20, 40, 60, 50, 5);
        full = new Playlist("Full", 25, 25, 25, 50, 50, 50, 1);
        song1 = new Song("Song 1", 15, 30, 25, "Main");
        song2 = new Song("Song 2", 25, 35, 40, "Hard");
        song3 = new Song("Song 3", 20, 30, 50, "Hard");
        song4 = new Song("Song 4", 41, 41, 41, "Full");
    }


    // ----------------------------------------------------------
    /**
     * Test method for the add() method.
     */
    public void testAdd()
    {
        assertEquals(full.getSpacesLeft(), 1);
        assertFalse(full.addSong(song1));
        full.addSong(song4);
        assertEquals(full.getSpacesLeft(), 0);
        assertFalse(full.addSong(song2));
    }


    // ----------------------------------------------------------
    /**
     * Test method for toString() method.
     */
    public void testToString()
    {
        assertTrue(hard.isQualified(song2));
        assertTrue(hard.isQualified(song3));
        hard.addSong(song2);
        hard.addSong(song3);
        assertEquals(hard.getSpacesLeft(), 3);
        assertEquals(
            hard.toString(),
            "Playlist: Hard, "
                + "# of songs: 2 (cap: 5), Requires: Pop:20%-40%, "
                + "Rock:20%-60%, Country:20%-50%");
    }


    // ----------------------------------------------------------
    /**
     * Test method for the equals() method
     */
    public void testEquals()
    {
        Playlist copy = new Playlist("Hard", 20, 20, 20, 40, 60, 50, 5);
        hard.addSong(song2);
        copy.addSong(song2);
        Playlist name = new Playlist("Rock", 20, 20, 20, 40, 60, 40, 5);
        Playlist capacity = new Playlist("Hard", 20, 20, 20, 40, 60, 40, 10);
        assertTrue(hard.equals(hard));
        assertFalse(hard.equals(null));
        assertFalse(hard.equals(new Object()));
        assertFalse(hard.equals(main));
        assertTrue(hard.equals(copy));
        copy.addSong(song3);
        assertFalse(hard.equals(copy));
        name.addSong(song2);
        assertFalse(hard.equals(name));
        capacity.addSong(song2);
        assertFalse(hard.equals(capacity));
    }


    // ----------------------------------------------------------
    /**
     * Test method for compareTo
     */
    public void testCompareTo()
    {
        assertTrue(main.compareTo(hard) > 0);
        assertTrue(full.compareTo(main) < 0);
        assertTrue(hard.addSong(song2));
        assertTrue(hard.addSong(song3));
        assertTrue(full.addSong(song4));
        assertEquals(full.getSpacesLeft(), 0);
        assertEquals(hard.getSpacesLeft(), 3);
        Playlist hard2 = new Playlist("Hard2", 20, 20, 20, 40, 60, 50, 5);
        hard2.addSong(new Song("Song 5", 25, 35, 40, "Hard2"));
        assertTrue(hard.compareTo(hard2) > 0);
        Playlist hard3 = new Playlist("HardTwin", 20, 20, 20, 40, 60, 50, 5);
        Playlist hard3Copy =
            new Playlist("HardTwin", 20, 20, 20, 40, 60, 50, 5);
        Playlist hard4 = new Playlist("HardTwin", 21, 21, 21, 40, 60, 50, 5);
        Playlist hard5 = new Playlist("HardTwin", 20, 20, 20, 41, 61, 51, 5);
        assertEquals(hard3.compareTo(hard3Copy), 0);
        assertTrue(hard3Copy.equals(hard3));
        assertTrue(hard3.compareTo(hard4) < 0);
        assertTrue(hard3.compareTo(hard5) < 0);
    }


    // ----------------------------------------------------------
    /**
     * Test method for all the small getters
     */
    public void testGetters()
    {
        GenreSet set = new GenreSet(20, 20, 20);
        GenreSet set2 = new GenreSet(40, 60, 50);
        assertEquals(hard.getName(), "Hard");
        assertEquals(hard.getNumberOfSongs(), 0);
        assertEquals(hard.getSpacesLeft(), 5);
        assertEquals(hard.getMinGenreSet(), set);
        assertEquals(hard.getMaxGenreSet(), set2);
        assertEquals(hard.getCapacity(), 5);
    }

}

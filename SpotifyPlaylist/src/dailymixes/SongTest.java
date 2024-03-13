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
 * Song test class Tests all of the methods inside the song class
 * 
 * @author rrisl
 * @version Nov 2, 2023
 */
public class SongTest
    extends TestCase
{
    private Song small;
    private Song alsoSmall;
    private Song mid;
    private Song large;

    /**
     * Setup method
     */
    public void setUp()
    {
        small = new Song("small", 10, 20, 30, "Main");
        alsoSmall = new Song("alsoSmall", 10, 20, 30, "Main");
        mid = new Song("mid", 15, 25, 35, "Side");
        large = new Song("large", 20, 30, 40, "");
    }


    /**
     * Getter method for playlist name
     */
    public void testGetPlaylist()
    {
        assertEquals(small.getPlaylistName(), "Main");
        assertEquals(alsoSmall.getPlaylistName(), "Main");
        assertEquals(mid.getPlaylistName(), "Side");
        assertEquals(large.getPlaylistName(), "");
    }


    /**
     * Tests that the getName method returns the correct song name.
     */
    public void testGetName()
    {
        assertEquals(small.getName(), "small");
        assertEquals(mid.getName(), "mid");
    }


    /**
     * Test method for {@link Song#getGenreSet()}. Ensures that the getGenreSet
     * method returns the correct GenreSet object.
     */
    public void testGetGenreSet()
    {
        GenreSet smallG = new GenreSet(10, 20, 30);
        assertEquals(smallG, small.getGenreSet());
    }


    /**
     * Tests whether the toString method functions
     */
    public void testToString()
    {
        assertEquals(
            small.toString(),
            "[Name: small, GenreSet: Pop:10 Rock:20 "
            + "Country:30, Suggested Playlist: Main]");
        assertEquals(
            alsoSmall.toString(),
            "[Name: alsoSmall, GenreSet: Pop:10 Rock:20 "
            + "Country:30, Suggested Playlist: Main]");
        assertEquals(
            mid.toString(),
            "[Name: mid, GenreSet: Pop:15 Rock:25 "
            + "Country:35, Suggested Playlist: Side]");
        assertEquals(
            large.toString(),
            "No Playlist [Name: large, GenreSet: "
            + "Pop:20 Rock:30 Country:40, Suggested Playlist: ]");
    }


    /**
     * Tests whether the equals method functions
     */
    public void testEquals()
    {
        assertFalse(small.equals(alsoSmall));
        assertFalse(small.equals(mid));
        assertFalse(small.equals(null));
        assertFalse(small.equals(new Object()));
        assertTrue(small.equals(small));
    }

}

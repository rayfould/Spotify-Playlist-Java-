package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * Test for the playlist calculator class Tests all of the methods inside
 * Playlist Calculator to ensure they function properly
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class PlaylistCalculatorTest
    extends TestCase
{
    private PlaylistCalculator playlistCalculator;
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;
    private Song popSong;
    private Song rockSong;
    private Song countrySong;
    private Song nullSong;
    private Song wrongSong;

    
     /**
     * setUp method for the class
     */
    public void setUp()
    {
        songQueue = new ArrayQueue<Song>();
        playlists = new Playlist[3];
        playlists[0] = new Playlist("Pop", 50, 0, 0, 100, 50, 50, 10);
        playlists[1] = new Playlist("Rock", 0, 50, 0, 50, 100, 50, 10);
        playlists[2] = new Playlist("Country", 0, 0, 50, 50, 50, 100, 10);
        popSong = new Song("Pop Song", 80, 10, 10, "Pop");
        rockSong = new Song("Rock Song", 10, 80, 10, "Rock");
        countrySong = new Song("Country Song", 10, 10, 80, "Country");
        nullSong = null;
        wrongSong = new Song("Empty", 0, 0, 0, "Blues");
        songQueue.enqueue(popSong);
        songQueue.enqueue(rockSong);
        songQueue.enqueue(countrySong);
        songQueue.enqueue(nullSong);
        songQueue.enqueue(wrongSong);
        playlistCalculator = new PlaylistCalculator(songQueue, playlists);
    }


    // ----------------------------------------------------------
    /**
     * Test method for the getPlaylistForSong()
     */
    public void testGetPlaylistForSong()
    {
        Playlist output = playlistCalculator.getPlaylistForSong(popSong);
        assertEquals(output.getName(), "Pop");
        Playlist output2 = playlistCalculator.getPlaylistForSong(rockSong);
        assertEquals(output2.getName(), "Rock");
        Playlist output3 = playlistCalculator.getPlaylistForSong(countrySong);
        assertEquals(output3.getName(), "Country");
        Playlist output4 = playlistCalculator.getPlaylistForSong(nullSong);
        assertNull(output4);
        Playlist output5 = playlistCalculator.getPlaylistForSong(wrongSong);
        assertNull(output5);
    }


    /**
     * Test method for the addSong()
     */
    public void testAddSong()
    {
        boolean output = playlistCalculator.addSongToPlaylist();
        assertTrue(output);
        assertEquals(songQueue.getSize(), 4);
        while (!songQueue.isEmpty())
        {
            songQueue.dequeue();
        }
        assertFalse(playlistCalculator.addSongToPlaylist());
    }


    /**
     * Test method for the reject()
     */
    public void testReject()
    {
        playlistCalculator.reject();
        assertNotNull(playlistCalculator.getRejected());

    }


    /**
     * Test method for the getPlaylistWithMostRoom()
     */
    public void testGetPlaylistWithMostRoom()
    {
        playlists[0].addSong(popSong);
        playlists[1].addSong(rockSong);
        Song song = new Song("All Song", 25, 25, 50, null);
        Playlist output = playlistCalculator.getPlaylistWithMostRoom(song);
        assertNotNull(output);
        assertEquals(output.getName(), "Country");
        playlists[0].addSong(rockSong);
        playlists[2].addSong(rockSong);
        playlists[1].addSong(popSong);
        playlists[2].addSong(popSong);
        playlists[0].addSong(countrySong);
        playlists[1].addSong(countrySong);
        Playlist output1 = playlistCalculator.getPlaylistWithMostRoom(song);
        assertNotNull(output1);

    }


    /**
     * Test method for all the small getters
     */
    public void testGetters()
    {
        assertEquals(playlistCalculator.getQueue(), songQueue);
        assertEquals(playlistCalculator.getPlaylists(), playlists);
    }

}

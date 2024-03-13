package dailymixes;

import java.util.*;
import list.AList;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * Playlist calculator class Calculates which song should go into which playlist
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class PlaylistCalculator
{
    /**
     * Number of playlists
     */
    static final int NUM_PLAYLISTS = 3;

    /**
     * Max percent per playlist
     */
    static final int MIN_PERCENT = 0;
    /**
     * Min percent per playlist
     */
    static final int MAX_PERCENT = 100;
    /**
     * Default capacity
     */
    static final int DEFAULT_CAPACITY = 100;
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;
    private AList<Song> rejected;

    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param songQueue - the song queue
     * @param playlists - the playlist list
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, Playlist[] playlists)
    {
        if (songQueue == null || playlists == null)
        {
            throw new IllegalArgumentException("Queue is null - no bueno");
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejected = new AList<>(NUM_PLAYLISTS);
        if (NUM_PLAYLISTS < DEFAULT_CAPACITY)
        {
            this.rejected = new AList<>(DEFAULT_CAPACITY);
        }
    }


    // ----------------------------------------------------------
    /**
     * This method gets the appropriate playlist for a provided song
     * 
     * @param nextSong - the next song
     * @return Playlist playlist for song
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null)
        {
            return null;
        }
        String suggestedPlaylist = nextSong.getPlaylistName();
        Playlist output = null;

        if (suggestedPlaylist != null && !suggestedPlaylist.equals("None"))
        {
            int index = getPlaylistIndex(suggestedPlaylist);
            if (index >= 0)
            {
                output = playlists[index];
                if (canAccept(output, nextSong))
                {
                    return output;
                }
            }
        }
        else
        {
            return getPlaylistWithMostRoom(nextSong);
        }
        return null;

    }


    /*
     * \ // ---------------------------------------------------------- /**
     * Method checks whether a playlist can accept a song
     * @param playlist - playlist to check
     * @param song - song to check
     * @return boolean sucess or fail
     */
    private boolean canAccept(Playlist playlist, Song song)
    {
        return !playlist.isFull() && playlist.isQualified(song);
    }


    // ----------------------------------------------------------
    /**
     * This method attempts to add a song to a playlist
     * 
     * @return boolean sucess or fail
     */
    public boolean addSongToPlaylist()
    {
        if (songQueue.isEmpty())
        {
            return false;
        }

        Song nextSong = songQueue.getFront();
        Playlist playlist = getPlaylistForSong(nextSong);
        if (playlist != null)
        {
            playlist.addSong(nextSong);
            songQueue.dequeue();
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * This method adds a song to a list of rejected songs if it was rejected
     */
    public void reject()
    {
        if (!songQueue.isEmpty())
        {
            Song song = songQueue.dequeue();
            rejected.add(song);
        }
    }


    // ----------------------------------------------------------
    /**
     * This method finds the most suitable playlist for a song to be added to.
     * 
     * @param song
     *            - the song to check
     * @return Playlist the best suiting playlist
     */
    public Playlist getPlaylistWithMostRoom(Song song)
    {
        Playlist outputPlaylist = null;
        int max = 0;
        for (Playlist playlist : playlists)
        {
            int current = playlist.getSpacesLeft();
            if (current > max && canAccept(playlist, song))
            {
                max = current;
                outputPlaylist = playlist;
            }
        }
        return outputPlaylist;
    }


    // ----------------------------------------------------------
    /**
     * Simply returns the index of a playlist in an queue of playlists
     * 
     * @param playlist
     *            - the playlist to check
     * @return int index of the playlist
     */
    public int getPlaylistIndex(String playlist)
    {
        for (int i = 0; i < playlists.length; i++)
        {
            if (playlists[i].getName().equals(playlist))
            {
                return i;
            }

        }
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the queue
     * 
     * @return queue
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for playlists
     * 
     * @return array of playlists
     */
    public Playlist[] getPlaylists()
    {
        return playlists;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for rejected list.
     * 
     * @return a list of rejected songs
     */
    public AList<Song> getRejected()
    {
        return rejected;
    }

}

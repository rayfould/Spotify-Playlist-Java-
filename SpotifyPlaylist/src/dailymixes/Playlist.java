package dailymixes;
import java.util.*;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * The main playlist class This class will be used to create groups of songs
 * that can be identified with similar parameters
 * 
 * @author rrisl
 * @version Nov 7, 2023
 */
public class Playlist
    implements Comparable<Playlist>
{
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     *            - the name of the playlist
     * @param minPop
     *            - the minimum pop requirement
     * @param minRock
     *            - the minimum rock requirement
     * @param minCountry
     *            - the minimum country requirement
     * @param maxPop
     *            - the maximum pop limit
     * @param maxRock
     *            - the maximum rock limit
     * @param maxCountry
     *            - the maximum country limit
     * @param playlistCap
     *            - the playlist cap
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        this.name = playlistName;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.capacity = playlistCap;
        this.songs = new Song[playlistCap];
        this.numberOfSongs = 0;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the spaces left in a playlist
     * 
     * @return int spaces left
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the max requirements of the playlist
     * 
     * @return GenreSet max requirements
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    /**
     * Getter method for the min requirements of the playlist
     * 
     * @return GenreSet min requirements
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for number of songs
     * 
     * @return int - number of songs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the capacity
     * 
     * @return int capacity
     */
    public int getCapacity()
    {
        return capacity;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the songs array
     * 
     * @return array of songs
     */
    public Song[] getSongs()
    {
        return this.songs;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the name
     * 
     * @return String name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for the name
     * 
     * @param newName
     *            - the new name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }


    // ----------------------------------------------------------
    /**
     * Helper method to test whether a playlist is full
     * 
     * @return boolean full or not
     */
    public boolean isFull()
    {
        return numberOfSongs == capacity;
    }


    // ----------------------------------------------------------
    /**
     * Method that adds the song to the playlist
     * 
     * @param newSong
     *            - the song to add
     * @return boolean sucess or failure
     */
    public boolean addSong(Song newSong)
    {
        if (!this.isFull() && isQualified(newSong))
        {

            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;

        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Helper method to check whether song fits parameters
     * 
     * @param song
     *            - the song to add
     * @return boolean sucess or fail
     */
    public boolean isQualified(Song song)
    {
        GenreSet temp = song.getGenreSet();
        return temp.isWithinRange(minGenreSet, maxGenreSet);
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Playlist: ").append(name).append(", # of songs: ")
            .append(numberOfSongs).append(" (cap: ").append(capacity)
            .append("), Requires: Pop:").append(minGenreSet.getPop())
            .append("%-").append(maxGenreSet.getPop()).append("%")
            .append(", Rock:").append(minGenreSet.getRock()).append("%-")
            .append(maxGenreSet.getRock()).append("%").append(", Country:")
            .append(minGenreSet.getCountry()).append("%-")
            .append(maxGenreSet.getCountry()).append("%");
        return builder.toString();
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }

        Playlist playlist = (Playlist)obj;
        return this.name.equals(playlist.name)
            && this.minGenreSet.equals(playlist.minGenreSet)
            && this.maxGenreSet.equals(playlist.maxGenreSet)
            && Arrays.equals(this.songs, playlist.songs)
            && this.capacity == playlist.capacity
            && this.numberOfSongs == playlist.numberOfSongs;
    }


    @Override
    public int compareTo(Playlist other)
    {
        if (this.capacity != other.capacity)
        {
            return this.capacity - other.capacity;
        }
        else if (this.getSpacesLeft() != other.getSpacesLeft())
        {
            return other.getSpacesLeft() - this.getSpacesLeft();
        }
        else
        {
            int min = this.minGenreSet.compareTo(other.minGenreSet);
            int max = this.maxGenreSet.compareTo(other.maxGenreSet);
            if (min != 0)
            {
                return min;
            }
            else if (max != 0)
            {
                return max;
            }

            else
            {
                return this.name.compareTo(other.name);
            }

        }
    }

}

package dailymixes;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * Song class Used for every individual song that we will create Defines all the
 * parameters for a song
 * 
 * @author rrisl
 * @version Nov 1, 2023
 */
public class Song
{
    private String name;
    private GenreSet genreSet;
    private String playlist;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param name - the name of the song
     * @param pop - the percept of the pop
     * @param rock - the percent of the rock
     * @param country - the percet of the country
     * @param suggested - the suggested playlist
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        this.genreSet = new GenreSet(pop, rock, country);
        this.playlist = suggested;
    }


    /**
     * Getter method for playlist name
     * 
     * @return string name
     */
    public String getPlaylistName()
    {
        return playlist;
    }


    /**
     * Gets the name of the song.
     *
     * @return the name of the song
     */
    public String getName()
    {
        return name;
    }


    /**
     * Gets the genre set of the song.
     *
     * @return the genre set
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }


    /**
     * Method that tests whether the two songs are equal
     * 
     * @return boolean truth
     * @param obj
     *            object to compare to
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        Song other = (Song)obj;

        boolean nameEquals =
            (this.name != null && this.name.equals(other.name));
        boolean playlistEquals =
            (this.playlist != null && this.playlist.equals(other.playlist));

        return nameEquals && playlistEquals
            && this.genreSet.equals(other.genreSet);
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if (playlist == null || playlist.isEmpty() || playlist.length() == 0)
        {
            builder.append("No Playlist ");
        }
        
        builder.append("[Name: ").append(name);
        builder.append(", GenreSet: ").append(genreSet);
        builder.append(", Suggested Playlist: ").append(playlist);
        builder.append(']');

        return builder.toString();
    }

}

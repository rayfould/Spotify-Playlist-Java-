package dailymixes;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * GenreSet class Utilized as the base class for sets of genres
 * 
 * @author rrisl
 * @version Nov 1, 2023
 */
public class GenreSet
    implements Comparable<GenreSet>
{
    private int country;
    private int rock;
    private int pop;

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * 
     * @param pop
     *            - the pop percentage
     * @param rock
     *            - the rock percentage
     * @param country
     *            - the country percentage
     */
    public GenreSet(int pop, int rock, int country)
    {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for rock
     * 
     * @return rock
     */
    public int getRock()
    {
        return rock;
    }


    /**
     * Getter method for pop
     * 
     * @return pop
     */
    public int getPop()
    {
        return pop;
    }


    /**
     * Getter for country
     * 
     * @return country
     */
    public int getCountry()
    {
        return country;
    }


    /**
     * Tests whether the two genre are less or equal
     * 
     * @param other - the other genre
     * @return boolean truth
     */
    public boolean isLessThanOrEqualTo(GenreSet other)
    {
        return this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country;
    }


    /**
     * Tests whether the two genres are greater or equal
     * 
     * @param other - the other genre
     * @return boolean truth
     */
    public boolean isGreaterThanOrEqualTo(GenreSet other)
    {
        return this.pop >= other.pop && this.rock >= other.rock
            && this.country >= other.country;
    }


    /**
     * Tests whether the genre is within range
     * 
     * @param minGenreSet - the minimum genre set
     * @param maxGenreSet - the max genre set
     * @return boolean truth
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return isGreaterThanOrEqualTo(minGenreSet)
            && isLessThanOrEqualTo(maxGenreSet);
    }


    @Override
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

        if (obj.getClass() != this.getClass())
        {
            return false;
        }

        GenreSet test = (GenreSet)obj;

        return this.pop == test.pop && this.rock == test.rock
            && this.country == test.country;
    }


    @Override
    public int compareTo(GenreSet o)
    {
        int sumOfThis = this.pop + this.rock + this.country;
        int sumOfO = o.pop + o.rock + o.country;

        if (sumOfThis < sumOfO)
        {
            return -1;
        }
        else if (sumOfThis > sumOfO)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Getter for sum
     * 
     * @return sum
     */
    public int sumOfGenres()
    {
        return pop + rock + country;
    }


    @Override
    public String toString()
    {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }

}

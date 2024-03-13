package dailymixes;

import queue.EmptyQueueException;
import student.TestCase;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * ArrayQueue test class Tests all of the methods inside of arrayQueue.
 * 
 * @author rrisl
 * @version Nov 2, 2023
 */
public class ArrayQueueTest
    extends TestCase
{
    private ArrayQueue<String> empty;
    private ArrayQueue<String> small;
    private ArrayQueue<String> full;

    /**
     * Setup method
     */
    public void setUp()
        throws Exception
    {
        empty = new ArrayQueue<>(3);
        small = new ArrayQueue<>(3);
        full = new ArrayQueue<>(3);

        small.enqueue("keys");
        small.enqueue("wallet");

        full.enqueue("pencil");
        full.enqueue("knife");
        full.enqueue("rock");
    }


    /**
     * Tests the enqueue method
     */
    public void testEnqueue()
    {
        assertEquals(full.getSize(), 3);
        empty.enqueue("keys");
        assertEquals(empty.toString(), "[keys]");

        small.enqueue("pills");
        assertEquals(small.toString(), "[keys, wallet, pills]");

        small.enqueue("bottle");
        assertEquals(small.getLengthOfUnderlyingArray(), 8);
        assertEquals(small.toString(), "[keys, wallet, pills, bottle]");
    }


    /**
     * Tests the dequeue method
     */
    public void testDequeue()
    {
        assertEquals(full.dequeue(), "pencil");
        assertEquals(full.toString(), "[knife, rock]");

        Exception exception = null;
        try
        {
            empty.dequeue();
            fail("dequeue() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(
            "dequeue() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * Tests the getFront() method
     */
    public void testGetFront()
    {
        assertEquals(small.getFront(), "keys");
        assertEquals(small.toString(), "[keys, wallet]");

        Exception exception = null;
        try
        {
            empty.getFront();
            fail("getFront() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(
            "getFront() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * Tests the clear() method
     */
    public void testClear()
    {
        small.clear();
        assertTrue(small.isEmpty());
        assertEquals(small.getLengthOfUnderlyingArray(), 21);
    }


    /**
     * Tests the toArray() method
     */
    @SuppressWarnings("unused")
    public void testToArray()
    {
        Object[] array = small.toArray();
        String[] expected = { "keys", "wallet" };

        Exception exception = null;
        try
        {
            empty.toArray();
            fail("toArray() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(
            "toArray() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    // ----------------------------------------------------------
    /**
     * Getter method for size
     */
    public void testGetSize()
    {
        assertEquals(empty.getSize(), 0);
        assertEquals(small.getSize(), 2);
        assertEquals(full.getSize(), 3);
    }


    // ----------------------------------------------------------
    /**
     * Getter method for capacity
     */
    public void testGetCapacity()
    {
        assertEquals(empty.getCapacity(), 4);
        assertEquals(small.getCapacity(), 4);
        assertEquals(full.getCapacity(), 4);
    }

}

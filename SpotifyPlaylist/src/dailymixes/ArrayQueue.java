package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- rudolfr
/**
 * This is the ArrayQueue class This class will be used as an underlying array
 * for all of the future methods
 * 
 * @author rrisl
 * @version Nov 2, 2023
 * @param <T>
 *            The generic
 */
public class ArrayQueue<T>
    implements QueueInterface<T>
{
    /**
     * Default capacity
     */
    static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * 
     * @param cap
     *            the capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int cap)
    {
        T[] temp = (T[])new Object[cap + 1];
        queue = temp;
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * Getter method for size
     * 
     * @return int size
     */
    public int getSize()
    {
        return size;
    }


    /**
     * Getter method for length of array
     * 
     * @return int length
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    /**
     * Incremends the index of an array
     * 
     * @param index
     *            the index
     * @return int new index
     */
    public int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    @SuppressWarnings("unchecked")
    /**
     * Method that checks whether the capacity of an array is viable
     */
    private void ensureCapacity()
    {
        if (this.size == queue.length - 1)
        {
            int updatedArrayLength = 2 * queue.length;

            T[] temp = (T[])new Object[updatedArrayLength];

            for (int i = 0; i < size; i++)
            {
                temp[i] = queue[dequeueIndex];
                dequeueIndex = incrementIndex(dequeueIndex);
            }
            enqueueIndex = size;
            dequeueIndex = 0;
            queue = temp;
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    @Override
    public T dequeue()
    {
        if (this.isEmpty())
        {
            throw new EmptyQueueException("Cant dequeue - empty");
        }

        T output = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return output;
    }


    @Override
    public void enqueue(T parameter)
    {
        ensureCapacity();
        queue[enqueueIndex] = parameter;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    @Override
    public T getFront()
    {
        if (this.isEmpty())
        {
            throw new EmptyQueueException("Cant getFront() - empty");
        }

        return queue[dequeueIndex];
    }


    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Returns the arrayqueue in the form of an array
     * 
     * @return Object[] the array as an object
     */
    public Object[] toArray()
    {
        if (this.isEmpty())
        {
            throw new EmptyQueueException("The queue is empty");
        }

        Object[] output = new Object[size];
        int indexTemp = dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            output[i] = queue[indexTemp];
            indexTemp = incrementIndex(indexTemp);
        }
        return output;
    }


    /**
     * Getter for the length of the underlying array.
     * 
     * @return length
     */
    public int getCapacity()
    {
        return queue.length;
    }


    @Override
    public String toString()
    {
        if (this.isEmpty())
        {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        int indexTemp = dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            builder.append(queue[indexTemp]);
            indexTemp = incrementIndex(indexTemp);
            builder.append(", ");

        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(']');
        return builder.toString();
    }

}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.queue;

import java.util.NoSuchElementException;

/**
 *
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */

public interface Queue <E>{
    
    /**
     * Returns the position where an object is on this queue
     * @param element
     * @return the position from the head of the queue where the object is located.
     * @exception IndexOutOfBoundsException
     */
    int search(E element) throws NoSuchElementException;
    
    /**
     * Inserts the specified element into the queue.
     * @param element
     * @exception IllegalStateException
     */
    void enqueue (E element) throws IllegalStateException;
    
    /**
     * Retrieves and removes the head of this queue, or returns null 
     * if this queue is empty.
     * @return the head of this queue.
     * @throws IllegalStateException 
     */
    E dequeue () throws IllegalStateException;
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue.
     * @throws IllegalStateException 
     */
    E peek () throws IllegalStateException;
    
    /**
     * Checks if the queue is empty.
     * @return true if and only if this queue contains no items; false otherwise.
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue.
     */
    int getSize();
    
}

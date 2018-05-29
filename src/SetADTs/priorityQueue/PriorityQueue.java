
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */
package SetADTs.priorityQueue;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 * @param <E> 
 */
public interface PriorityQueue <E> {
    
    /**
     * Inserts the specified element into thw priority queue
     * @param x 
     * @exception IllegalStateException
     */
    void insert (E x) throws IllegalStateException;
    
    /**
     * Retrieves, but does not remove, the max priority element
     * @return max priority element
     * @exception IllegalStateException
     */
    E max () throws IllegalStateException;
    
    /**
     * Deletes the max priority element if exists
     * @return max priority element
     * @exception IllegalStateException
     */
    E deleteMax () throws IllegalStateException;

}

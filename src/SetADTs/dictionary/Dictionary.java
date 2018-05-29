
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package SetADTs.dictionary;

import java.util.NoSuchElementException;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 * @param <K>
 * @param <V> 
 */
public interface Dictionary <K, V> {
    
    /**
     * Maps the specified key k to the spcified value x in the dictionary
     * @param k
     * @param x
     * @throws IllegalStateException 
     */
    void insert (K k, V x) throws IllegalStateException;
    
    /**
     * Removes the key k and its corresponding value x from the dictionary.
     * @param k
     * @throws NoSuchElementException
     */
    void delete (K k) throws NoSuchElementException;
    
    /**
     * Checks if key k has already been hashed in the table
     * @param k
     * @return true if k has been already hashed
     */
    boolean isMember (K k);
    
    /**
     * Retrieves, if exists, the position of the element whose key k
     * has already been hashed in the table
     * @param k
     * @return
     * @throws NoSuchElementException 
     */
    int search (K k) throws NoSuchElementException;
    
}

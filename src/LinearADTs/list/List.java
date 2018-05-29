/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.list;

import java.util.NoSuchElementException;

/**
 *
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public interface List <E> {
    
    /**
     * Searches for E and returns its postion
     * @param element
     * @return the position of the element E
     * @exception IndexOutOfBoundsException
     */
    int search(E element) throws NoSuchElementException;
    
    
    /**
     * Returns the element at the specified position in the list.
     * @param pos
     * @return the element at the specified position in this list
     * @exception IndexOutOfBoundsException
     */
    E get (int pos) throws IndexOutOfBoundsException;
    
    
    /**
     * Inserts element at given position
     * @param element
     * @param pos
     * @exception IndexOutOfBoundsException
     */
    void add(E element, int pos) throws IndexOutOfBoundsException;
    
    
    /**
     * Removes the element at the specified position in this list
     * @param pos
     * @return the element previously at the specified position
     * @exception IndexOutOfBoundsException
     */
    E removes(int pos) throws IndexOutOfBoundsException;
    
    
    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    int getSize();
    
    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    boolean isEmpty();
}

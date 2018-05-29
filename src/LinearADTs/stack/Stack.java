
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 *
 * @author Alejandro Pérez-Sanjuán
 * @param <E>
 */
public interface Stack <E> {
    
    /**
     * Returns the position where an object is on this stack
     * @param element
     * @return the position from the top of the stack where the object is located.
     * @exception IndexOutOfBoundsException
     */
    int search(E element) throws NoSuchElementException;
      
    /**
     * Append: Inserts an element at last position
     * @param element
     * @exception IllegalStateException
     */
    void push (E element) throws IllegalStateException;
    
    /**
     * Removes the object at the top of the stack and returns that object as the value of this function.
     * @return The object at the top of this stack.
     * @throws IllegalStateException 
     */
    E pop () throws EmptyStackException;
    
    /**
     * Looks at the object at the top of the stack without removing it from the stack.
     * @return the object at the top of this stack.
     * @throws IllegalStateException 
     */
    E peek () throws EmptyStackException;    
    
    /**
     * Checks if the stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    int getSize();
    
}


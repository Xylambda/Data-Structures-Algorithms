
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
public class ArrayStack <E> implements Stack <E> {
    private int S;
    private E[] vector;
    
    public ArrayStack(){
        S = 0;
    }
    
    public ArrayStack(int capacity){
        this();
        vector = (E[])new Object[capacity];
    }    

    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException("Empty Stack");
        
        else{
            int i = 0;
            while (element != vector[i]){
                i++;
                if (i == vector.length)
                    throw new NoSuchElementException("The element is not in the stack");
            }
            return i;        
        }
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (S == vector.length)
            throw new IllegalStateException("Full stack");
        
        else{
            vector[S] = element;          
            S ++;
        }
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty())
            throw new IllegalStateException("Empty stack");
        
        else{
            E deleted = vector[S - 1];
            vector[S - 1] = null;
            S --;
            return deleted;
        } 
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty())
            throw new IllegalStateException("Empty stack");
        
        else
            return vector[S-1];
    }

    @Override
    public boolean isEmpty() {
        return S == 0;
    }

    @Override
    public int getSize() {
        return S;
    }
 
    /**
     * Prints all elements of a non-empty list
     * @return String the with list elements
     * @throws IllegalStateException
     */
    @Override
    public String toString (){
        if (isEmpty())
            throw new IllegalStateException("Empty stack"); 
        
        else{
            String result = "";
            for (int i = 0; i < S; i++)
                result += vector[i] + ",";
            
            return result;          
        }
    }    
}

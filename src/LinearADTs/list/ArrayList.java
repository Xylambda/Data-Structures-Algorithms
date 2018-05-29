
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.list;

import java.util.NoSuchElementException;

/**
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public class ArrayList <E> implements List <E> {
    private int S;
    private E[] vector;
    
    public ArrayList(){
        S = 0;
    }
    
    public ArrayList(int capacity){
        this();
        vector = (E[])new Object[capacity];
    }

    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else{
            int i = 0;
            while (element != vector[i]){
                i++;
                if (i == vector.length)
                    throw new NoSuchElementException("The element is not in the list");    
            }
            return i;        
        }
    }

    @Override
    public E get(int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S);
        return vector[pos];
    }

    @Override
    public void add(E element, int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S + 1);
        if (S == vector.length)
            throw new IllegalStateException("Full list");
        else{
            for (int i = S - 1; i >= pos; i--)
                 vector[i+1] = vector[i];
            vector[pos] = element;
            S++;          
        }
    }

    @Override
    public E removes(int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S);
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else{
            E deleted = vector[pos];
            for (int i = pos; i < S-1; i++)
                vector[i] = vector [i + 1];
            vector [S - 1] = null;
            S --;
            return deleted;
        }
    }

    @Override
    public boolean isEmpty() {
        return S == 0;
    }
    
    @Override
    public int getSize(){      
        return S;
    }
    
    /**
     * Replaces the element of position pos with E
     * @param element
     * @param pos
     * @return Replaced element E
     * @throws IndexOutOfBoundsException 
     */
    public E replace (E element, int pos) throws IndexOutOfBoundsException{
        checkIndex (pos, S);
        E aux = vector [pos];
        vector [pos] = element;
        return aux;
    }    

    /**
     * Resizes the array
     * @param capacity
     */
    public void resize (int capacity){
        if (capacity <= vector.length){
            throw new IllegalStateException("Introduced capacity: " + capacity +" is less or equal than actual: " + vector.length);
        }
        else{
            E [] aux = (E[])new Object[capacity];
            for (int k=0; k < S; k++)
                aux [k] = vector[k];
            
            vector = aux; 
        }
    }
    
    /**
     * Checks if index is legal
     * @param index
     * @param range
     * @throws IndexOutOfBoundsException 
     */
    private void checkIndex (int index, int range) throws IndexOutOfBoundsException{
        if (index < 0 || index >= range)
            throw new IndexOutOfBoundsException ("Illegal index: " + index);
    }
    
    /**
     * Prints all elements of a non-empty list
     * @return String with list elements
     * @throws IllegalStateException
     */ 
    @Override
    public String toString (){
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else{
            String result = "";
            for (int i = 0; i < S; i++)
                result += vector[i] + ",";
            
            return result;          
        }
    }
    
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.queue;

import java.util.NoSuchElementException;

/**
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public class ArrayQueue <E> implements Queue <E> {
    
    private int S;
    private int first;
    private E[] vector;
    
    public ArrayQueue(){
        S = 0;
    }
    
    public ArrayQueue(int capacity){
        this();
        vector = (E[])new Object[capacity];
    }
    
    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException ("Empty queue");
        
        else{
            int i = 0;
            while (element != vector[i]){
                i++;
                if (i == vector.length)
                    throw new NoSuchElementException("The element is not in the queue");
            }
            
            return i;            
        }
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (S == vector.length)
            throw new IllegalStateException ("Full queue");
        
        else{
            int pos = (first + S)%vector.length;
            vector [pos] = element;
            S++;
        }
    }

    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException ("Empty queue");
        
        else{
            E dequeued = vector[first];
            vector [first] = null;
            
            first = (first + 1) % vector.length;
            S --;
            
            return dequeued;
        }
    }

    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException ("Empty queue");
        
        else
            return vector[first];
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
     * Resize the array
     * @param capacity
     */
    public void resize (int capacity){
        if (capacity <= vector.length)
            throw new IllegalStateException("Introduced capacity: " + capacity +" is less or equal than actual: " + vector.length);
        
        else{
            E [] aux = (E[])new Object[capacity];
            for (int k=0; k < S; k++)
                aux [k] = vector[k];
            
            vector = aux; 
        }
    }
   
    /**
     * Prints all elements of a non-empty list
     * @return String with list elements
     * @throws IllegalStateException
     */ 
    @Override
    public String toString (){
        if (isEmpty())
            throw new IllegalStateException("Empty queue");
        
        else{
            String result = "";
            for (int i = 0; i < S; i++)
                result += vector[i] + ",";
            
            return result;          
        }
    }
}

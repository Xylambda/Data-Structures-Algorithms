
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.queue;

import java.util.NoSuchElementException;
import LinearADTs.Node;

/**
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public class LinkedQueue <E> implements Queue <E> {
    private Node <E> first;
    private Node <E> last;
    private int S;
    
    public LinkedQueue(){
        S = 0;
    }    

    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException ("Empty queue");
        
        else{
            Node n = first;
            int i = 0;
            while (n != null && n.getData() != element) {
                n = n.getNext();
                i++;
                if (i == S)
                    throw new NoSuchElementException("The element is not in the queue");
            }
            return i;            
        }
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (isEmpty()){
            Node <E> n = new Node (element);
            first = n;
            last = n;
            S++;
        } 
        else{
            Node <E> n = new Node <> (element, null);
            last.setNext(n);
            last = n;
            S ++;
        } 
    }

    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()){
            throw new IllegalStateException("Empty queue");
        }
        else{
            E deleted = first.getData();
            if (S == 1){ //only remains 1 element
                first = null;
                last = null;
            } 
            else
                first = first.getNext();
            
            S--;
            return deleted;
        }
    }

    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()){
            throw new IllegalStateException("Empty queue");
        }
        else
            return first.getData();
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
     * @return String with list elements
     * @throws IllegalStateException
     */ 
    @Override
    public String toString(){
        if (isEmpty())
            throw new IllegalStateException("Empty queue");
        
        else{
            String result = "";
            Node <E> initial = first;
        
            for (int i = 0; i < S; i++){
                result += "(" + initial.getData() + ")" + " -> ";
                initial = initial.getNext();
            }
            result += "null";
            return result;   
        }
    }
    
}

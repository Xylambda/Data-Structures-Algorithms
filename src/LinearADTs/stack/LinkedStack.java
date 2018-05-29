
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.stack;

import LinearADTs.Node;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 *
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public class LinkedStack <E> implements Stack <E> {
    private Node <E> first;
    private Node <E> last;
    private int S = 0;
    
    public LinkedStack(){
        S = 0;
    }    

    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException("Empty stack");
        else{
            Node n = first;
            int i = 0;
            while (n != null && n.getData() != element) {
                n = n.getNext();
                i++;
                if (i == S)
                    throw new NoSuchElementException("The element is not in the stack");
            }
            return i;            
        }
    }

    @Override
    public void push(E element) throws IllegalStateException {
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
    public E pop() throws EmptyStackException {
        if (isEmpty()){
            throw new IllegalStateException("Empty stack");
        }
        else{
            E deleted = last.getData();
            
            if (S == 1){
                first = null;
                last = null;
            }
            else{
                Node previous = first;
                for (int i = 0; i < S - 2; i++)    // S - 1 = last position
                    previous = previous.getNext();
                
                previous.setNext(null);
                last = previous;
            }
            
            S--;
            return deleted;
        }
    }

    @Override
    public E peek() throws EmptyStackException {
        return last.getData();
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
     * Prints all elements of the list
     * @return String with list elements
     * @throws IllegalStateException
     */ 
    @Override
    public String toString(){
        if (isEmpty())
            throw new IllegalStateException("Empty stack");
        
        String total = "";
        Node <E> initial = first;
        
        for (int i = 0; i < S; i++){
            total += "(" + initial.getData() + ")" + " -> ";
            initial = initial.getNext();
        }
        
        return total;
    }    
}

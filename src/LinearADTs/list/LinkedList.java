
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs.list;

import java.util.NoSuchElementException;
import LinearADTs.Node;

/**
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */
public class LinkedList <E> implements List <E> {
    
    private Node <E> first;
    private Node <E> last;
    private int S;
    
    public LinkedList (){
        S = 0;
    }

    @Override
    public int search(E element) throws NoSuchElementException {
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else{
            Node n = first;
            int i = 0;
            while (n != null && n.getData() != element) {
                n = n.getNext();
                i++;
                if (i == S)
                    throw new NoSuchElementException("Element is not in the list");
            }
            return i;           
        }
    }

    @Override
    public E get(int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S);
        
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else {
            Node n = first;
            int counter = 0;
            while (n != null && counter < pos){
                if (n.getNext() == null)
                    return null;
                else{
                    n = n.getNext();
                    counter++;
                }
            }
            return (E) n.getData();
        }  
    }

    @Override
    public void add(E element, int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S + 1);
        
        Node <E> node = new Node <E> (element);
        if (isEmpty()){
            first = node;
            last = node;
            S++;
        }
        else{
            Node <E> prev = null;
            Node <E> actual = first;
            
            for (int i = 0; i < pos; i++){
                prev = actual;
                actual = actual.getNext();
            }
            
            prev.setNext(node);
            node.setNext(actual);
            
            if (actual == null)
                last = node;
            S++;
        }
    }

    @Override
    public E removes(int pos) throws IndexOutOfBoundsException {
        checkIndex (pos, S);
        if (isEmpty())
            throw new IllegalStateException("Empty list");
        else{
            Node previous = first;

            if (pos == 0){ //Head
                E deleted = (E) first.getData();
                first = previous.getNext();
                S--;
                return deleted;
            }
            else {
                for (int i = 0; previous != null && i < pos - 1; i++)
                    previous = previous.getNext();

                if (previous == null || previous.getNext() == null)
                    throw new IllegalStateException("The node doesn't exist");
                else{
                    E deleted = (E) previous.getNext().getData(); //save reference
                    previous.setNext(previous.getNext().getNext());
                    S--;
                    return deleted;
                }
            }            
        }
    }

    @Override
    public int getSize() {
        return S;
    }

    @Override
    public boolean isEmpty() {
        return S == 0;
    }
    
    /**
     * Prepend: Insert an element at first position 
     * @param element
     */
    public void prepend(E element){
        if (isEmpty()){
            Node <E> n = new Node (element);
            first = n;
            last = n;
            S++;
        }else{
            Node <E> n = new Node <> (element, first);
            first = n;
            S++;
        }      
    }
    
    /**
     * Append: Insert an element at last position
     * @param element
     * @exception IllegalStateException
     */
    public void append(E element) throws IllegalStateException {
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
    
    /**
     * Delete element at first position
     * @return deleted element, if any
     * @exception IllegalStateException
     */
    public E deleteLast()throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException("Empty list");
        }
        else{
            E deleted = first.getData();
            if (S == 1){
                first = null;
                last = null;
            } 
            else
                first = first.getNext();
            
            S--;
            return deleted;
        }
    }
    
    /**
     * Check if index is legal
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
    public String toString(){
        if (isEmpty())
            throw new IllegalStateException("Empty list");
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

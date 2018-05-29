/*

/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package LinearADTs;

/**
 * @author Alejandro Pérez Sanjuán
 * @param <E>
 */

public class Node <E> {
    private E data;
    private Node next;
    
    public Node(){}
    
    public Node (E data){
        this.data = data;
    }
    
    public Node (E data, Node <E> next){
        this.data = data;
        this.next = next;
    }
    
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    
    public Node <E> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package TreeADTs.bst;

/**
 *
 * @author Alejandro
 * @param E
 */
public class Node <E extends Comparable <E>> {
    
    private E data;
    private Node <E> leftChild;
    private Node <E> rightChild;
    private Node <E> parent;
    
    public Node (E data){
        this.data = data;
        this.rightChild = null;
        this.leftChild = null;
    }
    
    public Node (Node <E> hijoIzquierdo, Node <E> hijoDerecho){
        this.leftChild = hijoIzquierdo;
        this.rightChild = hijoDerecho;
    }
    
    public Node (Node <E> hijoIzquierdo, Node <E> hijoDerecho, Node <E> padre){
        this.leftChild = hijoIzquierdo;
        this.rightChild = hijoDerecho;
        this.parent = padre;
    }
    
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return leftChild;
    }

    public void setLeft(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<E> getRight() {
        return rightChild;
    }

    public void setRight(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> padre) {
        this.parent = padre;
    }
    
}//class
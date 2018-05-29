
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package TreeADTs.avl;

/**
 *
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public class Node <E extends Comparable <E>> {
    private E data;
    private Node <E> left;
    private Node <E> right;
    private Node <E> parent;
    private int height;
    
    public Node (E data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
    
    public Node (Node <E> leftChild, Node <E> rightChild){
        this.left = leftChild;
        this.right = rightChild;
    }

    public E getData() {
        return data;
    }

    public void setData (E dato) {
        this.data = dato;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> leftChild) {
        this.left = leftChild;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> rightChild) {
        this.right = rightChild;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

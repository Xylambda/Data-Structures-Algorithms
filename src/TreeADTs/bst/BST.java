
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package TreeADTs.bst;

/**
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public interface BST <E extends Comparable <E>> {
    
    /**
     * Retrieves the tree root.
     * @return root tree
     */
    Node <E> getRoot ();
    
    /**
     * Sets root tree
     * @param root 
     */
    void setRoot (Node <E> root);
    
    /**
     * Searches for the node that contains data
     * @param data
     * @return node
     */
    Node <E> search (E data);
    
    /**
     * Inserts n in the tree
     * @param n
     * @param data
     * @throws IllegalArgumentException 
     */
    void insert (Node<E> n, E data) throws IllegalArgumentException;
    
    /**
     * Removes node that contains data
     * @param data 
     */
    void delete (E data);
    
    /**
     * Finds the maximum key of the tree
     * @param aux
     * @return maximum node
     */
    Node <E> maximum (Node <E> auxiliar);
    
    /**
     * Finds the minimum key of the tree
     * @param aux
     * @return minimum node
     */
    Node <E> minimum (Node <E> auxiliar);
    
    
    /**
     * Retrieves the height of the tree
     * @param n
     * @return altura del árbol
     */
    int height (Node <E> n);
    
    /**
     * Traverses tree in preorder mode
     * @param n 
     */
    void preorder (Node <E> n);
    
    /**
     * Traverses tree in inorder mode
     * @param n 
     */   
    void inorder (Node <E> n);
    
    /**
     * Traverses tree in postorder mode
     * @param n 
     */    
    void postorder (Node <E> n);
    
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package TreeADTs.avl;

/**
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public interface AVL <E extends Comparable <E>> {
    
    
    /**
     * Obtains the tree root.
     * @return root tree
     */
    Node <E> getRoot ();
    
    /**
     * Sets root tree
     * @param raiz 
     */
    void setRoot (Node <E> raiz);
    
    /**
     * Searches for the node that contains data
     * @param data
     * @return node
     */
    Node <E> search (E data);    
    
    /**
     * Changes the shape of the tree with a leftRotation over node n
     * @param n 
     */
    void leftRotation (Node <E> n);

    /**
     * Changes the shape of the tree with a rightRotation over node n
     * @param n 
     */    
    void rightRotation (Node <E> n);
    
    /**
     * Checks and corrects n's balance
     * @param n 
     */
    void balance (Node <E> n);
    
    /**
     * Inserts n in the tree while keeping balance property
     * @param n
     * @param data 
     */
    void insert (Node <E> n, E data);
    
    /**
     * Deletes node that contains data while keeping balance property
     * @param data 
     */
    void delete (E data);
    
    /**
     * Finds the maximum key of the tree
     * @param aux
     * @return maximum node
     */
    Node <E> maximum (Node <E> aux);
    
    /**
     * Finds the minimum key of the tree
     * @param aux
     * @return minimum node
     */
    Node <E> minimum (Node <E> aux);
    
    
    /**
     * Obtains the height of the tree
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

/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package TreeADTs.bst;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public class BSTimplementation <E extends Comparable <E>> implements BST <E> {
    
    private Node <E> root;
    
    public BSTimplementation (){}
    
    public BSTimplementation (Node <E> raiz){
        this.root = raiz;
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public void setRoot(Node <E> root) {
        this.root = root;
    }

    @Override
    public Node <E> search(E data) {
        Node <E> aux = root;
        
        while (aux != null && !data.equals(aux.getData())){
            if (aux.getData().compareTo(data) > 0)
                aux = aux.getLeft();
            else
                aux = aux.getRight();
            
            if (aux == null)
                throw new NoSuchElementException("The value is not in the tree");
        }//while     
        
        return aux;
    }

    @Override
    public void insert (Node<E> n, E data) throws IllegalArgumentException{
        Node <E> z = new Node <> (data);
        if (root == null)
            root = z;
        else{
            Node <E> parentNode = null;

            while (n != null){
                parentNode = n;
                int comparable = n.getData().compareTo(data);
                if (comparable == 0 )
                    throw new IllegalArgumentException("The value is already in the tree");                
                else if (comparable < 0)
                    n = n.getRight();
                else
                    n = n.getLeft();
            } // while
            
            z.setParent(parentNode);
            
            int comparable = parentNode.getData().compareTo(data);
            
            if (comparable < 0)
                parentNode.setRight(z);
            else
                parentNode.setLeft(z);
        }
    } //insertar
    
    
    @Override  
    public void delete (E data){
        if (root == null)
            throw new IllegalStateException ("Empty tree");
        else{
            Node <E> deleted = search(data);
            Node <E> parent = deleted.getParent(); //We save a parent reference
            // --------------------- Case 1: Has 3 childs ---------------------
            if (deleted.getRight() != null && deleted.getLeft() != null){
                //Find maximum of left subtree
                Node <E> max = maximum (deleted.getLeft());
                
                // Copy the value and store it in the original node
                deleted.setData(max.getData());
                
                // Delete duplicate element of the tree
                if (max.getParent().getLeft().equals(max))
                    max.getParent().setLeft(null);
                else
                    max.getParent().setRight(null);
            }
            // --------------------- Case 2: Has 1 child ---------------------
            else if (deleted.getRight() != null || deleted.getLeft() != null){
                
                // We find the child node
                Node <E> child = deleted.getRight() != null ? deleted.getRight() : deleted.getLeft();
                
                //If is the root
                if (deleted.equals(root)) {
                    root = child;
                }
                else{
                    child.setParent(parent);
                    
                    if(deleted.equals(parent.getLeft()))
                        parent.setLeft(child);
                    else
                        parent.setRight(child);
                }
            }    
            // --------------------- Case 3: No childs ---------------------
            else {                
                int comparable = parent.getData().compareTo(deleted.getData());
                
                if (comparable < 0) // parent less than deleted
                    parent.setRight(null); 
                else
                    parent.setLeft(null);
            }
        } // delete   
    }

    @Override
    public Node <E> maximum (Node <E> aux) {
        while (aux.getRight() != null){
            aux = aux.getRight();
        }
        return aux;
    }

    @Override
    public Node <E> minimum (Node <E> aux) {
        while (aux.getLeft() != null){
            aux = aux.getLeft();
        }
        return aux;
    }

    @Override
    public int height (Node <E> n) {        
        if (n == null){
            return -1;
        }
        else{
            int leftHeight = height (n.getLeft());
            int rightHeight = height (n.getRight());
            
            return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        }
    }
    
    public int iterativeHeight (Node <E> n){
        if (n == null)
            return -1;
        else{
            Queue <Node<E>> queue = new LinkedList <>();
            queue.add(n);
            int h = -1;
            while (!queue.isEmpty()){
                int S = queue.size();

                while (S > 0){
                    Node <E> actual = queue.remove();

                    if (actual.getLeft() != null)
                        queue.add(actual.getLeft());
                    if (actual.getRight() != null)
                        queue.add(actual.getRight());

                    S--;
                }
                h++;
            }  
            return h;            
        }
    }

    @Override
    public void preorder(Node <E> n) {
        if (n != null){
            System.out.print(n.getData() + ", ");
            preorder (n.getLeft());
            preorder (n.getRight());
        }
    }
    
    public void iterativePreorder (Node <E> n){
        Stack <Node<E>> stack = new Stack ();
        stack.push(n);
        
        while (!stack.isEmpty()){
            Node <E> actual = stack.pop();
            System.out.print(actual.getData() + ", ");
            
            if (actual.getRight() != null)
                stack.push(actual.getRight());
            
            if (actual.getLeft() != null)
                stack.push(actual.getLeft());
        }
    }

    @Override
    public void inorder(Node <E> n) {
        if (n != null){   
            inorder (n.getLeft());
            System.out.print(n.getData() + ", ");
            inorder (n.getRight());
        }
    }
    
    public void iterativeInorder (Node <E> n){
        Stack <Node<E>> stack = new Stack ();
        
        while (!stack.isEmpty() || n != null){            
            if (n != null){
                stack.push(n);
                n = n.getLeft();
            }
            
            else{
                n = stack.pop();
                System.out.print(n.getData() + ", ");
                
                n = n.getRight(); 
            }
        }
    }

    @Override
    public void postorder(Node <E> n) {
        if (n != null){   
            postorder (n.getLeft());
            postorder (n.getRight());
            System.out.print(n.getData() + ", ");
        }
    }
    
    public void iterativePostorder (Node <E> n){
        Stack <Node <E>> stack = new Stack ();
        stack.push(n);
        
        Stack <Node <E>> exit = new Stack ();
        while (!stack.isEmpty()){
            n = stack.pop();
            exit.push(n);
            
            if (n.getLeft() != null)
                stack.push(n.getLeft());
            
            if (n.getRight() != null)
                stack.push(n.getRight());
        }
        
        while (!exit.isEmpty())
            System.out.print(exit.pop().getData() + ", ");
    }
    
    public void levels (Node <E> n){
        Queue <Node<E>> queue = new LinkedList <>();
        queue.add(n);
        int h = 0;
        while (!queue.isEmpty()){
            int S = queue.size();
            
            while (S > 0){
                Node <E> actual = queue.remove();  
                
                System.out.print(actual.getData() + ", ");
                
                if (actual.getLeft() != null)
                    queue.add(actual.getLeft());
                if (actual.getRight() != null)
                    queue.add(actual.getRight());
                
                S--;
            }
            System.out.println("");
        }
    }
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */
package SetADTs.priorityQueue;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 * @param <E> 
 */
public class Heap <E extends Comparable<E>> implements PriorityQueue <E>  {
    
    
    private int size;
    private E V [] = null;     //  Element V [0] is despised.
    
    public Heap (){
        size = 0;
    }
    
    public Heap (int m){
        this ();
        V = (E[]) new Comparable [m];
    }
    
    
    /**
     * Transforms a non-sorted array into a heap
     */
    private void buildHeap (){
        for (int i = size/2; i > 0; i--)
            heapify (V, i);
    }    
    
    /**
     * Builds a heap from a non-sorted array
     * @param v 
     */
    public void buildHeap (E [] v) {
        size = v.length;
        
        for (int i = 1; i <= size; i++)     //  Shifts elements one position
            V [i] = v[i - 1];
        
        Heap.this.buildHeap ();
    }
    
    private void heapify (E [] A, int pos){
        
        // ---- Iterative ----
        int largest = pos;
        while (true){
            int left = left (pos);
            int right = right (pos);
            
            if (left <= size  && V[left].compareTo(V[pos]) > 0)
                largest = left;
            
            else
                largest = pos;
            
            if (right <= size  && V[right].compareTo(V[largest]) > 0)
                largest = right;
            
            if (largest == pos)
                break;
            
            
            //  Exchange elements
            E auxiliar = V [pos];
            V [pos] = V[largest];
            V [largest] = auxiliar;
            
            pos = largest;
            
        }
        
        // ---- Recursive ----
        /*
        int left = left (pos);
        int right = right (pos);
        
        int largest = pos;
        
        if (left <= size  && V[left].compareTo(V[largest]) > 0)
            largest = left;
        
        if (right <= size  && V[right].compareTo(V[largest]) > 0)
            largest = right;
        
        if (largest != pos){
            E auxiliar = V [pos];
            V [pos] = V[largest];
            V [largest] = auxiliar;
            heapify (V, largest);
        }
        */
    }
    

    @Override
    public void insert(E x) throws IllegalStateException {
        if (contains (x))
            throw new IllegalStateException ("Element is already in the queue");
        
        else if (size == V.length)
            throw new IllegalStateException ("Full queue");
        
        else{
            size++;
            V [size] = x;
            int i = size;

            while (i > 1 && V [parent(i)].compareTo(x) < 0){
                V [i] = V [parent(i)];
                i = parent(i);
            }

            V [i] = x;      
        }
    }

    @Override
    public E max() throws IllegalStateException {
        if (size == 0)
            throw new IllegalStateException ("Empty queue"); 
        else        
            return V [1];
    }

    @Override
    public E deleteMax() throws IllegalStateException {
        if (size == 0)
            throw new IllegalStateException ("Empty queue");
        
        else {        
            E max = V [1];
            V [1] = V [size];
            size--;
            heapify (V, 1);
            
            return max;
        }
    }
    
    @Override
    public String toString (){
        String result = "";
        if (size == 0)
            throw new IllegalStateException ("Empty queue");
        
        else{
            for (int i = 1; i <= size; i++)
                result += V [i] + ", ";
            
            return result;
        }
    }
    
    
    /** -------------------------------------------------------------------------------------
     *  ---------------------------------- PRIVATE METHODS ----------------------------------
     *  -------------------------------------------------------------------------------------
     */
    
    /**
     * Checks if the array contains element x
     * @param x
     * @return true if x is in the array
     */
    private boolean contains (E x){ 
        int i = 1;
        while (i < size){
            if (V [i].compareTo(x) == 0)
                return true;
            
            else
                i++;    
        }
        return false;       
    }
    
    /**
     * Retrieves left child of a node given its position
     * @param i
     * @return left child position
     */
    private int left (int i){        
        return 2*i;
    }
    
    /**
     * Retrieves right child of a node given its position
     * @param i
     * @return right child position
     */
    private int right (int i){
        return 2*i + 1;
    }
    
    /**
     * Retrieves parent's node given its position
     * @param i
     * @return parent position
     */
    private int parent (int i){
        return i/2;
    }
}

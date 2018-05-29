
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */
package SetADTs.set;

/**
 *
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public interface Set <E> {
    
    /**
     * UNION operation over 2 sets
     * @param A
     * @param B 
     */
    void union (boolean[] A, boolean[] B);

    /**
     * INTERSECTION operation over 2 sets
     * @param A
     * @param B 
     */    
    void intersection (boolean[] A, boolean[] B);
    
    /**
     * DIFFERENCE operation over 2 sets
     * @param A
     * @param B 
     */    
    void difference (boolean[] A, boolean[] B);

    /**
     * Check if data is in the set
     * @param data
     * @return true if it is
     */
    boolean isMember (int data);
    
    /**
     * Deletes data from the set
     * @param data 
     */
    void delete (int data);
    
    /**
     * Inserts data in the set
     * @param data 
     */
    void insert (int data);
    
}

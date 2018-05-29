
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */
package SetADTs.set;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Pérez-Sanjuán
 * @param E
 */
public class LinkedSet <E> {
    
    private ArrayList <E> C;

    public LinkedSet (){
        C = new ArrayList <>();
    }
    
    public LinkedSet (ArrayList <E> C){
        this.C = C;
    }
    
    /**
     * Retrieves the list used to implement the set
     * @return 
     */
    public ArrayList <E> getC (){
        return C;
    }
    
    /**
     * A UNION B
     * @param A
     * @param B
     * @return list of all elements after operation
     */
    public ArrayList<E> union(ArrayList <E> A, ArrayList <E> B) {
        ArrayList <E> auxiliar = new ArrayList <>();
        auxiliar.addAll(A);
        //  UNION without duplicate elements
        for (int i = 0; i < B.size(); i++){
            if (!auxiliar.contains(B.get(i)))
                auxiliar.add(B.get(i));
        }
        return auxiliar;
    }
    
    /**
     * A INTERSECTION B
     * @param A
     * @param B
     * @return list of all elements after operation
     */
    public ArrayList<E> intersection(ArrayList <E> A, ArrayList <E> B) {
        ArrayList <E> auxiliar = new ArrayList <>();
        //  Find smallest list
        int S = A.size() < B.size() ? A.size() : B.size();
        
        for (int i = 0; i < S; i++){
            if (B.contains(A.get(i)))
                auxiliar.add(A.get(i));
        } 
        return auxiliar;
    }
    
    /**
     * A - B
     * @param A
     * @param B
     * @return list of all elements after operation
     */
    public ArrayList<E> difference(ArrayList <E> A, ArrayList <E> B) {
        ArrayList <E> aux = new ArrayList <>();
        //  Find smallest list
        int S = A.size() < B.size() ? A.size() : B.size();
        
        for (int i = 0; i < S; i++){
            if (!B.contains(A.get(i)))
                aux.add(A.get(i));
        }
        return aux;
    }
    
    /**
     * Checks if data is in the set
     * @param data
     * @return true if it is
     */
    public boolean isMember(E data) {
        return C.contains(data);
    }
    
    /**
     * Removes element if it is in the set
     * @param dato 
     * @exception IllegalStateException
     */
    public void delete(E data) {
        if (!C.contains(data))
            throw new IllegalStateException("Element " + data + " is not in the set");
        else
            C.remove(data);
    }
    
    /**
     * Inserts an element if is not in the set
     * @param dato 
     */
    public void insert(E data) {
        if (C.contains(data))
            throw new IllegalStateException("Element " + data + " is already in the set");
        else
            C.add(data);
    }
      
    @Override
    public String toString (){
        return C.toString();
    }
}

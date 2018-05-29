
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
public class ArrayBit <E> implements Set <E> {
    
    private boolean C [];
    
    public ArrayBit (int S){
        C = new boolean [S];
    }

    public boolean[] getC() {
        return C;
    }

    public void setC(boolean[] C) {
        this.C = C;
    }

    @Override
    public void union(boolean[] A, boolean[] B) {
        int size = A.length > B.length ? A.length : B.length;
        boolean [] result = new boolean [size];
        
        for (int i = 0; i < size; i++) 
            result [i] = A[i] | B[i];
        
        C = result;
    }

    @Override
    public void intersection(boolean[] A, boolean[] B) {
        int size = A.length > B.length ? A.length : B.length;
        boolean [] result = new boolean [size];
        
        for (int i = 0; i < size; i++)
            result [i] = A[i] & B[i];
        
        C = result;
    }

    @Override
    public void difference(boolean[] A, boolean[] B) {
        int size = A.length > B.length ? A.length : B.length;
        boolean [] result = new boolean [size];
        
        for (int i = 0; i < size; i++) 
            result [i] = A[i] & !B[i];
        
        C = result;
    }

    @Override
    public boolean isMember(int data) {
        checkIndex (data, C.length);
        return C[data];
    }

    @Override
    public void delete(int data) {
        checkIndex (data, C.length);
        if (!C[data])
            throw new IllegalStateException ("Element " + data + " is not in the set");
        else
            C[data] = false;
    }

    @Override
    public void insert(int data) {
        checkIndex (data, C.length);
        if (C[data])
            throw new IllegalArgumentException ("Element " + data + " is already in the set");
        else
            C [data] = true;
    }
    
    
    @Override
    public String toString (){
        String result = "";
        for (int i = 0; i < C.length;i++){
            int j = C[i] ? 1 : 0;
            result += j + ", ";
        }
        return result;        
    }
    
    /**
     * Checks if the index is a legal position
     * @param index
     * @param range
     * @throws IndexOutOfBoundsException 
     */
    private void checkIndex (int index, int range) throws IndexOutOfBoundsException{
        if (index < 0 || index >= range)
            throw new IndexOutOfBoundsException ("Illegal index at: " + index);
    }
    
}   //  class

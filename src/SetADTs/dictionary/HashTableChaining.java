/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package SetADTs.dictionary;

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 * @param <K>
 * @param <V> 
 */
public class HashTableChaining <K, V> implements Dictionary <K, V> {

    private int n;  //  number of elements
    
    //  We create an array of type buscket list
    private ArrayList <Bucket <K, V>> [] T = null;
        
    public HashTableChaining (int m){
        T = new ArrayList [m];
        for (int i = 0; i < m; i++)
            T [i] = new ArrayList <Bucket <K, V>>();
    }
    
    private int hashFunction(K key){
        return key.hashCode() % T.length;
    }
    
    @Override
    public void insert(K k, V x) throws IllegalStateException {
        if (isMember (k))
            throw new IllegalStateException ("Duplicated element: " + k.toString());
        
        else{
            Bucket <K, V> bucket = new Bucket <K, V> (k, x);
            int pos = hashFunction (k);
            T[pos].add(bucket);
            n++;
        }
    }

    @Override
    public void delete(K k) throws NoSuchElementException {
        if (!isMember (k))
            throw new NoSuchElementException ("Element " + k.toString() + " is not in the table");
        
        else{
            int pos = hashFunction(k);
            int i = 0;
            while (i < T[pos].size()){
                if (T[pos].get(i).getKey().equals(k)){
                    T[pos].remove(i);
                    n--;
                } 
                else
                    i++;           
            } //  while
        }
    }

    @Override
    public boolean isMember(K k) {
        int pos = hashFunction(k);
        
        int S = T[pos].size();  //  size of the list T[pos]
        
        int i = 0;
        while (i < S){
            if (T[pos].get(i).getKey().equals(k))
                return true;
            
            else
                i++;
        }
        
        return false;
    }

    @Override
    public int search(K k) throws NoSuchElementException {        
        if (!isMember (k))
            throw new NoSuchElementException ("Element " + k.toString() + " is not in the table");
        
        else
            return hashFunction(k);
    }
    
    /**
     * Returns the load factor of hash table
     * @return load factor
     */
    public double loadFactor (){
        return (double) n / (double) T.length;
    }    
}

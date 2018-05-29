
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */
package SetADTs.dictionary;

/**
 *
 * @author Alejandro Pérez-Sanjuán
 */
public class Bucket <K, V> {
    private K key;
    private V value;
    
    public Bucket (){}
    
    public Bucket (K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }    
}

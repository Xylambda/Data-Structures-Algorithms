
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package GraphADT;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 */
public class AdjacencyMatrix implements Graph {
    
    Integer [][] matrix;    //  Adjacency Matrix
    ArrayList <Integer> vertices;   // Ordered list with vertices
    
    /**
     * Creates a graph with a default vertex 0.
     */
    public AdjacencyMatrix (){
        matrix = new Integer [1][1];
        verticesList ();
    }
    
    /**
     * Creates a graph based on numberOfVertices.
     * Remember it's 0-based graph implementation. Vertices start at 0. 
     * @param numberOfVertices
     */
    public AdjacencyMatrix (int numberOfVertices){
        matrix = new Integer [numberOfVertices][numberOfVertices];
        verticesList ();
    }
    
    /**
     * Creates a graph from a matrix. The passed matrix will become in the new Adjacency Matrix
     * @param matrix 
     */
    public AdjacencyMatrix (Integer [][] matrix){
        this.matrix = matrix;
        verticesList ();
    }

    @Override
    public void addVertex(int v) throws IllegalStateException { //  Only "next" vertex allowed. Ex: 0-4 vertices in the graph, only 5 allowed
        if (v > matrix.length)
            throw new IllegalStateException ("Vertex: " + v + " is not allowed");
        
        else if (v < matrix.length)
            throw new IllegalStateException ("Vertex: " + v + " is already in the graph or does not exist");
        
        else{
            copyAndAdd ();
            vertices.add(v);    //  Adds vertex to vertices
        }
    }

    @Override
    public void removeVertex(int v) throws NoSuchElementException {
        if (v > matrix.length)
            throw new NoSuchElementException("Vertex " + v + " is not in the graph");
        
        else if (v < 0)
            throw new IllegalStateException ("Illegal vertex: " + v);
        
        else{
            copyAndDelete (v);      //  Shifts all elements. Alternative: set them as null
            vertices.remove(v);     //  Removes vertex from vertices
        }    
    }

    @Override
    public ArrayList<Integer> getVertices() {
        return vertices;
    }

    @Override
    public void addEdge(int source, int destination, Integer weight) throws IllegalStateException {
        if (matrix[source][destination] != null)
            throw new IllegalStateException ("Edge " + source + "," + destination + " is already in the graph");
        
        else
            matrix[source][destination] = weight;
    }

    @Override
    public void removeEdge(int source, int destination) throws NoSuchElementException {
        if (matrix[source][destination] == null)
            throw new NoSuchElementException ("Edge " + source + "," + destination + " is not in the graph");
        
        else
            matrix[source][destination] = null;
    }

    @Override
    public boolean containsEdge(int source, int destination) {
        return matrix[source][destination] != null;
    }

    @Override
    public int getEdge(int source, int destination) throws NoSuchElementException {
        if (matrix[source][destination] == null)
            throw new NoSuchElementException ("Edge " + source + "," + destination + " is not in the graph");
        
        else
            return matrix [source][destination];
    }
    
    @Override
    public String toString (){
        String result = "";
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++)
                result += matrix [i][j] + " ";
            
            result += "\n";
        }
        
        return result;
    }
    
    /** -------------------------------------------------------------------------------------
     *  ---------------------------------- PRIVATE METHODS ----------------------------------
     *  -------------------------------------------------------------------------------------
     */
    
    /**
     * Initializes the list of vertices
     */
    private void verticesList (){
        this.vertices = new ArrayList <>();
        
        if (matrix.length <= 1){
            Integer value = 0;
            vertices.add(value);
        }
        
        else
            for (int i = 0; i <= matrix.length; i++)
                vertices.add(i);  
    }
    
    /**
     * Creates an auxiliar with an extra vertex and copies all the elements from matrix to auxiliar.
     * Then, auxiliar becomes the new matrix.
     */
    private void copyAndAdd (){
        int newLenght = matrix.length + 1;
        Integer [][] auxiliar = new Integer [newLenght][newLenght];
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++)
                auxiliar [i][j] = matrix [i][j];
        }
        
        matrix = auxiliar;
    }
    
    /**
     * Creates an auxiliar with one less vertex and copies all the elements from matrix to auxiliar.
     * Then, auxiliar becomes the new matrix.
     * @param vertex 
     */
    private void copyAndDelete (int vertex){
        int newLenght = matrix.length - 1;
        Integer [][] auxiliar = new Integer [newLenght][newLenght];
        
        //  Case 1: first element
        if (vertex == 0){          
            shiftRows (0, newLenght);
            shiftColumns (0, newLenght);
            copyElements (auxiliar, newLenght);
        }
        
        //  Case 2: last element
        else if (vertex == newLenght) {
            copyElements (auxiliar, newLenght);
        }
        
        //  Case 3: other vertex
        else {
            shiftRows (vertex, newLenght);
            shiftColumns (vertex, newLenght);
            copyElements (auxiliar, newLenght);
        }
        
        matrix = auxiliar;
    }
    
    /**
     * Shifts all the rows from vertex 'from'
     * @param from
     * @param lenght 
     */
    private void shiftRows (int from, int lenght){      
        for (int i = from; i < lenght; i++){
            for (int j = 0; j < matrix.length; j++)
                matrix [i][j] = matrix [i + 1][j];
        }
    }
    
    /**
     * Shifts all the columns from vertex 'from'
     * @param from
     * @param lenght 
     */
    private void shiftColumns (int from, int lenght){
        for (int i = 0; i < matrix.length; i++){
            for (int j = from; j < lenght; j++)
                matrix [i][j] = matrix [i][j + 1]; 
        }        
    }
    
    /**
     * Copies elements from matrix to an auxiliar matrix
     * @param auxiliar
     * @param lenght 
     */
    private void copyElements (Integer [][] auxiliar, int lenght) {        
        for (int i = 0; i < lenght; i++){
            for (int j = 0; j < lenght; j++)
                auxiliar [i][j] = matrix[i][j]; 
        }
    }
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package GraphADT.Undirected;

import GraphADT.Directed.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 */
public class AdjMatrix implements Graph {
    
    private Integer [][] matrix;    //  Adjacency Matrix
    private ArrayList <Vertex> vertices;   // List with vertices
    
    public AdjMatrix (int size) {
        matrix = new Integer [size][size];
        verticesList ();
        initializeMatrix ();
    }

    @Override
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    @Override
    public void addEdge(int source, int destination, Integer weight) throws IllegalStateException {
        if (matrix[source][destination] != 0)
            throw new IllegalStateException ("Edge " + source + "," + destination + " is already in the graph");
        
        else{
            matrix[source][destination] = weight;
            matrix[destination][source] = weight;
        }
    }

    @Override
    public void removeEdge(int source, int destination) throws NoSuchElementException {
        if (matrix[source][destination] == 0 && matrix[destination][source] == 0)
            throw new NoSuchElementException ("Edge " + source + "," + destination + " is not in the graph");
        
        else{
            matrix[source][destination] = 0;
            matrix[destination][source] = 0;
        }
    }

    @Override
    public boolean containsEdge(int source, int destination) {
        return matrix[source][destination] != 0 &&
                matrix[destination][source] != 0;
    }

    @Override
    public int getEdge(int source, int destination) throws NoSuchElementException {
        if (matrix[source][destination] == null)
            throw new NoSuchElementException ("Edge " + source + "," + destination + " is not in the graph");
        
        else
            return matrix[source][destination];
    }
    
    @Override
    public String toString (){
        String result = "";
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++)
                result += matrix[i][j] + "  ";
            
            result += "\n";
        }
        
        return result;
    }
    
    public String verticesToString (){
        String result = "";
        for (int i = 0; i < vertices.size(); i++){
            result += vertices.get(i).getName() + ", ";
        }
        
        return result;
    }
    
    /** 
     * -------------------------------------------------------------------------------------
     *  ---------------------------------- PRIVATE METHODS ----------------------------------
     *  -------------------------------------------------------------------------------------
     */
    
    /**
     * Initializes the list of vertices
     */
    private void verticesList (){
        this.vertices = new ArrayList <>();
        
        if (matrix.length <= 1){
            Vertex zeroVertex = new Vertex (0);
            vertices.add(zeroVertex);
        }
        else
            for (int i = 0; i < matrix.length; i++)
                vertices.add(new Vertex(i));
    }
    
    /**
     * Initializes the matrix to have all edges equal to zero
     */
    private void initializeMatrix (){
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                matrix [i][j] = 0;   
    }
}

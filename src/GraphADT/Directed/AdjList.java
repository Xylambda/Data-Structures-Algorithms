
/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package GraphADT.Directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 */
public class AdjList implements Graph {
    
    ArrayList <Vertex> [] adj;
    private ArrayList <Vertex> vertices;   // List with vertices
    
    public AdjList (int size){
        adj = (ArrayList <Vertex> []) new ArrayList [size];
        for (int i = 0; i < size; i++)
            adj [i] = new ArrayList <>();
        
        verticesList (size);
    }

    @Override
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    @Override
    public void addEdge(int source, int destination, Integer weight) throws IllegalStateException {
        if (source < 0 || source >= adj.length)
            throw new IllegalStateException ("Illegal source vertex: " + source);
        
        else if (destination < 0 || destination >= adj.length)
            throw new IllegalStateException ("Illegal destination vertex: " + destination);
        
        else{
            Vertex v = new Vertex (destination, weight);
            adj[source].add(v);    
        }
    }

    @Override
    public void removeEdge(int source, int destination) throws NoSuchElementException {
        if (source < 0 || source >= adj.length)
            throw new IllegalStateException ("Illegal source vertex: " + source);
        
        else if (destination < 0 || destination >= adj.length)
            throw new IllegalStateException ("Illegal destination vertex: " + destination);
        
        else{
            int i = 0;
            while (i < adj[source].size() && adj[source].get(i).getName() != destination)
                i++;

            adj[source].remove(i);        
        }
    }

    @Override
    public boolean containsEdge(int source, int destination) {
        if (source < 0 || destination < 0)
            return false;
        
        else{
            int i = 0;
            while (i < adj[source].size()){
                if (adj[source].get(i).getName() == destination)
                    return true;

                else
                    i++;
            }
        }
        return false;  
    }

    @Override
    public int getEdge(int source, int destination) throws NoSuchElementException {
        if (source < 0 || source >= adj.length || destination < 0 || destination >= adj.length)
            throw new NoSuchElementException ("Edge: (" + source + "," + destination + ") is not in the Graph");
        
        else{
            int pos = search (source, destination);
            return adj[source].get(pos).getWeight();
        }       
    }
    
    @Override
    public String toString (){
        String output = "";
        
        for (int i = 0; i < adj.length; i++){
            output += i + ": ";
            for (int j = 0; j < adj[i].size(); j++){
                output += adj[i].get(j).getName() + ", ";
            }
            output += "\n";
        }
        
        return output;
    }
    
    /**
     * Transform vertices to string.
     * @return string of vertices
     */
    public String verticesToString (){
        String result = "";
        for (int i = 0; i < vertices.size(); i++)
            result += vertices.get(i).getName() + ", ";
        
        return result;
    }
    
    /**
     * Traverse the graph using iterative depth traverse algorithm.
     * @param v starting vertex
     */
    public void iterativeDepthTraverse (int v){
        //  Mark vertices as unvisited
        markAsUnvisited();
        
        //  Explicitly create a Stack
        Stack <Integer> s = new Stack <>();
        s.push(v);
        
        while (!s.isEmpty()){
            int w = s.pop();
            
            if (!vertices.get(w).isVisited()){
                //  Mark as visited
                vertices.get(w).setVisited(true);
                
                //Process Vertex
                System.out.print(w + " ");
                
                //  Visit adjacent nodes
                for (Vertex u: adj[w]){
                    if (!vertices.get(u.getName()).isVisited())
                        s.push(u.getName());
                }
            }
        }   //  while
    }
    
    /**
     * Traverse the graph using depth traverse algorithm.
     * @param v starting vertex
     */
    public void depthTraverse (int v) {
        //  Mark vertices as unvisited
        markAsUnvisited();
        
        //  Perform depth traverse
        doDepthTraverse (v);
    }
    
    public void breadthTraverse (int v){
        //  Mark vertices as unvisited
        markAsUnvisited();
        
        //  Create queue and add initial element
        Queue <Integer> q = new LinkedList <>();
        q.add(v);
        
        while (!q.isEmpty()){
            int w = q.remove();
            if (!vertices.get(w).isVisited()){
                //  Mark as visited
                vertices.get(w).setVisited(true);
                
                //  Process vertex
                System.out.print(w + " ");
                
                //  Visit adjacent nodes
                for (Vertex u: adj[w]){
                    if (!vertices.get(u.getName()).isVisited())
                        q.add(u.getName());
                }
            }
        }   //  while
    }
    
    /** 
     * -------------------------------------------------------------------------------------
     *  ---------------------------------- PRIVATE METHODS ----------------------------------
     *  -------------------------------------------------------------------------------------
     */
    private int search (int source, int destination){
        int i = 0;
        while (i < adj[source].size()){
            if (adj[source].get(i).getName() == destination)
                break;
            
            else
                i++;
        }
        
        return i;    
    }
    
    /**
     * Initializes the list of vertices
     */
    private void verticesList (int size){
        this.vertices = new ArrayList <>();
        
        if (size <= 1){
            Vertex zeroVertex = new Vertex (0);
            vertices.add(zeroVertex);
        }
        else
            for (int i = 0; i < size; i++)
                vertices.add(new Vertex(i));
    }
    
    /**
     * Marks vertices as unvisited
     */
    private void markAsUnvisited (){
        for (Vertex v: vertices)
            v.setVisited(false);
    }
    
    /**
     * Performs depth traverse recursively
     * @param v 
     */
    private void doDepthTraverse (int v){  //  v: initial vertex
        //  Mark as visited
        vertices.get(v).setVisited(true);
        
        //  Process vertex
        System.out.print(vertices.get(v).getName() + " ");
        
        //  Visit adjacent nodes
        for (Vertex w: adj[v]){
            if (!vertices.get(w.getName()).isVisited())
                doDepthTraverse (w.getName());
        }
    }
}

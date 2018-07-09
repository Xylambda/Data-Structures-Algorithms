/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphADT.Directed;

/**
 *
 * @author Alejandro
 */
public class tests {
    
    
    public static void main (String args []){
        
        int size = 5;
        
        /*
        AdjMatrix G = new AdjMatrix (size);
        
        System.out.println(G.toString());
        
        //  Create Matrix
        G.addEdge(0, 1, 1);
        G.addEdge(0, 3, 1);
        G.addEdge(1, 2, 1);
        G.addEdge(1, 3, 1);
        G.addEdge(2, 2, 1);
        G.addEdge(3, 2, 1);
        G.addEdge(3, 4, 1);
        G.addEdge(4, 0, 1);
        G.addEdge(4, 3, 1);
        
        System.out.println(G.toString());
        
        System.out.println(G.verticesToString());
        */
        
        AdjList G = new AdjList (5);
        
        G.addEdge(0, 2, 1);
        G.addEdge(0, 4, 1);
        G.addEdge(1, 2, 1);
        G.addEdge(1, 3, 1);
        G.addEdge(2, 4, 1);
        G.addEdge(3, 4, 1);
        G.addEdge(4, 0, 1);
        G.addEdge(4, 1, 1);
        G.addEdge(4, 4, 1);
        
        System.out.println(G.toString());
        System.out.println(G.verticesToString());
        
        System.out.println("\nRecursive Depth traverse:");
        G.depthTraverse(0);
        System.out.println("\n\nIterative Depth traverse:");
        G.iterativeDepthTraverse(0);
        
        System.out.println("\n\nBreadth Traverse:");
        G.breadthTraverse(0);
        
    }
}


/*
 * Released under MIT License.
 * Copyright 2018 Alejandro Pérez-Sanjuán.
 */

package GraphADT.Directed;

/**
 * 
 * @author Alejandro Pérez-Sanjuán
 */
public class Vertex {
    
    private int name;
    private int weight;
    private boolean visited = false;
    
    public Vertex (int name){
        this.name = name;
    }
    
    public Vertex (int name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int numVertices;
    private List<Integer> adjacencyList[];
    private int[][] adjacencyMatrix;

    Graph() {
        this.numVertices = 0;
        this.adjacencyList = null;
        this.adjacencyMatrix = new int[0][0];
    }

    Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        for (int row = 0; row < numVertices; row++) {
            for (int col = 0; col < numVertices; col++) {
                this.adjacencyMatrix[row][col] = 0;
            }
        }
        this.adjacencyList = new List[numVertices];
        for (int index = 0; index < numVertices; index++) {
            this.adjacencyList[index] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        // add edge to adjacency matrix if it does not exist
        if (this.adjacencyMatrix[source][destination] == 0) {
            this.adjacencyMatrix[source][destination] = 1;
        }

        // add edge to the adjacency list
        if (!this.adjacencyList[source].contains(destination)) {
            this.adjacencyList[source].add(destination);
        }
        if (!this.adjacencyList[destination].contains(source)) {
            this.adjacencyList[destination].add(source);
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("\nPrinting Adjacency Matrix");
        for (int row = 0; row < numVertices; row++) {
            System.out.println();
            for (int col = 0; col < numVertices; col++) {
                System.out.print(this.adjacencyMatrix[row][col] + " ");
            }
        }
    }

    public void printAdjacencyList() {
        System.out.println("\nPrinting Adjacency List");
        for (int node = 0; node < this.adjacencyList.length; node++) {
            System.out.println("\nNode: " + node);
            this.adjacencyList[node].stream().forEach(val -> System.out.print(val + " "));
        }
    }
}
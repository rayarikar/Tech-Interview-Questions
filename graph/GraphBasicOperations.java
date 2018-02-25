package graph;

public class GraphBasicOperations {
    public static void main(String args[]) {
        Graph graph = new Graph(5);
        System.out.println("Building a graph of 5 nodes");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 4);
        System.out.println("Done building a graph");
        graph.printAdjacencyMatrix();
        graph.printAdjacencyList();
    }
}

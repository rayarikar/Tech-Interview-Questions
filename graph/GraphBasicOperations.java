package graph;

public class GraphBasicOperations {

    public void buildGraph(UndirectedGraph graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 4);
    }

    public void printAdjacencyDetails(UndirectedGraph graph) {
        graph.printAdjacencyMatrix();
        graph.printAdjacencyList();
    }


    public static void main(String args[]) {
        GraphBasicOperations graphBasicOperations = new GraphBasicOperations();
        UndirectedGraph graph = new UndirectedGraph(5);
        System.out.println("Building a graph of 5 nodes");
        graphBasicOperations.buildGraph(graph);
        System.out.println("Done building a graph");
        graphBasicOperations.printAdjacencyDetails(graph);
    }
}

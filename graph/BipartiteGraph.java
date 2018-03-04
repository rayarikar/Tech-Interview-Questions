package graph;

import java.util.*;

/**
 * Given a graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * <p>
 * <p>
 * Note:
 * <p>
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 */

public class BipartiteGraph {

    public void buildGraph(UndirectedGraph graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);  // --> commenting this will make the graph bipartite
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0); // --> commenting this will make the graph bipartite
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
    }

    public void printAdjacencyDetails(UndirectedGraph graph) {
        graph.printAdjacencyMatrix();
        graph.printAdjacencyList();
    }

    public boolean isGraphBipartite(UndirectedGraph graph) {
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        int[] vertexColors = new int[4];
        Arrays.fill(vertexColors, -1);

        // BFS over each node starting from 0 coloring the graphs at the same time
        int startNode = 0;
        int startColor = 1;
        Queue<Integer> vertexQueue = new LinkedList<>();
        // add start node and color that
        vertexQueue.add(startNode);
        vertexColors[startNode] = startColor;

        while (!vertexQueue.isEmpty()) {
            int vertex = vertexQueue.poll();
            // get children of the vertex
            List<Integer> children = graph.getVertexChildren(vertex);

            // loop over each child to see if they have a different color
            for (int child: children) {
                // if there is an edge
                if (adjacencyMatrix[vertex][child] == 1) {
                    // if there is no color, add to the queue
                    if(vertexColors[child] == -1) {
                        vertexColors[child] = 1 - vertexColors[vertex];
                        vertexQueue.add(child);
                    }
                    // if the child has same color as parent, not a bipartite
                    else if (vertexColors[child] == vertexColors[vertex]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String args[]) {
        UndirectedGraph graph = new UndirectedGraph(4);
        System.out.println("Building a graph of 4 nodes");
        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        bipartiteGraph.buildGraph(graph);
        System.out.println("Done building a graph");
        bipartiteGraph.printAdjacencyDetails(graph);
        System.out.println("\nCurrent graph Bipartite status: " + bipartiteGraph.isGraphBipartite(graph));
    }
}

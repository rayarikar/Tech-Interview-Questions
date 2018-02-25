package graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class SearchGraph {

    public static void bfsUndirectedGraph(UndirectedGraph graph, int startNode) {
        System.out.println("\nTraversing the graph using BFS\n");
        if (startNode >= graph.getAdjacencyList().length) {
            System.out.println("Node does not exist in the graph. Exiting");
            return;
        }
        Queue queue = new ArrayDeque();
        boolean[] visited = new boolean[graph.getAdjacencyList().length];
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int head = (int) queue.poll();
            System.out.print(head + " ");
            visited[head] = true;
            List<Integer> neighbors = graph.getAdjacencyList()[head];
            neighbors.stream().forEach(neighbor -> {
                if (!visited[neighbor] && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            });
        }
    }
}

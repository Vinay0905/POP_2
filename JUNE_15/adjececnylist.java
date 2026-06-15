package JUNE_15;

import java.util.ArrayList;
import java.util.List;

public class adjececnylist {

    private final List<List<int[]>> adjList;

    public adjececnylist(int vertices) {
        adjList = new ArrayList<>();
        createAdjList(vertices);
    }

    private void createAdjList(int vertices) {
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new int[]{dest, weight});
    }

    public void addEdges(int[][] edges) {
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int[] edge : adjList.get(i)) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        adjececnylist graph = new adjececnylist(6);
        
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 4},
                {1, 3, 7},
                {1, 2, 1},
                {2, 4, 3},
                
                {3, 5, 1},
                {4, 5, 5},
                {4, 3, 2},
                {4, 5, 5}
        };

        graph.addEdges(edges);

        System.out.println("Directed weighted adjacency list:");
        graph.printGraph();
    }
}

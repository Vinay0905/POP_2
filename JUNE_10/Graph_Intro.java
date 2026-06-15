package JUNE_10;

import java.util.Scanner;

// Approach: Store the graph using an adjacency matrix.
// For every edge, mark both directions because this is an undirected graph.
public class Graph_Intro {

    // This reads edges and prints the adjacency matrix.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = 7, e = 8;
        int[][] adjmatrix = new int[v][v];

        System.out.println("Enter " + e + " edges:");
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adjmatrix[a][b] = 1;
            adjmatrix[b][a] = 1; // remove this line for directed graph
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adjmatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

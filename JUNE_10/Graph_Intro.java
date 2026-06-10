package JUNE_10;

import java.util.Scanner;

public class Graph_Intro {

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
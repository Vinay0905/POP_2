package JUNE_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph_List_Representation {
    

    public static void BFS(List<List<Integer>> adjList,int v,int start){
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);
        while (q.isEmpty()==false) {
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int i=0;i<adjList.get(curr).size();i++){
                if(visited[adjList.get(curr).get(i)]!=true)
                {
                    visited[adjList.get(curr).get(i)]=true;
                    q.offer(adjList.get(curr).get(i));
                }
            }

            
        }
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int v,e;
        System.out.println("Entire V");
        v=sc.nextInt();
        System.out.println("Entire E");
        e=sc.nextInt();
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int src,des;
            System.out.println("Entire ur src and des");
            src=sc.nextInt();
            des=sc.nextInt();
            adjList.get(src).add(des);
            adjList.get(des).add(src);
        }
        sc.close();
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        // INPUTS
        // 6
        // 9
        // 0 1
        // 0 2
        // 0 5
        // 1 2
        // 1 4
        // 2 3
        // 3 4
        // 3 5
        // 4 5
        System.out.println("BFS");
        BFS(adjList, v, 0);
    }
}

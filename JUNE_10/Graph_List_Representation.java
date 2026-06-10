package JUNE_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_List_Representation {
    
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
        for(int i=0;i<v;i++){
            for(int j=0;j<adjList.get(i).size();j++){
                System.err.println(adjList.get(i).get(j)+" ");
            }
        }
    }
}

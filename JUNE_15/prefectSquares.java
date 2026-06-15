package JUNE_15;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class prefectSquares {
    public static int BFS(int n){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int level=0;
        q.offer(n);
        set.add(n);
        while(q.isEmpty()==false){
            int size=q.size();
            level++;
            for(int i=0;i<size;i++){
                int curr=q.poll();
                for (int j = 1; j * j <= curr; j++) {
                    int nex = curr - (j * j);

                    if (nex == 0) {
                        return level;
                    }

                    if (!set.contains(nex)) {
                        set.add(nex);
                        q.offer(nex);
                    }
                }
            }
        }
        return level;
    }
    public static int numSquares(int n){
        return BFS(n);
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));

    }

}

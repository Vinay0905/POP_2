package JUNE_15;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Approach: Use BFS from n by subtracting perfect squares.
// Each BFS level means using one more square.
public class prefectSquares {
    // This finds the least number of perfect squares needed to make n.
    // It returns when subtraction reaches 0.
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
    // This starts the BFS solution.
    public static int numSquares(int n){
        return BFS(n);
    }
    // This tests the perfect squares answer for one number.
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));

    }

}

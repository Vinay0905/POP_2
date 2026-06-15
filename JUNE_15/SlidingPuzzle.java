package JUNE_15;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Approach: Convert the board into a string and use BFS.
// Each move swaps 0 with a valid neighbor until target state is found.
public class SlidingPuzzle {
    

    // This swaps two positions in the puzzle string.
    public static String swap(String curr,int i,int j){
        char[] chr=curr.toCharArray();
        char t=chr[i];
        chr[i]=chr[j];
        chr[j]=t;
        return new String(chr);
    }

    // This returns minimum moves needed to solve the puzzle.
    // If target state cannot be reached, it returns -1.
    public static int slidingPuzzle(int[][] board) {
        String s="";
        for(int[] r:board){
            for(int n: r){
                s=s+n;
            }
        }
        String t="123450";
        Queue<String> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        int[][] neig={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        int level=0;
        q.offer(s);
        set.add(s);
        while(q.isEmpty()==false){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(t)){
                    return level;
                }
                int idx=curr.indexOf('0');
                for(int next:neig[idx]){
                    String swapped=swap(curr,idx,next);
                    if(set.contains(swapped)==false){
                        set.add(swapped);
                        q.offer(swapped);
                    }
                }
            }
            level++;

        }
        return -1;

    }
    // This tests sliding puzzle with a sample board.
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,0,5}};
        System.out.println(slidingPuzzle(mat));
    }
}

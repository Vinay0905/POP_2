package JUNE_10;

import java.util.LinkedList;
import java.util.Queue;

// Approach: Scan the grid and start BFS whenever land '1' is found.
// BFS marks the full island as water so it is counted only once.
public class NumberOfIslands {
    

    // This visits all connected land cells from one starting cell.
    // It changes visited land from '1' to '0'.
    public static void BFS(char[][] grid,int i,int j){

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[] {i,j});
        grid[i][j]='0'; 

        int direct[][]={{0,-1},{0,1},{-1,0},{1,0}};

        while (q.isEmpty()==false){
            int[] curr=q.poll();
            int x =curr[0];
            int y=curr[1];
            for(int [] d:direct){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length  && grid[nx][ny]=='1'){
                    grid[nx][ny]='0';
                    q.offer(new int[] {nx,ny});
                }


            }
        }

    }
    // This counts how many separate islands are present in the grid.
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    c++;
                    BFS(grid,i,j);    
                }
            }
        
        }
        return c;
    }

    // This tests island counting on a sample grid.
    public static void main(String[] args) {



        char[][] grid = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                };
        System.out.println(numIslands(grid));
    }
}

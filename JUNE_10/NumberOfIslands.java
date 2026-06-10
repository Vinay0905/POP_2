package JUNE_10;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    

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

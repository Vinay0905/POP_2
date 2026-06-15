package JUNE_10;

import java.util.LinkedList;
import java.util.Queue;

// Approach: Use BFS from all rotten oranges at the same time.
// Each BFS level means one minute passes.
public class RottenOranges {
    

    // This returns minutes needed to rot all fresh oranges.
    // If some fresh orange cannot rot, it returns -1.
    public static  int orangesRotting(int[][] grid) {
        int min=0;
        int fresh=0;
        int n=grid.length,m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)fresh++;
                else continue;
            }    

        }
        int direct[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(q.isEmpty()==false && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int[] d:direct){
                    int nx=x+d[0];
                    int ny=y+d[1];
                    if(nx>=0 && nx<n && ny<m && ny>=0 && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        fresh--;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            min++;
        }
        
        return fresh == 0 ? min : -1;
    }
    // This tests rotten oranges on a sample grid.
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int ans = orangesRotting(grid);

        System.out.println(ans);
    }
}

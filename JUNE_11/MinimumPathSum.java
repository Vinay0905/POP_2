package JUNE_11;

// Approach: Use dynamic programming on the grid.
// Each cell stores the minimum sum needed to reach that cell.
public class MinimumPathSum {
    

    // This builds a dp table and returns the minimum path sum.
    // From each cell, we can come only from top or left.
    public static int dpfunc(int n,int m,int[][] grid){
        int [][] dp=new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 )continue;
                else if(j==0)dp[i][j]=grid[i][j]+dp[i-1][j];
                else if(i==0)dp[i][j]=grid[i][j]+dp[i][j-1];
                else{
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
        
    }
    // This tests minimum path sum on a sample grid.
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int n=grid.length;
        int m=grid[0].length;
        System.out.println(dpfunc(n, m, grid));
    }
}

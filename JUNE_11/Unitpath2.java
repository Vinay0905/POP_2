package JUNE_11;

// Approach: Count paths in a grid with obstacles.
// Use DP so each cell stores number of ways to reach it.
public class Unitpath2 {
    

    // This is a recursive memo idea for counting paths.
    // It returns 0 outside the grid and 1 at the start cell.
    public static int memo(int i,int j,int [][] dp){
        if(i==-1 || j==-1)return 0;
        if(i==0 && j==0)return 1;
        if(dp[i+1][j+1]!=-1 )return dp[i+1][j+1];
        else{
            int u=memo(i-1,j,dp);
            int b=memo(i,j-1,dp);
            return dp[i+1][j+1]=u+b;
        }

    }


    // This counts paths using tabulation.
    // Obstacle cells get 0 ways.
    public static int dp(int m,int n,int[][] grid){
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)dp[i][j]=0;
                else if(grid[i-1][j-1]==1)dp[i][j]=0;
                else if(i==1 && j==1 )dp[i][j]=1;
                else{ 
                    int up=0;
                    int left=0;
                    if(i>0){
                        up=dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m][n];
    }
    // This tests unique paths with obstacles on a sample grid.
    public static void main(String[] args) {
        int[][] grid={{0,0,0},{0,1,0},{0,0,0}};
        int m=grid.length;
        int n=grid[0].length;
       
       System.out.println(dp(m, n, grid));
    }
}

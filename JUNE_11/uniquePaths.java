package JUNE_11;

// DP Concept using - memoaization

// Approach: Count paths from top-left to bottom-right.
// Each cell gets ways from top plus ways from left.

public class uniquePaths {
    
    // This is a memo recursion for unique paths.
    // It returns 1 at start and 0 outside the grid.
    public static int memo(int i , int j,int[][] dp){
        if(i==-1 || j==-1)return 0;
        if(i==0 && j==0)return 1;
        if(dp[i+1][j+1]!=-1)return dp[i+1][j+1];
        else{
            int u=memo(i-1,j,dp);
            int b=memo(i,j-1,dp);
            return dp[i+1][j+1]=u+b;
        }
    }
    
    // This fills a DP table and prints number of paths.
    public static void main(String[] args) {
        int m=3, n=3;
        int[][] dp=new int[m+1][n+1];
        int i,j;
        for(i=0;i<m+1;i++){
            for(j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                if(i==1 &&j==1)dp[i][j]=1;

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
        for(i=0;i<m+1;i++){
            for(j=0;j<n+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[m][n]);

        // System.out.println(memo(m-1, n-1, dp));
    }
}

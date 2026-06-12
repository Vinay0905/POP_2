package JUNE_12;

public class LongestCommonSubtring {
    


    public int longCommSubstr(String s1, String s2) {
        // code here
        int c=0;
        int i=s1.length()-1,j=s2.length()-1;
        return solve(i,j,c,s1,s2);
        
    }
    public int solve(int i,int j, int c,String s1,String s2){
        if(i<0||j<0)return c;
        
        if(s1.charAt(i)==s2.charAt(j))c=solve(i-1,j-1,c+1,s1,s2);
        int skips1=solve(i-1,j,0,s1,s2);
        int skips2=solve(i,j-1,0,s1,s2);
        return Math.max(c,Math.max(skips1,skips2));
    }

    public static int dynamicPrograming(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "ACDGHR";

        System.out.println(dynamicPrograming(s1, s2));
    }
}

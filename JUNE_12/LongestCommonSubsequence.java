package JUNE_12;

// Approach: Compare two strings from the end.
// Use recursion, memoization, and tabulation to find LCS length.
public class LongestCommonSubsequence {
    
    // This finds LCS length using plain recursion.
    // If characters match, take both; else try skipping one side.
    public static int LCS(String s1,String s2,int i,int j){


        if(i==-1 || j==-1){
            return 0;
        }
        else if(s1.charAt(i)==s2.charAt(j)){
            return 1+LCS(s1, s2, i-1, j-1);
        }
        else{
            return Math.max(LCS(s1, s2, i, j-1),LCS(s1, s2, i-1, j));
        }

    }


    // This is the memoization version of LCS.
    // It stores answers in dp to avoid repeated work.
    public static int memo(String s1,String s2,int i,int j, int[][] dp){
         if(i==-1 || j==-1){
            return 0;
        }
        else if(s1.charAt(i)==s2.charAt(j)){
            return dp[i+1][j+1]=1+memo(s1, s2, i-1, j-1,dp);
        }
        else{
            return dp[i+1][j+1]=Math.max(LCS(s1, s2, i, j-1),LCS(s1, s2, i-1, j));
        }
    }

    // This fills the LCS table from small prefixes to full strings.
    // The bottom-right cell gives the final LCS length.
    public static int dynamicPrograming(String s1, String s2, int[][] dp) {

    for (int i = 0; i <= s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {

            if (i == 0 || j == 0) {
                dp[i][j] = 0;
            }
            else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[s1.length()][s2.length()];
    }

    // This tests all three LCS methods on sample strings.
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace" ;

        System.out.println(LCS(text1, text2, text1.length()-1,text2.length()-1));

        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(memo(text1, text2, text1.length()-1,text2.length()-1,dp));
        System.out.println(dynamicPrograming(text1, text2, dp));
    }
}

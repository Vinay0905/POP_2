package JUNE_12;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;

import java.util.Set;

// Approach: First build the LCS length table using DP.
// Then backtrack through the table to collect all longest subsequences.
public class AllLongestSubsequecnePrint {
    

    // This backtracks through the DP table to build all LCS strings.
    // The string is built backward, so it is reversed before storing.
    public static void solve(String s1,String s2,int i,int j,Set<String> set,int[][] dp,String s){

        if(dp[i][j]==0)set.add(new StringBuilder(s).reverse().toString());
        else if(s1.charAt(i-1)==s2.charAt(j-1)){
            solve(s1, s2, i-1, j-1, set, dp,s+s1.charAt(i-1));
        }
        else{
            if(dp[i][j-1]>=dp[i-1][j]){
                solve(s1, s2, i, j-1, set, dp, s);
            }
            if(dp[i-1][j]>=dp[i][j-1]){
                solve(s1, s2, i-1, j, set, dp, s);
            }
        }

    }
    
    // This fills the DP table and returns all LCS answers in sorted order.
    // A set is used to avoid duplicate subsequences.
    public static ArrayList<String> allLCS(String s1, String s2,int[][] dp) {
        // code here
        
    
        int n=s1.length(),m=s2.length();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        Set<String> set=new HashSet<>();
        String s="";
        solve(s1, s2, n, m, set, dp,s);
        ArrayList<String> res= new ArrayList<>(set);
        Collections.sort(res);

        return res;

        

    }
    // This tests all LCS printing with two sample strings.
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace" ;
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(allLCS(text1, text2, dp));
    }
}

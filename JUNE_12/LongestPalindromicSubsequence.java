package JUNE_12;

// Approach: Use recursion on the start and end of the string.
// If both characters match, take both; otherwise skip one side.
public class LongestPalindromicSubsequence {
    


    // This returns longest palindromic subsequence length in s[start..end].
    // It shrinks the range based on matching characters.
    public static int LPS(String s,int start,int end){
        if(start>end){
            return 0;
        }
        else if(start==end)return 1;
        else if(s.charAt(start)==s.charAt(end))return 2+LPS(s, start+1, end-1);
        else return Math.max(LPS(s, start+1, end), LPS(s, start, end-1));
    }


    // This starts LPS recursion for the full string.
    public static int longestPalindromeSubseq(String s) {
        return LPS(s, 0, s.length()-1);
    }

    

    // This tests LPS with one sample string.
    public static void main(String[] args) {
        String s="bbbab";
        System.out.println(longestPalindromeSubseq(s));


    }
}

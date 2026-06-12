package JUNE_12;

public class LongestPalindromicSubsequence {
    


    public static int LPS(String s,int start,int end){
        if(start>end){
            return 0;
        }
        else if(start==end)return 1;
        else if(s.charAt(start)==s.charAt(end))return 2+LPS(s, start+1, end-1);
        else return Math.max(LPS(s, start+1, end), LPS(s, start, end-1));
    }


    public static int longestPalindromeSubseq(String s) {
        return LPS(s, 0, s.length()-1);
    }

    

    public static void main(String[] args) {
        String s="bbbab";
        System.out.println(longestPalindromeSubseq(s));


    }
}

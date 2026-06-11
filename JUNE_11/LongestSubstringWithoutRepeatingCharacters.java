package JUNE_11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
    

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        Queue<Character> q=new LinkedList<>();
        int maxLen=0;
        for(char ch:s.toCharArray()){
            while(set.contains(ch)==true){
                set.remove(q.poll());
            }
            q.offer(ch);
            set.add(ch);
            maxLen=Math.max(maxLen, q.size());
        }
        return maxLen;


    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

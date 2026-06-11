package JUNE_11;

import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
    

    public static int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    int left = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);

        if (map.containsKey(ch)) {
            left = Math.max(left, map.get(ch) + 1);
        }

        map.put(ch, right);

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

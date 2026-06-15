package JUNE_11;

import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.Queue;

// Approach: Use sliding window with a map of last seen positions.
// Move the left pointer when a repeated character appears.
public class LongestSubstringWithoutRepeatingCharacters {
    

    // This returns the length of the longest substring with no repeated characters.
    // The map stores the last index of every character.
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
    // This tests the function with one sample string.
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

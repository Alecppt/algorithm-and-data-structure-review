package medium;

import java.util.HashSet;
import java.util.Set;

class _03_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] argv) {
        System.out.println(LengthOfLongestSubstring("ababcbb"));
        System.out.println(LengthOfLongestSubstring("bbbb"));
        System.out.println(LengthOfLongestSubstring("pwwkew"));
    }

    // brute force solution, Time O(n^3)
    static int LengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allunique(s, i, j)) {
                    longest = Math.max(longest, j - i);
                }
            }
        }
        return longest;
    }

    static boolean allunique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
}
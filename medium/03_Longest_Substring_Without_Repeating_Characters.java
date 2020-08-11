package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class _03_Longest_Substring_Without_Repeating_Characters {
    /*
     * Given a string, find the length of the longest substring without repeating
     * characters.
     * 
     * Next challenges: Longest Substring with At Most Two Distinct Characters
     * Longest Substring with At Most K Distinct Characters Subarrays with K
     * Different Integers
     */
    public static void main(String[] argv) {
        // System.out.println("answer should be 3: " + sildingWindowJump("ababcbb"));
        // System.out.println("answer should be 1: " + sildingWindowJump("bbbb"));
        // System.out.println("answer should be 3: " + sildingWindowJump("pwwkew"));
        // System.out.println("answer should be 3: " + slidingWindow("ababcbb"));
        // System.out.println("answer should be 1: " + slidingWindow("bbbb"));
        // System.out.println("answer should be 3: " + slidingWindow("pwwkew"));
        System.out.println("answer should be 5: " + sildingWindowJump("tmmzuxt"));
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

    // alot of repetition on checking allunique
    // if [0 .. 2] is allunique then no need to check [0..2] again in the next
    // iteration [0..3]
    // maybe update the left index once the duplicate char is hit
    // a b c a c b b
    // i j
    // remove a from set and then advance i

    static int slidingWindow(String s) {
        int ans = 0, i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    // still some repetition when detecting a duplicate where i only advance 1 step
    // in "pwwkew", when 2nd w is detected, i need to 2 steps where it causes
    // reapetitive duplicate checks
    // maybe use hashmap to save index, so i can advance whatever steps needed
    static int sildingWindowJump(String s) {
        int ans = 0, i = 0, j = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (i < n && j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
                // i++;//this will cause a bug whereit forces i to advance after previous
                // comparison
            }
            map.put(s.charAt(j), ++j); // save one step advanced to fix the bug
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
    // Time O(n), Space O(n)
}
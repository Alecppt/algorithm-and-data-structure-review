/*
Given a string S, find the length of the longest substring T that contains at most two distinct characters.

For example, Given S = “eceba”, T is "ece" which its length is 3.
*/

package medium;

import java.util.HashMap;
import java.util.Map;

class solution {
    public static void main(String[] argv) {
        System.out.println(findLongestSubstring2DistinctChar("eceba"));
    }

    static int findLongestSubstring2DistinctChar(String s) {

        int ans = 0, i = 0, j = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (i < n && j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);

            }
            map.put(s.charAt(j), ++j); // save one step advanced to fix the bug
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
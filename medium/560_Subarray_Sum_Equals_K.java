package medium;

import java.util.HashMap;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/

class _560 {
    // brute force: iterate through all permutation and check if the sum is k,
    // if true, add such subarray to collection
    // Time O(n^2), which has room to be improved.
    static int findNumOfArrWithgivenSum1(int[] nums, int sum) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int ans = 0;
            for (int j = i; j < nums.length; j++) {
                ans += nums[j];
                if (ans == sum) {
                    count++;
                    break;
                }
                ;
            }
        }

        return count;
    }

    // key to solution is the sum[i, j]. And if we know sum[0, i] and sum[0, j]
    // where j>i,
    // ex. Sum[0....J] = K which is Sum[n...J] + Sum[0....n-1]
    // therefore, we check Sum[0...J] - K to see if Sum[0....n-1] has been seen
    // using hashmap to record every Sum[0...n] -> Space O(n)
    // One pass through array -> Time O(n)
    static int findNumOfArrWithgivenSum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1); // address for the first subarray appearance sum[0...m] - k =0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumOfArrWithgivenSum2(new int[] { 1, 1, 1 }, 2));
        System.out.println(findNumOfArrWithgivenSum2(new int[] { 1, 2, 3, 3, 0, 6, 4, 2 }, 6));

    }
}
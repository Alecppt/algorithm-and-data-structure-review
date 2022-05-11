package easy;

import java.util.HashMap;

class _1_two_sum {
    // given an array of int and an int target, return indices of the 2 numbers so
    // that they adds up to target.
    // can assume only one solution
    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        int result[] = solution.twoSum(nums, target);
        System.out.println("Expected: [0, 1]");
        System.out.printf("Output: [%d, %d]\n", result[0], result[1]);

        int nums_1[] = { 3, 2, 4 };
        int target_1 = 6;
        int result_1[] = solution.twoSum(nums_1, target_1);
        System.out.println("Expected: [1, 2]");
        System.out.printf("Output: [%d, %d]\n", result_1[0], result_1[1]);
    }

}

class solution {

    /*
     * initial thought:
     * brute force solution:
     * iterate each number and upon each number,
     * iterate the rest integer to find a number that sum up to the target
     * analysis: nested iteration O(n^2), space O(1)
     * 
     * hashmap:
     * initialize a hashmap(num, index),
     * iterate each num, in which iteration, find the matching int,
     * if found, create the result[] for both index, if not store the current num
     * and index into hashmap
     * 
     * if no result, return new int[]{0, 0}
     * analysis: O[n] for one pass, space O(1)
     * 
     * two pointer:
     * init 2 pointer left = 0 and right = nums.length
     * while(right>left)
     * 1. check sum of num[left] and num[right] if match, ans found
     * 2. if target not found then check num[right]> target - num[left] if yes,
     * right--
     * 3. else left++
     * 
     * require to sort the array first, and question ask to return indexs
     * so need to create another copy for sorted array then find the index using the
     * number found in sorted array
     * analysis: O(n), space O(n);
     *
     * 
     * 
     * 
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int ans[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (sum.get(match) != null) {
                ans[0] = i;
                ans[1] = sum.get(match);
                return ans;
            }
            sum.put(nums[i], i);
        }

        return ans;
    }
}
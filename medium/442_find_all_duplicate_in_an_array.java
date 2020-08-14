package medium;

import java.util.ArrayList;
import java.util.List;

class _442 {
    /*
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
     * appear twice and others appear once.
     * 
     * Find all the elements that appear twice in this array.
     * 
     * Could you do it without extra space and in O(n) runtime?
     * 
     * Example: Input: [4,3,2,7,8,2,3,1]
     * 
     * Output: [2,3]
     */
    public static void main(String[] args) {
        System.out.print("[");
        for (int i : findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
    // at first glace, the intuitive way to solve is to use map
    // but the question ask for Space O(1) solution.
    // need to pay attention to description where it says
    // an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
    // so modifying the array using the elements as index to find visited elements

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return ans;
    }
}
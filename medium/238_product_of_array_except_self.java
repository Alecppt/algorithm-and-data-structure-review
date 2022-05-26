package medium;

class _238_ {
    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 4 };
        System.out.println("expect: [24, 12,8, 6]");

        int res[] = productExceptSelf(nums);
        System.out.print("output: [");
        for (int i : res) {
            System.out.print(i + ",");
        }
        System.out.print("]\n");

    }

    /*
     * brute force:
     * init int res[] size of nums.length
     * init int tmp for storing prodcut of nums in a loop
     * for every int in nums do:
     * - another loop to every int in nums except nums[i] to get tmp *= nums[j]
     * - res[i] = tmp; tmp = 1;
     * end
     * return res
     * 
     * O(n^2) bad
     * 
     * O(n), space O(n)
     * make 2 arrays, left and right to store the product of numbers for each index
     * then make one pass to calc the answer
     */
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        // first index got no product from the left, set it to 1 so the next iteration
        // is the prdoct of nums[i-1] * 1
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 1 - 1; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;

    }
}

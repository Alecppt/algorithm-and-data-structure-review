package easy;

class _53_maximumSubarray {
    public static void main(String[] args) {
        int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maximumSubarray(a));
        // should be 6 [4, -1, 2, 1]
    }

    static int maximumSubarray(int nums[]) {
        int globalMax = nums[0], currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
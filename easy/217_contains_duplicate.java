package easy;

import java.util.HashSet;

class _217_contains_duplicate {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        boolean ans = containDuplicate(nums);
        System.out.println("expected: true");
        System.out.printf("output: %b\n", ans);
    }

    static boolean containDuplicate(int[] nums) {

        // brute force: nested loop to find duplicate, worst case O(n^2)
        // hashset: one pass, O(n), space O(n)
        // possible solution using bit manipulation xor because n^n = 0;
        HashSet<Integer> list = new HashSet<Integer>();
        for (int n : nums) {
            if (list.contains(n)) {
                return true;
            }
            list.add(n);
        }
        return false;
    }
}

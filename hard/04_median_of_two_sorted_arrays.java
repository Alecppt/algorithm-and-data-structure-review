package hard;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.
Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/
class solution {
    /*
     * brute force solution would be merge 2 arrays and then find the median. Time
     * Complexity would be O(m + n), and space O(m+n) as well, which would fail in
     * leetcode testcases
     * 
     * the better approach maybe to just iterate through. With known length of 2
     * arr(len = A.length + B.length, we should be able to find the median within
     * len/2 + 1. The time complexity would still be O(m+n) where len = m+n even
     * though we iterate len/2 + 1. Space complexity improves to O(1). However, it
     * still fails the leetcode testcases.
     * 
     */

    // find the median by iterating to the total_length/2, Time O(m+n), Space O(1)
    static double findMedianSol2(int[] A, int[] B) {
        int a_len = A.length, b_len = B.length, total_len = a_len + b_len, m = 0, n = 0, p = 0, q = 0;
        if (a_len == 0)// return B's median
        {
            if ((b_len & 1) == 0) { // even number arr
                return (B[b_len / 2 - 1] + B[b_len / 2]) / 2.0;
            } else {
                return (double) (B[b_len / 2]);
            }
        }
        if (b_len == 0) {
            if ((a_len & 1) == 0) {
                return (A[b_len / 2 - 1] + A[b_len / 2]) / 2.0;
            } else {
                return (double) (A[b_len / 2]);
            }
        }
        for (int i = 0; i < total_len / 2 + 1; i++) {
            p = q;
            if (m < a_len && (n >= b_len || A[m] < B[n])) {
                q = A[m];
                m++;
            } else {
                q = B[n];
                n++;
            }
        }
        if ((total_len & 1) == 0) {
            return (p + q) / 2.0;
        } else
            return q;
    }

    // brute force Time: O(m+n) Space: O(m+n)
    static double findMedianSol1(int[] A, int[] B) {
        int a_len = A.length, b_len = B.length;
        int[] C = new int[a_len + b_len];

        if (a_len == 0)// return B's median
        {
            if ((b_len & 1) == 0) { // even number arr
                return (B[b_len / 2 - 1] + B[b_len / 2]) / 2.0;
            } else {
                return (double) (B[b_len / 2]);
            }
        }
        if (b_len == 0) {
            if ((a_len & 1) == 0) {
                return (A[b_len / 2 - 1] + A[b_len / 2]) / 2.0;
            } else {
                return (double) (A[b_len / 2]);
            }
        }

        int m = 0, n = 0, i = 0;
        for (i = 0; i < a_len + b_len; i++) {
            if (m >= a_len) {
                C[i] = B[n];
                n++;
            } else if (n >= b_len) {
                C[i] = A[m];
                m++;
            } else if (A[m] < B[n] && m < a_len && n < b_len) {
                C[i] = A[m];
                m++;
            } else {
                C[i] = B[n];
                n++;
            }
        }

        if ((i & 1) == 0) {
            return (C[i / 2 - 1] + C[i / 2]) / 2.0;
        } else {
            return (double) C[i / 2];
        }

    }

    public static void main(String[] argv) {
        System.out.println(findMedianSol2(new int[] { 1, 2 }, new int[] { 3, 4 }));
        System.out.println(findMedianSol2(new int[] { 1, 2 }, new int[] { 3 }));

    }
}
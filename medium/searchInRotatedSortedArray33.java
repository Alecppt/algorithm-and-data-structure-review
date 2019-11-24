package medium;

class searchInRotatedSortedArray33 
{
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
    
    */
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int k = 0;
        System.out.println(search(a, k));
        //4
        int[] b = {4,5,6,7,0,1,2};
        k = 3; 
        System.out.println(search(b, k));
        // -1
    }

    static int search(int[] nums, int target)
    {
        //find the offset, the starting point of array after rotation
        int start = 0, end = nums.length - 1;
        while(start < end)
        {
            int mid  = ((start + end )/ 2) + 1;
            if(nums[mid] < nums[start])
            {
                end = mid - 1;
            }
            else 
            {
                start = mid;
            }
        }

        int offset = start  + 1;
        start  = 0;
        end = nums.length - 1;

        //binary search 
        while (start <= end)
        {
            int mid = (start + end) / 2;
            int mid_index  = (mid + offset ) % nums.length;
            int value = nums[mid_index];
            if(target == value)
            {
                return mid_index;
            }
            if(target < value)
            {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
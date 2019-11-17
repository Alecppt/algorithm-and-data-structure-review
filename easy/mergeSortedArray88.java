package easy;

class mergeSortedArray88 
{
    /*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
    */
    public static void main(String[] args) {
        int a[] =  {8, 9 ,0 , 0 ,0};
        int b[] = {1, 2, 3};
        merge(a, 2, b, 3);
        for(int k : a )
        {
            System.out.print(k + " ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n -1;
        int nums1_i = m - 1, nums2_i = n - 1;
        while(nums1_i >= 0 && nums2_i >= 0)
        {
            if(nums1[nums1_i] < nums2[nums2_i])
            {
                nums1[i] = nums2[nums2_i];
                nums2_i--;
                i--;
            }
            else 
            {
                nums1[i] = nums1[nums1_i];
                nums1_i--;
                i--;
            }
        }
        while(nums2_i >= 0)
        {
            nums1[i] = nums2[nums2_i];
            nums2_i--; i--;
        }
        while(nums1_i >= 0)
        {
            nums1[i] = nums1[nums1_i];
            nums1_i--; i--;
        }        
    }
}
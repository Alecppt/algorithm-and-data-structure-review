package easy;

class removeDuplicatesFromSortedArray26
{
    public static void main(String[] args) {
        int[] input = {1, 1 ,2, 3,4,4,4,5};
        int n = removeDuplicates(input);

        System.out.print("[");
        for(int i = 0; i<n; i++)
        {
            System.out.print(input[i]);
            if(i != n -1)
            {
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }
    
    static int removeDuplicates(int[] nums)
    {
        int _i = 0; 
        for(int i = 1; i<nums.length; i++)
        {
            if(nums[i] != nums[_i])
            {
                _i++; //store the next index to be replaced
                nums[_i] = nums[i];
                
            }
        }
        return _i+1; //cuz starting from 0, need to +1 to give the length
    }
}
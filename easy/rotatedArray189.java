package easy;


public class rotatedArray189
{
    /*
    (Easy)
        Description 
        Given a string(Given in the way of char array) and an offset,
         rotate the string by offset in place. (rotate from left to right).
        https://leetcode.com/problems/rotate-array/ 
    */

    /*
    T O(n), S O(1)
    */
    public static void main(String argv[])
    {
        char[] input = "abcdefg".toCharArray();
        int k = 1;
        System.out.println("input: abcdefg, k = 1");
        roateArrayInplace(input, k);
        System.out.println("output: " + String.valueOf(input));
        //Output: str = "gabcdef"	
    }
    static void roateArrayInplace(char[] c, int k)
    {
        if(c == null || c.length == 0) return;
        int start = 0, end = c.length-1;
        int offset = k % end;
        reverse(c, start, end);
        reverse(c, start, offset - 1);
        reverse(c, offset, end);
    }
    static void reverse(char[] c, int start, int end)
    {
        for(int i = start, j = end; i < j; i++, j--)
        {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }
}
package medium;

class maximumSwap670
{   
    /*
        Given a non-negative integer, you could swap two digits at most once 
        to get the maximum valued number. Return the maximum valued number you could get.
        eg. 
        Input: 2736
        Output: 7236
        Explanation: Swap the number 2 and the number 7.
        https://leetcode.com/problems/maximum-swap/
        
    */
    public static void main(String[] argv)
    {
        System.out.println("input: " + 98368);
        //98863
        System.out.println(maximumSwap(98368));
    }

    static int maximumSwap(int num)
    {
        int max_num = num; 
        char[] char_num = String.valueOf(num).toCharArray();
        for(int i = 0 ; i<char_num.length - 1; i++)
        {
            for(int j = 1; j < char_num.length; j++)
            {
                if(char_num[i] < char_num[j])
                {
                    swap(char_num, i, j);
                    max_num = Math.max(max_num, Integer.valueOf(new String(char_num)));
                    swap(char_num, j, i);
                }
              
            }

            
        }
        return max_num;
    }
    static void swap(char[] c, int i, int j)
    {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
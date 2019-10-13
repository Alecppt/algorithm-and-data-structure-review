package sortingalgs;

public class BubbleSort 
{
    public static void sort (int[] arr)
    {
        for (int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j < arr.length-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr[j], arr[j+1]);
                }
            }
        }
    }
    
    private static void swap(int a, int b)
    {
        int temp = a;
        a = b; 
        b = temp;
    }
}
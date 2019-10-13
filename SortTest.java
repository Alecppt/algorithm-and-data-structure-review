import sortingalgs.*;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        int size = 1000;
        long total_time = 0 , current, end;
        int[] arr = new int[size];
        //qick sort
        for(int i = 0; i < 100; i++)
        {
            arr = getUnsortedArray(size);
            current = System.currentTimeMillis();
            QuickSort.sort(arr);
            end = System.currentTimeMillis();
            if(isArraySorted(arr))
            {
                total_time += (end - current);
            } 
            else {
                System.out.println("quick sort failed ");
                System.exit(1);
            }

        }
            System.out.println("quick sort takes " + total_time/100.0 + " milliseconds");

        //merge sort 
        for (int i = 0; i < 100; i++)
        {
            arr = getUnsortedArray(size);
            current = System.currentTimeMillis();
            arr = MergeSort.sort(arr);
            end = System.currentTimeMillis();
            if(isArraySorted(arr))
            {
                total_time += (end - current);
            } 
            else {
                System.out.println("merge sort failed ");
                System.exit(1);
            }

        }
            System.out.println("merge sort takes " + total_time/100.0 + " milliseconds");
        
        //bubble sort 
        for(int i = 0; i< 100; i++)
        {
            arr = getUnsortedArray(size);
            current = System.currentTimeMillis();
            BubbleSort.sort(arr);
            end = System.currentTimeMillis();
            if (isArraySorted(arr))
            {
                total_time += end - current;
            }   else {
                System.out.println("bubble sort failed ");
                System.exit(1);
            }


        }
            System.out.println("bubble sort takes " + total_time/100.0 + " milliseconds");
    }

    public static boolean isArraySorted(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i-1] > arr[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public static int[] getUnsortedArray(int size)
    {   
            int[] result = new int[size];
            Random r =  new Random();
            for (int i = 0; i < size; i++)
            {
                result[i] = r.nextInt(10000);
            }
            return result;
    }
}

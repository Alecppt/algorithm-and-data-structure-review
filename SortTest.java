import sortingalgs.*;

public class SortTest {

    public static void main(String[] args) {
        int[] even_num_array = new int[] { 93, 29, 3, 22, 25, 499, 29, 1, 23, 5};
        int[] sorted_even_num_array = new int[]{1,3,5,22,23,25,29,29,93,499};
        int[] odd_num_array = new int[] {1, -1, 3, 1111, 495, 443, 1324};
        int[] sorted_odd_num_array = new int[]{-1, 1, 3, 443, 495, 1111, 1324};
        int[] even_num_array_m = new int[] { 93, 29, 3, 22, 25, 499, 29, 1, 23, 5};
        int[] odd_num_array_m = new int[] {1, -1, 3, 1111, 495, 443, 1324};
        
        QuickSort.sort(even_num_array);
        QuickSort.sort(odd_num_array);

        
        MergeSort.sort(even_num_array_m);
        MergeSort.sort(odd_num_array_m);
        BubbleSort.sort(odd_num_array);
        
    }

    public static boolean compareTwoArrays(int[] a, int[] b)
    {
        if (a.length != b.length) return false;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }

}

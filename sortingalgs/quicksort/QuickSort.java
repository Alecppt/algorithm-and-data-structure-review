package sortingalgs.quicksort;

public class QuickSort {

    public static void sort(int[] array){
        quick_sort(array, 0, array.length - 1);
    }
    
    private static void quick_sort(int[] array, int left, int right)
    {
        if (left >= right) return ;
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quick_sort(array, left, index - 1);
        quick_sort(array, index , right);

    }

    private static int partition(int[] array, int left, int right, int pivot)
    {
        while(left <= right){
            while(array[left] < pivot)
            {
                left++;
            }
            while(array[right] > pivot)
            {
                right--;
            }
            if(left <= right)
            {
                swap(array, left, right);
                left++;
                right--;
            }
         
        }
        return left;
    }
    private static void swap(int[] array, int A, int B )
    {
        int temp = array[A];
        array[A] = array[B];
        array[B] = temp;
    }
}
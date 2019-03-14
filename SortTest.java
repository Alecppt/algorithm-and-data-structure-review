import com.alecppt.quicksort.QuickSort;
import com.alecppt.mergesort.MergeSort;

public class SortTest {

    public static void main(String[] args) {
        int[] num = new int[] { 93, 29, 3, 22, 25, 499, 29, 1, 23, 5};
        // QuickSort.quick_sort(num);
        num = MergeSort.mergesort(num);
        for ( int i : num)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

}

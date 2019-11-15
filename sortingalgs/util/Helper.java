package sortingalgs.util;

public final class Helper {
    public static void printArr(int[] a)
    {
        for (int i =0 ; i< a.length; i++)
        {
            System.out.print(a[i]+ " ");
        }
        System.out.print('\n');
    }

    public static void swap(int[] array, int A, int B )
    {
        int temp = array[A];
        array[A] = array[B];
        array[B] = temp;
    }
}
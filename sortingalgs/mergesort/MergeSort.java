package sortingalgs.mergesort;


public  class MergeSort 
{
    public static int[] sort(int[] arr)
    {
       arr = mergesort(arr);
        return arr;
    }
    private static int[] mergesort(int[] array)
    {
        if(array.length < 2) return array;
        int mid =  array.length /2;
        int[] a = new int[mid];
        int[] b = new int[array.length - mid];
        for (int i = 0; i<array.length; i++)
        {
            if(i < mid)
            {
                a[i] = array[i];
            }
            else
            {
                b[i-mid] = array[i];
            }
            
        }   
       return  merge(mergesort(a), mergesort(b));
    }

    private static int[] merge(int[] a, int[]b)
    {
        int[] temp = new int[a.length + b.length];
        int a_index = 0, b_index = 0;
        for(int i = 0; i < temp.length; i++)
        {
            if(a_index >= a.length) 
            {
                temp[i] = b[b_index];
                b_index++;
            }
            else if (b_index >= b.length)
            {
                temp[i] = a[a_index];
                a_index++;
            }
            else if (a[a_index]<= b[b_index] && (a_index < a.length && b_index < b.length))
            {
                temp[i] = a[a_index];
                a_index++;
            }
            else
            {
                temp[i] = b[b_index];
                b_index++;
            }
        }
        return temp;
    }
}
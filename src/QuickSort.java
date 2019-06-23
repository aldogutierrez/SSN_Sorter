import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort
{
    /**
     * Ctor for objects of type QuickSort
     */
    public QuickSort() {}

    /**
     * Method that swaps 2 numbers
     * inside an array
     * -
     * @param array - Given array
     * @param a - First element
     * @param b - Second element
     */
    public static void swap(List array, int a, int b)
    {
        Integer temp = (Integer) array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);
    }

    /**
     * According to the QuickSort algorithm
     * Parition() will split the array
     * according to the pivot value
     * leftSide < pivot < rightSide
     * -
     * @param array - Given array
     * @param p - 1st element of the array
     * @param r - Last element of the array
     * @return - pivot position
     */
    public static int partition(List array, int p, int r)
    {
        Integer pivot = (Integer) array.get(r);
        int i = p - 1;

        for (int j = p; j < r ; j++)
        {
            if ((Integer)array.get(j) <= pivot)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return (i + 1);
    }

    /**
     * Recursive sorting part of QuickSort
     * Recursively sorts the left, then
     * Recursively sorts the right
     * -
     * @param array - Given array
     * @param p - 1st element of the array
     * @param r - Last element of the array
     */
    public static void quicksort(List array, int p, int r)
    {
        if (p < r)
        {
            int q = partition(array, p, r);    // Partitions the array in preparation to sorting
            quicksort(array, p, q - 1);     // Recursive call to sort the left
            quicksort(array, q + 1, r);     // Recursive call to sort the right
        }
    }

    /**
     * Method call to sort the array only when passing the array
     * Makes a call to the full version of the array
     * @param array - Given array
     */
    public static void quickSort(List array)
    {
        quicksort(array, 0, array.size() - 1);
    }
}
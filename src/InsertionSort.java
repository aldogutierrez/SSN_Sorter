import java.util.List;

public class InsertionSort
{
    /**
     * Ctor for objects of type
     * InsertionSort
     */
    public InsertionSort(){}

    /**
     * Insertion sort algorithm
     * Efficient on short or nearly-sorted algorithms
     * Average time complexity: O(n^2)
     * -
     * Version for standard arrays
     * -
     * @param array - Given array
     */
    public void insertionSort(int array[])
    {
        for (int current = 1; current < array.length; current++)
        {
            int key = array[current];
            int previous = current - 1;

            while (previous >= 0 && array[previous] > key)
            {
                array[previous + 1] = array[previous];
                previous--;
            }
            array[previous + 1] = key;
        }
    }

    /**
     * Insertion sort algorithm
     * Efficient on short or nearly-sorted algorithms
     * Average time complexity: O(n^2)
     * -
     * Version for collections and lists
     * -
     * @param array - Given array
     */
    public void insertionSort(List array)
    {
        for (int current = 1; current < array.size(); current++)
        {
            Integer key = (Integer) array.get(current);
            int previous = current - 1;

            while (previous >= 0 && (Integer) array.get(previous) > key)
            {
                array.set(previous + 1, array.get(previous));
                previous--;
            }
            array.set(previous + 1, key);
        }
    }
}
import java.util.*;

public class BucketSort
{
    /**
     * Ctor for objects
     * of type BucketSort
     */
    public BucketSort(){}

    /**
     * Linear time sorting algorithm
     * Splits elements into "buckets"
     * and sorts them internally
     * using InsertionSort
     * -
     * The buckets themselves are
     * small singly LinkedLists
     * -
     * @param array - Given array
     */
    public static ArrayList<Integer> bucketSort(List array)
    {
        List[] buckets = new List[11];
        InsertionSort list = new InsertionSort();

        ArrayList<Integer> outputList = new ArrayList<>();

        //Starts by initializing each slot w/ an empty LinkedList
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new LinkedList<Integer>();
        }

        for (Integer number : (ArrayList<Integer>) array)
        {
            //Formula: (N * array[i]) / 10000000
            double modifiedValue = (number * Math.pow(10, -8));

            //Inserts into the correspondent LinkedList
            buckets[(int) Math.floor(modifiedValue)].add(number);
        }

        //Sorts every LinkedList with InsertionSort
        for (List bucket : buckets)
        {
            list.insertionSort(bucket);
        }

        //Concatenate every linked list in order
        for (List bucket : buckets)
        {
            outputList.addAll(bucket);
        }

        return outputList;
    }
}
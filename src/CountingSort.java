import java.util.Arrays;
import java.util.List;

public class CountingSort
{
    /**
     * Ctor for objects of type CountingSort
     */
    public CountingSort() {}

    /**
     * Linear sort which depends on counting the repeating values
     * Very efficient if the range inside the array
     * is not too huge
     * -
     * This version of Counting Sort is a modified version
     * for RadixSort, please note the iterations for the digits
     * -
     * @param input - Given array
     * @param output - Sorted array
     * @param k - Maximum value inside the given array
     */
    public static void countingSort(List input, List output, int k)
    {
        int counter[] = new int[10];
        Arrays.fill(counter, 0);

        for (int j = 0; j < input.size(); j++)
        {
            int currentDigit = ((Integer) input.get(j) / k) % 10;      //Checks the digits depending on the placement
            counter[currentDigit] = counter[currentDigit] + 1;
        }

        for (int i = 1; i < 10; i++)
        {
            counter[i] += counter[i - 1];
        }

        for (int j = input.size() - 1; j >= 0; j--)
        {
            int currentDigit = ((Integer) input.get(j) / k) % 10;              //Checks the digits depending on the placement
            output.set(counter[currentDigit] - 1, input.get(j));
            counter[currentDigit] = counter[currentDigit] - 1;
        }
    }
}
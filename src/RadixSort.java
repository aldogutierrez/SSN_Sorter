import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort
{
    /**
     * Ctor for objects
     * of type RadixSort
     */
    public RadixSort(){}

    /**
     * Linear sort based upon
     * CountingSort
     * It sorts by digit starting from
     * the Least Significant Digit
     * as it makes its way towards the
     * Most Significant Digit
     * -
     * @param array - Given array
     */
    public static ArrayList<Integer> radixSort(List array)
    {
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(array.size(), 0));
        int iterations = numberOfDigits(findMax(array));

        /**
         * We advance the exponent in which we will fetch the digit
         * 1: 1 <ones place>
         * 2: 10 <tens place>
         * 3: 100 <hundreds place>
         * And so on...
         */
        for (int i = 1; i < Math.pow(10, iterations); i *= 10)
        {
            CountingSort.countingSort(array, output, i);
            array = (List) output.clone();     //***NOTE*** it is very important that we replace the array with the
        }                                      //sorted output, otherwise it will not work - cloning the array will not
        return output;                         //affect the values from the original
    }

    /**
     * Returns the number of digits in a number
     * @param number
     * @return
     */
    public static int numberOfDigits(int number)
    {
        return (number < 10) ? 1 : (int) Math.floor(Math.log10(number)) + 1;
    }

    /**
     *
     * @param array
     * @return
     */
    public static int findMax(List array)
    {
        int max = 0;
        for (Object number: array)
        {
            if ((Integer) number > max)
            {
                max = (Integer) number;
            }
        }
        return max;
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static final int NUMBER_OF_SSN = 300;

    /**
     * Converts a string to a integer number in which
     * we can sort and manipulate into a desired format
     * @param s - the read string to be converted
     * @return
     */
    public static int stringToSSN(String s)
    {
        String areaNumber = s.substring(0, 3);
        String groupNumber = s.substring(4, 6);
        String serialNumber = s.substring(7, 11);
        String totalSSN = areaNumber + groupNumber + serialNumber;
        int SSN = Integer.parseInt(totalSSN);

        return SSN;
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println("***START***");
            RandomSSNFileGenerator random = new RandomSSNFileGenerator(NUMBER_OF_SSN);
            BufferedReader br = new BufferedReader(new FileReader("Random_SSN.txt"));
            System.out.println("- Random file has been successfully created");
            System.out.println();
            SSNFileReader reader = new SSNFileReader(br);

            ArrayList<String> readLines = reader.readTextFile(random);
            ArrayList<Integer> toBeSorted = new ArrayList<>();

            for (String s : readLines)
            {
                toBeSorted.add(stringToSSN(s));
            }

            /**
             * Does RadixSort on the list
             * which contains all the SSN Numbers
             * -
             * Since RadixSort is an out-of-place
             * algorithm I create a new ArrayList
             * containing the sorted SSN using RadixSort
             */
            ArrayList<Integer> radixSorted = RadixSort.radixSort(toBeSorted);
            SortedFileGenerator radix = new SortedFileGenerator();
            radix.listToFile(radixSorted, "Radix_SSN.txt");
            System.out.println("- RadixSort file has been successfully sorted and created");

            /**
             * Does BucketSort on the list
             * which contains all the SSN Numbers
             * -
             * Since BucketSort is an out-of-place
             * algorithm I create a new ArrayList
             * containing the sorted SSN using BucketSort
             */
            ArrayList<Integer> bucketSorted = BucketSort.bucketSort(toBeSorted);
            SortedFileGenerator bucket = new SortedFileGenerator();
            bucket.listToFile(bucketSorted, "Bucket_SSN.txt");
            System.out.println("- BucketSort file has been successfully sorted and created");

            /**
             * Does QuickSort on the list
             * which contains all the SSN Numbers
             * -
             * Since QuickSort is a in-place algorithm
             * I decided to call this at the very end
             * because this will change the original
             * values of the unsorted list with the SSN
             */
            QuickSort.quickSort(toBeSorted);
            SortedFileGenerator quick = new SortedFileGenerator();
            quick.listToFile(toBeSorted, "Quick_SSN.txt");
            System.out.println("- QuickSort file has been successfully sorted and created");

            System.out.println();
            System.out.println("***END***");
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }
}
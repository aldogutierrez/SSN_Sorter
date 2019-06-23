import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SortedFileGenerator
{
    private static int northEastCoast;
    private static int southCoast;
    private static int middleStates;
    private static int northWestCoast;
    private static int westCoast;

    public SortedFileGenerator()
    {
        northEastCoast = 0;
        southCoast = 0;
        middleStates = 0;
        northWestCoast = 0;
        westCoast = 0;
    }

    /**
     * Converts a List collection
     * into a .txt file
     * -
     * The created .txt file has
     * sorted SSN-like strings
     * that were created randomly
     * and sorted with different
     * efficient algorithms
     * @param array - Given array
     * @param fileName - Desired file name
     */
    public static void listToFile(List array, String fileName)
    {
        //This ArrayList will store the sorted SSN as strings
        ArrayList<String> SSNtoString = new ArrayList<>();
        try
        {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");

            //Converts all sorted integers to strings to format them accordingly
            for (Integer number : (ArrayList<Integer>) array)
            {
                SSNtoString.add(number.toString());
            }

            //Formats every string into SSN format
            for (String SSN : SSNtoString)
            {
                if (SSN.length() == 9) //Case 1 of SSN format
                {
                    int areaNumber = Integer.parseInt(SSN.substring(0, 3));
                    int groupNumber = Integer.parseInt(SSN.substring(3, 5));
                    int serialNumber = Integer.parseInt(SSN.substring(4, 8));

                    addToArea(areaNumber);

                    SSN = String.format("%03d", areaNumber) + "-" +
                          String.format("%02d", groupNumber) + "-" +
                          String.format("%04d", serialNumber);

                    writer.println(SSN);
                }
                else if (SSN.length() == 8) //Case 2 of SSN format
                {
                    int areaNumber = Integer.parseInt(SSN.substring(0, 2));
                    int groupNumber = Integer.parseInt(SSN.substring(2, 4));
                    int serialNumber = Integer.parseInt(SSN.substring(3, 7));

                    addToArea(areaNumber);

                    SSN = String.format("%03d", areaNumber) + "-" +
                          String.format("%02d", groupNumber) + "-" +
                          String.format("%04d", serialNumber);

                    writer.println(SSN);
                }
                else    //Case 3 of format
                {
                    int areaNumber = Integer.parseInt(SSN.substring(0, 1));
                    int groupNumber = Integer.parseInt(SSN.substring(1, 3));
                    int serialNumber = Integer.parseInt(SSN.substring(3, 7));

                    addToArea(areaNumber);

                    SSN = String.format("%03d", areaNumber) + "-" +
                          String.format("%02d", groupNumber) + "-" +
                          String.format("%04d", serialNumber);

                    writer.println(SSN);
                }
            }

            writer.println();
            writer.println("Northeast Coast States: " + northEastCoast + " people");
            writer.println("SouthCoast States: " + southCoast + " people");
            writer.println("Middle States: " + middleStates + " people");
            writer.println("Northwest Coast States: " + northWestCoast + " people");
            writer.println("West Coast States: " + westCoast + " people");

            writer.close();

        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (UnsupportedEncodingException e)
        {
            e.getMessage();
        }
    }

    /**
     * According to the SSN schema there are 5
     * different areas in which a person can reside:
     * - North East Coast
     * - South Coast
     * - Middle States
     * - North West Coast
     * - West Coast
     * -------------------------
     * This method adds to the population of
     * the SSN in the parameter for further
     * analysis
     * @param areaCode
     */
    public static void addToArea(int areaCode)
    {
        if (areaCode < 200)
        {
            northEastCoast++;
        }
        else if (areaCode >= 200 && areaCode < 400)
        {
            southCoast++;
        }
        else if (areaCode >= 400 && areaCode < 600)
        {
            middleStates++;
        }
        else if (areaCode >= 600 && areaCode < 800)
        {
            northWestCoast++;
        }
        else
        {
            westCoast++;
        }
    }
}

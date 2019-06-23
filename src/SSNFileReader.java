import java.io.*;
import java.util.ArrayList;

public class SSNFileReader
{
    private BufferedReader theBufferedReader;

    /**
     * Constructor for objects of type SSNFileReader
     * Just passes in a BufferedReader
     * @param bufferedReader
     */
    public SSNFileReader(BufferedReader bufferedReader)
    {
        theBufferedReader = bufferedReader;
    }

    /**
     * Method that reads lines from a .txt file
     * and places them in a ArrayList for parsing
     * and sorting
     * -
     * @param file
     * @return
     * @throws IOException
     */
    public ArrayList<String> readTextFile(RandomSSNFileGenerator file) throws IOException
    {
        ArrayList<String> SSNRecords = new ArrayList<>();
        String SSNRecord = "";
        while (SSNRecord != null)
        {
            SSNRecord = theBufferedReader.readLine();
            if (SSNRecord == null)
            {
                //Indicates End-Of-File
                break;
            }
            else
            {
                //Adds the SSN record to the ArrayList
                SSNRecords.add(SSNRecord);
            }
        }
        return SSNRecords;
    }
}
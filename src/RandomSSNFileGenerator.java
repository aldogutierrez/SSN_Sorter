import java.io.*;

public class RandomSSNFileGenerator
{
    private PrintWriter writer;

    /**
     * Ctor for objects of type RandomSSNFileGenerator
     * -
     * Creates a file with 300 Random Social Security Numbers
     * -
     * The name of such created file is Random_SSN.txt
     * -
     * @param numberOfLines - Desired number of SSN records
     * @throws IOException
     */
    public RandomSSNFileGenerator(int numberOfLines) throws IOException
    {
        try
        {
            writer = new PrintWriter("Random_SSN.txt", "UTF-8");    //File name with UTF-8 Encoding
            for (int i = 0; i < numberOfLines; i++)
            {
                writer.println(new SSN().toString()); //Writes a new Line per SSN
            }
            writer.close(); //Closes writer
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
    }
}
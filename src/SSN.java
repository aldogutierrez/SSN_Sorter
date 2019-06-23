import java.util.Random;

public class SSN
{
    private int areaNumber;             // 3 digits, 01 - 999
    private int groupNumber;            // 2 digits, 01 - 99
    private int serialNumber;           // 4 digits, 01 - 9999

    /**
     * Ctor for objects of type SSN
     * Depicts a Social Security Number
     * -
     * When a new SSN object is created
     * it assigns a random number to
     * each instance variable
     */
    public SSN()
    {
        Random ranInt = new Random();
        areaNumber = ranInt.nextInt(998) + 1;
        groupNumber = ranInt.nextInt(98) + 1;
        serialNumber = ranInt.nextInt(9998) + 1;
    }

    @Override
    public String toString()
    {
        return String.format("%03d", areaNumber) + "-" + String.format("%02d", groupNumber) + "-" + String.format("%04d", serialNumber);
    }
}
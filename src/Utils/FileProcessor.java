package Utils;
import Reports.Reports;

import java.io.*;

/**
 *
 * <h1>FileProcessor</h1>
 * The FileProcessor Object, meant for creating instances of the fileprocessor.
 * Will process the input and output files
 *
 * @author  Xavier Shelton
 * @version 1.0
 * @since   2019-08-15
 *
 */
public class FileProcessor {


    /**
     * Takes in a file location string, read the the file at that location generate
     * a new file
     *
     * @param filePath A string of the file path
     *
     */
    public Boolean processFile(String filePath) throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        File inputFile = new File(filePath);

        try {
            inputStream = new BufferedReader(new FileReader(inputFile));
            outputStream = new PrintWriter(new FileWriter("DriverHistory.txt"));

            fileReader(inputStream);

        } finally {
            // Close input stream
            if (inputStream != null) {
                inputStream.close();
            }
            // Final output for output file

            // Close output stream
            if (outputStream != null) {
                outputStream.close();
            }
        }

        return true;
    }
    /**
     * Reads input file and sends input to report to manage the info
     * correctly
     *
     * @param inputStream The input stream to read the file
     *
     */
    public boolean fileReader (BufferedReader inputStream) throws IOException {
        String line;
        while ((line = inputStream.readLine()) != null) {
            String[] outputArray = line.split("\\s+");
            try {
                //Process report information

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}

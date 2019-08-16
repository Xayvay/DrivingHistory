package Utils;

import Driver.Driver;
import Report.Report;
import Driver.DriverService;
import Trip.TripService;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>ReportProcessor</h1>
 * The FileProcessor Object, meant for creating instances of the reportProcessor.
 * Will process the input and output files
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class ReportProcessor {


    /**
     * Takes in a file location string, read the the file at that location generate
     * a new file
     *
     * @param filePath A string of the file path
     */
    public Boolean processReport(String filePath) throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        File inputFile = new File(filePath);
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        try {
            inputStream = new BufferedReader(new FileReader(inputFile));
            outputStream = new PrintWriter(new FileWriter("DriverHistory.txt"));

            fileReader(inputStream, drivers);

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
     */
    public boolean fileReader(BufferedReader inputStream, ArrayList<Driver> drivers) throws IOException {
        String line;
        try {
            while ((line = inputStream.readLine()) != null) {
                parseLine(line, drivers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void parseLine(String line, ArrayList<Driver> drivers) {
        String[] outputArray = line.split("\\s+");
        switch (outputArray[0]) {
            case "Driver":
                DriverService.addDriver(drivers, outputArray[1]);
                break;
            case "Trip":
                TripService.addTrip(drivers, outputArray[1], outputArray[2], outputArray[3], outputArray[4]);
                break;
            default:
                //throw error
                break;
        }
    }

}

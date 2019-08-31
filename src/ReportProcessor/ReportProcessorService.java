package ReportProcessor;

import Driver.Driver;
import Driver.DriverService;
import Report.Report;
import Trip.TripService;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;


/**
 * <h1>ReportProcessor</h1>
 * The ReportProcessor Object, meant for creating instances of the reportProcessor.
 * Will process the input and output files
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class ReportProcessorService {


    /**
     * Takes in a file location string, read the the file at that location generate
     * a new file
     *
     * @param filePath A string of the file path
     */
    public static void processReport(String filePath) throws IOException {
        File inputFile = new File(filePath);
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        Report report = new Report();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(inputFile)); PrintWriter outputStream = new PrintWriter(new FileWriter("DriverHistory.txt"))) {

            fileReader(inputStream, drivers);
        }
    }

    /**
     * Reads input file and sends input to report to manage the info
     * correctly
     *
     * @param inputStream The input stream to read the file
     */
    private static void fileReader(BufferedReader inputStream, ArrayList<Driver> drivers) throws IOException {
        String line;
        try {
            while ((line = inputStream.readLine()) != null) {
                parseLine(line, drivers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads in a line and seperates it to determine if it Driver information is being stored or Trip information.
     * Then Calls that specific service
     *
     * @param line Seperated line from file
     * @param drivers A group of drivers for adding a new driver or adding a trip for a driver
     */
    private static void parseLine(String line, ArrayList<Driver> drivers) throws ParseException {
        String[] outputArray = line.split("\\s+");
        switch (outputArray[0]) {
            case "Driver":
                DriverService.addDriver(drivers, outputArray[1]);
                break;
            case "Trip":
                TripService.addTrip(drivers, outputArray[1], outputArray[2], outputArray[3], outputArray[4]);
                break;
            default:
                throw new IllegalStateException("This line should be unreachable, please provide a file that is formatted correctly");
        }
    }

    private static void fileWriter(PrintWriter outputStream) {

    }

    private static void consoleWriter(String report ){

    }

    private static void reportGenerator(){

    }
}

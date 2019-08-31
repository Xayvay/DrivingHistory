package ReportProcessor;

import Driver.Driver;
import Driver.DriverService;
import Report.Report;
import Trip.TripService;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


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
     * @param input A string containing the users input of a file path or stdin
     */
    public static void processReport(String input) throws IOException {
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        Report report = new Report();

        if (input.endsWith(".txt")) {
            fileReader(input, drivers);
        } else {
            systemInputReader(drivers);
        }
    }

    /**
     * Reads input file and sends input to report to manage the info
     * correctly
     *
     * @param input   The input from the user
     * @param drivers an empty group of drivers
     */
    private static void fileReader(String input, ArrayList<Driver> drivers) throws IOException {
        File inputFile = new File(input);
        BufferedReader inputStream = new BufferedReader(new FileReader(inputFile));
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
     * Reads user input into console and sends input to report to manage the info
     * correctly
     *
     * @param drivers an empty group of drivers
     */
    private static void systemInputReader(ArrayList<Driver> drivers) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert valid driving history into console:");
        while (in.hasNext()) {
            parseLine(in.nextLine(), drivers);
        }
    }

    /**
     * Reads in a line and seperates it to determine if it Driver information is being stored or Trip information.
     * Then Calls that specific service
     *
     * @param line    Seperated line from file
     * @param drivers A group of drivers for adding a new driver or adding a trip for a driver
     */
    private static void parseLine(String line, ArrayList<Driver> drivers) {
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

    private static void fileWriter(PrintWriter outputStream, String reportOutput) {

    }

    private static void consoleWriter(String reportOutput) {

    }

    private static void reportGenerator() throws IOException {
        PrintWriter outputStream = new PrintWriter(new FileWriter("DrivingHistory.txt"));
        //consoleWriter();
        //fileWriter(outputStream,);
    }
}
package ReportProcessor;

import Driver.Driver;
import Driver.DriverService;
import Report.ReportService;
import Trip.TripService;

import java.io.*;
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

        if (input.endsWith(".txt")) {
            fileReader(input, drivers);
        } else {
            systemInputReader(drivers);
        }

        reportGenerator(ReportService.printDriverHistory(drivers));
    }

    /**
     * Reads input file and sends input to report to manage the info
     * correctly
     *
     * @param input   The input from the user
     * @param drivers an empty group of drivers
     */
    private static void fileReader(String input, ArrayList<Driver> drivers) {
        try {
            File inputFile = new File(input);
            BufferedReader inputStream = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = inputStream.readLine()) != null) {
                parseLine(line, drivers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads user input into console (Either from file or driver data ) then sends input to report to manage the info
     * correctly
     *
     * @param drivers an empty group of drivers
     */
    static void systemInputReader(ArrayList<Driver> drivers) {
        System.out.println("Pick an option:\n" +
                "A. Please insert a valid driving history file path ending in (.txt).\n" +
                "B. Please type in valid driver names and their driving history, When done type exit and press enter for the results: \n");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!input.equals("exit")) {
            if (input.endsWith(".txt")) {
                fileReader(input, drivers);
                break;
            } else {
                parseLine(input, drivers);
                input = in.nextLine();
            }
        }
        in.close();
    }

    /**
     * Reads in a line and seperates it to determine if it Driver information is being stored or Trip information.
     * Then Calls that specific service
     *
     * @param line    Seperated line from file
     * @param drivers A group of drivers for adding a new driver or adding a trip for a driver
     */
    static void parseLine(String line, ArrayList<Driver> drivers) {
        String[] outputArray = line.split("\\s+");
        switch (outputArray[0]) {
            case "Driver":
                DriverService.addDriver(drivers, outputArray[1]);
                break;
            case "Trip":
                TripService.addTrip(drivers, outputArray[1], outputArray[2], outputArray[3], outputArray[4]);
                break;
            default:
                throw new IllegalStateException("Wrong input given. Please check your driver history input commands for any issues.");
        }
    }

    /**
     * Writes the report output to a file
     *
     * @param reportOutput The report output String
     */
    private static void fileWriter(String reportOutput) throws IOException {
        PrintWriter outputStream = new PrintWriter(new FileWriter("DrivingHistory.txt"));
        outputStream.write(reportOutput);
        outputStream.close();
    }

    /**
     * Write the report output to the console
     *
     * @param reportOutput The report output String
     */
    private static void consoleWriter(String reportOutput) {
        System.out.println(reportOutput);
    }

    /**
     * Runs ConsoleWriter and fileWriter to return reports
     *
     * @param reportOutput The report output String
     */
    private static void reportGenerator(String reportOutput) throws IOException {
        consoleWriter(reportOutput);
        fileWriter(reportOutput);
    }
}

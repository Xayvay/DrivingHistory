package Report;

import Driver.Driver;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * <h1>Report</h1>
 * The Report Object, meant for creating instances of the report.
 * Will Piece together the Driver history reports for processing
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class Report {
    private ArrayList<Driver> drivers;

    public Report(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    /**
     * A method that organizes the collection of drivers then "prints" their report to a string
     */
    String printReport() {
        organizeDrivers();
        return recordDriverOutput(this.drivers);
    }

    /**
     * A method that organizes the drivers in a collection
     * <p>
     */
    private void organizeDrivers() {
        this.drivers.sort(Comparator.comparingDouble(Driver::getTotalMiles).reversed());
    }

    /**
     * A method that stores the drivers output to a string
     * <p>
     *
     * @param drivers Collection of Drivers
     */
    private String recordDriverOutput(ArrayList<Driver> drivers) {
        StringBuffer driverOutput = new StringBuffer();
        drivers.forEach(driver -> driverOutput.append(driver.generateDriverReport().concat("\n")));
        return driverOutput.toString().trim();
    }
}

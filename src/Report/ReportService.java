package Report;

import Driver.Driver;

import java.util.ArrayList;

/**
 * <h1>ReportService</h1>
 * The ReportService class, runs all services related to the reports objects
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class ReportService {

    /**
     * A method that gets a collection of drivers and prints their report
     * <p>
     *
     * @param drivers Collection of drivers
     */
    public static String printDriverHistory(ArrayList<Driver> drivers) {
        Report report = new Report(drivers);
        return report.printReport();
    }
}

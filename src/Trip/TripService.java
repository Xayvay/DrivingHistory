package Trip;

import Driver.Driver;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * <h1>DriverService</h1>
 * The DriverService class will initiate any Driver related functionality.
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class TripService {

    /**
     * A void method that adds a trip for a diver
     * <p>
     *
     * @param drivers     Collection of Driver Objects
     * @param driverName  A drivers name
     * @param startTime   The start time of a trip
     * @param endTime     the end time of a trip
     * @param milesDriven a duration of the miles traveled
     */
    public static void addTrip(ArrayList<Driver> drivers, String driverName, String startTime, String endTime, String milesDriven) {
        drivers.forEach(driver -> {
            if (driverName.equals(driver.getDriverName())) {
                driver.addTrip(new Trip(driverName, stringToTime(startTime), stringToTime(endTime), Double.parseDouble(milesDriven)));
            }
        });
    }

    /**
     * A method that converts a string of time into LocalTime
     * <p>
     *
     * @param time The start or end time of a trip in a date type
     */
    public static LocalTime stringToTime(String time) {
        return LocalTime.parse(time);
    }
}

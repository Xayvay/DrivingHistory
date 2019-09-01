package Driver;

import java.util.ArrayList;

/**
 * <h1>DriverService</h1>
 * The DriverService class will initiate any Driver related functionality.
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class DriverService {

    /**
     * A method that adds a new driver object to a collection of drivers
     *
     * @param drivers collection of drivers
     * @param driverName string representation of a driver's name
     */
    public static void addDriver(ArrayList<Driver> drivers, String driverName) {
        if (safeToAdd(drivers, driverName)) {
            drivers.add(new Driver(driverName));
        }
    }

    public static boolean safeToAdd(ArrayList<Driver> drivers, String driverName) {
        return drivers.stream().noneMatch(driver -> driver.getDriverName().equals(driverName));
    }

}

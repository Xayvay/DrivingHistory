package Driver;

import Trip.Trip;

import java.util.ArrayList;


public class DriverService {

    public static void addDriver(ArrayList<Driver> drivers, String driverName) {

        if (safeToAdd(drivers, driverName)) {
            drivers.add(new Driver(driverName));
        }

    }

    public static boolean safeToAdd(ArrayList<Driver> drivers, String driverName) {

        return drivers.stream().noneMatch(driver -> driver.getDriverName().equals(driverName));
    }

}

package Driver;

import Trip.Trip;

import java.util.ArrayList;


public class DriverService {

    public static void addDriver(ArrayList<Driver> drivers, String driverName) {
        drivers.add(new Driver(driverName));
    }

}

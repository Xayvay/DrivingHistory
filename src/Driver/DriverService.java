package Driver;

import java.util.ArrayList;


public class DriverService {

    public static void addDriver(ArrayList<Driver> drivers, String driverName) {
        drivers.add(new Driver(driverName));
    }

    public static void addTrip(){

    }

    public static void addTrips(){

    }

    public static int getAvgSpeed(){

        return accumulatedMiles()/accumulatedHours();
    }

    private static int accumulatedMiles(){

        return 0;
    }

    private static int accumulatedHours(){
        return 0;
    }

    public static String generateDriverReport(){
        return "";
    }

}

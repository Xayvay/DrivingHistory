package Trip;

import Driver.Driver;
import Driver.InvalidTripException;
import java.time.LocalTime;
import java.util.ArrayList;


public class TripService {
    public static void addTrip(ArrayList<Driver> drivers, String driverName, String startTime, String endTime, String milesDriven)  {

        drivers.forEach(driver -> {
            if (driverName.equals(driver.getDriverName())) {
                try {
                    driver.addTrip(new Trip(driverName, stringToTime(startTime), stringToTime(endTime), Double.parseDouble(milesDriven)));
                } catch (InvalidTripException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static LocalTime stringToTime(String str){
        return LocalTime.parse(str);
    }
}

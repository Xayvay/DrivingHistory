package Trip;

import Driver.Driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TripService {
    public static void addTrip(ArrayList<Driver> drivers, String driverName, String startTime, String stopTime, String milesDriven) throws ParseException {

        drivers.forEach(driver -> {
            if (driverName.equals(driver.getDriverName())) {
                try {
                    driver.addTrip(new Trip(driverName, stringToTime(startTime), stringToTime(stopTime), Integer.parseInt(milesDriven)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Date stringToTime(String str) throws ParseException {
        return new SimpleDateFormat("HH:mm:ss").parse(str);
    }
}

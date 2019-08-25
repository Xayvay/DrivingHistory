package Trip;

import Driver.Driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TripService {
    public static void addTrip(ArrayList<Driver> drivers, String driverName, String startTime, String endTime, String milesDriven)  {

        drivers.forEach(driver -> {
            if (driverName.equals(driver.getDriverName())) {
                try {
                    driver.addTrip(new Trip(driverName, stringToTime(startTime), stringToTime(endTime), Double.parseDouble(milesDriven)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static Date stringToTime(String str) throws ParseException {
        return new SimpleDateFormat("HH:mm").parse(str);
    }
}

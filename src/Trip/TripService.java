package Trip;

import Driver.Driver;
import Driver.InvalidTripException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class TripService {
    public static void addTrip(ArrayList<Driver> drivers, String driverName, String startTime, String endTime, String milesDriven)  {

        drivers.forEach(driver -> {
            if (driverName.equals(driver.getDriverName())) {
                try {
                    driver.addTrip(new Trip(driverName, stringToTime(startTime), stringToTime(endTime), Double.parseDouble(milesDriven)));
                } catch (ParseException | InvalidTripException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static LocalTime stringToTime(String str) throws ParseException {
        return LocalTime.parse(str);
    }
}

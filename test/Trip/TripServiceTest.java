package Trip;

import Driver.Driver;
import Driver.DriverService;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TripServiceTest {

    @Test
    public void testAddTrip(){
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers,"Goku","04:00","08:00","10");
        double avgSpeedCheck = 0;
        double milesCheck = 0.0;
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                avgSpeedCheck = driver.getAvgSpeed();
                milesCheck = driver.getTotalMiles();
                break;
            }
        }

        assertEquals(2.5,avgSpeedCheck,0);
        assertEquals(10,milesCheck,0);
    }

    @Test
    public void testStringToTime() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Date time = new SimpleDateFormat("HH:mm").parse("05:00");
        assertEquals(time,TripService.stringToTime("05:00"));
    }


}

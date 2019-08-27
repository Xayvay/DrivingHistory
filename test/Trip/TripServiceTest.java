package Trip;

import Driver.Driver;
import Driver.DriverService;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TripServiceTest {

    @Test
    public void testAddTrip(){
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers,"Goku","04:00","08:00","29");
        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        double avgSpeed = optionalGoku.get().getAvgSpeed();
        double totalMiles = optionalGoku.get().getTotalMiles();

        assertEquals(7.25,avgSpeed,0);
        assertEquals(29,totalMiles,0);
    }

    @Test
    public void testStringToTime() throws ParseException {
        LocalTime time = LocalTime.parse("05:00");
        assertEquals(time,TripService.stringToTime("05:00"));
    }


}

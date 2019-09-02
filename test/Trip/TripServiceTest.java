package Trip;

import Driver.Driver;
import Driver.DriverService;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceTest {

    @Test
    void testAddTrip() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "29");
        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        double avgSpeed = optionalGoku.get().getAvgSpeed();
        double totalMiles = optionalGoku.get().getTotalMiles();

        assertEquals(7.25, avgSpeed, 0);
        assertEquals(29, totalMiles, 0);
    }

    @Test
    void testStringToTime() {
        LocalTime time = LocalTime.parse("05:00");
        assertEquals(time, TripService.stringToTime("05:00"));
    }
}

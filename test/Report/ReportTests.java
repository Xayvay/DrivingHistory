package Report;

import Driver.Driver;
import Driver.DriverService;
import Trip.TripService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReportTests {
    @Test
    public void testAddTripExampleInput() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Dan");
        DriverService.addDriver(drivers, "Alex");
        DriverService.addDriver(drivers, "Bob");
        TripService.addTrip(drivers, "Dan", "07:15", "07:45", "17.3");
        TripService.addTrip(drivers, "Dan", "06:12", "06:32", "21.8");
        TripService.addTrip(drivers, "Alex", "12:01", "13:16", "42.0");


        assertEquals(
                "Alex: 42 miles @ 34 mph\n" +
                        "Dan: 39 miles @ 47 mph\n" +
                        "Bob: 0 miles", ReportService.printDriverHistory(drivers));
    }
}

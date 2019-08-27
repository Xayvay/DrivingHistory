package Driver;

import Trip.Trip;
import Trip.TripService;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DriverTests {

    @Test
    public void testName() {
        Driver mike = new Driver("Mike Wizowsky");
        Driver sully = new Driver("James P. Sullivan");
        Driver noOne = new Driver("noOne");
        assertEquals("Mike Wizowsky", mike.getDriverName());
        assertEquals("James P. Sullivan", sully.getDriverName());
        assertEquals("noOne", noOne.getDriverName());
    }

    @Test
    public void getDriverReport() {
        Driver mike = new Driver("Mike Wizowsky");
        mike.setTotalMiles(20);
        mike.setAvgSpeed(6);
        assertEquals("Mike Wizowsky: 20 miles @ 6 mph", mike.generateDriverReport());
    }

    @Test
    public void testAddTrip() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "09:00", "220");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        double avgSpeed = optionalGoku.get().getAvgSpeed();
        double totalMiles = optionalGoku.get().getTotalMiles();

        assertEquals(44.0, avgSpeed, 0);
        assertEquals(220, totalMiles, 0);
    }

    @Test
    public void testAddTrips() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "09:00", "30");
        TripService.addTrip(drivers, "Goku", "08:00", "13:26", "100");
        TripService.addTrip(drivers, "Goku", "16:20", "22:10", "200");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        double avgSpeed = optionalGoku.get().getAvgSpeed();
        double totalMiles = optionalGoku.get().getTotalMiles();

        assertEquals(20.0, Math.round(avgSpeed), 0);
        assertEquals(330, Math.round(totalMiles), 0);

    }

    @Test
    public void testAddTripThrowErrorTooLow()  {

        Driver Goku = new Driver("Goku");
        Trip aTrip = new Trip("Goku", TripService.stringToTime("04:00"), TripService.stringToTime("08:00"), 10);
        assertThrows(InvalidTripException.class, () -> {
            Goku.addTrip(aTrip);
        });
    }

    @Test
    public void testAddTripThrowErrorTooHigh() {

        Driver Goku = new Driver("Goku");
        Trip aTrip = new Trip("Goku", TripService.stringToTime("04:00"), TripService.stringToTime("08:00"), 10000);
        assertThrows(InvalidTripException.class, () -> {
            Goku.addTrip(aTrip);
        });

    }
    @Test
    public void testAddTripExampleInput() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Dan");
        DriverService.addDriver(drivers, "Alex");
        DriverService.addDriver(drivers, "Bob");
        TripService.addTrip(drivers, "Dan", "07:15", "07:45", "17.3");
        TripService.addTrip(drivers, "Dan", "06:12", "06:32", "21.8");
        TripService.addTrip(drivers, "Alex", "12:01", "13:16", "42.0");

        Optional<Driver> optionalDan = drivers.stream().filter(driver -> driver.getDriverName().equals("Dan")).findFirst();
        Optional<Driver> optionalAlex = drivers.stream().filter(driver -> driver.getDriverName().equals("Alex")).findFirst();
        Optional<Driver> optionalBob = drivers.stream().filter(driver -> driver.getDriverName().equals("Bob")).findFirst();
        assertFalse(optionalDan.isEmpty());
        assertFalse(optionalAlex.isEmpty());
        assertFalse(optionalBob.isEmpty());

        double avgSpeedDan = optionalDan.get().getAvgSpeed();
        double totalMilesDan = optionalDan.get().getTotalMiles();

        double avgSpeedAlex = optionalAlex.get().getAvgSpeed();
        double totalMilesAlex = optionalAlex.get().getTotalMiles();

        double avgSpeedBob = optionalBob.get().getAvgSpeed();
        double totalMilesBob = optionalBob.get().getTotalMiles();

        assertEquals(47, Math.round(avgSpeedDan), 0);
        assertEquals(39, Math.round(totalMilesDan), 0);
        assertEquals(34, Math.round(avgSpeedAlex), 0);
        assertEquals(42, Math.round(totalMilesAlex), 0);
        assertEquals(0, Math.round(avgSpeedBob), 0);
        assertEquals(0, Math.round(totalMilesBob), 0);
    }


    @Test
    public void testGenerateReportSingleEntry() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "40");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        String checkReport = optionalGoku.get().generateDriverReport();
        assertEquals("Goku: 40 miles @ 10 mph", checkReport);
    }

    @Test
    public void testGenerateReportSingleEntryRoundDetermination() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:59", "40");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        String checkReport = optionalGoku.get().generateDriverReport();
        assertEquals("Goku: 40 miles @ 8 mph", checkReport);
    }

    @Test
    public void testGenerateReportMultiEntries() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "37");
        TripService.addTrip(drivers, "Goku", "05:00", "13:50", "100");
        TripService.addTrip(drivers, "Goku", "17:24", "23:59", "200");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        assertFalse(optionalGoku.isEmpty());

        String checkReport = optionalGoku.get().generateDriverReport();
        assertEquals("Goku: 337 miles @ 17 mph", checkReport);
    }

    @Test
    public void testGenerateReportMultiEntriesMultiplePeople() {
        ArrayList<Driver> drivers = new ArrayList<>();

        DriverService.addDriver(drivers, "Goku");
        DriverService.addDriver(drivers, "Vegeta");
        TripService.addTrip(drivers, "Vegeta", "01:43", "07:16", "290");
        TripService.addTrip(drivers, "Goku", "06:00", "10:49", "210");
        TripService.addTrip(drivers, "Vegeta", "05:24", "12:13", "402");
        TripService.addTrip(drivers, "Vegeta", "04:00", "08:00", "330");
        TripService.addTrip(drivers, "Goku", "09:20", "16:09", "290");
        TripService.addTrip(drivers, "Goku", "12:59", "23:10", "777");

        Optional<Driver> optionalGoku = drivers.stream().filter(driver -> driver.getDriverName().equals("Goku")).findFirst();
        Optional<Driver> optionalVegeta = drivers.stream().filter(driver -> driver.getDriverName().equals("Vegeta")).findFirst();

        assertFalse(optionalGoku.isEmpty());
        assertFalse(optionalVegeta.isEmpty());

        String checkReportGoku = optionalGoku.get().generateDriverReport();
        String checkReportVegeta = optionalVegeta.get().generateDriverReport();

        assertEquals("Goku: 1277 miles @ 59 mph", checkReportGoku);
        assertEquals("Vegeta: 1022 miles @ 62 mph", checkReportVegeta);

    }

    @Test
    public void testGenerateReportProvidedData() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Dan");
        DriverService.addDriver(drivers, "Alex");
        DriverService.addDriver(drivers, "Bob");
        TripService.addTrip(drivers, "Dan", "07:15", "07:45", "17.3");
        TripService.addTrip(drivers, "Dan", "06:12", "06:32", "21.8");
        TripService.addTrip(drivers, "Alex", "12:01", "13:16", "42.0");

        Optional<Driver> optionalDan = drivers.stream().filter(driver -> driver.getDriverName().equals("Dan")).findFirst();
        Optional<Driver> optionalAlex = drivers.stream().filter(driver -> driver.getDriverName().equals("Alex")).findFirst();
        Optional<Driver> optionalBob = drivers.stream().filter(driver -> driver.getDriverName().equals("Bob")).findFirst();

        assertFalse(optionalDan.isEmpty());
        assertFalse(optionalAlex.isEmpty());
        assertFalse(optionalBob.isEmpty());

        String checkReportDan = optionalDan.get().generateDriverReport();
        String checkReportAlex = optionalAlex.get().generateDriverReport();
        String checkReportBob = optionalBob.get().generateDriverReport();

        assertEquals("Dan: 39 miles @ 47 mph", checkReportDan);
        assertEquals("Alex: 42 miles @ 34 mph", checkReportAlex);
        assertEquals("Bob: 0 miles", checkReportBob);

    }

}
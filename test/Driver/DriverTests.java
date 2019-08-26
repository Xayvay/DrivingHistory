package Driver;

import Trip.TripService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DriverTests {


    @Test
    public void testName() {
        Driver mike = new Driver("Mike Wizowsky");
        Driver sully = new Driver("James P. Sullivan");
        Driver noOne = new Driver("");
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

        double avgSpeed = 0.0;
        double totalMiles = 0.0;
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                avgSpeed = driver.getAvgSpeed();
                totalMiles = driver.getTotalMiles();
                break;
            }
        }
        assertEquals(44.0, avgSpeed, 0);
        assertEquals(220, totalMiles, 0);
    }

    @Test
    public void testAddTrips() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "09:00", "30");
        TripService.addTrip(drivers, "Goku", "08:00", "13:26", "100");
        TripService.addTrip(drivers, "Goku", "16:20", "24:10", "200");

        double avgSpeed = 0.0;
        double totalMiles = 0.0;
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                avgSpeed = driver.getAvgSpeed();
                totalMiles = driver.getTotalMiles();
                break;
            }
        }
        assertEquals(18.0, Math.round(avgSpeed), 0);
        assertEquals(330, Math.round(totalMiles), 0);
    }

    @Test
    public void testAddTripProvidedData() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Dan");
        DriverService.addDriver(drivers, "Alex");
        DriverService.addDriver(drivers, "Bob");
        TripService.addTrip(drivers, "Dan", "07:15", "07:45", "17.3");
        TripService.addTrip(drivers, "Dan", "06:12", "06:32", "21.8");
        TripService.addTrip(drivers, "Alex", "12:01", "13:16", "42.0");

        double avgSpeedDan = 0.0;
        double totalMilesDan = 0.0;
        double avgSpeedAlex = 0.0;
        double totalMilesAlex = 0.0;
        double avgSpeedBob = 0.0;
        double totalMilesBob = 0.0;
        for (Driver driver : drivers) {
            switch (driver.getDriverName()) {
                case "Dan":
                    avgSpeedDan = driver.getAvgSpeed();
                    totalMilesDan = driver.getTotalMiles();
                    break;
                case "Alex":
                    avgSpeedAlex = driver.getAvgSpeed();
                    totalMilesAlex = driver.getTotalMiles();
                    break;
                case "Bob":
                    avgSpeedBob = driver.getAvgSpeed();
                    totalMilesBob = driver.getTotalMiles();
                    break;
            }
        }
        assertEquals(47, Math.round(avgSpeedDan), 0);
        assertEquals(39, Math.round(totalMilesDan), 0);
        assertEquals(34, Math.round(avgSpeedAlex), 0);
        assertEquals(42, Math.round(totalMilesAlex), 0);
        assertEquals(0, Math.round(avgSpeedBob), 0);
        assertEquals(0, Math.round(totalMilesBob), 0);
    }

    @Test(expected = RuntimeException.class)
    public void testaddTripThrowErrorTooLow() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "10");
    }


    @Test(expected = RuntimeException.class)
    public void testAddTripThrowErrorTooHigh() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "100000");
    }

    @Test
    public void testGenerateReportSingleEntry() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "40");

        String checkReport = "";
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                checkReport = driver.generateDriverReport();
                break;
            }
        }

        assertEquals("Goku: 40 miles @ 10 mph", checkReport);
    }

    @Test
    public void testGenerateReportSingleEntryRoundDetermination() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:59", "40");

        String checkReport = "";
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                checkReport = driver.generateDriverReport();
                break;
            }
        }

        assertEquals("Goku: 40 miles @ 8 mph", checkReport);
    }

    @Test
    public void testGenerateReportMultiEntries() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        TripService.addTrip(drivers, "Goku", "04:00", "08:00", "37");
        TripService.addTrip(drivers, "Goku", "05:00", "13:50", "100");
        TripService.addTrip(drivers, "Goku", "17:24", "24:10", "200");

        String checkReport = "";
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                checkReport = driver.generateDriverReport();
                break;
            }
        }

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
        TripService.addTrip(drivers, "Goku", "12:59", "24:10", "777");

        String checkReportGoku = "";
        String checkReportVegeta = "";
        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Goku")) {
                checkReportGoku = driver.generateDriverReport();
            } else if (driver.getDriverName().equals("Vegeta")) {
                checkReportVegeta = driver.generateDriverReport();
            }
        }

        assertEquals("Goku: 1277 miles @ 56 mph", checkReportGoku);
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

        String checkReportDan = "";
        String checkReportAlex = "";
        String checkReportBob = "";

        for (Driver driver : drivers) {
            switch (driver.getDriverName()) {
                case "Dan":
                    checkReportDan = driver.generateDriverReport();
                    break;
                case "Alex":
                    checkReportAlex = driver.generateDriverReport();
                    break;
                case "Bob":
                    checkReportBob = driver.generateDriverReport();
                    break;
            }
        }
        assertEquals("Dan: 39 miles @ 47 mph", checkReportDan);
        assertEquals("Alex: 42 miles @ 34 mph", checkReportAlex);
        assertEquals("Bob: 0 miles", checkReportBob);


    }

}
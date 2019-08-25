package Driver;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DriverServiceTests {

    @Test
    public void testDriverAdded() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Mike Wizowsky");
        boolean hasName = false;

        for (Driver driver : drivers) {
            if (driver.getDriverName().equals("Mike Wizowsky")) {
                hasName = true;
                break;
            }
        }

        assertTrue(hasName);
    }

    @Test
    public void testSafeToAddTrue() {
        ArrayList<Driver> drivers = new ArrayList<>();
        assertTrue(DriverService.safeToAdd(drivers, "Goku"));
    }

    @Test
    public void testSafeToAddFalse() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        assertFalse(DriverService.safeToAdd(drivers, "Goku"));
    }
}

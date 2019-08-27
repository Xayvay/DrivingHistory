package Driver;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class DriverServiceTests {

    @Test
    public void testDriverAdded() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Mike Wizowsky");

        Optional<Driver> optionalMike = drivers.stream().filter(driver -> driver.getDriverName().equals("Mike Wizowsky")).findFirst();
        assertTrue(optionalMike.isPresent());
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

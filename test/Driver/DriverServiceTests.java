package Driver;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

class DriverServiceTests {

    @Test
    void testDriverAdded() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Mike Wizowsky");

        Optional<Driver> optionalMike = drivers.stream().filter(driver -> driver.getDriverName().equals("Mike Wizowsky")).findFirst();
        assertTrue(optionalMike.isPresent());
    }

    @Test
    void testSafeToAddTrue() {
        ArrayList<Driver> drivers = new ArrayList<>();
        assertTrue(DriverService.safeToAdd(drivers, "Goku"));
    }

    @Test
    void testSafeToAddFalse() {
        ArrayList<Driver> drivers = new ArrayList<>();
        DriverService.addDriver(drivers, "Goku");
        assertFalse(DriverService.safeToAdd(drivers, "Goku"));
    }
}

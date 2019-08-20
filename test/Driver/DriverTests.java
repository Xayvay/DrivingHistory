package Driver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTests {

    private Driver mike = new Driver("Mike Wizowsky");
    private Driver sully = new Driver("James P. Sullivan");
    private Driver noOne = new Driver("");

    @Test
    public void testName() {
        assertEquals("Mike Wizowsky", mike.getDriverName());
        assertEquals("James P. Sullivan", sully.getDriverName());
        assertEquals("", noOne.getDriverName());
    }

    @Test
    public void getDriverReport() {
        mike.setTotalMiles(20);
        mike.setAvgSpeed(6);
        assertEquals("Mike Wizowsky: 20 miles @ 6 mph", mike.generateDriverReport());
    }
}
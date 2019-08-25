package Trip;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class TripTests {
    @Test
    public void testConvertToHours() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("05:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("6:00");

        Trip trip = new Trip("Doug", startTime, endTime, 20);
        assertEquals(10,trip.convertToHours(startTime));
        assertEquals(11,trip.convertToHours(endTime));
    }

    @Test
    public void testTripDuration() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("05:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("6:00");
        Trip trip = new Trip("Doug", startTime, endTime, 20);

        assertEquals(1,trip.getTripDuration());

        startTime = new SimpleDateFormat("HH:mm").parse("11:00");
        endTime = new SimpleDateFormat("HH:mm").parse("20:30");
        trip = new Trip("Kevin", startTime, endTime, 20);

        assertEquals(9,trip.getTripDuration());
    }

}

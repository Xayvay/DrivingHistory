package Trip;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TripTests {
    @Test
    public void testConvertToHours() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("07:15");
        Date endTime = new SimpleDateFormat("HH:mm").parse("7:45");

        Trip trip = new Trip("Doug", startTime, endTime, 17.3);
        assertEquals(12.25,trip.convertToHours(startTime),0);
        assertEquals(12.75,trip.convertToHours(endTime),0);
    }


    @Test
    public void testTripDurationOfSingleDigit() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("05:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("6:00");
        Trip trip = new Trip("Doug", startTime, endTime, 20);

        assertEquals(1,trip.getTripDuration());
    }

    @Test
    public void testTripDurationOfMultipleDigits() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("9:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("20:30");
        Trip trip = new Trip("Kevin", startTime, endTime, 20);

        assertEquals(9,trip.getTripDuration());
    }
    @Test
    public void testIsValid() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("10:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("15:00");
        Trip trip = new Trip("Eddie Murphy", startTime, endTime, 30);

        assertTrue(trip.isValid());
    }

    @Test
    public void testIsNotValidTooSlow() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("10:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("15:00");
        Trip trip = new Trip("Kevin Hart", startTime, endTime, 5);

        assertFalse(trip.isValid());
    }

    @Test
    public void testIsValidIfFive() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("10:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("15:00");
        Trip trip = new Trip("Kevin Hart", startTime, endTime, 5);

        assertFalse(trip.isValid());
    }

    @Test
    public void testIsNotValidTooFast() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("03:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("04:00");
        Trip trip = new Trip("Kevin Hart", startTime, endTime, 5);

        assertFalse(trip.isValid());
    }
    @Test
    public void testIsValidIfOneHundred() throws ParseException {
        Date startTime = new SimpleDateFormat("HH:mm").parse("10:00");
        Date endTime = new SimpleDateFormat("HH:mm").parse("15:00");
        Trip trip = new Trip("Kevin Hart", startTime, endTime, 5);

        assertFalse(trip.isValid());
    }
}

package Trip;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TripTests {
    @Test
    public void testConvertToHours() throws ParseException {
        LocalTime time1 = TripService.stringToTime("07:15");
        LocalTime time2 = TripService.stringToTime("07:45");
        LocalTime time3 = TripService.stringToTime("21:57");

        Trip trip = new Trip("Doug", time1, time2, 17.3);
        assertEquals(7.25,trip.convertToHours(time1),0);
        assertEquals(7.75,trip.convertToHours(time2),0);
        assertEquals(21.95,trip.convertToHours(time3),0);
    }


    @Test
    public void testTripDurationOfSingleDigit() throws ParseException {
        LocalTime startTime = TripService.stringToTime("05:00");
        LocalTime endTime = TripService.stringToTime("06:00");
        Trip trip = new Trip("Doug", startTime, endTime, 20);

        assertEquals(1,trip.getTripDuration(),0);
    }

    @Test
    public void testTripDurationOfMultipleDigits() throws ParseException {
        LocalTime startTime = TripService.stringToTime("09:00");
        LocalTime endTime = TripService.stringToTime("20:30");
        Trip trip = new Trip("Kevin", startTime, endTime, 20);

        assertEquals(11.5,trip.getTripDuration(),0);
    }
    @Test
    public void testIsValid() throws ParseException {
        LocalTime startTime = TripService.stringToTime("10:00");
        LocalTime endTime = TripService.stringToTime("15:00");
        Trip trip = new Trip("Eddie Murphy", startTime, endTime, 30);

        assertTrue(trip.isValid());
    }

    @Test
    public void testIsNotValidTooSlow() throws ParseException {
        LocalTime startTime = TripService.stringToTime("10:00");
        LocalTime endTime = TripService.stringToTime("15:00");
        Trip trip = new Trip("Kevin Hart", startTime, endTime, 5);

        assertFalse(trip.isValid());
    }

    @Test
    public void testIsValidIfFive() throws ParseException {
        LocalTime startTime = TripService.stringToTime("11:30");
        LocalTime endTime = TripService.stringToTime("12:30");
        Trip trip = new Trip("David Chappelle", startTime, endTime, 5);

        assertTrue(trip.isValid());
    }

    @Test
    public void testIsNotValidTooFast() throws ParseException {
        LocalTime startTime = TripService.stringToTime("03:00");
        LocalTime endTime = TripService.stringToTime("04:00");
        Trip trip = new Trip("Will Farrell", startTime, endTime, 110);

        assertFalse(trip.isValid());
    }
    @Test
    public void testIsValidIfOneHundred() throws ParseException {
        LocalTime startTime = TripService.stringToTime("10:00");
        LocalTime endTime = TripService.stringToTime("15:00");
        Trip trip = new Trip("Tosh", startTime, endTime, 500);

        assertTrue(trip.isValid());
    }
}

package Trip;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TripServiceTest {

    @Test
    public void testStringToTime() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Date time = new SimpleDateFormat("HH:mm").parse("05:00");
        assertEquals(time,TripService.stringToTime("05:00"));
    }


}

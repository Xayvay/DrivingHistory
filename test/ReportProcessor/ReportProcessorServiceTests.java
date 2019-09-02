package ReportProcessor;

import Driver.Driver;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportProcessorServiceTests {

    @Test
    void testProcessReportWithGoodInput() throws IOException {
        ReportProcessorService.processReport("./resources/exampleInput.txt");
        assertTrue(true);
    }

    @Test
    void testProcessReportWithGoodInputTwo() throws IOException {
        ReportProcessorService.processReport("./resources/exampleInputTwo.txt");
        assertTrue(true);
    }

    @Test
    void testProcessReportWithBadInput() {
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        assertThrows(IllegalStateException.class, () -> ReportProcessorService.parseLine("This line should fail", drivers));
    }

    @Test
    void testProcessReportFailBadFile() {
        try {
            ReportProcessorService.processReport("./cantFindFile.txt");
        } catch (Exception e) {
            assertThrows(FileNotFoundException.class, () -> ReportProcessorService.processReport("./cantFindFile.txt"));
        }
    }

    @Test
    void testSystemInputReaderGoodDriverData() {

        String input = "Driver Dan\n" +
                "Driver Alex\n" +
                "Driver Bob\n" +
                "Trip Dan 07:15 07:45 17.3\n" +
                "Trip Dan 06:12 06:32 21.8\n" +
                "Trip Alex 12:01 13:16 42.0\n" +
                "exit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        System.setIn(in);
        ReportProcessorService.systemInputReader(drivers);

        assertTrue(true);
    }

    @Test
    void testSystemInputReaderBadDriverData() {

        String input = "BAD DATA";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        System.setIn(in);

        assertThrows(IllegalStateException.class, () -> ReportProcessorService.systemInputReader(drivers));

    }

    @Test
    void testSystemInputReaderGoodFile() {

        String input = "./resources/exampleInputTwo.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        System.setIn(in);
        ReportProcessorService.systemInputReader(drivers);

        assertTrue(true);
    }

    @Test
    void testSystemInputReaderBadFile() {

        String input = "./cantFindFile.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        System.setIn(in);
        ReportProcessorService.systemInputReader(drivers);

        try {
            ReportProcessorService.processReport("./cantFindFile.txt");
        } catch (Exception e) {
            assertThrows(FileNotFoundException.class, () -> ReportProcessorService.processReport("./cantFindFile.txt"));
        }
    }
}

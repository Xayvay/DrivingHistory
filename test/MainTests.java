import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTests {
    @Test
    void testMainWithGoodInput() throws IOException {
        String[] array = {"./resources/exampleInput.txt"};
        Main.main(array);
        assertTrue(true);
    }

    @Test
    void testMainWithNoInput() throws IOException {
        String[] array = new String[0];
        String input = "Driver Dan\n" +
                "Driver Alex\n" +
                "Driver Bob\n" +
                "Trip Dan 07:15 07:45 17.3\n" +
                "Trip Dan 06:12 06:32 21.8\n" +
                "Trip Alex 12:01 13:16 42.0\n" +
                "exit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(array);
        assertTrue(true);
    }
}

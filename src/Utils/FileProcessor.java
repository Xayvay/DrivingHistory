package Utils;
import java.io.BufferedReader;

/**
 *
 * <h1>FileProcessor</h1>
 * The FileProcessor Object, meant for creating instances of a driver.
 *
 * @author  Xavier Shelton
 * @version 1.0
 * @since   2019-08-15
 *
 */
public class FileProcessor {

    BufferedReader inputStream;

    FileProcessor(BufferedReader inputStream){
        this.inputStream = inputStream;
    }

}

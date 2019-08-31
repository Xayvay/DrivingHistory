import ReportProcessor.ReportProcessorService;

import java.io.IOException;

/**
 * <h1>Main</h1>
 * The Main class initialize the program
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // Check for the arguments
        if (null != args[0]) ReportProcessorService.processReport(args[0]);
    }
}
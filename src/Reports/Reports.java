package Reports;

import java.util.ArrayList;

/**
 *
 * <h1>Reports</h1>
 * The Reports Object, meant for creating instances of the report.
 * Will Piece together the Driver history reports for processing
 *
 * @author  Xavier Shelton
 * @version 1.0
 * @since   2019-08-15
 */
public class Reports {
    private ArrayList<String> drivers = new ArrayList<String>();
    public Reports(ArrayList<String> drivers){
        this.drivers = drivers;
    }

}

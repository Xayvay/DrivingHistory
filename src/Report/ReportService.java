package Report;

import Driver.Driver;

import java.util.ArrayList;

public class ReportService {
    
    public static String printDriverHistory(ArrayList<Driver> drivers){
        Report report = new Report(drivers);
        return report.printReport();
    }
}

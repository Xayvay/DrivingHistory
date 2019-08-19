package Trip;

import java.util.Date;

/**
 * <h1>Trip</h1>
 * The Trip Object, meant for creating instances of a trip.
 * Will set Trip information
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class Trip {
    String driverName;
    Date startTime;
    Date endTime;
    int tripDuration;
    int milesTraveled;


    Trip(String driverName, Date startTime, Date endTime, int milesTraveled) {
        this.driverName = driverName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripDuration = 0;
        this.milesTraveled = milesTraveled;
    }


    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public Date getStartDate() {
        return this.startTime;
    }

    public Date getEndDate() {
        return this.endTime;
    }

    public int getTripDuration() {
        return this.tripDuration;
    }

    public int getMilesTraveled() {
        return this.milesTraveled;
    }

    public int convertToHours(int time) {
        return 0;
    }
}

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
    private String driverName;
    private Date startTime;
    private Date endTime;
    private long tripDuration;
    private long milesDriven;


    Trip(String driverName, Date startTime, Date endTime, long milesDriven) {
        this.driverName = driverName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripDuration = 0;
        this.milesDriven = milesDriven;
    }

    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setStartDate(Date startDate) {
        this.startTime = startDate;
    }

    public Date getStartDate() {
        return this.startTime;
    }

    public void setEndDate(Date endDate) {
        this.endTime = endDate;
    }

    public Date getEndDate() {
        return this.endTime;
    }

    public void setTripDuration(long tripDuration) {
        this.tripDuration = tripDuration;
    }

    public long getTripDuration() {
        return convertToHours(this.endTime) - convertToHours(this.startTime);
    }

    public long getMilesTraveled() {
        return this.milesDriven;
    }

    public boolean isValid() {
        return false;
    }

    /**
     * A method that gets the converts a date type to hours.
     *
     * (FYI: This method returns a value of the hours that were provided plus the value representation of 1970-01-01 00:00:00)
     * Can improve this method to subtract 1970-01-01 in its miliseconds form but it is later subtracted in the getDuration method
     *
     * @param time The start or end time of a trip in a date type
     *
     */
    long convertToHours(Date time) {
        long milsecsToMin = 60000;
        long givenTime = time.getTime();
        long timeInMinutes = givenTime / milsecsToMin;

        return timeInMinutes / 60;
    }
}

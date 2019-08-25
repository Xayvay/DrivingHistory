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
    private double tripDuration;
    private double milesDriven;


    Trip(String driverName, Date startTime, Date endTime, double milesDriven) {
        this.driverName = driverName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripDuration = this.getTripDuration();
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

    public double getTripDuration() {
        return convertToHours(this.endTime) - convertToHours(this.startTime);
    }

    public double getMilesTraveled() {
        return this.milesDriven;
    }

    boolean isValid() {

        double miles = (double) Math.round(this.milesDriven);
        double mph = miles / this.tripDuration;
        boolean validation = true;

        if (mph < 5 || mph > 100) {
            validation = false;
        }

        return validation;
    }

    /**
     * A method that converts a date type containing a given time to hours.
     * <p>
     * (FYI: This method returns a value of the hours that were provided plus the value representation of 1970-01-01 00:00:00)
     * Can improve this method to subtract 1970-01-01 in its miliseconds form but it is later subtracted in the getDuration method
     *
     * @param time The start or end time of a trip in a date type
     */
    double convertToHours(Date time) {
        double milsecsToMin = 60000.0;
        double givenTime = time.getTime();
        double timeInMinutes = givenTime / milsecsToMin;

        return timeInMinutes / 60;
    }
}

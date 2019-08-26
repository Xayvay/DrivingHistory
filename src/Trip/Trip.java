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


    public String getDriverName() {
        return this.driverName;
    }

    public double getTripDuration() {
        return convertToHours(this.endTime) - convertToHours(this.startTime);
    }

    public double getMilesTraveled() {
        return this.milesDriven;
    }

    public boolean isValid() {

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
     * (FYI: the startDateValue of 18000000 is the default milliseconds added from 1970-01-01 00:00:00)
     * Can improve this method to subtract 1970-01-01 in its milliseconds form but it is later subtracted in the getDuration method
     *
     * @param time The start or end time of a trip in a date type
     */
    double convertToHours(Date time) {
        double startDateMillis = 18000000;
        double milsecsToMin = 60000.0;
        double givenTime = time.getTime() - startDateMillis;
        double timeInMinutes = givenTime / milsecsToMin;

        return timeInMinutes / 60;
    }
}

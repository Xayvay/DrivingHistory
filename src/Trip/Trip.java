package Trip;

import java.time.LocalTime;
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
    private LocalTime startTime;
    private LocalTime endTime;
    private double tripDuration;
    private double milesDriven;


   public Trip(String driverName, LocalTime startTime, LocalTime endTime, double milesDriven) {
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
     *
     * @param time The start or end time of a trip in a date type
     */
    double convertToHours(LocalTime time) {

        double givenHour = time.getHour();
        double givenMinutes = time.getMinute() / 60.0;

        return givenHour + givenMinutes;
    }
}

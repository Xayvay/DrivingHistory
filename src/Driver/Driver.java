package Driver;


import Trip.Trip;

import java.util.ArrayList;

/**
 * <h1>Driver</h1>
 * The Driver Object, meant for creating instances of a driver.
 * Will set driver information for each driver
 *
 * @author Xavier Shelton
 * @version 1.0
 * @since 2019-08-15
 */
public class Driver {
    private String driverName = "";
    private double totalMiles;
    private long totalHours;
    private double avgSpeed;
    private ArrayList<Trip> trips;

    public Driver(String driverName) {
        this.driverName = driverName;
        totalMiles = 0;
        totalHours = 0;
        avgSpeed = 0;
        trips = new ArrayList<Trip>();
    }

    //Getters and Setters for member props in Driver

    public String getDriverName() {
        return this.driverName;
    }

    public void setTotalMiles(long totalMiles) {
        this.totalMiles = totalMiles;
    }

    public double getTotalMiles() {
        return this.totalMiles;
    }

    public void setAvgSpeed(long avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getAvgSpeed() {
        return accumulatedMiles(this.trips) / accumulatedHours(this.trips);
    }

    /**
     * A method that gets the total amount of hours driven
     *
     * @param trips amount of trips the driver has
     */
    private double accumulatedHours(ArrayList<Trip> trips) {
        double hours = 0;
        for (Trip trip : trips) {
            hours += trip.getTripDuration();
        }
        return hours;
    }

    /**
     * A method that gets the total amount of miles driven
     *
     * @param trips amount of trips the driver has
     */
    private double accumulatedMiles(ArrayList<Trip> trips) {
        double miles = 0;
        for (Trip trip : trips) {
            miles += trip.getMilesTraveled();
        }
        return miles;
    }
    /**
     * A method that adds a trip to the droves trips arraylist
     * Updates the total miles driven
     * Updates the average speed of all the drivers trips
     *
     * @param trip A trip that the driver has drove
     */
    public void addTrip(Trip trip) {

        if (trip.getDriverName().equals(this.driverName)) {
            this.trips.add(trip);
            this.totalMiles += trip.getMilesTraveled();
            this.avgSpeed = getAvgSpeed();
        } else {
            throw new java.lang.RuntimeException("The following trip is not for this specific driver");
        }
    }

    /**
     * A method that generates the drivers report (driveName: totaMiles @ avgSpeed)
     *
     */
    public String generateDriverReport() {
        return this.driverName + ": " + this.totalMiles + " miles @ " + this.avgSpeed + " mph";
    }

}

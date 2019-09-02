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
    private String driverName;
    private double totalMiles;
    private double avgSpeed;
    private ArrayList<Trip> trips;

    public Driver(String driverName) {
        this.driverName = driverName;
        totalMiles = 0;
        avgSpeed = 0;
        trips = new ArrayList<Trip>();
    }

    //Getters and Setters for member props in Driver

    public String getDriverName() {
        return this.driverName;
    }

    public double getTotalMiles() {
        return this.totalMiles;
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
        try {
            addTripValues(trip);
        } catch (InvalidTripException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that generates the drivers report (driveName: totaMiles @ avgSpeed)
     */
    public String generateDriverReport() {
        if (this.totalMiles == 0) {
            return this.driverName + ": " + 0 + " miles";
        }
        return this.driverName + ": " + Math.round(this.totalMiles) + " miles @ " + Math.round(this.avgSpeed) + " mph";
    }

    /**
     * Updating trip values
     *
     * @param trip A trip that the driver has drove
     */
    private void addTripValues(Trip trip) throws InvalidTripException {
        if (trip.isValid()) {
            this.trips.add(trip);
            this.totalMiles += trip.getMilesTraveled();
            this.avgSpeed = getAvgSpeed();
        } else {
            throw new InvalidTripException("The follow trip doesn't meet the correct requirements, \n either this is the wrong driver: (" +
                    trip.getDriverName() + ") or it doesn't follow the speed parameters: (" + (trip.getMilesTraveled() / trip.getTripDuration()) + ") mph");
        }
    }
}

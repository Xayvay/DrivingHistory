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
    private int totalMiles;
    private int avgSpeed;
    private ArrayList<Trip> trips;

    public Driver(String driverName) {
        this.driverName = driverName;
        totalMiles = 0;
        avgSpeed = 0;
        trips = new ArrayList<Trip>();
    }

    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setTotalMiles(int totalMiles) {
        this.totalMiles = totalMiles;
    }

    public int getTotalMiles() {
        return this.totalMiles;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public ArrayList<Trip> getTrips() {
        return this.trips;
    }

    private int getAvgSpeed() {
        return accumulatedMiles(this.trips) / accumulatedHours(this.trips);
    }

    private int accumulatedHours(ArrayList<Trip> trips) {
        int hours = 0;
        for (Trip trip : trips) {
            hours += trip.getTripDuration();
        }
        return hours;
    }

    private int accumulatedMiles(ArrayList<Trip> trips) {
        int miles = 0;
        for (Trip trip : trips) {
            miles += trip.getMilesTraveled();
        }
        return miles;
    }

    public void addTrip(Trip trip) {

        if (trip.getDriverName().equals(this.driverName)) {
            this.trips.add(trip);
            this.totalMiles += trip.getMilesTraveled();
            this.avgSpeed = getAvgSpeed();
        } else {
            throw new java.lang.RuntimeException("The following trip is not for this specific driver");
        }
    }

    public void addTrips() {

    }

    public String generateDriverReport() {
        return "";
    }

}

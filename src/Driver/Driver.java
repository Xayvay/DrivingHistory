package Driver;


import Trip.Trip;

import java.util.ArrayList;

/**
 *
 * <h1>Driver</h1>
 * The Driver Object, meant for creating instances of a driver.
 * Will set driver information for each driver
 *
 * @author  Xavier Shelton
 * @version 1.0
 * @since   2019-08-15
 *
 */
public class Driver {
    private String driverName = "";
    private int miles;
    private int speed ;
    private ArrayList<Trip> trips;

    public Driver(String driverName){
        this.driverName = driverName;
        miles = 0;
        speed = 0;
        trips = new ArrayList<Trip>();
    }

    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName(){
        return this.driverName;
    }

    public void setTotalMiles(int totalMiles){
        this.miles = totalMiles;
    }

    public int getTotalMiles(){
        return this.miles;
    }

    public void setTotalSpeed(int totalSpeed){
        this.speed = totalSpeed;
    }

    public int getTotalSpeed(){
        return this.speed;
    }

    public void setTrips(ArrayList<Trip> trips){
        this.trips = trips;
    }

    public ArrayList<Trip> getTrips(){
        return this.trips;
    }

}

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
    private int totalMiles;
    private int avgSpeed ;
    private ArrayList<Trip> trips;

    public Driver(String driverName){
        this.driverName = driverName;
        totalMiles = 0;
        avgSpeed = 0;
        trips = new ArrayList<Trip>();
    }

    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName(){
        return this.driverName;
    }

    public void setTotalMiles(int totalMiles){
        this.totalMiles = totalMiles;
    }

    public int getTotalMiles(){
        return this.totalMiles;
    }

    public void setTotalSpeed(int totalSpeed){
        this.avgSpeed = totalSpeed;
    }

    public int getTotalSpeed(){
        return this.avgSpeed;
    }

    public void setTrips(ArrayList<Trip> trips){
        this.trips = trips;
    }

    public ArrayList<Trip> getTrips(){
        return this.trips;
    }

    public int getAvgSpeed(){
        return this.avgSpeed/this.totalMiles;
    }
    
    private  int accumulatedHours(){
        return 0;
    }

    private int accumulatedMiles(){
        return 0;
    }

    public  void addTrip(Trip trip){

    }

    public  void addTrips(){

    }

    public  String generateDriverReport(){
        return "";
    }
}

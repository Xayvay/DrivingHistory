package Trip;

import java.util.Date;

/**
 *
 * <h1>Trip</h1>
 * The Trip Object, meant for creating instances of a trip.
 * Will set Trip information
 *
 * @author  Xavier Shelton
 * @version 1.0
 * @since   2019-08-15
 */
public class Trip {
    String driverName;
    Date startDate;
    Date endDate;
    int tripDuration;
    int milesTraveled;


    Trip(String driverName,Date startDate,Date endDate,int milesTraveled){
        this.driverName = driverName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripDuration = 0;
        this.milesTraveled = milesTraveled;
    }


    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName(){
        return this.driverName;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public void setTripDuration(int tripDuration){
        this.tripDuration = tripDuration;
    }

    public int getTripDuration(){
        return this.tripDuration;
    }

    public void setMilesTraveled(int milesTraveled){
        this.milesTraveled = milesTraveled;
    }

    public int getMilesTraveled(){
        return this.milesTraveled;
    }
}

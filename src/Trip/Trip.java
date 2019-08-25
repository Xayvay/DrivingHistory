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
    Date startTime;
    Date endTime;
    int tripDuration;
    int milesDriven;


    Trip(String driverName,Date startTime,Date endTime,int milesDriven){
        this.driverName = driverName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripDuration = 0;
        this.milesDriven = milesDriven;
    }


    public void setDriveName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName(){
        return this.driverName;
    }

    public void setStartDate(Date startDate){
        this.startTime = startDate;
    }

    public Date getStartDate(){
        return this.startTime;
    }

    public void setEndDate(Date endDate){
        this.endTime = endDate;
    }

    public Date getEndDate(){
        return this.endTime;
    }

    public void setTripDuration(int tripDuration){
        this.tripDuration = tripDuration;
    }

    public int getTripDuration(){
        return this.tripDuration;
    }

    public int getMilesTraveled(){
        return this.milesDriven;
    }
    
    public boolean isValid() {
        return false;
    }

    public int convertToHours(Date time) {
        return 0;
    }
}

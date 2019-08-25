# Driving History

Driving History is a java application that will process an input file (.txt) with information based on a driver/s. The application will filter through the list of information and print out a new file with the driver/s name,how many miles they have drove, and their average speed.

# Initial Key Observations

- The code will process an input file.
- Each line in the input file will start with a command. 
- There are two possible commands:
1. The first command is Driver, which will register a new Driver in the app. Example:
   Driver Dan
2. The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example:
   Trip Dan 07:15 07:45 17.3
- Discard any trips that average a speed of less than 5 mph or greater than 100 mph.
- Generate a report containing each driver with total miles driven and average speed. 
- Sort the output by most miles driven to least. 
- Round miles and miles per hour to the nearest integer.

# Coding Process

From first glance it seems like I need a:
- Main Class
- Driver Class
- Trip Class
- Report Class

Now going back to my initial key observations it seems like I want to be able to process an input file.
Debating if I want this functionality in main or reports or in its own utils class called file processor or something of that nature.

Created a FileProcessor class that will process the file in and utilize the Driver,Trip, and Reports class, also created an inputStream for reading the files.

### ReportProcessor class

I changed my fileprocessor class to reportsprocessor because it is ultimately processing a report with the correct driving history.
It will need to:

- Read a file
- Determine all the key drivers without duplicates
- Determine the trips that the key drivers may have
- Record everything on Reports
- Spit our results on console or in output file... or both.

While staring at my fileReader method for awhile. It was safe to determine that I can parse each of these lines into their correct "silo" of Driver and Trip. Yet I didnt want to overload these objects with methods so I created a DriverService and TripService class.

This class will initialize the Driver and Trip classes and then i'll add getters and setters for the Driver and Trip Objects.

### DriverService class

Created this class to add a driver to the drivers ArrayList. Simple service for adding new drivers when a parsed Driver line is given.

### TripService class

Created this class to add a drivers trip. This will look for the driver and see if the driverName in the parse trip like matches a driver in our drivers ArrayList

### Driver class

Took me some time to really figure out what exactly the driver class needed. I initially put the getters and setters as well as the driver name, total miles, average speed, and trips. These are the common qualities for a driver provided in my key observations.

This will also mean that I need a way to get the average speed, total miles, and trips.Okay but I need the trips first to get any of these. I mean if I could simply set these values that would be ideal but, that is not the ask for this project. So really I dont need some of these setter methods that I precreated.( I actually lied I will use these setter methods for testing purposes)

I do need a method for adding trips and I also need a way to filter through those trips. So I will create an add trip method and an addTrips method. Seperating these duties once again to make the code cleaner.

Before I move forward. I want to determine if there is anything else that maybe needed by the driver. Well, the driver will have all the correct data needed to be recorded on the report. I mean they own their own hours,miles,avgSpeed,etc show they should also write their input on the report. Thus,I created a generateDriverReport method for finally recording the drivers properties.

Now to get average speed I need to have an accumulation of miles and hours.(mph)
Seperating these duties into their own methods I created the accumulateMiles method and accumalateHours method.

After going over my driver class it seems pretty much done at the moment so I wanted to move forward with my trips service. 
Which lead me to clean up a few methods I thought I needed in the past but do not need now. Since I am not filter through the entire document at once. I dont need to have an addTrips method. I can simply add trips for each driver when I run into it. Thank you past me for making it possible to do either or. Now I want to test to confirm the driver and the trips serive is working fine. I will create a same text file for testing and create junits.

### 

         


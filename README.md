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

While starring at my fileReader method for awhile. It was safe to determine that I can parse each of these lines into their correct "silo" of Driver and Trip. Yet I didnt want to overload these objects with methods so I created a DriverService and TripService class.

Adding getters and setters for the Driver and Trip Objects

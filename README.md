# Driving History

Driving History is a java application that can process input data based on a driver and the trips they take. Once processed the application will output driver data that contains the miles a driver has driven, and their average speed. If multiple driver information is provided. Then the application will output each driver with their information from descending order based on miles driven.

# How To Deploy
Driving History is wrapped into a .gitbundle
You deploy this onto your computer by:
* Downloading the git bundle XavierSheltonDrivingHistory.gitbundle
* Opening your command prompt (windows) or terminal (mac).
* Navigating to the location that you want the repo to be located (i.e.: cd Desktop)
* Run: git clone $somewhere/XavierSheltonDrivingHistory.gitbundle 
(i.e.: git clone Downloads/XavierSheltonDrivingHistory.gitbundle)
* Navigate to new repo location (i.e.: cd Desktop/XavierSheltonDrivingHistory)

# How To Run
FYI: I compiled the project with java jdk-12.0.2

When running the appliction with an intellij built project. You would want to navigate to the Main class within the production folder. From terminal or command prompt you want to:

- Navigate to the project director if you're not already there (i.e.: $somewhere/XavierShelton)
- Navigate into Driving History Project Folder (i.e.: cd out/production/DrivingHistory)

 From here you can run in the terminal or command prompt:
 
* java Main (This will run the application without arguments, You will be able to insert a text file or correct driver data)
* java Main $somefilelocation/somefile.txt (This will run the applcation with an input file i.e.: java Main exampleInput.txt)

# The Coding Process

### Initial Key Observations

- The code will process an input file. You can *either* choose to accept the input via stdin (e.g. if you're using Ruby cat input.txt | ruby yourcode.rb), or as a file name given on the command line
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

#### From First Glance

I can make this application in two classes with about 4 methods and 300 lines of code.
This was my initial thought, and to be honestly this was what I thought the first time I submitted this coding sample.
Well this time I want to actually think this through.

From past experiences, I have worked on different applications that delt with microservices. Which in short is building the applications as a collection of different smaller services rather than one whole app. Hmmm, without building a database for storing data,creating a restcontroller to retrieve that data, and consuming the rest calls from the front end. How will I follow this process? Well I can treat each object as their own service and call towards them and their methods when needed. I can make it very similar to MVC where I have my model objects, my main view, and the services as controllers?

WHY NOT BOTH?!

Breaking this up the best way possible:

* Main Class
* Driver Package - Driver Service and Drive Object
* Trip Package - Trip Service and Trip Object
* Report Package - Report Service and Report Object
* ReportProcessor Package - ReportProcessor Service

Now going back to my initial key observations it seems like I want to be able to process an input file. It does also say that you can choose to accept the input via stdin. I know initially the application says to accept an input.txt file but I am not sure if we can assume that correct input into the console as data cannot also be processed (maybe a stretch...Scope creep). It also says either, which can be interepreted as either this or that, or either or. 

Therefore, I will create 2 ways that a user can input data:
* Insert inputFile.txt into command line
* Insert directly into the console  after running application either by an input.txt file or correctly formatted driver data.

Next I am debating if I want this functionality in main or reports or in its own processing class called report processor or something of that nature.

Created a ReportProcessor class that will process the file in and utilize the Driver,Trip, and Reports class, then generate output onto the console for instant viewing and a file for later.

### ReportProcessorService Class

#### Naming Matters
I initially created a class called my FileProcessor but I changed it to ReportProcessorService because it is ultimately a microservice that will processing input data, then I will call multiple services to update the input data, and finally generate a report with the correct driving history.

THIS WILL BE MY IVORY TOWER!!
(of my microservices)

It will need to:

- Read in input
- Determine all the key drivers without duplicates
- Determine the trips that the key drivers may have
- Record everything on Reports
- Spit our results on console or in output file... or both.

#### File Reader

I need a way to read an input file from the user. If an input file is received, then read it in line by line and send it to a parser.

#### System Input

If user input on console. Read in system input line by line and send it to parsing.

#### Parsing

It was safe to determine that I can parse each of these lines into their correct "silo" of Driver or Trip. Yet I didnt want to simply create a new driver/trip object into my report processor everytime I needed to add a new one. So I create a DriverService and TripService class that would do that for me. When a line is parsed the parseLine method is called which will select the correct service to run.

#### Write Output

After the implementation of the Driver And Trip classes I want to start implementation on the Report class.
To do this I first would like to be able to output this data on a file within a filewriter method. In which the file writer method will call another method called obtain reports. The obtainReports method will then call the reportService to add a report to the file.

#### System Output

I think I should also be able to see the results on the console as well. I mean when we say report what do we actually mean? I think a report can be a multitude of things but ultimately its a detailed account or statement. So lets be a descriptive as possible and provide the user will many ways to review their results.

#### Processing Report

I need a method that can determine the input from the user and then spit out the generated report. It will Call the file reader method or the system input method. Then a generate report with the write output and system output methods.

### DriverService Class

The DriverService Class will function as a microservice for adding new drivers when a parsed Driver line is given.

### TripService Class

The TripService Class will funtion as a microservice that will add a trip to the designated driver. This will look for the driver and see if the driverName in the parsed Trip line matches a driver in our drivers ArrayList

### Driver Class

Took me some time to really figure out what exactly the driver class needed. I initially put the getters and setters as well as the driver name, total miles, average speed, and trips. These are the common qualities for a driver provided in my key observations.

This will also mean that I need a way to get the average speed, total miles, and trips.Okay but I need the trips first to get any of these. I mean if I could simply set these values that would be ideal but, that is not the ask for this project. So really I dont need some of these setter methods that I precreated.

I do need a method for adding trips and I also need a way to filter through those trips. So I will create an add trip method and an addTrips method. Seperating these duties once again to make the code cleaner.

Before I move forward. I want to determine if there is anything else that maybe needed by the driver. Well, the driver will have all the correct data needed to be recorded on the report. I mean they own their own hours,miles,avgSpeed,etc show they should also write their input on the report. Thus,I created a generateDriverReport method for finally recording the drivers properties.

Now to get average speed I need to have an accumulation of miles and hours.(mph)
Seperating these duties into their own methods I created the accumulateMiles method and accumalateHours method.

After going over my driver class it seems pretty much done at the moment so I wanted to move forward with my trips service. 
Which lead me to clean up a few methods I thought I needed in the past but do not need now. Since I am not filter through the entire document at once. I dont need to have an addTrips method. I can simply add trips for each driver when I run into it. Thank you past me for making it possible to do either or. Now I want to test to confirm the driver and the trips serive is working fine. I will create a sample text file for testing and create junits.

After imnproving my junit, I wanted to have a better way to model issues with possible input scenarios that may occur.
So I added my own exception called InvalidTripException.

### Trip Class

With the Trip class I created pre determined methods based off of my initial key observations. Similar to the Driver class. These methods consist of getters and setters for the class members as well as a method to get the duration of a trip (how long it took), get the miles traveled in a trip, is the trip even a valid trip, and convert the trip time to hours.

After initially struggling with the setup of my Driver class; I think it is safe to say that by mapping out all that was asked from the beginning into methods allowed me to architect the structure of this application fairly well. Other than building an application model diagram I think that this would be a great practice to use when mapping out future stories.

Anyway,My first thought is to confirm that a trip is valid. Since I initially put this in my Trip class, I wanted the trips to be able to determine if they're valid or not.So inside of my isValid trip method I am going to check any trips that average a speed of less than 5 mph or greater than 100 mph. If any of these cases are true then RETURN FALSE!

Well, To determine if something is valid I need to get the mph, which also means I have to calculate the tripduration, and miles traveled.

With getTripDuration I would like to return the Date Time in hours. I will first update the convertToHours method which will call in one DateTime and return a long of hours. Then I will call that within getTripDuration.

3 hours later this took me a very long time to figure out why my test cases were failing and its because in Java the milliseconds obtained are the milliseconds between the desired epoch and 1970-01-01 00:00:00. So I was getting values 2 times greater than what I desired. When I subtract the duration this will be resolved so no isses. I can also add the value of 18000000 yet I am not sure when or if this will ever change so I left this in and tested the values expected.

Was able to add testcases for getTripduration now. Assuming that the values are rounded correctly I should be able to move forward. If this does not work as expected I will have to improve the convertToHours method.

The next logical step is to now see if I can validate if the trip is successful. I will do this by converting my miles received to a long and rounded it. As explained from the documentation and then dividing that by the tripDuration. Then finally checking if  the value false within mph < 5 || mph > 100 if so then its false else true.

While testing I didnt like how my values were coming out even though they made since I personally did not like it so I added the startingDateMillis to my convertToHours method. This makes my testcases look a little more appealing. Also, added test cases for TestService whih lead me to remove a lot of the getters and setters from the Driver and Trip classes that I am not using at this point

Now I initially feel like I have completed the Trip and Driver class so I will create testcases for my addTrips method and generateReport method.

WHOA! Good thing I am testing this I just realize I didnt add my isValid to the addTrips check. Now I am able to further improve my test cases.

While improving test cases I still did not like the way that my convertToHours method functioned. So I updated the Date data type to LocalTime. Which allowed me to improve how this method looked and how the test looked.

### ReportService Class

The ReportService Class will function as a microservice for creating new reports with correctly formatted driver history on it.

### Report Class

Creating the Reports Class was almost a breeze. While working through this project, I made it a priority to test and develope as soon as I created a new method. I would say I did TDD development but if I knew what I exactly wanted to do then I did not use TDD. I guess I didn't ultimately use TDD to its core but I used TDDSS (Test Driven Development's Step Sibling) or a loosly related form of TDD. Anyway, this allowed me to feel confident that everything technically worked and I just needed to spit out the results some how.

When I think about the driver they basically own the trips. The driver has trips because if we have a trip without a driver then what are we actually trying to explain? With that being said. The report basically owns the drivers. I cant have a report on driving history. If I am not reporting any drivers. 

This made it really easy for me to determine what I want in this class.
* I need to get the driver report
* Organize the drivers for output
* PRINT ALL THE THINGS... I mean drivers.

Completing this task was also very easy except for the record driver output method.
I wanted to create the driver output at this moment. The problem is that I took a foreach look against each driver object.
Then created a string buffer to append the output together.

I DONT LIKE THIS!!

Yet I am not quite sure how else I can accomplish what is needed.
I also don't know if its more important to be threadsafe or fast. (I mean obviously safer is better)
I went with StringBuffer instead of StringBuilder because being thread safe seemed more important.

### Main Class

Now that im done, basically. My main class can check for what input is coming from the user. Either an input file or nothing.
If the user inserts an input file path ending with .txt. The program will call our ivory tower ReportProcessorService.processReport(args[0]). This will call the fileReader method for reading files.
If no input is provided. The application will call ReportProcessorService.processReport("") Which will trigger the systemInputReader.

Run the code...

GREAT SUCCESS!

### Testing

As explained previously, I have been building my test cases while simultaneously building my classes. This allowed me to know how well I was progressing in a successful manner.

When creating my test cases. I first wanted to confirm that I was meeting the desired requirements. Good input, valid trips, good output.

Then I tried to cover all edge cases (That I could think of). For example:
* If the trip is at the end of the day will it go past 24 hours?
* How well is the trip rounding if time is at :59 or :01?
* Are we calculating correct input or throwing correct errors?

Finally, since I am using intellij for my application. I was able to see how much test coverage I have. 
I created as many test that I could, until my entire application was 100% method covered and 100% line covered.

### What I Could Improve

Many things.
Beside creating the application with a DB,restcontrollers, etc.
I could have:
* Mapped the project out better. Architecture is key in this kind of assignment and sometimes it is hard to articulate what you want to accomplish.
* Created cleaner code. I feel like I wanted to push myself into doing things that I basically didn't do. I used higher order functions in swift but I barely utilized the lambda notation and optionals in java. This was cool but very difficult to grasp at first.
* Handling input. I really think its important to have a product owner or someone who is there to talk to you about what they need. When I initially started this project I read it as an input file is needed. With that being said, there are many times that one can miss interpret any kind of input as "this is me filing input" So I possibly created more than I should have, but I still covered all possibly scenarios that I could think of.
* Test Cases. It is hard to think of everything that you should test. I mean if it feel like it works and you covered everything. You will ignore that you are possibly missing edge cases. I still feel like there are many edge cases that I could create. (i.e.: what if someone used negative time? like why would I test for that? Yet maybe I should)
* Read Me. I have a scatter brain, so even though it is easy for me to explain my process. I ramble. A LOT!
* Commits. I could have improved my commits in a more straight forward fashion of what functionality is within them.

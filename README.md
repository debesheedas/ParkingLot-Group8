# ParkingLot-Group8

This repository consists of multiple .java files containing class and enum declarations. 
.class files also exist and may cause conflicts so please compile all the files individually once to make sure you have the right version of the .class files for everything

We have used SQLite to manage the database.
Please use and sqlite browser such as DB Browser for SQLite to view the data and its interaction with the system
You may download this browser from the following link if you wish
https://sqlitebrowser.org/
Some data has already been filled in the datatbase to make demonstration of features and evaluation more convenient 
Compile and run the files Test4.java, Test5.java and test6.java to interact with the system as
an Admin, Employee and Customer respectively

The JDBC driver has been included in the repository but please use the following commands to make sure it is included in your path

for Windows, use the following commands in the command prompt to run the testing code in file Test4.java

javac Test4.java
java -classpath ".;JDBC/sqlite-jdbc-3.7.2.jar" Test4

for Non Windows, use the following commands in the terminal to run testing code for file Test4.java

javac Test4.java
java -classpath ".:JDBC/sqlite-jdbc-3.7.2.jar" Test4

Similaryly do the same for Test5.java and Test6.java

Main feautures

For safety and clarity the system allows for only 1 admin. 
Please use Admin username: admin
and password: password
when logging in as admin
The Admin can change all Settings of the Parking Lot,
1. Number of Floors, How many of each type spots in each floor
2. Price for each type of Spot, with variation based on time as well
3. Can login and log out
4. Can add or remove employees from the system
5. Can add or remove Checkpoints such as Entry points, Exit points and Info Portals from the System
6. Can modify the Proce of electricity to be charged per hour at the Electric Panels
7. All other powers of Employees and Customers

The Employee, after logging in 
1. Can get assigned to a particular Checkpoint, where he performs his duty for the day
2. Can Pay his dues if any
3. Can change his password
4. Can park his car at non-duty hours by behaving like a customer

The Customer can Go to any checkpoint by entering its ID
1. At EntryPoint, by informing his ParkingSpot Type requirement, the ParkingLot is searched for the closest suitable Spot and is available, a Ticket with uniques is generated and stored in Database. 
2. At Info portal he can pay for his tecket in advance. If he pays now, then his Ticket status us changed to isPaid but his Spot id not freed
3. At ExitPoint if his Ticket is already paid then his Spot is made available and Ticket deleted from database. Otherwise, he must pay and then his Spot is freed.

A great amount of flexibility is allowed by this system and it mirrors real life situations.
Since a GUI starts a different thread of execution, please close the GUI after you have finished entering whatever you need to enter. The data you entered will be saved in the database and will be made aavailable to you when you re run the program by loading into instance variables using loadDatabase() method of Database class. When using the Admin Options GUI, dont forget to CLICK THE SAVE CHANGES BUTTON to save your changes to the Database. 
Notice the use of the ADD FLOOR and REMOVE FLOOR button which changes the display and that the GUI testfields pre-load the existing data of the database.
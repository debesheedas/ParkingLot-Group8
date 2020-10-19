//Aashrith
//Handling information exchange between database inout output and program

class Database{

    //every time admin options are changed, reset the whole database
     boolean databaseExists()
     {
        //return true if the database with same name as ParkingLotDatabase, basically check if database exists
     }
     void setupDatabase()//if database does not exist already
     {
         
         //if no then continue in this method
         //create a default admin object and then call methods on it - with hardcoded standard password
         //call admin methods - Customer.java - such as sign in, followed by changeSettings method(only if admin login is successful)
         //create Database named ParkingLotDatabase
         //create the tables, initalise the slots with their unique ids and types
     }
     void loadData()
     {
         //read data from existing database, accordingly create all required objects 
     }
     //individual methods to update particular tables

     void updateAll()
     {
        //call all the individual update methods to update all the tables
     }
    
    
}
//one database for the entire program - check if database of given name already exist, otherwise run the setup database module
//one database for the entire parking lot.
//one table for employees
//one table for slots
//whenever program is launched, read data from existing databases and create all the objects java and assign all the values
//use these created objects throughout the program and update the database at regular intervals - code to update database should be in this file
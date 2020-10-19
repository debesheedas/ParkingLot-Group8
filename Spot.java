//Jaswanth
public enum ParkingSpotType 
{
    COMPACT, LARGE, HANDICAPPED, TWOWHEELER, ELECTRIC
}

class Spot
{
    int id;
    String name;//generate an alphanumeric sequence such as 5C04 where 5 stands for 5th floor, C stands for compact and 04 is the id number of the spot, use L for large, H for handicapped, T for Twowheeler and E for electric
    ParkingSpotType t;
    double[] prices;
    int floor;
    boolean isAvailable;

    
}

class ElectricPanel
{
    //connect it with the UI
    //associate it with slots that have electric panel
    double computeBill(Time start, Time stop)
    {
        // by calling the difference function from Time class you will get time of electricity used in hours as a double data type
        //compute bill using 
        //return stop-start; 
    }

}

class Floor
{
    int[] NumberOfSpots = new int[10];
    ArrayList<EntryPoint> entryPoint = new ArrayList();
    ArrayList<ExitPoint> exitPoint = new ArrayList();
    ArrayList<InfoPortal> infoportal = new ArrayList();}

class Ticket{
    int ID;
    Spot s; //Spot allotted
    Time entry;
    Time exit;
    boolean isPaid;
    String VehicleNumberPlate;
    void AddtoDatabase()
    {
        //whenever a ticket is created it is added to the database in case the program is closed before the the car leaves the parking lot

    }
    
    void setEntryTime()
    {

    }
    void setStopTime()
    {

    }
    double computeBill()
    {
        return billAmount;//use appropriate information from instance variables and calculate bill
    }
    void changeIsPaid(boolean status)
    {

    }
    //pay ticket - after payment, delete ticket from database
    
}

class EntryPoint
{
    int ID;
    String name;
    int floorNumber;
    void userInput()
    {
        //take user input using scanner for vehicle numberplate and slot type required and set the instance variables
        //once GUI is made, this will be replaced with calling the GUImethod
    }
    int searchForSpot(ParkingSpotType t)
    {
        //return floor (preferably closest to entry point) on which corresponding parking spot is avaiable
    }
    void generateTicket()
    {
        //call user input method
        //call search for spot method, if available
        //take vehicle number plate 
        //create Ticket object and add to the list in ParkingLot class using setter method
        //update corresponding database methods - tickets table and floors table
    }
    
}
class ExitPoint
{
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
    }

    void checkTicket()
    {
        Ticket t = ;//call userInput
        //check if ticket is paid, if not paid, call pay ticket and change isPaid status of ticket, if paid, modify available spots - free the spot
        //update corresponding database tables by calling the corresponding methods



    }
    void PayTicket()
    {
        //call computeBill method
        //change paid status
    }


}
class InfoPortal{
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
    }

    void checkTicket()
    {
        Ticket t = ;//call userInput
        //call payTicket if ticket exists and is not paid yet


    }
    void PayTicket()
    {
        //call computeBill method
        //change paid status
    }

}
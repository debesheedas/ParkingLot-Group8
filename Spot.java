//Jaswanth
import java.util.*;
enum ParkingSpotType 
{
    COMPACT, LARGE, HANDICAPPED, TWOWHEELER, ELECTRIC
}

class Spot//write a parameterized constructor for  this to initialize the variables as follows
{
    int id; 
    String name;//generate an alphanumeric sequence such as 5C04 where 5 stands for 5th floor, C stands for compact and 04 is the id number of the spot, use L for large, H for handicapped, T for Twowheeler and E for electric
    ParkingSpotType t;
    //double[] prices;
    int floor;
    boolean isAvailable;

    Spot(int id, ParkingSpotType t, int floor, boolean status)
    {
        //assign all values as directed
    }



class Floor
{
    int[] NumberOfSpots = new int[10];//if the name of this array is arr, then arr[0]=number of total compact spots, arr[1] = number of available compact spots and so on
    ArrayList<Spot> allSpotsOnthisFloor = new ArrayList<Spot>();
}

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
    //whenever you need the difference between two time objects t1 and t2 in hours, then just call double difference = exit.diff(entry);
    void setEntryTime()
    {
        entry = new Time();
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
class Checkpoint
{
    int ID;
    String name;
    Employee assigned;
    int floorNumber;//here write getter and setter methods for all instance variables after declaring them protected
}
class EntryPoint extends Checkpoint
{
    void run()
    {
        //call userInput()
        //then call generateticket()
    }
    void userInput()
    {
        //take user input using scanner for spot type required 
        
    }
    Spot searchForSpot(ParkingSpotType t)
    {
        // use the method getAllFloors() to get an ArrayList of all Floors. Now use the getter methods of Floor class to otain information on which Spots on each Floor are Avaiable
        //if the spot type is available on some floor, create a Spot object with parameterized constructor to initialize it
        //to choose an id number for the Spot that you are creating, use the ArrayList of Spots on each Floor to find the smallest ID value which is not occupied
        //return Spot of specified ParkingSpotType on some floor (preferably closest to entry point) on which corresponding parking spot is avaiable
    }
    void generateTicket(ParkingSpotType t)
    {
        Spot temp = this.searchForSpot(t);
        if(temp!=null)//basiclaly if suitable spot is available
        {
            //take vehicle number plate through Scanner
        //create Ticket object and add to the list in ParkingLot class using setter method
        //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed

        }       
    }
    
}


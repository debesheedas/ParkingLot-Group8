//Jaswanth
import java.util.*;
enum ParkingSpotType 
{
    COMPACT, LARGE, HANDICAPPED, TWOWHEELER, ELECTRIC
}

public class Spot//write a parameterized constructor for  this to initialize the variables as follows
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
        int n;
        char c ='\0';
        this.id = id;
        this.t = t;
        this.floor = floor;
        isAvailable = status;
        switch (this.t) {
            case COMPACT -> c = 'C';
            case LARGE -> c = 'L';
            case ELECTRIC -> c = 'E';
            case TWOWHEELER -> c = 'T';
            case HANDICAPPED -> c = 'H';
            default -> System.out.println("Invalid ParkingSpot Type");
        }
        name = (this.floor+""+c+""+String.valueOf(this.id/10)+String.valueOf(this.id%10));
        System.out.println(name);
    }
}




class EntryPoint extends Checkpoint {
    Scanner Ep = new Scanner(System.in);
    ParkingSpotType t;
    void run()
    {
        //call userInput()
        //then call generateticket()
        userInput();
        generateTicket(t);
    }
    void userInput()
    {
        //take user input using scanner for spot type required
        System.out.println("All spotTypes : LARGE , COMPACT , ELECTRICAL , TWOWHEELER , HANDICAPPED");
        System.out.println("Enter the required spot type : ");
        String str = Ep.next().toUpperCase();
        t = ParkingSpotType.valueOf(str);
    }
    Spot searchForSpot(ParkingSpotType t)
    {
        // use the method getAllFloors() to get an ArrayList of all Floors. Now use the getter methods of Floor class to obtain information on which Spots on each Floor are Available
        //if the spot type is available on some floor, create a Spot object with parameterized constructor to initialize it
        //to choose an id number for the Spot that you are creating, use the ArrayList of Spots on each Floor to find the smallest ID value which is not occupied
        //return Spot of specified ParkingSpotType on some floor (preferably closest to entry point) on which corresponding parking spot is available


        ParkingLot P = new ParkingLot();
        ArrayList<Floor> floors = P.getAllFloors();
        for (Floor floor : floors){
            if (t == ParkingSpotType.COMPACT)
                floor.getNumberOfAvailableCompactSpots();
            else if (t == ParkingSpotType.LARGE)
                floor.getNumberOfAvailableLargeSpots();
            else if (t == ParkingSpotType.ELECTRIC)
                floor.getNumberOfAvailableElectricalSpots();
            else if (t == ParkingSpotType.TWOWHEELER)
                floor.getNumberOfAvailableTwowheelerSpots();
            else if (t == ParkingSpotType.HANDICAPPED)
                floor.getNumberOfAvailableHandicappedSpots();
        }
        getFloorNumber();
    }
    void generateTicket(ParkingSpotType t)
    {
        Spot temp = this.searchForSpot(t);
        if(temp!=null){//basically if suitable spot is available

                //take vehicle number plate through Scanner
                //create Ticket object and add to the list in ParkingLot class using setter method
                //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed
            System.out.println("Enter the number of vehicleNumberPlate : ");
            T.VehicleNumberPlate = Ep.next();
        }
    }

}


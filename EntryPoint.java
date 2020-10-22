import java.util.ArrayList;
import java.util.Scanner;

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
            ArrayList<Spot> spots = floor.getAllSpotsOnthisFloor();
            for(Spot s:spots){
                if(s.getSpotType() == t){
                    return s;
                }
            }
        }
        System.out.println("Spot not found");
    }
    void generateTicket(ParkingSpotType t)
    {
        Ticket T = new Ticket();
        Spot temp = this.searchForSpot(t);
        if(temp!=null){//basically if suitable spot is available

                //take vehicle number plate through Scanner
                //create Ticket object and add to the list in ParkingLot class using setter method
                //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed
            System.out.println("Enter the number of vehicleNumberPlate : ");
            T.VehicleNumberPlate = Ep.next();
            setAllTickets(T);
        }
    }

}
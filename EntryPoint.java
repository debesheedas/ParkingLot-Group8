import java.util.ArrayList;
import java.util.Scanner;

class EntryPoint extends Checkpoint {
    Scanner Ep = new Scanner(System.in);
    //private ParkingSpotType t;
    //private Spot s;
    private ParkingLot pl;
    EntryPoint(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.ENTRY, floorNo);
        pl=p;
        /*super.pl=p;
        super.ID = id;
        super.name = nm;
        super.type = Checkpoint.ENTRY;
        super.assignedEmployeeID=0;
        super.floorNumber = floorNo;*/


    }
    /*
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
        System.out.println("All spotTypes :  COMPACT , LARGE , ELECTRIC , TWOWHEELER , HANDICAPPED");
        System.out.println("Enter the required spot type : \n press corresponding number for required type");
        System.out.println("1-COMPACT \n 2-LARGE \n 3-ELECTRIC \n 4-TWOWHEELER \n 5-HANDICAPPED");
        int num = Ep.nextInt();
        switch(num){
            case 1:t = ParkingSpotType.COMPACT;
                break;
            case 2:t = ParkingSpotType.LARGE;
                break;  
            case 3:t = ParkingSpotType.ELECTRIC;
                break;
            case 4:t = ParkingSpotType.TWOWHEELER;
                break;
            case 5:t = ParkingSpotType.HANDICAPPED;
                break;  
            default:System.out.println("INVALID NUMBER !!");
                break;        
        }
    }
    Spot searchForSpot(ParkingSpotType t)
    {
        // use the method getAllFloors() to get an ArrayList of all Floors. Now use the getter methods of Floor class to obtain information on which Spots on each Floor are Available
        //if the spot type is available on some floor, create a Spot object with parameterized constructor to initialize it
        //to choose an id number for the Spot that you are creating, use the ArrayList of Spots on each Floor to find the smallest ID value which is not occupied
        //return Spot of specified ParkingSpotType on some floor (preferably closest to entry point) on which corresponding parking spot is available
        //Floor floor;
        ArrayList<Floor> floors = pl.getAllFloors();
        for (Floor floor : floors){
            ArrayList<Spot> spots = floor.getAllSpotsOnthisFloor();
            for(Spot s:spots){
                if(s.getSpotType() == t){
                    return s;
                }
            }
        }
        if(s.isAvailable())
            s = new Spot(s.getID(), t,getFloorNumber(), true);
         return s;
    }
    void generateTicket(ParkingSpotType t)
    {   
        Ticket T;
        Ticket tc = null;
        Spot temp = this.searchForSpot(t);
        if(temp!=null){//basically if suitable spot is available

                //take vehicle number plate through Scanner
                //create Ticket object and add to the list in ParkingLot class using setter method
                //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed
            System.out.println("Enter the number of vehicleNumberPlate : ");
            String vehicleNumberPlate = Ep.nextLine();
            int id = pl.returnTicketByID(tc);
            T = new Ticket(super.pl, id+1, temp, vehicleNumberPlate);
            pl.addTicket(T);
            tc = T;
        }
    }
    */
}
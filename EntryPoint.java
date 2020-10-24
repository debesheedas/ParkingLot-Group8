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
    
    void run()
    {
        generateTicket(userInput());
    }
    
    ParkingSpotType userInput()
    {
        //take user input using scanner for spot type required
        System.out.println("All spotTypes :  COMPACT , LARGE , ELECTRIC , TWOWHEELER , HANDICAPPED");
        System.out.println("Enter the required spot type : \n Press corresponding number for required type");
        System.out.println("1-COMPACT \n 2-LARGE \n 3-ELECTRIC \n 4-TWOWHEELER \n 5-HANDICAPPED");
        try
        {
            int num = Integer.parseInt(Ep.nextLine());
            switch(num){
            case 1:
                return ParkingSpotType.COMPACT;
                //break;
            case 2:
                return ParkingSpotType.LARGE;
                //break;  
            case 3:
                return ParkingSpotType.ELECTRIC;
                //break;
            case 4:
                return ParkingSpotType.TWOWHEELER;
                //break;
            case 5:
                return ParkingSpotType.HANDICAPPED;
                //break;  
            default:System.out.println("INVALID NUMBER !! Assuming COMPACT!!");
                return ParkingSpotType.COMPACT;
                //break;        
            }
            

        }
        catch(Exception e)
        {
            System.out.println("Please enter some valid input and try again");
            return ParkingSpotType.COMPACT;
        }
        
    }
    Spot searchForSpot(ParkingSpotType t)
    {
        int n = super.getFloorNumber();
        int total = pl.getAllFloors().size();
        if(total<=0)
        return null;
        Floor f = pl.getAllFloors().get(0);
        int counter=0;
        for(int i=n; counter<total; i++, counter++)
        {
            f = pl.getAllFloors().get((i-1)%total);
            int num = 0;
            switch(t)
            {
                case COMPACT:
                    num = f.getNumberOfAvailableCompactSpots();
                    break;
                case LARGE:
                    num = f.getNumberOfAvailableLargeSpots();
                    break;
                case HANDICAPPED:
                    num = f.getNumberOfAvailableHandicappedSpots();
                    break;
                case TWOWHEELER:
                    num = f.getNumberOfAvailableTwowheelerSpots();
                    break;
                case ELECTRIC:
                    num = f.getNumberOfAvailableElectricalSpots();
                    break;
            }
            if(num>0)
            {
                break;
            }
            
        }
        if(counter==total)
        {
            return null;
        }
        ArrayList<Spot> spots = f.getAllSpotsOnthisFloor();
            for(Spot s:spots){
                if(s.isAvailable()&& s.getSpotType() == t)
                {   
                    s.setIsAvailable(false);
                    return s;
                }
            }
        return null;
        //Floor f = pl.getAllFloors().get(n-1);
        // use the method getAllFloors() to get an ArrayList of all Floors. Now use the getter methods of Floor class to obtain information on which Spots on each Floor are Available
        //if the spot type is available on some floor, create a Spot object with parameterized constructor to initialize it
        //to choose an id number for the Spot that you are creating, use the ArrayList of Spots on each Floor to find the smallest ID value which is not occupied
        //return Spot of specified ParkingSpotType on some floor (preferably closest to entry point) on which corresponding parking spot is available
        //Floor floor;
        /*ArrayList<Floor> floors = pl.getAllFloors();
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
         */
    }
    void generateTicket(ParkingSpotType t)
    {   
        //Ticket T;
        //Ticket tc = null;
        Spot spot = this.searchForSpot(t);
        if(spot!=null)
        {//basically if suitable spot is available

                //take vehicle number plate through Scanner
                //create Ticket object and add to the list in ParkingLot class using setter method
                //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed
            System.out.println("Enter the number of vehicleNumberPlate : ");
            String vehicleNumberPlate = Ep.nextLine();
            Ticket last = pl.getAllTickets().get(pl.getAllTickets().size()-1);
            int id = last.getID()+1;
            Ticket T = new Ticket(pl, id, spot, vehicleNumberPlate);
            //int id = pl.returnTicketByID(tc);
            
            //T = new Ticket(super.pl, id+1, temp, vehicleNumberPlate);
            pl.addTicket(T);
            System.out.println("Ticket has been generated. Ticket ID: "+T.getID());
        }
        else
        {
            System.out.println("Sorry, no spot available in the ParkingLot for your Spot Type");

        }
    }
    
}
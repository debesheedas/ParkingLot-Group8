import java.util.ArrayList;
import java.util.Scanner;

class EntryPoint extends Checkpoint {
    Scanner Ep = new Scanner(System.in);
    private ParkingLot pl;
    EntryPoint(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.ENTRY, floorNo);
        pl=p;
    }
    
    void run()
    {
        generateTicket(userInput());
    }
    
    ParkingSpotType userInput()
    {
        System.out.println("All spotTypes :  COMPACT , LARGE , ELECTRIC , TWOWHEELER , HANDICAPPED");
        System.out.println("Enter the required spot type : \n Press corresponding number for required type");
        System.out.println("1-COMPACT\n2-LARGE\n3-ELECTRIC\n4-TWOWHEELER\n5-HANDICAPPED");
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
    Spot searchForSpot(ParkingSpotType t)//this method searches the whole ParkingLot, finds and returns a Spot object for the closest available SPot of the required type, starting at the same floor as this entry point
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
                    f.decrementAvailableSpots(s.getSpotType());
                    s.setIsAvailable(false);
                    return s;
                }
            }
        return null;
        
    }
    void generateTicket(ParkingSpotType t)
    {  
        Spot spot = this.searchForSpot(t);
        if(spot!=null)
        {
            System.out.println("Enter the number of vehicleNumberPlate : ");
            String vehicleNumberPlate = Ep.nextLine();
            int id;
            if(pl.getAllTickets().size()==0)
                id=1;
            else
            {
                Ticket last = pl.getAllTickets().get(pl.getAllTickets().size()-1);
                id = last.getID()+1;
            }
            
            Ticket T = new Ticket(pl, id, spot, vehicleNumberPlate);
            pl.addTicket(T);
            System.out.println("Ticket has been generated. Ticket ID: "+T.getID());
        }
        else
        {
            System.out.println("Sorry, no spot available in the ParkingLot for your Spot Type");

        }
    }
    
}
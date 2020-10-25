import java.util.Scanner;

class ExitPoint extends Checkpoint
{
    Scanner sc = new Scanner(System.in);
    ParkingLot pl;
    ExitPoint(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.EXIT, floorNo);
        pl=p;
    }

    void run()
    {
        checkTicket(userInput());
    }
    Ticket userInput()
    {
        System.out.println("Enter your Ticket ID");
        try
        {
            int id = Integer.parseInt(sc.nextLine());
            return pl.returnTicketbyID(id);
        }
        catch(Exception e)
        {
            System.out.println("please enter a valid choice");
        }
        
        return null;
    }
    void checkTicket(Ticket t)
    {
        //If the ticket is already paid previously at the Infor Portal, then the Spot availability will be modified and Ticket will be removed from the System   
        if(t.getIsPaid()==false)
        {
            payTicket(t);
        }
        else
        {
            freeSpot(t);
        }

    }
    
    void payTicket(Ticket t)
    {
        System.out.println("Your bill amount is: "+t.computeBill());
        System.out.println("Press 1: To Pay by Cash\nPress 2: To Pay with Card");
        try{
            int n = Integer.parseInt(sc.nextLine());
            switch(n)
            {
                case 1:
                System.out.println("Paying with Cash");
                break;
                case 2:
                System.out.println("Paying with Card");
                break;
                default:
                System.out.println("Invalid Option. Assuming payment by cash");
            }
            t.changeIsPaid(true);
            freeSpot(t);

        }
        catch(Exception e)
        {
            System.out.println("Please enter a valid choice");
        }
        
    }
    void freeSpot(Ticket t)
    {
        t.getSpot().setIsAvailable(true);
        int n = t.getSpot().getFloorNo();
        Floor f = pl.getAllFloors().get(n-1);
        f.incrementAvailableSpots(t.getSpot().getSpotType());
        pl.removeTicket(t);

    }
}

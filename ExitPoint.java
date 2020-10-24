import java.util.Scanner;

//Anand
class ExitPoint extends Checkpoint
{
    Scanner sc = new Scanner(System.in);
    
    //Ticket t = new Ticket(0,null, null);
    ParkingLot pl;
    //Floor f = new Floor(null, 0);
    //int id;
    //boolean isPaid = true;
    ExitPoint(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.EXIT, floorNo);
        pl=p;
        /*super.pl=p;
        super.ID = id;
        super.name = nm;
        super.type = Checkpoint.EXIT;
        super.assignedEmployeeID=0;
        super.floorNumber = floorNo;*/


    }

    void run()
    {
        //call userInput()
    
        checkTicket(userInput());
        
    }
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
        System.out.println("Enter your Ticket ID");
        try
        {
            int id = Integer.parseInt(sc.nextLine());
            return pl.returnTicketbyID(id);
        }
        catch(Exception e)
        {
            System.out.println("Please enter a valid choice");
        }
        
        return null;
    }
    void checkTicket(Ticket t)
    {
        
        if(t.getIsPaid()==false)
        {
            payTicket(t);
        }

    }
    
    void payTicket(Ticket t)
    {
        //call computeBill method
        //change paid status
        //modify spots, free the corresponding spot by modifying the instance variables of ParkingLot -  Floor list and Ticket List
        System.out.println("Your bill amount is: "+t.computeBill());
        System.out.println("Press 1: To Pay by Cash\nPress 2: To Pay with Card");
        try{
            int n = Integer.parseInt(sc.next());
            t.changeIsPaid(true);
            t.getSpot().setIsAvailable(true);
        }
        catch(Exception e)
        {
            System.out.println("Please enter a valid choice");
        }
        
    }
}

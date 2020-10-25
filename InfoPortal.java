import java.util.*;
public class InfoPortal extends Checkpoint
{
    Scanner sc = new Scanner(System.in);
    ParkingLot pl;
    InfoPortal(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.INFO, floorNo);
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
            System.out.println("Please enter a valid option");
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
        System.out.println("For how many hours you want to pay?");
        try
        {
            double b = Double.parseDouble(sc.nextLine());
            System.out.println("Your bill amount is: "+t.computeBill(b));
            t.changeIsPaid(true);
        
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid number of hours");
        }
    }
}

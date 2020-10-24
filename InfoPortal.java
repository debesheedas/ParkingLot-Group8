import java.util.*;
public class InfoPortal extends Checkpoint
{
    //double t;
    Scanner sc = new Scanner(System.in);
    //boolean isPaid = true;
    //int id;
    ParkingLot pl;
    InfoPortal(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, CheckpointType.INFO, floorNo);
        pl=p;
        /*super.pl=p;
        super.ID = id;
        super.name = nm;
        super.type = Checkpoint.INFO;
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
        //call userInput
        //call payTicket if ticket exists and is not paid yet
        // use scanner to ask for how many hours user wishes to pay...prepaid basically
    }
    //compute bill - write a local method here called double computeBill(double hours) which takes input as number of hours entered by user
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

        //call computeBill method
        //change paid status
        
    }
   
}

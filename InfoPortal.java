import java.util.*;
public class InfoPortal extends Checkpoint
{
    //double t;
    //Scanner sc = new Scanner(System.in);
    //boolean isPaid = true;
    int id;
    InfoPortal(ParkingLot p, int id, String nm, int floorNo)
    {
        super(p, id, nm, Checkpoint.INFO, floorNo)
        /*super.pl=p;
        super.ID = id;
        super.name = nm;
        super.type = Checkpoint.INFO;
        super.assignedEmployeeID=0;
        super.floorNumber = floorNo;*/


    }
/*
    void run()
    {
        //call userInput()
        id = userInput();
        checkTicket(id);
    }
    int userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
        System.out.println("Enter your Ticket ID");
        id = sc.nextInt();
        return id;
    }
    void checkTicket(int id)
    {
        for(Ticket tk : p.getAllTickets())
        {
            if(id == tk.getID())
            {
                isPaid = false;
                tk.changeIsPaid(false);
            }
        }
        //call userInput
        //call payTicket if ticket exists and is not paid yet
        // use scanner to ask for how many hours user wishes to pay...prepaid basically
        if(!isPaid)
        {
            payTicket();
            System.out.println("For how many hours you want to pay?");
            t = sc.nextDouble();
        }
    }
    //compute bill - write a local method here called double computeBill(double hours) which takes input as number of hours entered by user
    void payTicket()
    {
        //call computeBill method
        //change paid status
        computeBill(t);
        isPaid = true;
        tk.changeIsPaid(true);
    }
    double computeBill(double hours)
    {
        //Copy-paste from computeBill in Ticket class;
        return 0.0;
    }
    */
}

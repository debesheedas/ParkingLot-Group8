import java.util.Scanner;

//Anand
class ExitPoint extends Checkpoint
{
    Scanner sc = new Scanner(System.in);
    Ticket t = new Ticket();
    ParkingLot p = new ParkingLot();
    int id;
    boolean isPaid = true;
    void run()
    {
        //call userInput
        //call checkTicket
        //if not paid, based on check Ticket, call payTicket
        int id = userInput();
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
        for(Ticket ts : p.allTickets)
        {
            if(id == ts.ID)
            {
                isPaid = false;
                t.changeIsPaid(false);
            }
        }
        //check if ticket is paid, if not paid, call pay ticket and change isPaid status of ticket, if paid, modify available spots - free the spot
        //update corresponding database tables by calling the corresponding method
        //arraylist of all floors
        //check in your spot which belongs to your ticket, which floor it is, x , spot has an ID, and it should be there in this floor - remove it
        if(isPaid)
        {
            //check which floor this spot is on, let it be f
            //call f.freeSpot(spot obj)
            int f = t.s.floor;
            f.freeSpot(t.s);
        }
        else
        {
            payTicket();
        }
    }
    void payTicket()
    {
        //call computeBill method
        //change paid status
        //modify spots, free the corresponding spot by modifying the instance variables of ParkingLot -  Floor list and Ticket List
        t.computeBill();
        isPaid = true;
        t.changeIsPaid(true);
        int f = t.s.floor;
        f.freeSpot(t.s);
    }
}
class InfoPortal extends Checkpoint
{
    ParkingLot p = new ParkingLot();
    Ticket tk = new Ticket();
    double t;
    Scanner sc = new Scanner(System.in);
    boolean isPaid = true;
    int id;
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
        for(Ticket tk : p.allTickets)
        {
            if(id == tk.ID)
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
        double billAmount;
        if (hours <= 1)
            billAmount = hours * p.spotPrice[0];
        else if (hours > 1 && hours <= 2)
            billAmount = hours * p.spotPrice[1];
        else
            billAmount = hours * p.spotPrice[2];
        return billAmount;
    }
}

import java.util.Scanner;

//Anand
class ExitPoint extends Checkpoint
{
    Scanner sc = new Scanner(System.in);
    Ticket t = new Ticket(0,null, null);
    ParkingLot p = new ParkingLot();
    Floor f = new Floor(null, 0);
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
        for(Ticket ts : p.getAllTickets())
        {
            if(id == ts.getID())
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
            //int f = t.getSpot().getFloorNo();
            //f.freeSpot(t.getSpot());
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

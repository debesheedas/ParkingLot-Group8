
//Anand
class ExitPoint extends CheckPoint
{
    Ticket t = new Ticket();
    int id;
    public boolean isPaid = true;
    void run()
    {
        //call userInput
        //call checkTicket
        //if not paid, based on check Ticket, call payTicket
        Ticket t = userInput();
        checkTicket(t);
    }
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
        System.out.println("Enter your Ticket ID");
        id = sc.nextInt();
        for(Ticket t : allTickets)
        {
            if(id == t.id) //getter method from class Floor
            {
                isPaid = false;
                t.changeIsPaid(false);
                return t;
            }
        }
    }

    boolean checkTicket(Ticket t)
    {
        Ticket t = userInput();
        //check if ticket is paid, if not paid, call pay ticket and change isPaid status of ticket, if paid, modify available spots - free the spot
        //update corresponding database tables by calling the corresponding method
        if(isPaid)
        {

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
        computeBill();
        isPaid = true;
        t.changeIsPaid(true);
    }
}
class InfoPortal extends Checkpoint
{
    Time t;
    Scanner sc = new Scanner(System.in);
    void run()
    {
        //call userInput()
        userInput();
    }
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
        System.out.println("Enter your Ticket ID");
        id = sc.nextInt();
        for(Ticket tk : allTickets)
        {
            if(id == t.id) //getter method from class Floor
            {
                isPaid = false;
                t.changeIsPaid(false);
                return tk;
            }
        }
    }

    void checkTicket()
    {
        Ticket t = userInput();//call userInput
        //call payTicket if ticket exists and is not paid yet
        // use scanner to ask for how many hours user wishes to pay...prepaid basically
        if(!isPaid)
        {
            payTicket();
            System.out.println("For how many hours you want to pay?");
            t = sc.next();
        }
    }
    //compute bill - write a local method here called double computeBill(double hours) which takes input as number of hours entered by user
    void PayTicket()
    {
        //call computeBill method
        //change paid status
        computeBill(t);
        isPaid = true;
        t.changeIsPaid(true);
    }
    double computeBill(double hours)
    {

    }
}

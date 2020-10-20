
//Anand
class ExitPoint extends CheckPoint
{
    void run()
    {
        //call userInput
        //call checkTicket
        //if not paid, based on check Ticket, call payTicket
    }
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
    }

    boolean checkTicket(Ticket t)
    {
        Ticket t = ;
        //check if ticket is paid, if not paid, call pay ticket and change isPaid status of ticket, if paid, modify available spots - free the spot
        //update corresponding database tables by calling the corresponding method


    }
    void PayTicket()
    {
        //call computeBill method
        //change paid status
        //modify spots, free the corresponding spot by modifying the instance variables of ParkingLot -  Floor list and Ticket List
    }


}
class InfoPortal extends Checkpoint
{
    void run()
    {
        //call userInput()
    }
    Ticket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
    }

    void checkTicket()
    {
        Ticket t = ;//call userInput
        //call payTicket if ticket exists and is not paid yet
        // use scanner to ask for how many hours user wishes to pay...prepaid basically
    }
    //compute bill - write a local method here called double computeBill(double hours) which takes input as number of hours entered by user
    void PayTicket()
    {
        //call computeBill method
        //change paid status
    }

}
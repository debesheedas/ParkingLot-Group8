//Anand
class Customer
{
    
    void run()
    {
        //menu driven what do you want to do
        //Go to
        //1. Entry point
        //Enter entry point ID via Scanner - call generate Ticket method on corresponding entry point object by searching list of entry points by unique entry point ID
        //2. Exit point
        //call check ticket method
        //3. Info Portal
        // call checkTicket method

    }
    
}
class Employee extends Customer{

    void run()
    {
        //menu driven, login method
        //if successful, ask if they want to park or pay
        //if they want to pay, call amount due
        //if they want to park, call super.run
        //think about how to implement the keeping record of the employees bill amount...we probably cannot use the customer methods
        //probably writing completely different methods might be better

    }


    
     void payAmountDue()
     {
         //ask if paying by cash or card
         //update the database for the particular employee
     }
}

class Admin implements Employee
{
    private String password;
    void changePassword();
    boolean loginstatus;

    void run()
    {
        //run sign in or login method, if successful, next, run menu driven loop to choose options from 
        // 1. Admin options - changing parking lot settings
        // 2. Change password
        // 3. Add or remove employees
        // 4. 
        //make methods for each of the above options
    }
    boolean signIn()
    {	//take input
        //check password is correct or not
        //call a GUI method
	    //return true or false based on if login is successful
    }
    void changeSettings()
    {
        //as of now, write scanner methods to take input and set the instance variables of ParkingLot
        //GUI methods or classes callen Admin Options
    }
    

}

class System
{
    //call display method
    void Display(int floor)
    {
        //print in command line the complete display for the particular floor, will be replaced with GUI once made
    }

}


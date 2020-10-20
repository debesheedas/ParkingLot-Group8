//PM Case Study 1 Parking Lot
//Navjoth

import java.util.*;


public class PMCS1
{
    public static void main(String args[])
    {
        System.out.println("Hello");
        test s = new test();
        s.print();
        ParkingLot obj = new ParkingLot();
        obj.run();
        

    }
}

class Time
{
    Date d = new Date(System.currentTimeMillis());
    double diff(Time entry)//this method returns the difference in time between the 2 date objects as a double data type, useful for calculating bill amounts
    {
        //return the difference in time between (this.d-entry.d) ;
    }
}
class ParkingLot
{
    Database db = new Database();
    Admin admin = new Admin();//consider making this static
    ArrayList<Employee>  employeeList = new ArrayList<Employee>();
    ArrayList<Ticket> allTickets = new ArrayList();
    ArrayList<Checkpoint> allCheckpoints = new ArrayList();
    ArrayList<Floor> allFloors = new ArrayList<Floor>();
    double priceOfElectricityPerHour;
    double[] compactPrices = new double[3];
    double[] largePrices = new double[3];
    double[] handicappedPrices = new double[3];
    double[] twowheelerPrices = new double[3];
    double[] electricPrices = new double[3];

    //get full employee list method should return an array or arraylist of employee objects
    //search by id and return employee method get
    //add employee method - set 
    //delete employee - set
    ArrayList<Employee> allEmployees()
    {
        return employeeList;
    }
    boolean addEmployee(Employee e)
    {
        //first check if employee with this ID already exists - method to search by id
        //if it already exists return false
        //if it does not exist already, then 
        employeeList.add(e);
        return true;
    }
    boolean searchEmployeeByID(Employee e)
    {
        int id = e.getID();
        for loop to go through the entire array list
        {
            check if id==employeelist(i).getID();
            return true;
        }
        return false;
    }


    //Array list of entry points exit points and info portals basically an arraylist of all checkpoints
    //write getter and setter methods for each of the instance variables of this class
    
    void run()
    {
        
        //just call db.setupDatabase(); 
        //call db.loadDatabase();
        
        //write a menu driven program, while loop to test the program
        /*
        boolean y;//take input through Scanner
        while(y)
        {
            //display the menu here
            y = userInput
            db.updateDatabase();
        }
        *Provide options such as are you admin, employee or customer
        write a switch case
        case 1 if admin
        admin.run
        case 2 if employee
        employee.run
        case 3 if customer
        customer.run
        before closing the loop, like just before terminating each iteration, call the update all method


        *
        *
        */
    }
    //call update all tables method from Database.java here again before terminating the program

}


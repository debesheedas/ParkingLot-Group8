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
        return (this.d.getTime()-entry.d.getTime())/3600000;//return the difference in time between (this.d-entry.d) ;
    }
}
class ParkingLot
{
    Database db = new Database();
    Admin admin = new Admin();//consider making this static
    private ArrayList<Employee>  employeeList = new ArrayList<Employee>();
    private ArrayList<Ticket> allTickets = new ArrayList();
    private ArrayList<Checkpoint> allCheckpoints = new ArrayList();
    private ArrayList<Floor> allFloors = new ArrayList<Floor>();
    private double priceOfElectricityPerHour;
    private double[] compactPrices = new double[3];
    private double[] largePrices = new double[3];
    private double[] handicappedPrices = new double[3];
    private double[] twowheelerPrices = new double[3];
    private double[] electricPrices = new double[3];

    //get full employee list method should return an array or arraylist of employee objects
    //search by id and return employee method get
    //add employee method - set 
    //delete employee - set
    public ArrayList<Employee> getAllEmployees()
    {
        return employeeList;
    }


    boolean addEmployee(Employee e)
    {
        //first check if employee with this ID already exists - method to search by id
        if (searchEmployeeByID(e))
            return false;
        //if it already exists return false
        //if it does not exist already, then
        getAllEmployees().add(e);
        return true;
    }
    boolean searchEmployeeByID(Employee e)
    {
        int id = e.getID();
        for (Employee i : employeeList )
        {
             if (id == i.getID())
                 return true;
        }
        return false;
    }
    boolean searchEmployeeByUsername(String username, String password)
    {

        for(Employee emp : employeeList)
        {
            if(username.equals(emp.getUsername()) && password.equals(emp.getPassword()))//getusername() and getpassword() to be provided in class Employee
            {
                return true;
            }
        }
        return false;
    }

    Employee returnEmployeeByUsername(String username, String password)
    {

        for(Employee emp : employeeList)
        {
            if(username.equals(emp.getUsername()) && password.equals(emp.getPassword()))
            {
                return emp;
            }
        }
        return null;
    }

    public ArrayList<Floor> getAllFloors() {
        return allFloors;
    }


    public ArrayList<Checkpoint> getAllCheckpoints() {

        return allCheckpoints;
    }

    public double[] getCompactPrices() {
        return compactPrices;
    }

    public double[] getLargePrices() {
        return largePrices;
    }

    public double[] getHandicappedPrices() {
        return handicappedPrices;
    }

    public double[] getTwowheelerPrices() {
        return twowheelerPrices;
    }

    public double[] getElectricPrices() {
        return electricPrices;
    }

    //Array list of entry points exit points and info portals basically an arraylist of all checkpoints
    //write getter and setter methods for each of the instance variables of this class
    
    void run()
    {
        
        //just call db.setupDatabase();
        db.setupDatabase();
        //call db.loadDatabase();
        db.loadDatabase();

        //write a menu driven program, while loop to test the program
        /*
        boolean y;//take input through Scanner
        while(y)
        {
            //display the menu here
            y = userInput
            db.updateDatabase();
        }
        *Provide options such as are you admin, employee or customer basically similar to the main method Anand has written in Customer.java, atleast for now
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


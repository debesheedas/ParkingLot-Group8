//PM Case Study 1 Parking Lot
//Navjoth

import java.util.*;
import java.lang.*;


public class PMCS1
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
        ParkingLot obj = new ParkingLot();
        obj.run();
        

    }
}


class ParkingLot
{
    Database db = new Database();
    Admin admin = new Admin();//consider making this static
    private ArrayList<Employee>  employeeList = new ArrayList<Employee>();
    private ArrayList<Ticket> allTickets = new ArrayList<>();
    private ArrayList<Checkpoint> allCheckpoints = new ArrayList<>();
    private ArrayList<Floor> allFloors = new ArrayList<>();
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
    //Array list of entry points exit points and info portals basically an arraylist of all checkpoints
    //write getter and setter methods for each of the instance variables of this class
    public ArrayList<Employee> getAllEmployees()
    {
        return employeeList;
    }

    void setEmployees(ArrayList<Employee> e)
    {
        employeeList = e;
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

    public ArrayList<Ticket> getAllTickets() {
        return allTickets;
    }

    public void setTickets(ArrayList<Ticket> t) {
        allTickets = t;
    }

    public void removeTicket(Ticket t){
        getAllTickets().remove(t);
    }
    public void addTicket(Ticket t){
        getAllTickets().add(t);
    }

    public boolean searchTicket(Ticket t){
        int id = t.getID();
        for(Ticket i: allTickets ){
            if(id == i.getID())
                return true;
        }
        return false;
    }

    public int returnTicketByID (Ticket t){
        if (searchTicket(t))
            return t.getID();
        return 0;
    }

    public ArrayList<Checkpoint> getAllCheckpoints() {

        return allCheckpoints;
    }
    public void setCheckpoints(ArrayList<Checkpoint> c){
        allCheckpoints = c;
    }
    public void removeChekpoint(Checkpoint c){
        getAllCheckpoints().remove(c);
    }
    public void addCheckpoint(Checkpoint c){
        getAllCheckpoints().add(c);
    }

    public ArrayList<Floor> getAllFloors() {

        return allFloors;
    }
    public void setFloors(ArrayList<Floor> f){

        allFloors = f;
    }
    public void removeFloor(Floor f){
        getAllFloors().remove(f);
    }
    public void addFloor(Floor f){
        getAllFloors().add(f);
    }


    public double[] getCompactPrices() {
        return compactPrices;
    }
    public void setCompactPrices(double[] p)
    {
        for(int i=0; i<3; i++)
        {
            compactPrices[i] = p[i];
        }
    }

    public double[] getLargePrices() {
        return largePrices;
    }
    public void setLargePrices(double[] p)
    {
        for(int i=0; i<3; i++)
        {
            largePrices[i] = p[i];
        }
    }

    public double[] getHandicappedPrices() {
        return handicappedPrices;
    }
    public void setHandicappedPrices(double[] p)
    {
        for(int i=0; i<3; i++)
        {
            handicappedPrices[i] = p[i];
        }
    }

    public double[] getTwowheelerPrices() {
        return twowheelerPrices;
    }
    public void setTwowheelerPrices(double[] p)
    {
        for(int i=0; i<3; i++)
        {
            twowheelerPrices[i] = p[i];
        }
    }
    public double[] getElectricPrices() {
        return electricPrices;
    }
    public void setElectricPrices(double[] p)
    {
        for(int i=0; i<3; i++)
        {
            electricPrices[i] = p[i];
        }
    }

    void run()
    {
        
        //just call db.setupDatabase();
        //db.setupDatabase();
        //call db.loadDatabase();
        db.loadDatabase(this);

        Scanner scan = new Scanner(System.in);
        boolean y = scan.nextBoolean();
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


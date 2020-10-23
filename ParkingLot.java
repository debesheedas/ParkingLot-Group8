import java.util.*;

public class ParkingLot
{
    Database db = new Database(this);
    Admin admin = new Admin(this);//consider making this static
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
    

    Admin getAdmin()
    {
        return admin;
    }
    double getPriceOfElectricityPerHour()
    {
        return priceOfElectricityPerHour;
    }
    void setPriceOfElectricityPerHour(double p)
    {
        priceOfElectricityPerHour=p;
    }

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
        employeeList.add(e);
        return true;
    }
    boolean removeEmployee(Employee e)
    {
        //first check if employee with this ID already exists - method to search by id
        if (searchEmployeeByID(e))
        {
            employeeList.remove(e); 
            return true;  
        }
            return false;
        
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

    ArrayList<Ticket> getAllTickets() {
        return allTickets;
    }

    void setTickets(ArrayList<Ticket> t) {
        allTickets = t;
    }

    boolean removeTicket(Ticket t){
        for(Ticket i: allTickets){
            if(t.getID() == i.getID())
            {
                allTickets.remove(t);
                return true;
            }       
        }
        return true;
        
    }
    boolean addTicket(Ticket t){
        for(Ticket i: allTickets){
            if(t.getID() == i.getID())
                return false;
        }
        allTickets.add(t);
        return true;
    }

    boolean searchTicketbyID(int id){
        for(Ticket i: allTickets){
            if(id == i.getID())
                return true;
        }
        return false;
    }
    //probably wont need this, not tested yet
    int returnTicketByID (Ticket t){
        if (searchTicketbyID(t.getID()))
            return t.getID();
        return 0;
    }


    ArrayList<Checkpoint> getAllCheckpoints() {

        return allCheckpoints;
    }
    void setCheckpoints(ArrayList<Checkpoint> c){
        allCheckpoints = c;
    }
    boolean removeChekpoint(Checkpoint c){
        for(Checkpoint i: allCheckpoints)
        {
            if(c.getID()==i.getID())
            {
                allCheckpoints.remove(c);
            return true;
            } 
        }
        return false;
        
    }
    boolean addCheckpoint(Checkpoint c){
        for(Checkpoint i: allCheckpoints)
        {
            if(c.getID()==i.getID())
            {
                return false;
            }
        }
        allCheckpoints.add(c);
        return true;
    }
    Checkpoint searchCheckpointByID(int id)
    {
        for(Checkpoint i: allCheckpoints)
        {
            if(id==i.getID())
            {
                return i;
            }
        }
        return null;
    }


    ArrayList<Floor> getAllFloors() {

        return allFloors;
    }
    void setFloors(ArrayList<Floor> f){

        allFloors = f;
    }
    boolean removeFloor(Floor f){
        for(Floor i:allFloors)
        {
            if(f.getFloorNo()==i.getFloorNo())
            {
                allFloors.remove(f);
                return true;
            }
        }
        return false;        
    }
    boolean addFloor(Floor f){
        for(Floor i:allFloors)
        {
            if(f.getFloorNo()==i.getFloorNo())
            {
                return false;
            }
        }
        allFloors.add(f);
        return true;  
    }
    Floor searchFloorByFloorNo(int no)
    {
        for(Floor i:allFloors)
        {
            if(no==i.getFloorNo())
            {
                return i;
            }
        }
        return null; 
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
        System.out.println("Enter run");
        //db.loadDatabase(this);//loading data into objects from existing database if exists, else setting up database
        /*Spot s = new Spot(this, 1, ParkingSpotType.COMPACT, 1, true);
        System.out.println(s);
        //Scanner scan = new Scanner(System.in);
        //boolean y = scan.nextBoolean();
        //setting up parkingLot by entering Admin Options
        //call AdminOPtionsGUI
        Employee e = new Employee(this, 1,"Username", "pass", 0.0);
        employeeList.add(e);
        System.out.println(e.toString());
        */
        //db.updateDatabase(this); //updates database before terminating the program

        
    
    }
   
}





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
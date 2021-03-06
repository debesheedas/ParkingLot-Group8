import java.util.*;
public class Admin extends Employee {
    ParkingLot pl;
    private String username = "admin";
    private String password = "password";
    boolean loginstatus;
    Scanner sc = new Scanner(System.in);
    

    Admin(ParkingLot p, boolean status)
    {
        super(p, 0, "admin", "password", 0.0, status);
        pl = p;
        username = "admin";
        password = "password";
        loginstatus = status;
    }
    void setLoginStatus(boolean status)
    { 
        this.loginstatus = status; 
    }
    boolean getLoginStatus()
    {
        return loginstatus;
    }
    
    private void addEmp() {
        int id;
        Employee e;
        String name, password;
        try
        {
            System.out.println("Enter id of the employee");
            id = Integer.parseInt(sc.nextLine());
            System.out.println("Enter name of the employee");
            name = sc.nextLine();
            System.out.println("Create a password");
            password = sc.nextLine();
            e = new Employee(pl , id, name, password, 0,false);
            if(pl.addEmployee(e))
                System.out.println("Employee added successfully");
            else
                System.out.println("Unsuccessful. Employee not added becausethis ID already exists.");
        }
        catch(Exception ex)
        {
            System.out.println("Please enter Valid input and try again");
        }
        
    }
    private void removeEmp() {
        int id;
        //show name corresponding to id of the employee
        System.out.println("Enter the ID of the employee to remove");
        try
        {
            id = Integer.parseInt(sc.nextLine());
            if(pl.returnEmployeeByID(id)!=null)
            {
                pl.removeEmployee(pl.returnEmployeeByID(id));
                System.out.println("Employee removed successfully");
            }
        }
        catch(Exception e)
        {
            System.out.println("Please enter Valid input and try again");
        }
        
    }
    private void addOrRemoveEmployee()
    {
        try{
            System.out.println("Press 1: To add Employee\nPress 2: To remove Employee");
            int i = Integer.parseInt(sc.nextLine());
            switch(i)
            {
                case 1: addEmp();
                    break;
                case 2: removeEmp();
                    break;
                default:
                    System.out.println("Please Enter Valid option");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Please enter Valid input and try again");
        }
    }
    private void addCheck() {
        int id, floorNo;
        Checkpoint e;
        String name;
        CheckpointType t;
        try
        {
            System.out.println("Enter id of the Checkpoint");
            id = Integer.parseInt(sc.nextLine());
            System.out.println("Enter name of the Checkpoint");
            name = sc.nextLine();
            System.out.println("Enter floor number within range "+pl.getAllFloors().size());
            floorNo = Integer.parseInt(sc.nextLine());
            System.out.println("Press 1: for EntryPoint\nPress 2: for ExitPoint\nPress 3: for InforPortal");
            int input = Integer.parseInt(sc.nextLine());
            if(floorNo>pl.getAllFloors().size())
            {
                System.out.println("Cannot add checkpoint on this floor because this floor does not exist");
                return;
            }
            
            switch(input)
            {
                case 1:
                    t=CheckpointType.ENTRY;
                    break;
                case 2:
                    t=CheckpointType.EXIT;
                    break;
                case 3:
                    t = CheckpointType.INFO;
                    break;
                default:
                    System.out.println("Please enter valid choice. Assuming Entrypoint");
                    t = CheckpointType.ENTRY;  

            }
            e = new Checkpoint(pl , id , name, t, floorNo);
            if(pl.addCheckpoint(e))
                System.out.println("Checkpoint added successfully");
        }
        catch(Exception ex)
        {
            System.out.println("Please enter Valid input and try again");
        }
        
    }
    private void removeCheck() {
        int id;
        //show name corresponding to id of the employee
        System.out.println("Enter the ID of the checkpoint to remove");
        try
        {
            id = Integer.parseInt(sc.nextLine());
            if(pl.returnCheckpointByID(id)!=null)
            {
                pl.removeCheckpoint(pl.returnCheckpointByID(id));
                System.out.println("Checkpoint removed successfully");
            }
        }
        catch(Exception e)
        {
            System.out.println("Please enter Valid input and try again");
        }
        
    }
    private void addOrRemoveCheckpoint()
    {
        try{
            System.out.println("Press 1: To add Checkpoint\nPress 2: To remove Checkpoint");
            int i = Integer.parseInt(sc.nextLine());
            switch(i)
            {
                case 1: addCheck();
                    break;
                case 2: removeCheck();
                    break;
                default:
                    System.out.println("Please Enter Valid option");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Please enter Valid input and try again");
        }
    }
    void menu(){
        
            System.out.println("Welcome Admin.");
            System.out.println("Press 1: To Login\nPress 2: To Change Admin Options of Parking Lot\nPress 3: To Add/Remove Employees\nPress 4: To add/Remove Checkpoints\nPress 5: To View Floor Display\nPress 6: To LogOut");
            int n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1 : 
                    LoginGUI l = new LoginGUI(pl);
                    l.run(pl);
                    break;
                
                case 2 : 
                    if(loginstatus)
                    {
                        AdminOptionsGUI ao = new AdminOptionsGUI(pl);
                         ao.run();
                    }
                    else
                    {
                        System.out.println("Please Login as Admin before trying to change settings");
                    }
                    break;
                case 3 : 
                    if(loginstatus)
                    addOrRemoveEmployee();
                    else
                    System.out.println("Please Login as Admin before trying to change settings");
                    break;
                case 4:
                    if(loginstatus)
                    addOrRemoveCheckpoint();
                    else
                    System.out.println("Please Login as Admin before trying to change settings");
                    break;
                case 5 : 
                    System.out.println("Total Number of Floors ="+pl.getAllFloors().size());
                    System.out.println("Please enter the Floor Number of the display you want to see");
                    try
                    {
                        int i = Integer.parseInt(sc.nextLine());
                        if(i>0 && i<=pl.getAllFloors().size())
                        {
                            FloorDisplayGUI fd = new FloorDisplayGUI(pl.getAllFloors().get(i-1));
                        }
                        else
                        {
                            System.out.println("Please enter Valid input and try again");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter Valid input and try again");
                    }
                    break;
                    
                case 6 : 
                    this.setLoginStatus(false);
                    break;
                
                default : {
                    System.out.println("Invalid Option");
                }
            }
            pl.getDatabase().updateDatabase();
        
    }
    
    /*
    
    void run()
    {
        //run sign in or login method, if successful, next, run menu driven loop to choose options from
        // 1. Admin options - changing parking lot settings
        // 2. Change password
        // 3. Add or remove employees
        // 4.
        //make methods for each of the above options
        //l.run();
        menu();
    }
    
    private void logOut(){
        setLoginStatus(false);
    }
    private void changePassword() {
        System.out.println("Enter Existing Password");
        String pass = sc.next();
        String pass1, pass2;
        do {
            agn = "no";
            if (checkPassword(pass)) {
                System.out.println("Enter new Password");
                pass1 = sc.next();
                System.out.println("Enter new password again");
                pass2 = sc.next();
                if(pass1.equals(pass2)){
                    System.out.println("Password changed successfully");
                    password = pass1;
                }
                else{
                    System.out.println("Try Again");
                    agn = "yes";
                }
            }
            else {
                System.out.println("Password Wrong\nTry again? (yes/no)");
                agn = sc.next();
            }
        }while(agn.equals("yes"));
    }
    private boolean checkPassword(String pass)
    {
        if(pass.equals(password))   return true;
        return false;
    }
    private void addRemoveEmployee() {
        System.out.println("Press 1: Add Employee\nPress 2: Remove Employee");
        switch (sc.nextInt()) {
            case 1 : {
                addEmp();
                break;
            }
            case 2 : {
                removeEmp();
                break;
            }
            default : {
                System.out.println("Invalid Option");
            }
        }
    }
    
    
    void changeSettings()
    {
        //as of now, write scanner methods to take input and set the instance variables of ParkingLot
        //GUI methods or classes call Admin Options
        System.out.println("Press 1: Add Parking floor\n" +
                "Press 2: Add electric panel\n" +
                "Press 3: Modify Parking Rates\n" +
                "Press 4: Add entrance/exit panel");
        switch (sc.nextInt()) {
            case 1 : {
                addFloor();
                break;
            }
            case 2 : {
                addEpanel();
                break;
            }
            case 3 : {
                modifyRate();
                break;
            }
            case 4 : {
                addPanel();
                break;
            }
            default : {
                System.out.println("Invalid Option");
            }
        }
    }
    private void addFloor() {
        int floor = 3;
        System.out.println("Existing number of floor: " + floor);
        System.out.print("Number of floor to be added: ");
        floor += sc.nextInt();
        System.out.println("Updated number of floor: " + floor);
        //call a method to add spots on that floor
    }

    private void addEpanel() {
        int epanel = 20;
        System.out.println("Existing number of electric panel: " + epanel);
        System.out.print("Number of electric panel to be added: ");
        epanel += sc.nextInt();
        System.out.println("Updated number of electric panel: " + epanel);
    }

    private void modifyRate() {
        int rate = 10;
        System.out.println("Existing Parking rate: " + rate + "/hr");
        System.out.print("Enter new Parking rate (in numeric): ");
        rate = sc.nextInt();
        System.out.println("Updated Parking rate: " + rate + "/hr");
    }

    private void addPanel() {
        int enp = 3, exp = 2;
        System.out.println("Existing number of entrance panel: " + enp);
        System.out.print("Number of entrance panel to be added: ");
        enp += sc.nextInt();
        System.out.println("Existing number of exit panel: " + exp);
        System.out.print("Number of exit panel to be added: ");
        exp += sc.nextInt();
        System.out.println("Updated number of entrance panel: " + enp);
        System.out.println("Updated number of exit panel: " + exp);
    }
    */
}

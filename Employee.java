import java.util.*;

public class Employee extends Customer{
    //Scanner sc = new Scanner(System.in);

    //ParkingLot p = new ParkingLot();
    //Checkpoint cp = new Checkpoint();
    //LoginGUI l = new LoginGUI();
    //ChangePasswordGUI c = new ChangePasswordGUI();

    boolean loginstatus;
    private int id;
    protected String username;
    protected String password;
    double dues;//think about how we can internally increasing

    Employee(ParkingLot pl, int id, String name, String password, double dues, boolean status) 
    {
        super(pl);
        //super.pl=pl;
        loginstatus=status;
        this.id = id;
        this.username = name;
        this.password = password;
        this.dues = dues;
    }
    
    int getID() {
        return id;
    }
    String getPassword() {
        return password;
    }
    double getDues() {
        return dues;
    }
    String getUsername() {
        return username;
    }

    void setID(int id) {
        this.id = id;
    }
    void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String psd){ this.password=psd; }
    public void setDues(double d){ this.dues = d; }
    void setLoginStatus(boolean status)
    {
        this.loginstatus = status;
    }
    
    void run()
    {
        //menu driven, login method
        //if successful, ask if they want to park or pay
        //if they want to pay, call amount due
        //if they want to park, call super.run
        //think about how to implement the keeping record of the employees bill amount...we probably cannot use the customer methods
        //probably writing completely different methods might be better
        //check for password of corresponding ID
        //l.run();
        //could add check floor display to this also
        
        
            System.out.println("Press 1: LogIn\nPress 2: Get assigned to Checkpoint to start Working\nPress 3: Pay dues\nPress 4: Change Password\nPress 5: Park Car (Non-duty hours)\nPress 6: LogOut");
            try
            {
                switch (sc.nextInt()) {
                    case 1 : 
                        LoginGUI l = new LoginGUI(pl);
                        l.run(pl);//both not required, check later
                    
                        System.out.println(loginstatus);
                        break;
                    
                    case 2 : 
                        System.out.println("Please enter the ID of the Checkpoint you would like to go to");
                        int id = Integer.parseInt(sc.nextLine());
                        Checkpoint c = pl.searchCheckpointByID(id);
                        if(c!=null)
                        {
                            c.setAssigned(id);
                            System.out.println("You have been assigned to the checkpoint "+c.getName());
                        }
                        else
                        {
                            System.out.println("No such checkpoint exists");
                        }
                        break;
                        
                    
                    case 3 : 
                        dues=0;
                        System.out.println("Dues paid");
                    case 4 : 
                        ChangePasswordGUI cp = new ChangePasswordGUI();
                        cp.run(this);
                    break;
                
                    case 5 : 
                        super.run();
                        break;    
                    
                    case 6 : 
                        this.setLoginStatus(false);
                        System.out.println("Logged out successfully");
                        break;
                    
                    default : {
                        System.out.println("Invalid Input");
                    }
                }
            
            }
            catch(Exception e)
            {
                System.out.println("Please enter a valid choice");
            }
        
    }
    
    /*
    private void panel() {
        int n;
        System.out.println("Press 1: Entry Point\nPress 2: Exit Point");
        switch(sc.nextInt()){
            case 1: {
                System.out.println("Select a Entry Point");
                n=sc.nextInt();
                cp.setID(id);
                cp.setName(username);
                cp.setAssigned(n);
                //dues() dummy method
                break;
            }
            case 2: {
                System.out.println("Select a Exit Point");
                n=sc.nextInt();
                cp.setID(id);
                cp.setName(username);
                cp.setAssigned(n);
                //dues() dummy method
                break;
            }
            default: {
                System.out.println("Invalid Option");
            }
        }
    }
    private void infoPortal() {
        System.out.println("Your Due is: " + getDues());
    }
    private void changePassword()
    {
        int id, flag=0;
        System.out.println("Enter your ID");
        id = sc.nextInt();
        for (Employee i : p.getAllEmployees() ) 
        {
            if (id == i.getID()) {
                c.run(i);
                flag = 1;
            }
        }
        if(flag==0)     System.out.println("Employee not found");
    }
    
    void payAmountDue()
    {
        //ask if paying by cash or card
        //update the database for the particular employee
        System.out.println("Your Bill Amount is " + getDues());
        System.out.println("Press 1: Cash\nPress 2: Card");
        switch (sc.nextInt()) {
            case 1 : {
                System.out.println("Amount successfully paid");
                break;
            }
            case 2 : {
                System.out.println("Amount successfully paid");
                break;
            }
            default : {
                System.out.println("Invalid Input");
            }
        }
        setDues(0.0);
    }
    private void logout() {
        setLoginStatus(false);
        System.out.println("LogOut Successful");
    }
}
/*
class Dues{
    int d=0;        //Should be made array and initialise in PMCS1 where every index should be for every employee
    public int dues(){      //Whenever it called d should be increased by one
        setD();
        return d*50;
    }
    setD(){d++;}
}*/

}
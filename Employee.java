public class Employee extends Customer{
    
    boolean loginstatus;
    private int id;
    protected String username;
    protected String password;
    double dues;//think about how we can internally increasing

    Employee(ParkingLot pl, int id, String name, String password, double dues, boolean status) 
    {
        super(pl);
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
    boolean getLoginStatus()
    {
        return loginstatus;
    }
    
    void run()
    {
            System.out.println("Press 1: LogIn\nPress 2: Get assigned to Checkpoint to start Working\nPress 3: Pay dues\nPress 4: Change Password\nPress 5: Park Car (Non-duty hours)\nPress 6: LogOut");
            try
            {
                int n = Integer.parseInt(sc.nextLine());
                switch (n) {
                    case 1 : 
                        LoginGUI l = new LoginGUI(pl);
                        l.run(pl);
                        break;
                    case 2 : 
                        if(loginstatus)
                        {
                            System.out.println("Please enter the ID of the Checkpoint you would like to go to");
                        int id = Integer.parseInt(sc.nextLine());
                        Checkpoint c = pl.returnCheckpointByID(id);
                        if(c!=null)
                        {
                            c.setAssigned(this.getID());

                            System.out.println("You have been assigned to the checkpoint "+c.getName());
                        }
                        else
                        {
                            System.out.println("No such ch1eckpoint exists");
                        }
                        break;
                        }
                        else
                        {
                            System.out.println("Please Login before trying to get assigned to Checkpoint for your duty");
                        }
                        
                    
                    case 3 : 
                        if(loginstatus)//this case is kept in for paying dues of Employee which can be accumulated when Employee parks car in the parkingLot during duty hours, for which he gets partial compensation from company
                        {
                            dues=0;
                            System.out.println("Dues paid");
                        }
                        else
                        {
                            System.out.println("Please Login before trying to pay dues");   
                        }
                        
                        break;
                    case 4 : 
                        if(loginstatus)
                        {
                            ChangePasswordGUI cp = new ChangePasswordGUI(pl, this);
                            cp.run();
                        }
                        else
                        {
                            System.out.println("Please Login before trying to change password.");
                        }
                        
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
   
}
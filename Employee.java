import java.util.*;

public class Employee extends Customer{
    ParkingLot p = new ParkingLot();
    Scanner sc = new Scanner(System.in);
    boolean loginstatus = false;
    LoginGUI l = new LoginGUI();
    ChangePasswordGUI c = new ChangePasswordGUI();
    int id;
    String name;
    String password;
    double dues;
    //Employee(int, String, String, double)...............................................................
    Employee(int id, String name, String password, double dues) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dues = dues;
    }
    public int getID() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public double getDues() {
        return dues;
    }
    public String getUsername() {
        return name;
    }

    void run()
    {
        int id;
        String pass;
        //menu driven, login method
        //if successful, ask if they want to park or pay
        //if they want to pay, call amount due
        //if they want to park, call super.run
        //think about how to implement the keeping record of the employees bill amount...we probably cannot use the customer methods
        //probably writing completely different methods might be better
        //check for password of corresponding ID
        l.run();
        do {
            System.out.println("Press 1: Pay dues\nPress 2: Park Vehicle\nPress 3: Display Floor Plan\nPress 4: Check/Exit Point\nPress 5: Info Portal\nPress 6: Change Password\nPress 7: LogOut");
            switch (sc.nextInt()) {
                case 1 : {
                    payAmountDue();
                }
                case 2 : {
                    super.run();
                }
                /*case 3 : {
                    s.Display();
                }*/
                case 4 : {
                    panel();
                }
                case 5 : {
                    infoPortal();
                }
                case 6 : {
                    changePassword();
                }
                case 7 : {
                    logout();
                }
                default : {
                    System.out.println("Invalid Input");
                }
            }
        }while(loginstatus);
    }

    private void panel() {
        int n;
        System.out.println("Press 1: Check Point\nPress 2: Exit Point");
        switch(sc.nextInt()){
            case 1: {
                System.out.println("Select a Check Point");
                n=sc.nextInt();
                System.out.println("You are assigned to Check Point no.: "+n);
            }
            case 2: {
                System.out.println("Select a Exit Point");
                n=sc.nextInt();
                System.out.println("You are assigned to Exit Point no.: "+n);
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
    void setPassword(String pass)
    {
        this.password = pass;
    }
    void setLoginStatus(boolean status)
    {
        this.loginstatus = status;
    }
    void payAmountDue()
    {
        //ask if paying by cash or card
        //update the database for the particular employee
        System.out.println("Your Bill Amount is " + t.computeBill());
        System.out.println("Press 1: Cash\nPress 2: Card");
        switch (sc.nextInt()) {
            case 1 : {
                System.out.println("Amount successfully paid");
            }
            case 2 : {
                System.out.println("Amount successfully paid");
            }
            default : {
                System.out.println("Invalid Input");
            }
        }
        t.changeIsPaid(true);
    }
    private void logout() {
        setLoginStatus(false);
        System.out.println("LogOut Successful");
    }
}

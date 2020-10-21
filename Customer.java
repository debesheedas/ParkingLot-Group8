//Anand
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
public class Customer
{
    Scanner sc = new Scanner(System.in);
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
        menu();
    }

    private void menu() {
        System.out.println("Press 1: Entry Point\nPress 2: Exit Point\nPress 3: Info Portal");
        int n = sc.nextInt();
        switch (n) {
            case 1 -> generateTicket();
            case 2 -> checkTicket();
            case 3 -> checkTicket();
            default -> System.out.println("Invalid Option");
        }
    }
}
class Employee extends Customer{
    boolean loginstatus = false;
    private String password = "password";
    LoginGUI l = new LoginGUI();
    ChangePassword c = new ChangePassword();
    System s = new System();
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
            System.out.println("Press 1: Pay dues\nPress 2: Park Vehicle\nPress 3: Display Floor Plan\nPress 4: Entry/Exit Panel\nPress 5: Info Portal\nPress 6: Change Password\nPress 7: LogOut");
            switch (sc.nextInt()) {
                case 1 -> payAmountDue();
                case 2 -> super.run();
                case 3 -> s.Display();
                case 4 -> panel();
                case 5 -> infoPortal();
                case 6 -> changePassword();
                case 7 -> logout();
                default -> System.out.println("Invalid Input");
            }
        }while(loginstatus);
    }
    private void changePassword()
    {
        int id, flag=0;
        System.out.println("Enter your ID");
        id = sc.nextInt();
        for (Employee i : employeeList )
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
        obj.loadData();     //load the details of dues
        System.out.println("Press 1: Cash\nPress 2: Card");
        switch (sc.nextInt()) {
            case 1 -> System.out.println("Amount successfully paid");
            case 2 -> System.out.println("Amount successfully paid");
            default -> System.out.println("Invalid Input");
        }
        obj.updateAll();        //update the database for the particular employee
    }
    private void logout() {
        setLoginStatus(false);
        System.out.println("LogOut Successful");
    }
}
class Admin extends Employee {
    boolean loginstatus;
    private String agn;
    void run()
    {
        //run sign in or login method, if successful, next, run menu driven loop to choose options from
        // 1. Admin options - changing parking lot settings
        // 2. Change password
        // 3. Add or remove employees
        // 4.
        //make methods for each of the above options
        l.run();
        menu();
    }
    private void menu(){
        do {
            System.out.println("Press 1: Admin options\nPress 2: Change Password\nPress 3: Add/remove Employees\nPress 4: Display Floor Plan\nPress 5: LogOut");
            switch (sc.nextInt()) {
                case 1 -> changeSettings();
                case 2 -> changePassword();
                case 3 -> addRemoveEmployee();
                case 3 -> s.Display();
                case 5 -> super.logout();
                default -> System.out.println("Invalid Option");
            }
        }while(loginstatus);
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
            case 1 -> addEmployee();
            case 2 -> removeEmployee();
            default -> System.out.println("Invalid Option");
        }
    }
    void setLoginStatus(boolean status)
    {
        this.loginstatus = status;
    }
    private void addEmployee() {
        int id;
        String name, password;
        System.out.println("Enter id of the employee");
        id = sc.nextInt();
        System.out.println("Enter name of the employee");
        name = sc.next();
        System.out.println("Create a password");
        password = sc.next();
        //Instead of taking id as input, get him next available id checking the database
        System.out.println("Employee added successfully");
        obj.setupDatabase();        //Setting Employer Details
    }
    private void removeEmployee() {
        int id;
        obj.loadData();
        //show name corresponding to id of the employee
        System.out.println("Enter the ID of the employee to remove");
        id = sc.nextInt();
        //remove employ with id==this.id from the database
        if(obj.databaseExists()){
            obj.updateAll();
            System.out.println("Employee with Id: " + id  + " is fired");
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
            case 1 -> addFloor();
            case 2 -> addEpanel();
            case 3 -> modifyRate();
            case 4 -> addPanel();
            default -> System.out.println("Invalid Option");
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
}

class System
{
    FloorDisplayGUI e;
    ElectricPanelGUI e = new ElectricPanelGUI();
    //call display method
    void Display()
    {
        System.out.println("Enter Floor");
        int n = sc.nextInt();
        //print in command line the complete display for the particular floor, will be replaced with GUI once made
        for(Floor f : allFloors)
        {
            if(n == f.getFloorNumber()) //getter method from class Floor
            {
                e = new FloorDisplayGUI(f);
            }
        }
    }
    void Charge()
    {
        e.run(p);       //p = ParkingLot Object
    }
}

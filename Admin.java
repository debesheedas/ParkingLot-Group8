import java.util.*;
public class Admin extends Employee {
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
                case 4 -> s.Display();
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
            case 1 -> addEmp();
            case 2 -> removeEmp();
            default -> System.out.println("Invalid Option");
        }
    }
    void setLoginStatus(boolean status) { this.loginstatus = status; }
    private void addEmp() {
        int id;
        Employee e;
        String name, password;
        System.out.println("Enter id of the employee");
        id = sc.nextInt();
        System.out.println("Enter name of the employee");
        name = sc.next();
        System.out.println("Create a password");
        password = sc.next();
        e = {id,name,password,0.00};
        getAllEmployees().add(e);
        System.out.println("Employee added successfully");
    }
    private void removeEmp() {
        int id;
        //show name corresponding to id of the employee
        System.out.println("Enter the ID of the employee to remove");
        id = sc.nextInt();
        for (Employee i : employeeList )
        {
            if (id == i.getID())
            {
                getAllEmployees().remove(i);
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

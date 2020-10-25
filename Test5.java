//Please use this testing code to interact with the system as an Employee

import java.util.*;

public class Test5
{
    public static void main(String args[])
    {
        ParkingLot pl = new ParkingLot();
        test5(pl);
    }
    static void test5(ParkingLot p)
    {
        Scanner sc = new Scanner(System.in);
        p.getDatabase().loadDatabase();
        p.getAdmin().menu();
        Customer c = new Customer(p);
        c.run();
        // System.out.println("Welcome Employee\nPlease Enter your unique Employee ID");
        // try
        // {
        //     int id = Integer.parseInt(sc.nextLine());
        //     Employee e = p.returnEmployeeByID(id);
        //     if(e!=null)
        //     {
        //         e.run();
        //     }
        //     else
        //     {
        //         System.out.println("Sorry, you do not exist in the records. Please ask the Admin to add you.");
        //     }
        // }
        // catch(Exception e)
        // {
        //     System.out.println(e.getMessage() + "  Please enter a valid number and try again");
        // }
        
        System.out.println("Welcome Employee\nPlease Enter your unique Employee ID");
        try
        {
            int id = Integer.parseInt(sc.nextLine());
            Employee e = p.returnEmployeeByID(id);
            if(e!=null)
            {
                e.run();
            }
            else
            {
                System.out.println("Sorry, you do not exist in the records. Please ask the Admin to add you.");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() + "  Please enter a valid number and try again");
        }
        p.getDatabase().updateDatabase();
        sc.close();
    }
}

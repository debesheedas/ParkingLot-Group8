//This file was used during initial rounds of Testing. Kindly ignore it.

/*
import java.util.*;
public class TestingModule1
{

    public static void main(String[] args)
    {
        System.out.println("Hello");
        ParkingLot obj = new ParkingLot();
        test1(obj);       

    }
    
    static void test1(ParkingLot p)
    {
        System.out.println("Enter test1");
        p.getDatabase().loadDatabase();
        Employee e = new Employee(p, 1, "Sheldon Cooper", "Bazinga!", 100.4, false);
        System.out.println(p.addEmployee(e));
        Employee e1 = new Employee(p, 2, "Leonard", "Sheldon!", 205, false);
        System.out.println(p.addEmployee(e1));
        Employee e2 = new Employee(p, 3, "Howard", "MOM!", 0.0, false);
        System.out.println(p.addEmployee(e2));
        Employee e3 = new Employee(p, 5, "Penny", "sweety", 2000, true);
        System.out.println(p.addEmployee(e3));
        Employee e4 = new Employee(p, 6, "Amy", "brain", 0.0, true);
        System.out.println(p.addEmployee(e4));
        System.out.println(e);
        
        Checkpoint c1 = new Checkpoint(p, 1, "India Gate", CheckpointType.ENTRY, 2);
        p.addCheckpoint(c1);
        Checkpoint c2 = new Checkpoint(p, 2, "LFS gate", CheckpointType.EXIT, 2);
        p.addCheckpoint(c2);
        Checkpoint c3 = new Checkpoint(p, 3, "Central Info", CheckpointType.INFO, 3);
        p.addCheckpoint(c3);
        Checkpoint c4 = new Checkpoint(p, 4, "Main Exit", CheckpointType.EXIT, 3);
        p.addCheckpoint(c4);
        Checkpoint c5 = new Checkpoint(p, 6, "Central Info Point", CheckpointType.INFO, 4);
        p.addCheckpoint(c5);
        
        Customer c = new Customer(p);
        System.out.println(c);
        Time t = new Time();
        System.out.println(t);
        Checkpoint check = new Checkpoint(p, 3, "South Point", CheckpointType.ENTRY, 4);
        System.out.println(check);
        Checkpoint en = new EntryPoint(p, 3, "South Point", 4);
        System.out.println(en);
        Checkpoint ex = new ExitPoint(p, 3, "South Point",  4);
        System.out.println(ex);
        Checkpoint in = new InfoPortal(p, 3, "South Point",  4);
        System.out.println(in);
        Spot s = new Spot(p, 4, ParkingSpotType.COMPACT, 5, true);
        Ticket ticket= new Ticket(p, 3, s, "KA1022");
        System.out.println(s);
        System.out.println(ticket);
        int[] numberOfSpots = {10, 10, 20, 20, 30, 30, 40, 40, 50, 50};
        Floor f = new Floor(p, numberOfSpots, 5);
        System.out.println(f);
        
        //FloorDisplayGUI fd = new FloorDisplayGUI(f);
        //System.out.println(fd);
        //LoginGUI l = new LoginGUI(p);
        //System.out.println(l);
        //ChangePasswordGUI chp = new ChangePasswordGUI();
        //System.out.println(chp);
        
        //ElectricPanelGUI elec = new ElectricPanelGUI(p);
        //elec.run();
        //System.out.println(elec);
        p.getDatabase().updateDatabase();

    }
}
*/
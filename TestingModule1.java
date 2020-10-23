import java.util.*;

public class TestingModule1
{
    /*public static void main(String[] args)
    {
        System.out.println("Hello");
        ParkingLot obj = new ParkingLot();
        test1(obj);       

    }*/
    static void test1(ParkingLot p)
    {
        System.out.println("Enter test1");
        Employee e = new Employee(p, 1, "Name", "Password", 0.8);
        System.out.println(e);
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
        ElectricPanelGUI elec = new ElectricPanelGUI(p);
        System.out.println(elec);
        //FloorDisplayGUI fd = new FloorDisplayGUI(f);
        //System.out.println(fd);
        LoginGUI l = new LoginGUI(p);
        System.out.println(l);
        ChangePasswordGUI chp = new ChangePasswordGUI();
        System.out.println(chp);
        


    }
}
//Please use this testing code to interact with the system as a Customer
//import java.util.*;

public class Test6
{
    public static void main(String args[])
    {
        ParkingLot pl = new ParkingLot();
        test6(pl);
    }
    static void test6(ParkingLot p)
    {
        p.getDatabase().loadDatabase();
        System.out.println("Dear Customer, Welcome to ParkingLot");
        Customer c = new Customer(p);
        c.run();
        p.getDatabase().updateDatabase();
    }
}
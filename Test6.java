import java.util.*;

public class Test6
{
    public static void main(String args[])
    {
        ParkingLot pl = new ParkingLot();
        test6(pl);
    }
    static void test6(ParkingLot p)
    {
        //Scanner sc = new Scanner(System.in);
        p.getDatabase().loadDatabase();
        System.out.println("Dear Customer, Welcome to ParkingLot");
        Customer c = new Customer(p);
        c.run();
        
        p.getDatabase().updateDatabase();
        //sc.close();
    }
}
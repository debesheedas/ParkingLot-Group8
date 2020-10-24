import java.util.*;

public class TestingModule2
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
        ParkingLot obj = new ParkingLot();
        test2(obj);       

    }
    static void test2(ParkingLot p)
    {
        p.run();
        System.out.println("Enter test2");
        //Testing all methods of parkingLot class
        System.out.println("Admin belonging to p "+ p.getAdmin());
        System.out.println("Setting Price of electricity as 4");
        p.setPriceOfElectricityPerHour(4);
        System.out.println("Getting Price of electricity "+p.getPriceOfElectricityPerHour());

        double[] cp = {20, 10, 5};
        double[] lp = {30, 20, 10};
        double[] hp = {20, 10, 5};
        double[] tp = {10, 5, 4};
        double[] ep = {20, 10, 5};
        p.setCompactPrices(cp);
        p.setLargePrices(lp);
        p.setHandicappedPrices(hp);
        p.setTwowheelerPrices(tp);
        p.setElectricPrices(ep);
        System.out.println(p.getCompactPrices());
        System.out.println(p.getLargePrices());
        System.out.println(p.getHandicappedPrices());
        System.out.println(p.getTwowheelerPrices());
        System.out.println(p.getElectricPrices());

        //Checking functions related to Employee
        Employee e1 = new Employee(p, 1, "Raj", "raja123", 0.0);
        Employee e2 = new Employee(p, 2, "Sheldon", "Hawkins", 2.3);
        System.out.println(p.addEmployee(e1));
        System.out.println(p.addEmployee(e1));
        System.out.println(p.addEmployee(e2));
        System.out.println(p.searchEmployeeByID(e2));
        System.out.println(p.searchEmployeeByUsername("Raj", "raja123"));
        System.out.println(p.searchEmployeeByUsername("Sheldon", "raja123"));
        System.out.println(p.returnEmployeeByUsername("Raj", "raja123"));
        System.out.println(e1);
        System.out.println(p.getAllEmployees());
        System.out.println(p.removeEmployee(e2));
        System.out.println(p.removeEmployee(e2));
        System.out.println(p.getAllEmployees());
        System.out.println();

        //Checking all functions related to Checkpoints
        Checkpoint c1= new Checkpoint(p, 2, "SouthWing", CheckpointType.ENTRY, 3);
        Checkpoint c2 = new InfoPortal(p, 4, "CentralInformation", 2);
        System.out.println(p.addCheckpoint(c1));
        System.out.println(p.addCheckpoint(c1));
        System.out.println(p.addCheckpoint(c2));
        System.out.println(p.getAllCheckpoints());
        System.out.println(p.searchCheckpointByID(3));
        System.out.println(p.searchCheckpointByID(4));
        System.out.println(p.removeChekpoint(c1));
        System.out.println(p.getAllCheckpoints());
        System.out.println();

        //Checking all functions related to Floors
        int[] numberOfSpots = {10, 10, 20, 20, 30, 30, 40, 40, 50, 50};
        Floor f1 = new Floor(p, numberOfSpots, 5);
        Floor f2 = new Floor(p, numberOfSpots, 5);
        Floor f3 = new Floor(p, numberOfSpots, 1);
        System.out.println(p.addFloor(f1));
        System.out.println(p.addFloor(f2));
        System.out.println(p.addFloor(f3));
        System.out.println(p.searchFloorByFloorNo(5));
        System.out.println(p.searchFloorByFloorNo(-2));
        System.out.println(p.getAllFloors());
        System.out.println();
        System.out.println();

        //Checking all functions related to Tickets
        
        Spot s1 = new Spot(p, 3, ParkingSpotType.COMPACT, 2, false);
        Ticket t1 = new Ticket(p, 1, s1, "KA987");
        Spot s2 = new Spot(p, 4, ParkingSpotType.COMPACT, 5, true);
        Ticket t2= new Ticket(p, 3, s2, "KA1022");
        System.out.println(p.getAllTickets());
        System.out.println(p.addTicket(t1));
        System.out.println(p.searchTicketbyID(1));
        System.out.println(p.searchTicketbyID(3));
        System.out.println(p.addTicket(t2));
        System.out.println(p.removeTicket(t2));
        System.out.println();

        /*
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
        p.run();
        */
        


    }
}
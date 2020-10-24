import java.util.*;

public class Test4 {

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        test4(pl);
        /*Database db = new Database(pl);

        pl.addEmployee(new Employee(pl, 3, "cooper", "djnkjfsk",45.5 , true));
        Checkpoint cp = new Checkpoint(pl, 5, "west wing", CheckpointType.ENTRY, 5);
        cp.setAssigned(1001);
        pl.addCheckpoint(cp);
        pl.addFloor(new Floor(pl, new int[]{3,3,3,3,3,3,3,3,3,3}, 1));
        pl.addTicket(new Ticket(pl, 101, new Spot(pl , 3 , ParkingSpotType.COMPACT , 1 , true) , "6709")); // here floorNo and SpotID must exist befor we create Ticket

        pl.setCompactPrices(new double[]{2.3 , 3.3 , 4.4});
        pl.setLargePrices(new double[]{5.5 , 3.53 , 34.4});
        pl.setTwowheelerPrices(new double[]{22.3 , 3.33 , 34.4});
        pl.setElectricPrices(new double[]{72.3 , 53.3 , 44.4});
        pl.setHandicappedPrices(new double[]{2.83 , 3.37 , 4.34});
      
        // update the database with instance variables of ParkingLot
        db.updateDatabase();

        //load dn
        db.loadDatabase();

        //check
        ArrayList<Floor> floors = pl.getAllFloors();
        for(Floor floor : floors){
            System.out.println(floor.getFloorNo());
            System.out.println(floor.getTotalNumberOfCompactSpots());
            System.out.println(floor.getNumberOfAvailableCompactSpots());
            System.out.println(floor.getTotalNumberOfHandicappedSpots());
            System.out.println(floor.getNumberOfAvailableElectricalSpots());
            System.out.println(floor.getNumberOfAvailableTwowheelerSpots());
        }
        ArrayList<Employee> employees = pl.getAllEmployees();
        for(Employee  employee: employees){
            System.out.println(employee.getID());
            System.out.println(employee.getDues());
            System.out.println(employee.getUsername());
            System.out.println(employee.getPassword());
            System.out.println(employee.loginstatus);
        }
        ArrayList<Ticket> tickets = pl.getAllTickets();
        for(Ticket  t: tickets){
            System.out.println(t.getStartTime());
            System.out.println(t.getVehicleNumberPlate());
            System.out.println(t.getSpot().getFloorNo());
            System.out.println(t.getSpot().getSpotType());
        }*/
    }
    static void test4(ParkingLot p)
    {
        //p.getDatabase().loadDatabase();
        p.getAdmin().menu();
        //p.getDatabase().updateDatabase();
    }
    
}

public class Test5 {

    public static void main(String[] args) {

        ParkingLot pl = new ParkingLot();
        pl.addFloor(new Floor(pl, new int[]{3,3,3,3,3,3,3,3,3,3}, 1));
        pl.addCheckpoint(new EntryPoint(pl, 5, "main Entry", 1));
        Customer c = new Customer(pl);
        c.run();
        pl.getDatabase().updateDatabase();



    }  
    
}

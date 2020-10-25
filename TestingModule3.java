
import java.util.*;

public class TestingModule3
{
    /*public static void main(String[] args)
    {
        System.out.println("Hello");
        ParkingLot obj = new ParkingLot();
        test3(obj);       

    }*/
    static void test3(ParkingLot p)
    {
        Database db = new Database(p);
        db.deleteDatabase();;
        db.setupDatabase();
        AdminOptionsGUI ao = new AdminOptionsGUI(p);
        ao.run();
        //Checking if AdminOPtionsGUI is working or not
        
    
        // System.out.println(p.getPriceOfElectricityPerHour());
        // System.out.println(p.getCompactPrices().toString());
        // System.out.println(p.getLargePrices());
        // System.out.println(p.getHandicappedPrices());
        // System.out.println(p.getElectricPrices());
        // System.out.println(p.getAllFloors());
        // for(Floor f: p.getAllFloors())
        // {
        //     System.out.println(f.getFloorNo());
        //     System.out.println(f.getAllSpotsOnthisFloor());
        // }

       
       
        
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println();

        // System.out.println();
        // System.out.println();
        boolean loop = true;
        while(loop){
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();
            if(response == "save"){
                db.updateDatabase();
                loop = false;
            }
        }
        db.updateDatabase();
        System.out.println("ended");
    }


}
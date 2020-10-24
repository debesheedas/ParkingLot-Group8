import java.util.*;

public class Ticket
{
    private ParkingLot pl;
    private int ID;
    private Spot s; //Spot allotted
    private Time entry;
    private Time exit;
    private boolean isPaid;
    private String VehicleNumberPlate;
    Ticket(ParkingLot p, int id, Spot spot, String vnp)
    {
        pl=p;
        ID=id;
        s=spot;
        entry= new Time();
        exit=new Time();//dummy value
        isPaid=false;
        VehicleNumberPlate = vnp;
    }
    Ticket(ParkingLot p, int id, Spot spot, Time e, String vnp)
    {  
        pl=p;  
        ID=id;
        s=spot;
        entry=e;
        exit = new Time();//dummy value
        isPaid=false;
        VehicleNumberPlate = vnp;



    }
    /*void AddtoDatabase()
    {
            //whenever a ticket is created it is added to the database in case the program is closed before the the car leaves the parking lot
    }*/

        //whenever you need the difference between two time objects t1 and t2 in hours, then just call double difference = exit.diff(entry);
    public Spot getSpot()
    {
        return s;
    }
    void setSpot(Spot s)
    {
        this.s = s;
    }
        void setEntryTime() {
        entry = new Time();
    }
    void setStopTime(Time t)
    {
        exit = t;
    }
    void setStopTime(String s)
    {
        //figure out how to convert String to date type...convert it into time object and assign to exit
    }
    String getStartTime()
    {
        return entry.getTime();
    }
    double computeBill()
    {
        double difference = exit.diff(entry);
        double billAmount;
        ParkingSpotType t= s.getSpotType(); 
        double[] arr = new double[3];
        switch(t)
        {
            case COMPACT: arr = pl.getCompactPrices();
                break;
            case LARGE: arr = pl.getLargePrices();
                break;
            case ELECTRIC: arr = pl.getElectricPrices();
                break;
            case TWOWHEELER: arr = pl.getTwowheelerPrices();
                break;
            case HANDICAPPED: arr = pl.getHandicappedPrices();
                break;
            default: System.out.println("Invalid Spot Type");
                break;
        }
        if (difference <= 1)
            billAmount = difference * arr[0];
        else if (difference > 1 && difference <= 3)
            billAmount = difference * arr[1];
        else
            billAmount = difference * arr[2];
        return billAmount;//use appropriate information from instance variables and calculate bill
    }
    void changeIsPaid(boolean status)
    {
        isPaid = status;
    }
    int getID()
    {
        return ID;
    }
    void setID(int id){
        ID = id;
    }
    String getVehicleNumberPlate(){
        return VehicleNumberPlate;
    }
    void setVehicleNumberPlate(String vnp){
        VehicleNumberPlate = vnp;
    }
        //pay ticket - after payment, delete ticket from database

}
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
        exit=new Time();//dummy value just for cnstrutor purposes
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
    String getStartTime()
    {
        return entry.getTime();
    }
    double computeBill()
    {
        double difference = exit.diff(entry);
        System.out.println(difference);
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
            billAmount = arr[0]+(difference-1) * arr[1];
        else
            billAmount = arr[0]+ 2*arr[1]+(difference-3) * arr[2];
        return billAmount;//use appropriate information from instance variables and calculate bill
    }
    double computeBill(double hours)
    {
        double difference = hours;
        double billAmount=0;
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
            billAmount = arr[0]+(difference-1) * arr[1];
        else
            billAmount = arr[0]+ 2*arr[1]+(difference-3) * arr[2];
        return billAmount;
    }
    void changeIsPaid(boolean status)
    {
        isPaid = status;
    }
    boolean getIsPaid()
    {
        return isPaid;
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
}
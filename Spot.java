//Jaswanth
import java.util.*;

public class Spot//write a parameterized constructor for  this to initialize the variables as follows
{
    ParkingLot pl;
    private int id; 
    private String name;//generate an alphanumeric sequence such as 5C04 where 5 stands for 5th floor, C stands for compact and 04 is the id number of the spot, use L for large, H for handicapped, T for Twowheeler and E for electric
    private ParkingSpotType t;
    //double[] prices;
    private int floor;
    private boolean isAvailable;

    Spot(ParkingLot p, int id, ParkingSpotType t, int floor, boolean status)
    {
        pl=p;
        //assign all values as directed
        char c ='\0';
        this.id = id;
        this.t = t;
        this.floor = floor;
        isAvailable = status;
        switch (this.t) {
            case COMPACT:
                c = 'C';
                break;
            case LARGE:
                c = 'L';
                break;
            case ELECTRIC:
                c = 'E';
                break;
            case TWOWHEELER:
                c = 'T';
                break;
            case HANDICAPPED:
                c = 'H';
                break;
            default:
                System.out.println("Invalid ParkingSpot Type");
                break;
        }
        name = (this.floor+""+c+""+String.valueOf(this.id/10)+String.valueOf(this.id%10));
    }
    ParkingSpotType getSpotType(){
        return t;
    }
    void setSpotType(ParkingSpotType t){
        this.t = t;
    }
    String getName(){
        return name;
    }
    void setName(String n){
        name = n;
    }
    int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public int getFloorNo(){
        return floor;
    }
    public void setFloorNo(int f){
        floor = f;
    }
    boolean isAvailable(){
        return isAvailable;
    }
    void isAvailable(boolean iA){
        isAvailable = iA;
    }
}

   

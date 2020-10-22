//Jaswanth
import java.util.*;
enum ParkingSpotType 
{
    COMPACT, LARGE, HANDICAPPED, TWOWHEELER, ELECTRIC
}

public class Spot//write a parameterized constructor for  this to initialize the variables as follows
{
    int id; 
    String name;//generate an alphanumeric sequence such as 5C04 where 5 stands for 5th floor, C stands for compact and 04 is the id number of the spot, use L for large, H for handicapped, T for Twowheeler and E for electric
    ParkingSpotType t;
    //double[] prices;
    int floor;
    boolean isAvailable;

    Spot(int id, ParkingSpotType t, int floor, boolean status)
    {
        //assign all values as directed
        int n;
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
        System.out.println("Spot Name : "+name);
    }
}

   

import java.util.*;
public class Ticket {
    int ID;
    Spot s; //Spot allotted
    Time entry;
    Time exit;
    boolean isPaid;
    String VehicleNumberPlate;
    void AddtoDatabase()
    {
            //whenever a ticket is created it is added to the database in case the program is closed before the the car leaves the parking lot
    }
        //whenever you need the difference between two time objects t1 and t2 in hours, then just call double difference = exit.diff(entry);
    void setEntryTime() {
        entry = new Time();
    }
    void setStopTime()
    {
        exit = new Time();
    }
    double computeBill()
    {
        double difference = exit.diff(entry);
        double billAmount;
        if (difference <= 1)
            billAmount = difference * Parkinglot.spotPrice[0];
        else if (difference > 1 && difference <= 2)
            billAmount = difference * Parkinlot.spotPrice[1];
        else
            billAmount = difference * Parkinglot.spotPrice[2];
        return billAmount;//use appropriate information from instance variables and calculate bill
    }
    void changeIsPaid(boolean status)
    {

    }
        //pay ticket - after payment, delete ticket from database

}
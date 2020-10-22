public class Ticket
{
    int ID;
    Spot s; //Spot allotted
    Time entry;
    Time exit;
    boolean isPaid;
    String VehicleNumberPlate;
    Ticket(int id, Spot spot, String vnp)
    {
        ID=id;
        s=spot;
        entry= new Time();
        exit=new Time();//dummy value
        isPaid=false;


    }
    Ticket(int id, Spot spot, Time e, String vnp)
    {   
        ID=id;
        s=spot;
        entry=e;
        exit = new Time();//dummy value
        isPaid=false;



    }
    /*void AddtoDatabase()
    {
            //whenever a ticket is created it is added to the database in case the program is closed before the the car leaves the parking lot
    }*/

        //whenever you need the difference between two time objects t1 and t2 in hours, then just call double difference = exit.diff(entry);
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
            case COMPACT:arr=super.getCompactPrices();
        }
        if (difference <= 1)
            billAmount = difference * arr[0];
        else if (difference > 1 && difference <= 2)
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
        //pay ticket - after payment, delete ticket from database

}
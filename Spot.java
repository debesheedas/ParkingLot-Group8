//Jaswanth
import java.util.*;git
enum ParkingSpotType 
{
    COMPACT, LARGE, HANDICAPPED, TWOWHEELER, ELECTRIC
}

class Spot//write a parameterized constructor for  this to initialize the variables as follows
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


class Floor {
    int[] NumberOfSpots = new int[10];//if the name of this array is arr, then arr[0]=number of total compact spots, arr[1] = number of available compact spots and so on
    ArrayList<Spot> allSpotsOnthisFloor = new ArrayList<Spot>();
    int floorNo;
    public int getTotalNumberOfCompactSpots(){
        return NumberOfSpots[0];
    }
    public int getNumberOfAvailableCompactSpots(){
        return NumberOfSpots[1];
    }
    public int getTotalNumberOfLargeSpots(){
        return NumberOfSpots[2];
    }
    public int getNumberOfAvailableLargeSpots(){
        return NumberOfSpots[3];
    }
    public int getTotalNumberOfElectricalSpots(){
        return NumberOfSpots[4];
    }
    public int getNumberOfAvailableElectricalSpots(){
        return NumberOfSpots[5];
    }
    public int getTotalNumberOfTwowheelerSpots(){
        return NumberOfSpots[6];
    }
    public int getNumberOfAvailableTwowheelerSpots(){
        return NumberOfSpots[7];
    }
    public int getTotalNumberOfHandicappedSpots(){
        return NumberOfSpots[8];
    }
    public int getNumberOfAvailableHandicappedSpots(){
        return NumberOfSpots[9];
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
    public void setTotalNumberOfCompactSpots(int NumberOfSpots ){
         this.NumberOfSpots[0] = NumberOfSpots;
    }
    public void setNumberOfAvailableCompactSpots(int NumberOfSpots){
         this.NumberOfSpots[1] = NumberOfSpots;
    }
    public void setTotalNumberOfLargeSpots(int NumberOfSpots){
         this.NumberOfSpots[2] = NumberOfSpots;
    }
    public void setNumberOfAvailableLargeSpots(int NumberOfSpots){
         this.NumberOfSpots[3] = NumberOfSpots ;
    }
    public void setTotalNumberOfElectricalSpots(int NumberOfSpots){
         this.NumberOfSpots[4] = NumberOfSpots;
    }
    public void setNumberOfAvailableElectricalSpots(int NumberOfSpots){
         this.NumberOfSpots[5] = NumberOfSpots;
    }
    public void setTotalNumberOfTwowheelerSpots(int NumberOfSpots){
         this.NumberOfSpots[6] = NumberOfSpots;
    }
    public void setNumberOfAvailableTwowheelerSpots(int NumberOfSpots){
         this.NumberOfSpots[7] = NumberOfSpots;
    }
    public void setTotalNumberOfHandicappedSpots(int NumberOfSpots){
         this.NumberOfSpots[8] = NumberOfSpots;
    }
    public void setNumberOfAvailableHandicappedSpots(int NumberOfSpots){
         this.NumberOfSpots[9] = NumberOfSpots;
    }
    public ArrayList<Spot> getAllSpotsOnthisFloor() {
        return allSpotsOnthisFloor;
    }
    public int[] getNumberOfSpots() {
        return NumberOfSpots;
    }
    public void setAllSpotsOnthisFloor(ArrayList<Spot> allSpotsOnthisFloor) {
        this.allSpotsOnthisFloor = allSpotsOnthisFloor;
    }
    public void setNumberOfSpots(int[] numberOfSpots) {
        NumberOfSpots = numberOfSpots;
    }
}
class Ticket {
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
class Checkpoint {
    int ID;
    String name;
    Employee assigned;
    int floorNumber;//here write getter and setter methods for all instance variables after declaring them protected

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Employee getAssigned() {
        return assigned;
    }

    public void setAssigned(Employee assigned) {
        this.assigned = assigned;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class EntryPoint extends Checkpoint {
    Scanner Ep = new Scanner(System.in);
    ParkingSpotType t;
    void run()
    {
        //call userInput()
        //then call generateticket()
        userInput();
        generateTicket(t);
    }
    void userInput()
    {
        //take user input using scanner for spot type required
        System.out.println("All spotTypes : LARGE , COMPACT , ELECTRICAL , TWOWHEELER , HANDICAPPED");
        System.out.println("Enter the required spot type : ");
        String str = Ep.next().toUpperCase();
        t = ParkingSpotType.valueOf(str);
    }
    Spot searchForSpot(ParkingSpotType t)
    {
        // use the method getAllFloors() to get an ArrayList of all Floors. Now use the getter methods of Floor class to obtain information on which Spots on each Floor are Available
        //if the spot type is available on some floor, create a Spot object with parameterized constructor to initialize it
        //to choose an id number for the Spot that you are creating, use the ArrayList of Spots on each Floor to find the smallest ID value which is not occupied
        //return Spot of specified ParkingSpotType on some floor (preferably closest to entry point) on which corresponding parking spot is available


        ParkingLot P = new ParkingLot();
        ArrayList<Floor> floors = P.getAllFloors();
        for (Floor floor : floors){
            if (t == ParkingSpotType.COMPACT)
                floor.getNumberOfAvailableCompactSpots();
            else if (t == ParkingSpotType.LARGE)
                floor.getNumberOfAvailableLargeSpots();
            else if (t == ParkingSpotType.ELECTRIC)
                floor.getNumberOfAvailableElectricalSpots();
            else if (t == ParkingSpotType.TWOWHEELER)
                floor.getNumberOfAvailableTwowheelerSpots();
            else if (t == ParkingSpotType.HANDICAPPED)
                floor.getNumberOfAvailableHandicappedSpots();
        }
        getFloorNumber();
    }
    void generateTicket(ParkingSpotType t)
    {
        Ticket T = new Ticket();
        Spot temp = this.searchForSpot(t);
        if(temp!=null){//basically if suitable spot is available

                //take vehicle number plate through Scanner
                //create Ticket object and add to the list in ParkingLot class using setter method
                //update corresponding instance variables of ParkingLot class and all other classes- whichever has been changed
            System.out.println("Enter the number of vehicleNumberPlate : ");
            T.VehicleNumberPlate = Ep.next();
            ArrayList<Ticket> setAllTickets(T);
        }
    }

}


import java.util.ArrayList;

public class Floor 
{
    ParkingLot pl;
    int[] NumberOfSpots = new int[10];//if the name of this array is arr, then arr[0]=number of total compact spots, arr[1] = number of available compact spots and so on
    ArrayList<Spot> allSpotsOnthisFloor = new ArrayList<Spot>();
    int floorNo;
    Floor(ParkingLot pl, int[] NumberOfSpots,  int floorNo)
    {
        //every Spot on a floor has a unique ID
        int id=1;
        this.pl=pl;
        this.NumberOfSpots = NumberOfSpots;
        this.floorNo = floorNo;
        //initialize this by creating all the spot objects of appropriate types
        for(int i=0; i<NumberOfSpots[0]; i++, id++)
        {
            allSpotsOnthisFloor.add(new Spot(pl, id,ParkingSpotType.COMPACT , this.floorNo, true));
        }
        for(int i=0; i<NumberOfSpots[2]; i++, id++)
        {
            allSpotsOnthisFloor.add(new Spot(pl, id,ParkingSpotType.LARGE , this.floorNo, true));
        }
        for(int i=0; i<NumberOfSpots[4]; i++, id++)
        {
            allSpotsOnthisFloor.add(new Spot(pl, id,ParkingSpotType.HANDICAPPED , this.floorNo, true));
        }
        for(int i=0; i<NumberOfSpots[6]; i++, id++)
        {
            allSpotsOnthisFloor.add(new Spot(pl, id,ParkingSpotType.TWOWHEELER , this.floorNo, true));
        }
        for(int i=0; i<NumberOfSpots[8]; i++, id++)
        {
            allSpotsOnthisFloor.add(new Spot(pl, id,ParkingSpotType.ELECTRIC , this.floorNo, true));
        }
        /*
        for(int i=1;i<=5;i++){
            if(i==1)
                allSpotsOnthisFloor.add(new Spot(pl, i,ParkingSpotType.COMPACT , this.floorNo, true));
            else if(i==2)
                allSpotsOnthisFloor.add(new Spot(pl, i,ParkingSpotType.LARGE , this.floorNo, true));
            else if(i==3)
                allSpotsOnthisFloor.add(new Spot(pl, i,ParkingSpotType.ELECTRIC , this.floorNo, true));   
            else if(i==4)
                allSpotsOnthisFloor.add(new Spot(pl, i,ParkingSpotType.TWOWHEELER , this.floorNo, true));
            else if(i==5)
                allSpotsOnthisFloor.add(new Spot(pl, i,ParkingSpotType.HANDICAPPED , this.floorNo, true));        
        }*/

    }
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
    public int getFloorNo(){
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

    /*
    public void freeSpot(Spot s){
        //change the isAvailable value to true
        //also modify NumberOfSpots - From Spot object, identify which type it is...and then modify corresponding array value
        s.isAvailable(true);
        ParkingSpotType t = s.getSpotType(); // CHECK IF THIS ASSIGNMENT IS CORRECT
        switch(t){
            case COMPACT:NumberOfSpots[1] += 1;
                break;
            case LARGE:NumberOfSpots[3] += 1;
                break;
            case ELECTRIC:NumberOfSpots[5] += 1;
                break;
            case TWOWHEELER:NumberOfSpots[7] += 1;
                break;
            case HANDICAPPED:NumberOfSpots[9] += 1;
                break;
            default: System.out.println("Invalid Spot Type");
                break;
            
        }
    }*/
}
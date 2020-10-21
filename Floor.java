import java.util.*;
public class Floor {

    //need to make a parameterized constructor....
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
    public void setTotalNumberOfCompactSpots(int[] NumberOfSpots ){
         this.NumberOfSpots[0] = NumberOfSpots[0];
    }
    public void setNumberOfAvailableCompactSpots(int[] NumberOfSpots){
         this.NumberOfSpots[1] = NumberOfSpots[1];
    }
    public void setTotalNumberOfLargeSpots(int[] NumberOfSpots){
         this.NumberOfSpots[2] = NumberOfSpots[2];
    }
    public void setNumberOfAvailableLargeSpots(int[] NumberOfSpots){
         this.NumberOfSpots[3] = NumberOfSpots[3] ;
    }
    public void setTotalNumberOfElectricalSpots(int[] NumberOfSpots){
         this.NumberOfSpots[4] = NumberOfSpots[4];
    }
    public void setNumberOfAvailableElectricalSpots(int[] NumberOfSpots){
         this.NumberOfSpots[5] = NumberOfSpots[5];
    }
    public void setTotalNumberOfTwowheelerSpots(int[] NumberOfSpots){
         this.NumberOfSpots[6] = NumberOfSpots[6];
    }
    public void setNumberOfAvailableTwowheelerSpots(int[] NumberOfSpots){
         this.NumberOfSpots[7] = NumberOfSpots[7];
    }
    public void setTotalNumberOfHandicappedSpots(int[] NumberOfSpots){
         this.NumberOfSpots[8] = NumberOfSpots[8];
    }
    public void setNumberOfAvailableHandicappedSpots(int[] NumberOfSpots){
         this.NumberOfSpots[9] = NumberOfSpots[9];
    }

    //void/boolean freeSpot(Spot s)
    {

    }
}

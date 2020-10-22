public class Floor {
    int[] NumberOfSpots = new int[10];//if the name of this array is arr, then arr[0]=number of total compact spots, arr[1] = number of available compact spots and so on
    ArrayList<Spot> allSpotsOnthisFloor = new ArrayList<Spot>();
    int floorNo;
    Floor(int[] NumberOfSpots , ArrayList<Spot> allSpotsOnthisFloor , int floorNo){
        this.NumberOfSpots = NumberOfSpots;
        this.allSpotsOnthisFloor = allSpotsOnthisFloor;
        this.floorNo = floorNo;
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
=======
>>>>>>> upstream/main


<<<<<<< HEAD
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
    public boolean removeSpot(Spot s){
        allSpotsOnthisFloor.remove(s);
    }
}
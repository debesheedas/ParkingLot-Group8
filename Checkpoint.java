

public class Checkpoint {
    protected ParkingLot pl;
    protected int ID;
    protected String name;
    private CheckpointType type;
    protected int assignedEmployeeID;//The ID of the Employee who has been assigned to this Checkpoint
    protected int floorNumber;

    Checkpoint(ParkingLot p, int id, String nm, CheckpointType t, int floorNo)
    {
        pl=p;
        ID = id;
        name = nm;
        type = t;
        assignedEmployeeID=0;
        floorNumber = floorNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAssigned() {
        return assignedEmployeeID;
    }

    public void setAssigned(int assigned) {
        this.assignedEmployeeID = assigned;
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
    public CheckpointType getCheckpointType(){
        return type;
    }
    void setCheckpointType(CheckpointType c){
        type = c;
    }
}
enum CheckpointType
{
    ENTRY, EXIT, INFO
}

public class Checkpoint {
    private int ID;
    private String name;
    private CheckpointType type;//getter setter methods
    //Employee assigned;
    private int assignedEmployeeID;
    private int floorNumber;//here write getter and setter methods for all instance variables after declaring them protected

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
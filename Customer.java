//Anand
import java.util.*;
public class Customer
{
    protected ParkingLot pl;
    Customer(ParkingLot pl)
    {
        this.pl=pl;
    }


    Scanner sc = new Scanner(System.in);
    void run()
    {
        System.out.println("Press 1: Entry Point\nPress 2: Exit Point\nPress 3: Info Portal\n Press 4: To view Floor Display\n Press 5: To charge Electric Vehicle");
        try{
            int n = Integer.parseInt(sc.nextLine());
            switch(n)
            {
                case 1:
                case 2:
                case 3:
                    System.out.println("Please enter the ID of the Checkpoint you would like to go to");
                    int id = Integer.parseInt(sc.nextLine());
                    Checkpoint c = pl.returnCheckpointByID(id);
                    int i = pl.getAllCheckpoints().indexOf(c);
                    if(c!=null)
                    {
                        CheckpointType t = c.getCheckpointType();
                        switch(t)
                        {
                            case ENTRY:
                                EntryPoint p1 = new EntryPoint(pl, id, c.getName(), c.getFloorNumber());
                                p1.run();
                                break;
                            case EXIT:
                                ExitPoint p2 = new ExitPoint(pl, id, c.getName(), c.getFloorNumber());
                                p2.run();
                            case INFO:
                                InfoPortal p3 = new InfoPortal(pl, id, c.getName(), c.getFloorNumber());
                                p3.run();
                            default:
                                break;
                        }
                    }
                    else
                    {
                        System.out.println("No such checkpoint exists");
                    }
                    break;
                case 4:
                    System.out.println("Total Number of Floors ="+pl.getAllFloors().size());
                    System.out.println("Please enter the Floor Number of the display you want to see");
                    try
                    {
                        int j = Integer.parseInt(sc.nextLine());
                        if(j>0 && j<=pl.getAllFloors().size())
                        {
                            FloorDisplayGUI fd = new FloorDisplayGUI(pl.getAllFloors().get(j-1));
                        }
                        else
                        {
                            System.out.println("Please enter Valid input and try again");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage() + "  Please enter Valid input and try again");
                    }
                    break;
                case 5:
                    ElectricPanelGUI e = new ElectricPanelGUI(pl);
                    e.run();
                    break;
                default:
                    System.out.println("Please enter Valid input and try again");

            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() +  "  Please enter a valid choice");
        }
    }
}
    //menu driven what do you want to do
    //Go totest s = new test();
    //s.print();
    //1. Entry point
    //Enter entry point ID via Scanner - call generate Ticket method on corresponding entry point object by searching list of entry points by unique entry point ID
    //2. Exit point
    //call check ticket method
    //3. Info Portal
    // call checkTicket method
    //menu();
    //}
    
    //EntryPoint ep = new EntryPoint();
    //ExitPoint ex = new ExitPoint();
    //InfoPortal ip = new InfoPortal();
    /*
   

    private void menu() {
        System.out.println("Press 1: Entry Point\nPress 2: Exit Point\nPress 3: Info Portal");
        int n = sc.nextInt();
        switch (n) {
            case 1 : {
                //ep.userInput();
            }
            case 2 : {
                //ex.userInput();
            }
            case 3 : {
                //ip.userInput();
            }
            default : {
                System.out.println("Invalid Option");
            }
        }
    }
}
*/
/*class System
{
    FloorDisplayGUI e;
    ElectricPanelGUI e = new ElectricPanelGUI();
    //call display method
    void Display()
    {
        System.out.println("Enter Floor");
        int n = sc.nextInt();
        //print in command line the complete display for the particular floor, will be replaced with GUI once made
        for(Floor f : allFloors)
        {
            if(n == f.getFloorNumber()) //getter method from class Floor
            {
                e = new FloorDisplayGUI(f);
            }
        }
    }
    void Charge()
    {
        e.run(p);       //p = ParkingLot Object
    }
}*/

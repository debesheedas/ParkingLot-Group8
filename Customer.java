//Anand
import java.util.Scanner;
public class Customer
{
    protected ParkingLot pl;
    Customer(ParkingLot pl)
    {
        this.pl=pl;
    }

}
    
    //Scanner sc = new Scanner(System.in);
    //EntryPoint ep = new EntryPoint();
    //ExitPoint ex = new ExitPoint();
    //InfoPortal ip = new InfoPortal();
    /*
    void run()
    {
        //menu driven what do you want to do
        //Go totest s = new test();
        //s.print();
        //1. Entry point
        //Enter entry point ID via Scanner - call generate Ticket method on corresponding entry point object by searching list of entry points by unique entry point ID
        //2. Exit point
        //call check ticket method
        //3. Info Portal
        // call checkTicket method
        menu();
    }

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

//Anand
import java.util.Scanner;
public class Customer
{
    Scanner sc = new Scanner(System.in);
    protected Ticket t = new Ticket();
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
                t.generateTicket();
            }
            case 2 : {
                t.checkTicket();
            }
            case 3 : {
                t.checkTicket();
            }
            default : {
                System.out.println("Invalid Option");
            }
        }
    }
}

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

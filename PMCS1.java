//PM Case Study 1 Parking Lot
//Navjoth

import java.util.*;


public class PMCS1
{
    public static void main(String args[])
    {
        System.out.println("Hello");
        test s = new test();
        s.print();
        ParkingLot obj = new ParkingLot();
        obj.run();
        

    }
}

class Time
{
    Date d = new Date(System.currentTimeMillis());
    double diff(Date d1, Date d2)//this method returns the difference in time between the 2 date objects as a double data type, useful for calculating bill amounts
    {
        //return d2-d1;
    }
}
class ParkingLot
{
    Database lot = new Database();
    Admin admin = new Admin();
    ArrayList<Employee>  employeeList = new ArrayList();
    ArrayList<Ticket> allTickets = new ArrayList();
    double priceOfElectricityPerHour;
    double[] compactPrices = new double[3];
    double[] largePrices = new double[3];
    double[] handicappedPrices = new double[3];
    double[] twowheelerPrices = new double[3];
    double[] electricPrices = new double[3];
    //write getter and setter methods for each of the instance variables of this class
    
    void run()
    {
        
        //setup database if required - Database.java
        //for this, call check if Database exists
        //if it does not exist, call setupDatabase method
        //if database already exists, establish connection and load data - Database.java call loadDatabase method
        //initialize all instance variables 
        //write a menu driven program, while loop to test the program
        /*
        *Provide options such as are you admin, employee or customer
        write a switch case
        case 1 if admin
        admin.run
        case 2 if employee
        employee.run
        case 3 if customer
        customer.run
        before closing the loop, like just before terminating each iteration, call the update all method


        *
        *
        */
    }
    //call update all tables method from Database.java here again before terminating the program

}


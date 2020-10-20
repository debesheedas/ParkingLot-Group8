//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI1//testing the code
{  //

}
//to call Login for both admin or Employee, call this class and its static method as the following statement
//LoginGUI.run();
class LoginGUI extends ParkingLot implements ActionListener 
{
    private static JFrame frame;
	private static JPanel panel;
	private static JLabel label;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
    private static JLabel success;
    private String username;
    private String password;

    public static void run()
    {
        frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(panel);
		frame.setTitle("Login");
		panel.setLayout(null);
		
		label = new JLabel("User");
		label.setBounds(20, 20, 80, 25);
		panel.add(label);
		
		userText = new JTextField();
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 50, 165, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(100, 80, 80, 25);
		button.addActionListener(new LoginGUI());
		panel.add(button);
		
		success = new JLabel();
		success.setBounds(20, 110, 300, 25);
		panel.add(success);
		//set Text if credentials are correct
		
		
        frame.setVisible(true);
        //System.out.println();
        //return true;
    }
    @Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("Button clicked");
		username = userText.getText();
		password = new String(passwordText.getPassword());
        System.out.println(username + " "+ password);
        
        
        if(username.equals("admin")&&password.equals("password"))
		{
            success.setText("Login Successful!");
            //Admin a = super.getAdmin();//getter method for admin instance variable available in ParkingLot class
            //a.setLoginStatus(true);//setter method provided in Admin class...we could consider making admin a static variable
        }
        else if(searchEmployeeByUsername(username, password))
        {
            success.setText("Login Successful!");
            Employee emp = returnEmployeeByUsername(username, password);//method present in ParkingLot class
            emp.setLoginStatus(true);//setter method of Employee class
            //search for employee and set login status as true
        }
		else
		{
			success.setText("Login Unsuccessful, please try again");
		}	
		
    }
}
/*boolean searchEmployeeByUsername(String username, String password)
{
    
    for(Employee emp : employeeList)
    {
        if(username.equals(emp.getUsername()) && password.equals(emp.getPassword()))//getusername() and getpassword() to be provided in class Employee
        {
            return true;
        }
    }
    return false;
}*/


//user interface
//for info portal, entry points, exit points and manned and automated...(as well as display on each floor)
/*
interface LogIn
{
    //for both employee and admin
}
class GUI1{
    
}
//class admin settings
// class floor number X display
//Electric panel automated

class AdminOptions
{
    void run()
    {

    }
}
class Display
{
    void displayPanel(int floorinfo[])
    {

    }
}
class ElectricPanelGUI
{
    //generate window
    //On startTicket userInput()
    {
        //take in ticket ID via Scanner
        //return corresponding Ticket object after searching instance variable Ticket arraylist to calling method
    }

    void checkTicket()
    {
        Ticket t = ;//call userInput


    }
    void PayTicket()
    {
        //call computeBill method
        //change paid status
    }

}
*/
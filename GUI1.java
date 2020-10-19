//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI1//testing the code
{  
    public static void main(String args[])
    {
        LoginGUI.run();
        
    }

}
class LoginGUI implements ActionListener
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

    boolean searchEmployeeDatabase(String username, String password)
    {
        System.out.println("Searching for employee "+username+" with password "+password);
        //return true if employee username and password exists in database
        return true;
    }

    public static boolean run()
    {
        frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(panel);
		
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
        return true;
    }
    @Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("Button clicked");
		String user = userText.getText();
		String password = new String(passwordText.getPassword());
        //System.out.println(user + " "+ password);
        
        
        if(searchEmployeeDatabase(user, password))
		{
            success.setText("Login Successful!");
			
		}
		else
		{

			success.setText("Login Unsuccessful, please try again");
		}		
		
	}

}
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
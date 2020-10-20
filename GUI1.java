//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI1//testing the code
{  //

}
//to call Login for both admin or Employee, call this class and run method as the following statements
//LoginGUI l = new LoginGUI();
//l.run();
class LoginGUI extends ParkingLot implements ActionListener 
{
    private static JFrame frame;
	private static JPanel panel;
	private static JLabel label;
	private static JTextField password1;
	private static JLabel passwordLabel;
	private static JPasswordField password2;
	private static JButton button;
    private static JLabel success;
    private String username;
    private String password;

    public void run()
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
		
		password1 = new JTextField();
		password1.setBounds(100, 20, 165, 25);
		panel.add(password1);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 50, 165, 25);
		panel.add(passwordLabel);
		
		password2 = new JPasswordField();
		password2.setBounds(100, 50, 165, 25);
		panel.add(password2);
		
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
		username = password1.getText();
		password = new String(password2.getPassword());
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

//call this class using the following statements by passing an Employee object IF AND ONLY IF Employee is logged in
//ChangePassword c = new ChangePassword();
//c.run(r);//where r is the Employee object

class ChangePassword implements ActionListener 
{
    private static JFrame frame;
	private static JPanel panel;
	private static JLabel label1;
	private static JPasswordField password1;
	private static JLabel label2;
	private static JPasswordField password2;
	private static JButton button;
    private static JLabel success;

    public void run(Employee e)
    {
        frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(360,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(panel);
		frame.setTitle("Change Password");
		panel.setLayout(null);
		
		label1 = new JLabel("Enter Password");
		label1.setBounds(20, 20, 165, 25);
		panel.add(label1);
		
		password1 = new JPasswordField();
		password1.setBounds(170, 20, 165, 25);
		panel.add(password1);
		
		label2 = new JLabel("Re-enter Password");
		label2.setBounds(20, 50, 165, 25);
		panel.add(label2);
		
		password2 = new JPasswordField();
		password2.setBounds(170, 50, 165, 25);
		panel.add(password2);
		
		button = new JButton("Change Password");
		button.setBounds(100, 80, 170, 25);
		button.addActionListener(new ChangePassword());
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
		String p1 = new String(password1.getPassword());
		String p2  = new String(password2.getPassword());
        //System.out.println(username + " "+ password);
        
        
        if(p1.equals(p2))
		{
            success.setText("Password changed successfully!");
            e.setPassword(p1);//method provided im Employee class
        }
		else
		{
			success.setText("Unsuccessful, please try again");
		}	
		
    }
}

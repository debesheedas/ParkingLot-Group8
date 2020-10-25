//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/*
interface Callback
{
	void execute(boolean status);
}*/

//to call Login for both admin or Employee, call this class and run method as the following statements
//LoginGUI l = new LoginGUI();
//l.run();
public class LoginGUI implements ActionListener
{
	ParkingLot pl;
	LoginGUI(ParkingLot p)
	{
		pl=p;
	}
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

    public void run(ParkingLot pl)
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
		button.addActionListener(new LoginGUI(pl));
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
        //System.out.println(username + " "+ password);
        
        
        if(username.equals("admin")&&password.equals("password"))
		{
			success.setText("Login Successful!");
			pl.getAdmin().setLoginStatus(true);
			pl.getDatabase().updateDatabase();

			//execute(true);
            //Admin a = super.getAdmin();//getter method for admin instance variable available in ParkingLot class
            //a.setLoginStatus(true);//setter method provided in Admin class...we could consider making admin a static variable
        }
        else if(pl.searchEmployeeByUsername(username, password))
        {
            success.setText("Login Successful!");
			Employee emp = pl.returnEmployeeByUsername(username, password);//method present in ParkingLot class
			
			emp.setLoginStatus(true);//setter method of Employee class
			pl.getDatabase().updateDatabase();

            //search for employee and set login status as true
        }
		else
		{
			success.setText("Login Unsuccessful, please try again");
		}	
		
    }
}




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//call this class using the following statements by passing an Employee object IF AND ONLY IF Employee is logged in
//ChangePasswordGUI c = new ChangePasswordGUI();
//c.run(r);//where r is the Employee object
class ChangePasswordGUI implements ActionListener 
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
		button.addActionListener(new ChangePasswordGUI());
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

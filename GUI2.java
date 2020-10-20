//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class GUI2 {
    //test
}
//pass Floor object into this(Floor floor)
//to run this GUI program for a particular Floor object floor, write the following statement
// FloorDisplayGUI e = new FloorDisplayGUI(floor);
class FloorDisplayGUI
{    
    JFrame f;    
    FloorDisplayGUI(Floor floor)
    {  
        //int X = 3;
        int X = floor.getFloorNumber();//getter method from class Floor
        //int arr[] = {40, 25, 30, 25, 10, 8, 40, 25, 15, 10};
        int arr[] = floor.getNumberOfSpots();//getter method from class Floor
        String[] a = new String[10];
        for(int i=0; i<10; i++)
        {
            a[i] = Integer.toString(arr[i]);
        }  
        f=new JFrame();    
        String data[][]={ {"Compact",a[1],a[0]},    
                          {"Large",a[3],a[2]},    
                          {"Handicapped",a[5],a[4]},
                          {"Two Wheeler",a[7],a[6]},
                          {"Electric",a[9],a[8]}};    
        String column[]={"SLOT TYPE","AVAILABLE SLOTS","TOTAL SLOTS"};         
        JTable jt=new JTable(data,column);    
        jt.setBounds(30,40,200,300);          
        JScrollPane sp=new JScrollPane(jt);    
        f.add(sp);          
        f.setSize(600,300); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Floor Number "+X+" Display");   
        f.setVisible(true); 	
		
	}
		
}
//to run ElectricPanelGUI, run the following commands where p is ParkingLot object
//ElectricPanelGUI e = new ElectricPanelGUI();
//e.run(p);
class ElectricPanelGUI implements ActionListener
{
    private static JFrame frame;
	private static JPanel panel;
	private static JLabel amount_due;
	
    private static JButton start_button;
    private static JButton stop_button;
    private static JButton cash_button;
    private static JButton card_button;
    private static JLabel payment_success;
    private Time start;
    private static boolean flag;
    private static double price;
	
    void run(ParkingLot p)
    {//Pass ParkingLot object p - void run(ParkingLot p)
		
		frame = new JFrame();
		panel = new JPanel();
		frame.setTitle("Electric Panel- Automated Portal");
		frame.setSize(640,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(panel);
		panel.setLayout(null);
		
		start_button = new JButton("START CHARGING");
        start_button.setBounds(100, 80, 160, 25);
        start_button.setBackground(Color.GREEN);
		start_button.addActionListener(new ElectricPanelGUI());
        panel.add(start_button);
        
        stop_button = new JButton("STOP CHARGING");
        stop_button.setBounds(340, 80, 160, 25);
        stop_button.setBackground(Color.RED);
		stop_button.addActionListener(new ElectricPanelGUI());
        panel.add(stop_button);

        amount_due = new JLabel();
		amount_due.setBounds(100, 140, 480, 25);
        panel.add(amount_due);

        cash_button = new JButton("Pay with Cash");
		cash_button.setBounds(100, 200, 160, 25);
		cash_button.addActionListener(new ElectricPanelGUI());
        panel.add(cash_button);
        cash_button.setVisible(false);
        
        card_button = new JButton("Pay with Card");
		card_button.setBounds(340, 200, 160, 25);
		card_button.addActionListener(new ElectricPanelGUI());
        panel.add(card_button);
        card_button.setVisible(false);
		
		payment_success = new JLabel();
		payment_success.setBounds(100, 250, 300, 25);
        panel.add(payment_success);
        price = p.getPriceOfElectricityPerHour();
		
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        System.out.println("Some Button clicked");
        if(e.getSource().equals(start_button))
        {
            System.out.println("Start Button clicked");
            amount_due.setText("Charging...");
            start = new Time();
            flag = true;
            cash_button.setVisible(false);
            card_button.setVisible(false);
            payment_success.setVisible(false);
        }
        else if(e.getSource().equals(stop_button) && flag==true)
        {
            double bill=0;
            Time stop = new Time();
            //double d = 3;
            double d = stop.diff(start);
            bill = d*price;
            System.out.println("Stop Button clicked");
            amount_due.setText("The Bill Amount is "+bill+" rupees and the time charged is "+d+" hours");//replace X with bill. could considered showing time charged also
            cash_button.setVisible(true);
            card_button.setVisible(true);
            flag=false;
            
        }
        else if(e.getSource().equals(card_button)|| e.getSource().equals(cash_button))
        {
            System.out.println("Pay with cash or pay with card Button clicked");
            payment_success.setVisible(true);
            payment_success.setText("Payment Successful!");
            cash_button.setVisible(false);
            card_button.setVisible(false);            
        }		
    }	
}	
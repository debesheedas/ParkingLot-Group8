import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ElectricPanelGUI implements ActionListener
{
    ParkingLot p;
    private static JFrame frame;
	private static JPanel panel;
	private static JLabel amount_due;
	
    private static JButton start_button;
    private static JButton stop_button;
    private static JButton cash_button;
    private static JButton card_button;
    private static JLabel payment_success;
    private static Time start;
    private static Time stop;
    private static boolean flag;
    private static double price;
    
    ElectricPanelGUI(ParkingLot pl)
    {
        start = new Time();
        stop = new Time();
        p=pl;
        price = pl.getPriceOfElectricityPerHour();
    }
    void run()
    {
		
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
		start_button.addActionListener(new ElectricPanelGUI(p));
        panel.add(start_button);
        
        stop_button = new JButton("STOP CHARGING");
        stop_button.setBounds(340, 80, 160, 25);
        stop_button.setBackground(Color.RED);
		stop_button.addActionListener(new ElectricPanelGUI(p));
        panel.add(stop_button);

        amount_due = new JLabel();
		amount_due.setBounds(100, 140, 480, 25);
        panel.add(amount_due);

        cash_button = new JButton("Pay with Cash");
		cash_button.setBounds(100, 200, 160, 25);
		cash_button.addActionListener(new ElectricPanelGUI(p));
        panel.add(cash_button);
        cash_button.setVisible(false);
        
        card_button = new JButton("Pay with Card");
		card_button.setBounds(340, 200, 160, 25);
		card_button.addActionListener(new ElectricPanelGUI(p));
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

        //System.out.println("Some Button clicked");
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
            stop = new Time();
            //double d = 3;
            //System.out.println(price);
            //System.out.println(start.getTime());
            double d = stop.diff(start);
            bill = d*price;
            System.out.println("Stop Button clicked");
            amount_due.setText("The Bill Amount is "+bill+" rupees and the time charged is "+d*60+" minutes");//replace X with bill. could considered showing time charged also
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
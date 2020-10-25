//Admin Options 
import java.util.*;
//import java.util.concurrent.atomic.DoubleAdder;
import javax.swing.*;
//import jdk.javadoc.internal.doclets.formats.html.PackageWriterImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class AdminOptionsGUITest
{
    public static void main(String args[])
    {
        System.out.println("Running");
        AdminOptionsGUI e = new AdminOptionsGUI();
        e.run();

    }
}*/
public class AdminOptionsGUI implements ActionListener
{
    ParkingLot p;
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel electricityPriceLabel;
    private static JTextField electricityPrice;
    private static JLabel ParkingRateLabel;
    private static JLabel ParkingCategoryLabel;
    private static JLabel FirstHourLabel;
    private static JTextField[] cpf = new JTextField[3];
    private static JTextField[] lpf = new JTextField[3];
    private static JTextField[] hpf = new JTextField[3];
    private static JTextField[] tpf = new JTextField[3];
    private static JTextField[] epf = new JTextField[3];
    private static JLabel SecondHourLabel;
    private static JLabel RemainingHourLabel;
    private static JLabel FloorNoLabel;
    private static JLabel ParkingCategoryLabel2;
    private static JLabel[] FloorNumbers;
    private static JTextField[][] FloorFields;
    private static JLabel save_success;
    private static JButton save_button;
    private static JButton add_floor_button;
    private static JButton remove_floor_button;

    private final int maxNumberOfFloors = 15;
    private double pe=3;
    private double[] cp = {20, 10, 5};
    private double[] lp = {30, 20, 10};
    private double[] hp = {20, 10, 5};
    private double[] tp = {10, 5, 4};
    private double[] ep = {20, 10, 5};
    private static int numberOfFloors=5;
    private int[][] floorMatrix = new int[maxNumberOfFloors][10];
    private ArrayList<Floor> inputFloorMatrix;
    
 

    AdminOptionsGUI(ParkingLot pl)
    {
        p=pl;
        pe = p.getPriceOfElectricityPerHour();
        cp = p.getCompactPrices();
        lp = p.getLargePrices();
        hp = p.getHandicappedPrices();
        tp = p.getTwowheelerPrices();
        ep = p.getElectricPrices();
        inputFloorMatrix = p.getAllFloors();
        
        System.out.println("i am in  constructor");
    }
    void setUpFloorMatrix()
    {
        int n = inputFloorMatrix.size();int m=0;
        for(Floor i: inputFloorMatrix)
        {            
            int[] arr = i.getNumberOfSpots();
            for(int j=0; j<10; j++)
            {
                floorMatrix[m][j] = arr[j];
            }
            m++;
        }
        for(int i=n; i<maxNumberOfFloors; i++)
        {
            for(int j=0; j<10; j++)
            {
                floorMatrix[i][j]=0;
            }
        }
    }
    
	void run(){
        setUpFloorMatrix(); 

		frame = new JFrame();
        panel = new JPanel();

        System.out.println("check");
        
		frame.setTitle("Admin Options");
		frame.setSize(1000,3000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.add(panel);
        panel.setLayout(null);
        
        electricityPriceLabel = new JLabel("The price of electricity per hour in rupees");
		electricityPriceLabel.setBounds(20, 40, 300, 25);
        panel.add(electricityPriceLabel);
		
		electricityPrice = new JTextField(Double.toString(pe));
		electricityPrice.setBounds(340, 40, 165, 25);
        panel.add(electricityPrice);

        ParkingRateLabel = new JLabel("Parking Rate in Rupees");
		ParkingRateLabel.setBounds(20, 80, 300, 25);
        panel.add(ParkingRateLabel);

        ParkingCategoryLabel = new JLabel("Compact   Large   Handicapped  Two-Wheeler  Electric");
		ParkingCategoryLabel.setBounds(340, 80, 500, 25);
        panel.add(ParkingCategoryLabel);

        FirstHourLabel = new JLabel("First Hour");
		FirstHourLabel.setBounds(20, 110, 300, 25);
        panel.add(FirstHourLabel);

        SecondHourLabel = new JLabel("Second & Third Hour");
		SecondHourLabel.setBounds(20, 140, 300, 25);
        panel.add(SecondHourLabel);
        
        RemainingHourLabel = new JLabel("Remaining Hours");
		RemainingHourLabel.setBounds(20, 170, 300, 25);
        panel.add(RemainingHourLabel);
        
        for(int i=0; i<3; i++)
        {
            cpf[i] = new JTextField(Double.toString(cp[i]));
            int y = 110+(i*30);
            cpf[i].setBounds(340, y, 60, 25);
            //cpf[i].setText(Integer.toString(cp[i]));
            panel.add(cpf[i]);
        }
        for(int i=0; i<3; i++)
        {
            lpf[i] = new JTextField(Double.toString(lp[i]));
            int y = 110+(i*30);
            lpf[i].setBounds(415, y, 60, 25);
            //cpf[i].setText(Integer.toString(cp[i]));
            panel.add(lpf[i]);
        }
        for(int i=0; i<3; i++)
        {
            hpf[i] = new JTextField(Double.toString(hp[i]));
            int y = 110+(i*30);
            hpf[i].setBounds(490, y, 60, 25);
            //cpf[i].setText(Integer.toString(cp[i]));
            panel.add(hpf[i]);
        }
        for(int i=0; i<3; i++)
        {
            tpf[i] = new JTextField(Double.toString(tp[i]));
            int y = 110+(i*30);
            tpf[i].setBounds(565, y, 60, 25);
            //cpf[i].setText(Integer.toString(cp[i]));
            panel.add(tpf[i]);
        }
        for(int i=0; i<3; i++)
        {
            epf[i] = new JTextField(Double.toString(ep[i]));
            int y = 110+(i*30);
            epf[i].setBounds(640, y, 60, 25);
            //cpf[i].setText(Integer.toString(cp[i]));
            panel.add(epf[i]);
        }
        
        FloorNoLabel = new JLabel("Floor Number");
		FloorNoLabel.setBounds(20, 230, 300, 25);
        panel.add(FloorNoLabel);

        ParkingCategoryLabel2 = new JLabel("Compact   Large   Handicapped  Two-Wheeler  Electric");
		ParkingCategoryLabel2.setBounds(340, 230, 500, 25);
        panel.add(ParkingCategoryLabel2);

        FloorNumbers= new JLabel[numberOfFloors];
        FloorFields = new JTextField[numberOfFloors][10];
        //initializing floorMatrix
        initializeFloorMatrix(numberOfFloors);
        initializeFloorDisplay(numberOfFloors);
        /*for(int i=0; i<numberOfFloors; i++)
        {
            FloorNumbers[i] = new JLabel(Integer.toString(i+1));
            int y=270+(i*30);
            FloorNumbers[i].setBounds(40, y, 30, 25);
            panel.add(FloorNumbers[i]);

        }
        for(int i=0; i<numberOfFloors; i++)
        {
            for(int j=0; j<10; j=j+2)
            {
                int x = 340 + (j/2)*75;
                int y=270+(i*30);
                FloorFields[i][j] = new JTextField(Integer.toString(floorMatrix[i][j]));
                FloorFields[i][j].setBounds(x, y, 60, 25);
                panel.add(FloorFields[i][j]);
            }
            FloorNumbers[i] = new JLabel(Integer.toString(i+1));
            int y=270+(i*30);
            FloorNumbers[i].setBounds(40, y, 30, 25);
            panel.add(FloorNumbers[i]);

        }  */        
        
        add_floor_button = new JButton("ADD FLOOR");
        add_floor_button.setBounds(100, 560, 160, 25);
        add_floor_button.setBackground(Color.GREEN);
		add_floor_button.addActionListener(new AdminOptionsGUI(p));
        panel.add(add_floor_button);

        remove_floor_button = new JButton("REMOVE FLOOR");
        remove_floor_button.setBounds(400, 560, 160, 25);
        remove_floor_button.setBackground(Color.RED);
		remove_floor_button.addActionListener(new AdminOptionsGUI(p));
        panel.add(remove_floor_button);
        
        save_button = new JButton("SAVE CHANGES");
        save_button.setBounds(500, 600, 160, 25);
        save_button.setBackground(Color.GREEN);
		save_button.addActionListener(new AdminOptionsGUI(p));
        panel.add(save_button);

        save_success = new JLabel();
		save_success.setBounds(500, 840, 300, 25);
        panel.add(save_success);
		
        frame.setVisible(true);
    }

    public void initializeFloorMatrix(int n)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<10; j++)
            {
                
                floorMatrix[i][j]=0;
               
            }
        }
    }
    public void initializeFloorDisplay(int n)
    {
        FloorNumbers= new JLabel[maxNumberOfFloors];
        FloorFields = new JTextField[maxNumberOfFloors][10];
        for(int i=0; i<maxNumberOfFloors; i++)
        {
            FloorNumbers[i] = new JLabel(Integer.toString(i+1));
            int y=270+(i*30);
            FloorNumbers[i].setBounds(40, y, 30, 25);
            panel.add(FloorNumbers[i]);
            if(i<n)
                {
                    FloorNumbers[i].setVisible(true);
                }
                else
                {
                    FloorNumbers[i].setVisible(false);
                }

        }
        for(int i=0; i<maxNumberOfFloors; i++)
        {
            for(int j=0; j<10; j=j+2)
            {
                int x = 340 + (j/2)*75;
                int y=270+(i*30);
                FloorFields[i][j] = new JTextField(Integer.toString(floorMatrix[i][j]));
                FloorFields[i][j].setBounds(x, y, 60, 25);
                panel.add(FloorFields[i][j]);
                if(i<n)
                {
                    FloorFields[i][j].setVisible(true);
                }
                else
                {
                    FloorFields[i][j].setVisible(false);
                }
            }

        }    

    }
    public void refreshFloorDisplay(int n)
    {
        for(int i=0; i<maxNumberOfFloors; i++)
        {
            if(i<n)
                {
                    FloorNumbers[i].setVisible(true);
                }
                else
                {
                    FloorNumbers[i].setVisible(false);
                }
        }
        for(int i=0; i<maxNumberOfFloors; i++)
        {
            for(int j=0; j<10; j=j+2)
            {
            
                if(i<n)
                {
                    FloorFields[i][j].setVisible(true);
                }
                else
                {
                    FloorFields[i][j].setVisible(false);
                }
            }

        }  

    }
        public void updateFloorMatrix(int n)
        {
            for(int i=0; i<maxNumberOfFloors; i++)
            {
                for(int j=0; j<10; j=j+2)
                {
                    if(i<n)
                    {
                        floorMatrix[i][j] = Integer.parseInt("0"+FloorFields[i][j].getText());
                    }
                    else
                    {
                        floorMatrix[i][j]=0;
                        FloorFields[i][j].setText("0");
                    }
                }

            }  
        }  
        public void updatePrices()
        {
            for(int i=0; i<3; i++)
            {
                cp[i] = Double.parseDouble("0"+cpf[i].getText());
            
            }
            for(int i=0; i<3; i++)
            {
                lp[i] = Double.parseDouble("0"+lpf[i].getText());
            
            }
            for(int i=0; i<3; i++)
            {
                hp[i] = Double.parseDouble("0"+hpf[i].getText());
            
            }
            for(int i=0; i<3; i++)
            {
                tp[i] = Double.parseDouble("0"+tpf[i].getText());
            
            }
            for(int i=0; i<3; i++)
            {
                ep[i] = Double.parseDouble("0"+epf[i].getText());
            
            }
            p.setCompactPrices(cp);
            p.setLargePrices(lp);
            p.setHandicappedPrices(hp);
            p.setTwowheelerPrices(tp);
            p.setElectricPrices(ep);

        }
        public void saveFloorMatrix(int n)
        {
            ArrayList<Floor> temp = new ArrayList<Floor>();
            for(int i=0; i<n; i++)
            {
                int[] t = new int[10];
                for(int j=0; j<10; j=j+2)
                {
                    t[j]=floorMatrix[i][j];
                    t[j+1]=floorMatrix[i][j];
                }
                Floor f = new Floor(p, t, i+1);
                temp.add(f);
            }

            p.setFloors(temp);
            for(int i=0; i<maxNumberOfFloors; i++)
            {
                for(int j=0; j<10; j=j+2)
                {
                    if(i<n)
                    {
                        floorMatrix[i][j] = Integer.parseInt("0"+FloorFields[i][j].getText());
                    }
                    else
                    {
                        floorMatrix[i][j]=0;
                        FloorFields[i][j].setText("0");
                    }
                }

            }  
        }
        void checkUpdate()
        {
            System.out.println(p.getPriceOfElectricityPerHour());
            System.out.println(p.getCompactPrices().toString());
            System.out.println(p.getLargePrices());
            System.out.println(p.getHandicappedPrices());
            System.out.println(p.getElectricPrices());
    
            System.out.println(p.getAllFloors());
            for(Floor f: p.getAllFloors())
            {
                System.out.println(f.getFloorNo());
                System.out.println(f.getAllSpotsOnthisFloor());
                System.out.println(f.getNumberOfSpots());
                for(int i: f.getNumberOfSpots())
                {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }  
    void removeDeletedCheckpoints(int n)
    {
        ArrayList<Checkpoint> all = p.getAllCheckpoints();
        for(Checkpoint i:all)
        {
            if(i.getFloorNumber()>n)
            {
                p.removeCheckpoint(i);
            }
        }
    }        

    
    
    @Override
	public void actionPerformed(ActionEvent e) {

        //System.out.println("Some Button clicked");
        if(e.getSource().equals(save_button))
        {
            
            pe = Double.parseDouble("0"+electricityPrice.getText());
            //System.out.println("save Button clicked"+pe);
            p.setPriceOfElectricityPerHour(pe);
            updatePrices();
            updateFloorMatrix(numberOfFloors);
            saveFloorMatrix(numberOfFloors);
            removeDeletedCheckpoints(numberOfFloors);
            //checkUpdate();
            p.getDatabase().updateDatabase();
            save_success.setText("Changes Saved Successfully!");
           
        }
        
        else if(e.getSource().equals(add_floor_button))
        {
            if(numberOfFloors<15)
            {
                numberOfFloors++;
                updateFloorMatrix(numberOfFloors);
                //initializeFloorMatrix(numberOfFloors);
                refreshFloorDisplay(numberOfFloors);
            }
            System.out.println("Add Floor Button clicked");
            
        }
        else if(e.getSource().equals(remove_floor_button))
        {
            if(numberOfFloors>0)
            {
                numberOfFloors--;
                updateFloorMatrix(numberOfFloors);
                //initializeFloorMatrix(numberOfFloors);
                refreshFloorDisplay(numberOfFloors);
            }
            
            System.out.println("Remove floor Button clicked");
            
        }		
		
	}
		
}
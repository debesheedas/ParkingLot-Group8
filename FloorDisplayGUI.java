//Debeshee

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



//pass Floor object into this(Floor floor)
//to run this GUI program for a particular Floor object floor, write the following statement
// FloorDisplayGUI e = new FloorDisplayGUI(floor);
public class FloorDisplayGUI
{    
    JFrame f;    
    FloorDisplayGUI(Floor floor)
    {  
        //int X = 3;
        int X = floor.getFloorNo();//getter method from class Floor
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

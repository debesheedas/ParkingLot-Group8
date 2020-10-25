import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Time//try ot figure out how to generate a Date object from String
{
    /*public static void main(String args[])
    {
        Time t1 = new Time();
        Time t2 = new Time();
        System.out.println(t2.diff(t1));
    }*/
    
    Date d ; //

    Time(){
            d = new Date(System.currentTimeMillis());
    }
    Time(String time){

        SimpleDateFormat formatter = new SimpleDateFormat("E M d HH:mm:ss z yyyy");  
        try {  
            this.d = formatter.parse(time);  
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    double diff(Time entry)//this method returns the difference in time between the 2 date objects as a double data type, useful for calculating bill amounts
    {   
        double timeDiff =Math.abs(((entry.d.getTime() - this.d.getTime())/3600000.0)) ;
        return timeDiff;//return the difference in time between (this.d-entry.d) ;
    }
    String getTime()
    {
        return d.toString();
    }
    void setTime(String time)//how to ma ke a Date object
    {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");  
        try {  
            this.d = formatter.parse(time);  
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}


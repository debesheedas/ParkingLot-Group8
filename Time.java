import java.util.*;

public class Time//try ot figure out how to generate a Date object from String
{
    Date d = new Date(System.currentTimeMillis());
    String time = d.toString();
    double diff(Time entry)//this method returns the difference in time between the 2 date objects as a double data type, useful for calculating bill amounts
    {   
        return (this.d.getTime()-entry.d.getTime())/3600000;//return the difference in time between (this.d-entry.d) ;
    }
    String getTime()
    {
        return time;
    }
    void setTime(String t)//how to ma ke a Date object
    {
        time= t;
        d=null;
    }
    
}
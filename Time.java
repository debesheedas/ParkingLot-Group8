import java.util.*;

public class Time
{
    Date d = new Date(System.currentTimeMillis());
    double diff(Time entry)//this method returns the difference in time between the 2 date objects as a double data type, useful for calculating bill amounts
    {
        return (this.d.getTime()-entry.d.getTime())/3600000;//return the difference in time between (this.d-entry.d) ;
    }
}
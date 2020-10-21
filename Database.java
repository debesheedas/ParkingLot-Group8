//Aashrith
//Handling information exchange between database inout output and program
import java.lang.System;
import java.sql.*;
import java.util.*;

// Driver path   -------->>   ".;JDBC/sqlite-jdbc-3.7.2.jar"
public class Database{
    
    private String db_name = "parkinglot.db";
    private String url = "jdbc:sqlite:db/"+db_name; // url of the database

    public static void main(String[] args) {

        Database db = new Database();
        db.deleteAllTables();
        System.out.println(db.count_tables());
        db.setupDatabase();
        System.out.println(db.count_tables());
        //db.loadData();
        // db.addTicket(1, "12:30", "compact");
        // db.addTicket(2, "1:30", "large");
        // db.addTicket(3, "2:30", "compact");
        // db.getAllTickets();
        // db.deleteTicket(3);
        // db.getAllTickets();
        // db.addEmployee(1, "aashrith", "qwert", 1000);
        // db.addEmployee(2, "e2", "qert", 1500);
        // db.deleteEmployee(1);
        // db.getAllEmployees();
    }


    private Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return conn;
    }

     public int count_tables(){
         int n = 0;
         try(   
                Connection c = this.connect();
                ResultSet rs = c.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
         ){
            
             while(rs.next()){
                    n++;
             }
            }catch(Exception e){
                System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            }
            return n;
     }

     public void setupDatabase(){
         try(Connection c = this.connect();
            Statement s = c.createStatement();
         ){

            s.executeUpdate("create table if not exists employees (id int primary key not null , name text not null , pswd text not null , due int not null)");
            s.executeUpdate("create table if not exists floors (num int primary key not null , tcs int not null , acs int not null , tls int not null , als int not null , ths int not null , ahs int not null , ttws int not null , atws int not null , tes int not null , aes int not null )");
            s.executeUpdate("create table if not exists tickets (id int primary key not null , starttime text not null , slot text not null )");
            s.executeUpdate("create table if not exists checkpoints (id int primary key not null , name text not null , type text not null , floorno int not null , employeeAssigned int not null )");
            s.executeUpdate("create table if not exists spotprices (type text primary key not null , firsthour int not null , secondhour int not null , remaininghours int not null)");

         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }
     }

     public void deleteAllTables(){
         try(Connection c = this.connect();
            Statement s = c.createStatement();
         ){
            s.executeUpdate("drop table if exists 'employees' ");
            s.executeUpdate("drop table if exists 'floors' ");
            s.executeUpdate("drop table if exists 'tickets' ");
            s.executeUpdate("drop table if exists 'checkpoints' ");
            s.executeUpdate("drop table if exists 'spotprices' ");
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }
     }





     private void addEmployee(int id , String name , String pswd , int due){

      try(Connection c = this.connect();
          PreparedStatement ps = c.prepareStatement("insert into employees values (?,?,?,?)");
       ){

          ps.setInt(1, id);
          ps.setString(2, name);
          ps.setString(3, pswd);
          ps.setInt(4, due);
          ps.executeUpdate();
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
       }

   }


   private void addFloor(int num , int tcs ,int acs ,int tls ,int als ,int ths ,int ahs ,int ttws ,int atws ,int tes ,int aes ){

      try(Connection c = this.connect();
          PreparedStatement ps = c.prepareStatement("insert into floors values (?,?,?,?,?,?,?,?,?,?,?)");
       ){

          ps.setInt(1, num);
          ps.setInt(2, tcs);
          ps.setInt(3,acs);
          ps.setInt(4, tls);
          ps.setInt(5, als);
          ps.setInt(6, ths);
          ps.setInt(7, ahs);
          ps.setInt(8, ttws);
          ps.setInt(9, atws);
          ps.setInt(10, tes);
          ps.setInt(11, aes);
          
          ps.executeUpdate();
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
       }

   }

   private void addTicket(int id , String starttime , String slot){

        try(Connection c = this.connect();
            PreparedStatement ps = c.prepareStatement("insert into tickets values (?,?,?)");
         ){

            ps.setInt(1, id);
            ps.setString(2, starttime);
            ps.setString(3, slot);
            ps.executeUpdate();
            
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }

   }


     




     private ArrayList<Employee> fillEmployees(ArrayList<Employee> employees){
        employees.clear();
        try(Connection c = this.connect();
            Statement s = c.createStatement();
         ){

            ResultSet rs = s.executeQuery("select * from employees");
            while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String pswd = rs.getString("pswd");
               int due = rs.getInt("due");

               Employee e = new Employee();
               e.setId(id);
               e.setName(name);
               e.setPswd(pswd);
               e.setDue(due);

               employees.add(e);
            }

            return employees;
            
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            return null;
         }
     }

     private ArrayList<Floor> fillFloors(ArrayList<Floor> floors){
      floors.clear();
      try(Connection c = this.connect();
          Statement s = c.createStatement();
       ){

          ResultSet rs = s.executeQuery("select * from floors");
          while(rs.next()){
             int num = rs.getInt("num");
             int tcs = rs.getInt("tcs");
             int acs = rs.getInt("acs");
             int tls = rs.getInt("tls");
             int als = rs.getInt("als");
             int ths = rs.getInt("ths");
             int ahs = rs.getInt("ahs");
             int ttws = rs.getInt("ttws");
             int atws = rs.getInt("atws");
             int tes = rs.getInt("tes");
             int aes = rs.getInt("aes");

             Floor f = new Floor();
             f.setFloornum(num);
             f.setTCS(tcs);
             f.setACS(acs);
             f.setTLS(tls);
             f.setALS(als);
             f.setTHS(ths);
             f.setAHS(ahs);
             f.setTTWS(ttws);
             f.setATWS(atws);
             f.setTES(tes);
             f.setAES(aes);

             floors.add(f);
          }

          return floors;
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
       }
   }

   private ArrayList<Ticket> fillTickets(ArrayList<Ticket> tickets){
      tickets.clear();
      try(Connection c = this.connect();
          Statement s = c.createStatement();
       ){

          ResultSet rs = s.executeQuery("select * from tickets");
          while(rs.next()){
             int id = rs.getInt("id");
             String startTime = rs.getString("starttime");
             String slot = rs.getString("slot");
             

             Ticket t = new Ticket();
             t.setId(id);
             t.setStartTime(startTime);
             t.setSlot(slot);

             tickets.add(t);
          }

          return tickets;
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
       }
   }

   private ArrayList<CheckPoint> fillCheckPoints(ArrayList<Checkpoint> checkPoints){
      checkPoints.clear();
      try(Connection c = this.connect();
          Statement s = c.createStatement();
       ){

          ResultSet rs = s.executeQuery("select * from checkpoints");
          while(rs.next()){
             int id = rs.getInt("id");
             String name = rs.getString("name");
             String type = rs.getString("type");
             int floorno = rs.getInt("floorno");
             int employeeAssigned = rs.getInt("employeeAssigned");
             

             CheckPoint c = new Checkpoint();

             c.setId(id);
             c.setName(name);
             c.setType(type);
             c.setFloorNo(floorno);
             c.setEmployee(employeeAssigned);
             

             checkPoints.add(c);
          }

          return checkPoints;
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
       }
   }

   private ArrayList<Spot> fillSpots(ArrayList<Spot> spots){
      spots.clear();
      try(Connection c = this.connect();
          Statement s = c.createStatement();
       ){

          ResultSet rs = s.executeQuery("select * from spotprices");
          while(rs.next()){
             String type = rs.getString("type");
             int fh = rs.getInt("firsthour");
             int sh = rs.getInt("secondhour");
             int rh = rs.getInt("remaininghours");
             

             Spot s = new Spot();

             s.setType(type);
             s.setFirstHour(fh);
             s.setSecondHour(sh);
             s.setRemainingHours(rh);
             

             spots.add(s);
          }

          return spots;
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
       }
   }





     public ParkingLot loadDatabase(ParkingLot pl){

        pl.setEmployees(fillEmployees(new ArrayList<Employee>()));
        pl.setFloors(fillFloors(new ArrayList<Floor>()));
        pl.setTickets(fillTickets(new ArrayList<Ticket>()));
        pl.setCheckPoints(fillCheckPoints(new ArrayList<CheckPoint>()));
        pl.setSpots(fillSpots(new ArrayList<Spot>()));

      return pl;

     }

     public void updateDatabase(ParkingLot pl){

     }
    


    //every time admin options are changed, reset the whole database
    //  public boolean databaseExists()
    //  {
    //      //return true if the database with same name as ParkingLotDatabase, basically check if database exists
    //      try{
    //         int no_tables = 0;
    //         DatabaseMetaData metaData = conn.getMetaData();
    //         String[] types = {"TABLE"};
    //         ResultSet tables = metaData.getTables(null, null, "FLOORS", null);
    //         while (tables.next()) {
    //             System.out.println(tables.getString("TABLE_NAME"));
    //             no_tables++;
    //         }
    //         System.out.println("No of tables : "+no_tables);
    //         tables.close();
    //         if(no_tables==0)
    //             return false;
    //         else    
    //             return true;
    //      }catch(Exception e){
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         return false;
    //      }
         
    //  }


//      private void setupDatabase()//if database does not exist already
//      {
//          System.out.println("setup method.");

//          try{
//             String sql = "CREATE TABLE FLOORS (FLOORNO INT,TCS INT);";
//             stmt.executeUpdate(sql);
//             sql = "INSERT INTO FLOORS (FLOORNO,TCS) VALUES (1,2);";
//             stmt.executeUpdate(sql);
//             sql = "INSERT INTO FLOORS (FLOORNO,TCS) VALUES (2,10);";
//             stmt.executeUpdate(sql);
//             sql = "INSERT INTO FLOORS (FLOORNO,TCS) VALUES (3,7);";
//             stmt.executeUpdate(sql);
            
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }

          
         
//          //if no then continue in this method
//          //create a default admin object and then call methods on it - with hardcoded standard password
//          //call admin methods - Customer.java - such as sign in, followed by changeSettings method(only if admin login is successful)
//          //create Database named ParkingLotDatabase
//          //create the tables, initalise the slots with their unique ids and types

//         //  Admin admin = new Admin();
//         //  boolean successful = admin.signIn();
//         //  if(successful){
//         //      admin.changeSettings();
//         //      connect();
//         //  }else{
//         //     System.out.println("Login Failed!!");
//         //  }
//      }
     private void loadData(){

        getAllEmployees();
        getAllTickets();
            
     }
//      //individual methods to update particular tables

//      public void updateAll()
//      {
//         //call all the individual update methods to update all the tables
//      }

//      private void insertEmloyee(int id,String name,String pswd,int due){
//          String sql = "INSERT INTO Employees (id,name,pswd,due) VALUES (?,?,?,?)";
//          try{
//              PreparedStatement pstmt = conn.prepareStatement(sql);
//              pstmt.setInt(1, id);
//              pstmt.setString(2, name);
//              pstmt.setString(3, pswd);
//              pstmt.setInt(4, due);
//              pstmt.executeUpdate();
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }
//      }

//      private void insertFloor(int floorno,int cs,int ls,int hs,int tws,int es){
//          String sql = "INSERT INTO Employees (floorno,cs,acs,ls,als,hs,ahs,tws,atws,es,aes) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//          try{
//              PreparedStatement pstmt = conn.prepareStatement(sql);
//              pstmt.setInt(1, floorno);
//              pstmt.setInt(2, cs);
//              pstmt.setInt(3, cs);
//              pstmt.setInt(4, ls);
//              pstmt.setInt(5, ls);
//              pstmt.setInt(6, hs);
//              pstmt.setInt(7, hs);
//              pstmt.setInt(8, tws);
//              pstmt.setInt(9, tws);
//              pstmt.setInt(10, es);
//              pstmt.setInt(11, es);
//              pstmt.executeUpdate();
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }
//      }
//      private void insertTicket(int startTime , String spot){
//          String sql = "INSERT INTO Tickets (startTime,spot) VALUES (?,?)";
//          try{
//              PreparedStatement pstmt = conn.prepareStatement(sql);
//              pstmt.setInt(1, startTime);
//              pstmt.setString(2, spot);
//              pstmt.executeUpdate();
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }
//      }
//      private void insertCheckpoint(String name,String type,int floorno){
//          String sql = "INSERT INTO Employees (name,type,floorno) VALUES (?,?,?)";
//          try{
//              PreparedStatement pstmt = conn.prepareStatement(sql);
//              pstmt.setString(1, name);
//              pstmt.setString(2, type);
//              pstmt.setInt(3, floorno);
//              pstmt.executeUpdate();
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }
//      }
//      private void insertSpot(int firstHour,int nextTwoHours , int remainingHours){
//          String sql = "INSERT INTO spots(firstHour,nextTwoHours,remainingHours) VALUES (?,?,?)";
//          try{
//              PreparedStatement pstmt = conn.prepareStatement(sql);
//              pstmt.setInt(1, firstHour);
//              pstmt.setInt(2, nextTwoHours);
//              pstmt.setInt(3, remainingHours);
//              pstmt.executeUpdate();
//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }
//      }
     
    
    
}
//one database for the entire program - check if database of given name already exist, otherwise run the setup database module
//one database for the entire parking lot.
//one table for employees
//one table for slots
//whenever program is launched, read data from existing databases and create all the objects java and assign all the values
//use these created objects throughout the program and update the database at regular intervals - code to update database should be in this file
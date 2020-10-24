//Aashrith
//Handling information exchange between database inout output and program
import java.io.File;
import java.lang.System;
import java.sql.*;
import java.util.*;

// Driver path   -------->   ".;JDBC/sqlite-jdbc-3.7.2.jar"
public class Database{
    
    private String db_name = "parkinglot.db";
    private String url = "jdbc:sqlite:db/"+db_name; // url of the database
    private ParkingLot pl;

    Database(ParkingLot pl){
      this.pl = pl;
      db_name = "parkinglot.db";
      url = "jdbc:sqlite:db/"+db_name;
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

            s.executeUpdate("create table if not exists employees (id int primary key not null , name text not null , pswd text not null , due real not null , loginStatus text not null)");
            s.executeUpdate("create table if not exists floors (floorNo int primary key not null , tcs int not null , acs int not null , tls int not null , als int not null , ths int not null , ahs int not null , ttws int not null , atws int not null , tes int not null , aes int not null )");
            s.executeUpdate("create table if not exists tickets (id int primary key not null , startTime text not null , spotID int not null , floorNo int not null , vnp text not null )");
            s.executeUpdate("create table if not exists checkpoints (id int primary key  not null, name text not null, type text not null, floorNo int not null, assignedEmployeeID int not null)");
            s.executeUpdate("create table if not exists spotprices (type text primary key not null , firsthour real not null , secondhour real not null , remaininghours real not null)");

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


   //=======================================================================================================================

   private Admin getAdmin(){
   
      try(Connection c = this.connect();
          Statement s = c.createStatement();
       ){

          ResultSet rs = s.executeQuery("select * from employees");
          while(rs.next()){
            
            int id = rs.getInt("id");
            if(id == 0){

               String loginstatus = rs.getString("loginStatus");

               Admin admin = new Admin(pl , loginstatus.equals("yes"));

               return admin;
            }
             
          }

          return null;
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
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
               double due = rs.getDouble("due");
               String loginstatus = rs.getString("loginStatus");

               Employee e = new Employee(this.pl ,id,name,pswd,due , loginstatus.equals("yes"));
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
             int floorNo = rs.getInt("floorNo");
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

            Floor f = new Floor(this.pl , new int[]{tcs , acs ,tls , als , ths , ahs , ttws , atws , tes , aes } , floorNo);
            //  f.setFloorNo(num);
            //  f.setTotalNumberOfCompactSpots(tcs);
            //  f.setNumberOfAvailableCompactSpots(acs);
            //  f.setTotalNumberOfLargeSpots(tls);
            //  f.setNumberOfAvailableLargeSpots(als);
            //  f.setTotalNumberOfHandicappedSpots(ths);
            //  f.setNumberOfAvailableHandicappedSpots(ahs);
            //  f.setTotalNumberOfTwowheelerSpots(ttws);
            //  f.setNumberOfAvailableTwowheelerSpots(atws);
            //  f.setTotalNumberOfElectricalSpots(tes);
            //  f.setNumberOfAvailableElectricalSpots(aes);

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
             String startTime = rs.getString("startTime");
             int spotID = rs.getInt("spotID");
             int floorNo = rs.getInt("floorNo");
             String vnp = rs.getString("vnp");

             Ticket t =null;

             ArrayList<Floor> floors = pl.getAllFloors();
             for(Floor floor : floors){
                if(floor.getFloorNo() == floorNo){
                   ArrayList<Spot> spots = floor.getAllSpotsOnthisFloor();
                   for(Spot spot : spots){
                      if(spot.getID() == spotID){
                         Time time = new Time();
                         time.setTime(startTime);
                           t = new Ticket(pl,id, spot,time , vnp);
                      }
                   }
                }
             }
             
             tickets.add(t);
         }

          return tickets;
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
       }
   }

   private ArrayList<Checkpoint> fillCheckPoints(ArrayList<Checkpoint> checkPoints){
      checkPoints.clear();
      try(Connection c = this.connect();
          Statement s = c.createStatement();
      ){

          ResultSet rs = s.executeQuery("select * from checkpoints");
          while(rs.next()){
             int id = rs.getInt("id");
             String name = rs.getString("name");
             String type = rs.getString("type");
             int floorNo = rs.getInt("floorNo");
             int assignedEmployeeID = rs.getInt("assignedEmployeeID");

            switch (type) {
               case "ENTRY":
                   EntryPoint ep = new EntryPoint(this.pl , id , name , floorNo);
                   ep.setAssigned(assignedEmployeeID);
                   ep.setCheckpointType(CheckpointType.ENTRY);
                   checkPoints.add(ep);
                   break;
               
               case "EXIT":
                  ExitPoint exp = new ExitPoint(this.pl , id , name , floorNo);
                  exp.setAssigned(assignedEmployeeID);
                  exp.setCheckpointType(CheckpointType.EXIT);
                  checkPoints.add(exp);
                  break;
               case "INFO":
                  InfoPortal ip = new InfoPortal(this.pl , id , name , floorNo);
                  ip.setAssigned(assignedEmployeeID);
                  ip.setCheckpointType(CheckpointType.INFO);
                  checkPoints.add(ip);
                  break;
             
                default:
                   break;
            }

         }

         return checkPoints;
          
      }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
      }
   }

   private double[] getSpotPrices(String type){

      double[] spotPrices = new double[3];
   
      try(Connection c = this.connect();
          PreparedStatement ps = c.prepareStatement("select * from spotprices where type like ?");
      ){

         ps.setString(1, type);

         ResultSet rs = ps.executeQuery();
         spotPrices[0] = rs.getDouble("firsthour");
         spotPrices[1] = rs.getDouble("secondhour");
         spotPrices[2] = rs.getDouble("remaininghours");

         return spotPrices;
          
      }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
          return null;
      }
   }


   public void loadDatabase(){

         File f = new File("db/parkinglot.db");  

         if(!(f.isFile() && this.count_tables() == 5)){  // checking if db file exists and has 5 tables in it 
            this.setupDatabase();                        // if not create db and tables in it
         }

         pl.admin = getAdmin();
         pl.setEmployees(fillEmployees(new ArrayList<Employee>()));
         pl.setFloors(fillFloors(new ArrayList<Floor>()));
         pl.setTickets(fillTickets(new ArrayList<Ticket>()));
         pl.setCheckpoints(fillCheckPoints(new ArrayList<Checkpoint>()));
         
         pl.setCompactPrices(getSpotPrices("COMPACT"));
         pl.setLargePrices(getSpotPrices("LARGE"));
         pl.setHandicappedPrices(getSpotPrices("HANDICAPPED"));
         pl.setTwowheelerPrices(getSpotPrices("TWOWHEELER"));
         pl.setElectricPrices(getSpotPrices("ELECTRIC"));


   }

   //=========================================================================================================================================================


   private void addEmployee(int id , String name , String pswd , double due , String loginStatus ){

      try(Connection c = this.connect();
          PreparedStatement ps = c.prepareStatement("insert into employees values (?,?,?,?,?)");
       ){

          ps.setInt(1, id);
          ps.setString(2, name);
          ps.setString(3, pswd);
          ps.setDouble(4, due);
          ps.setString(5 , loginStatus);

          ps.executeUpdate();
          
       }catch(Exception e){
          System.out.println(e.getClass().getName() +" : "+e.getMessage());
       }

   }


   private void addFloor(int floorNo , int tcs ,int acs ,int tls ,int als ,int ths ,int ahs ,int ttws ,int atws ,int tes ,int aes ){

      try(Connection c = this.connect();
          PreparedStatement ps = c.prepareStatement("insert into floors values (?,?,?,?,?,?,?,?,?,?,?)");
       ){

          ps.setInt(1, floorNo);
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

    
   private void addTicket(int id ,String startTime, int spotID,int floorNo,String vnp){

        try(Connection c = this.connect();
            PreparedStatement ps = c.prepareStatement("insert into tickets values (?,?,?,?,?)");
         ){

            ps.setInt(1, id);
            ps.setString(2, startTime);
            ps.setInt(3, spotID);
            ps.setInt(4, floorNo);
            ps.setString(5, vnp);
            ps.executeUpdate();
            
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }

   }

   private void addCheckPoint(int id,String name,String type,int floorNo,int assignedEmployeeID){

      try(Connection c = this.connect();
            PreparedStatement ps = c.prepareStatement("insert into checkpoints values (?,?,?,?,?)");
         ){

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setInt(4,floorNo);
            ps.setInt(5 , assignedEmployeeID);

            ps.executeUpdate();
            
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }

   }

   private void addSpotPrice(String type,double fh,double sh,double rh){

      try(Connection c = this.connect();
            PreparedStatement ps = c.prepareStatement("insert into spotprices values (?,?,?,?)");
         ){

            ps.setString(1, type);
            ps.setDouble(2, fh);
            ps.setDouble(3, sh);
            ps.setDouble(4, rh);

            ps.executeUpdate();
            
         }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
         }

   }

   public void updateDatabase(){

      deleteAllTables(); // deleting all existing tables 
      setupDatabase();  // again creating all empty tables

      ArrayList<Employee> employees = pl.getAllEmployees();
      ArrayList<Floor> floors = pl.getAllFloors();
      ArrayList<Ticket> tickets = pl.getAllTickets();
      ArrayList<Checkpoint> checkPoints = pl.getAllCheckpoints();
      Admin admin = pl.getAdmin();

      double[] compactPrices = pl.getCompactPrices();
      double[] largePrices = pl.getLargePrices();
      double[] handiCappedPrices = pl.getHandicappedPrices();
      double[] twoWheelerPrices = pl.getTwowheelerPrices();
      double[] electricPrices = pl.getElectricPrices();
      
      addEmployee(admin.getID(), admin.getUsername(), admin.getPassword(), admin.getDues(), (String)((admin.getLoginStatus()) ? "yes" : "no" ) );

      for(Employee e:employees){
         addEmployee(e.getID(), e.getUsername(), e.getPassword(), e.getDues() ,(String)((e.loginstatus) ? "yes" : "no" ));
      }


      for(Floor f:floors){
         addFloor(f.getFloorNo(), f.getTotalNumberOfCompactSpots(), f.getNumberOfAvailableCompactSpots(), f.getTotalNumberOfLargeSpots() , f.getNumberOfAvailableLargeSpots() , f.getTotalNumberOfHandicappedSpots() , f.getNumberOfAvailableHandicappedSpots() , f.getTotalNumberOfTwowheelerSpots() , f.getNumberOfAvailableTwowheelerSpots() , f.getTotalNumberOfElectricalSpots() , f.getNumberOfAvailableElectricalSpots());
      }
      for(Ticket t:tickets){
         addTicket(t.getID(), t.getStartTime(), t.getSpot().getID() , t.getSpot().getFloorNo() , t.getVehicleNumberPlate());
      }
      for(Checkpoint c:checkPoints){
         addCheckPoint(c.getID(), c.getName(), c.getCheckpointType().toString(), c.getFloorNumber() , c.getAssigned());
      }

      addSpotPrice("COMPACT", compactPrices[0], compactPrices[1], compactPrices[2]);
      addSpotPrice("LARGE", largePrices[0], largePrices[1], largePrices[2]);
      addSpotPrice("HANDICAPPED", handiCappedPrices[0], handiCappedPrices[1], handiCappedPrices[2]);
      addSpotPrice("TWOWHEELER", twoWheelerPrices[0], twoWheelerPrices[1], twoWheelerPrices[2]);
      addSpotPrice("ELECTRIC", electricPrices[0], electricPrices[1], electricPrices[2]);


      

   }
        
}
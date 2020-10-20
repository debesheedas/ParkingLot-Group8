//Aashrith
//Handling information exchange between database inout output and program
import java.lang.System;
import java.sql.*;

// Driver path   -------- ".;JDBC_driver/sqlite-jdbc-3.7.2.jar"
//,ACS INT,TLS INT,ALS INT,THS INT,AHS INT,TTWS INT,ATWS INT,TES INT,AES INT
public class Database{
    
    private String db_name = "parkinglot.db";
    private String url = "jdbc:sqlite:db/"+db_name; // url of the database

    public static void main(String[] args) {

        Database db = new Database();
        System.out.println(db.count_tables());
        db.createTable("floors");
        db.createTable("employees");
        db.createTable("spots");
        System.out.println(db.count_tables());
        //db.deleteTable("floors");
        //System.out.println(db.count_tables());
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

     public void createTable(String table_name){

        try(Connection c = this.connect();
            Statement s = c.createStatement();    
        ){
            s.executeUpdate("create table if not exists "+table_name+" (id integer primary key not null)");
        
        }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
        }

     }

     public void deleteTable(String table_name){

        try(Connection c = this.connect();
            Statement s = c.createStatement();    
        ){
            s.executeUpdate("drop table if exists "+table_name);
            //c.commit();

        }catch(Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
        }
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
//      private void loadData()
//      {
//          //read data from existing database, accordingly create all required objects
//          try{

//             ResultSet rs = stmt.executeQuery("SELECT * FROM FLOORS;");
//             while(rs.next()){
//                 int floorno = rs.getInt("floorno");
//                 int tcs = rs.getInt("tcs");

//                 System.out.println("Floor no : "+floorno);
//                 System.out.println("Total compact spots : "+tcs);
               
//             }

//          }catch(Exception e){
//             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//          }

            
//      }
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
package ict.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ict.bean.AccountBean;
import ict.bean.BookingBean;
import ict.bean.StaffBean;
import ict.bean.MemberList;
import ict.bean.VenueBean;
import ict.bean.GuestBean;
import javax.servlet.http.HttpSession;

public class BookingDB {
    
        String doUser, doPassword, doUrl;
        BookingBean cb;
        StaffBean sb;
        VenueBean vb;
    
    public BookingDB(String doUser, String doPassword, String doUrl) {
        this.doUser=doUser;
        this.doPassword=doPassword;
        this.doUrl=doUrl;
    }
    
    public void CreateUserInfoTable() {
        Statement stmnt = null;
        Connection cmnt = null;
            try {
                cmnt = getConnection();
                stmnt = cmnt.createStatement();
                String sql =
                    "CREATE TABLE IF NOT EXISTS booking ("
                    + "bookingId int auto_increment primary key,"
                    + "venueId number(1) NOT NULL,"
                    + "date varchar(25) NOT NULL,"
                    + "startTime varchar(2) NOT NULL," 
                    + "memberEmail varchar(40) NULL," 
                    + "available tinyint(1) NOT NULL," 
                    + ")";
                stmnt.execute(sql);
                stmnt.close();
                cmnt.close();           
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        }  catch (IOException ex) {
            ex.printStackTrace();
        }        
    }
  
    public boolean addBooking(int venueId, String date, String startTime, String memberEmail, boolean available) throws SQLException, IOException{
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "INSERT INTO booking (venueId, date, startTime, memberEmail, available) VALUES (?,?,?,?,?)";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            //pStmnt.setInt(1, bookingId);
            pStmnt.setInt(1, venueId);
            pStmnt.setString(2, date);
            pStmnt.setString(3, startTime);
            pStmnt.setString(4, memberEmail);
            pStmnt.setBoolean(5,available);
            
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess=true;
                System.out.println("Booking id "+ venueId + " is added");
            }      
        } catch (SQLException ex) {
            while ( ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
            return isSuccess;        
    } 
    
    public boolean addVenue(int id, String name, String address, String pic, String phone, String email, int price) throws SQLException, IOException{
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "INSERT INTO venue (venueId, name, address, pic, phone, email, hourlyPrice) VALUES (?,?,?,?,?,?,?)";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            //pStmnt.setInt(1, bookingId);
            pStmnt.setInt(1, id);
            pStmnt.setString(2, name);
            pStmnt.setString(3, address);
            pStmnt.setString(4, pic);
            pStmnt.setString(5,phone);
            pStmnt.setString(6,email);
            pStmnt.setInt(7,price);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess=true;
            }      
        } catch (SQLException ex) {
            while ( ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
            return isSuccess;        
    }      
    
    public ArrayList<BookingBean> queryBookingByVenueAndDate(String date, String venueId) {
        //ArrayList<AccountBean> list = new ArrayList();
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        BookingBean bb =null;     
        ArrayList<BookingBean> book_list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE date = ? AND venueId = ? AND available = true  ";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,date);
            pStmnt.setString(2,venueId);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                bb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"), rs.getBoolean("isApproved"));
                book_list.add(bb);
            } 
            pStmnt.close();
            cmnt.close();  
            return book_list;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return book_list;        
    }  
    
    public ArrayList<BookingBean> queryBookingByBooked() {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        BookingBean bb =null;     
        ArrayList<BookingBean> book_list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE available = false";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                bb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"),rs.getBoolean("isApproved"));
                book_list.add(bb);
            } 
            pStmnt.close();
            cmnt.close();  
            return book_list;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return book_list;        
    }  

    public ArrayList<BookingBean> queryBookingByPlace(int vid) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        BookingBean bb =null;     
        ArrayList<BookingBean> book_list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE available = false AND venueId=?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,vid);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                bb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"),rs.getBoolean("isApproved"));
                book_list.add(bb);
            } 
            pStmnt.close();
            cmnt.close();  
            return book_list;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return book_list;        
    }      
    
    public BookingBean queryBookingById(int id) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE bookingId = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"),rs.getBoolean("isApproved"));         
            } 
            pStmnt.close();
            cmnt.close();  
            return cb;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return cb;        
    }
    
    public boolean checkUnavailableBooking() {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        Statement stmt = null;
        boolean result = false;
        int row = 0;
        try {
            cmnt = getConnection();
            String sql = "SELECT * FROM booking WHERE available = 0 AND isApproved = 0";
            stmt = cmnt.createStatement();
   
            row = stmt.executeUpdate(sql);
            if (row>0){
                result=true;
                stmt.close();
                cmnt.close();  
                
            }else{
                stmt.close();
                cmnt.close();  
             
            }
            
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
        return result;     
    }
 
    public ArrayList<BookingBean> getBookingById(int id) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<BookingBean> list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE bookingId = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"),rs.getBoolean("isApproved"));  
                list.add(cb);
            } 
            pStmnt.close();
            cmnt.close();  
            return list;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return list;     
    }    
    
    public ArrayList<BookingBean> queryBookingByMemberEmail(String email) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<BookingBean> list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM booking WHERE memberEmail = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,email);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new BookingBean(rs.getInt("bookingId"), rs.getInt("venueId"), rs.getString("date"), rs.getString("startTime"), rs.getString("memberEmail"), rs.getBoolean("available"),rs.getBoolean("isApproved"));  
                list.add(cb);
            } 
            pStmnt.close();
            cmnt.close();  
            return list;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return list;     
    }
    
     public ArrayList<GuestBean> getGuest(int id) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        GuestBean gb = null;    
        ArrayList<GuestBean> list = new ArrayList();
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM guest WHERE bookingId = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                gb = new GuestBean(rs.getInt("bookingId"), rs.getString("memberEmail"), rs.getString("guestName"), rs.getString("guestEmail"));
                list.add(gb);
            } 
            pStmnt.close();
            cmnt.close();  
            return list;  
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return list;       
    }      
    
        public VenueBean queryVenueById(String id) {
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM venue WHERE venueId = ? ";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            //int int_id = Integer.parseInt(id);
            pStmnt.setString(1,id);
            //pStmnt.setString(2,password);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                vb = new VenueBean(rs.getInt("venueId"), rs.getString("name"), rs.getString("address"), rs.getString("pic"), rs.getString("phone"), rs.getString("email"), rs.getInt("hourlyPrice"));
            } 
            pStmnt.close();
            cmnt.close();  
            return vb;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return vb;        
    }  
        
        public VenueBean getVenueById(int id) {
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM venue WHERE venueId = ? ";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            //int int_id = Integer.parseInt(id);
            pStmnt.setInt(1,id);
            //pStmnt.setString(2,password);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                vb = new VenueBean(rs.getInt("venueId"), rs.getString("name"), rs.getString("address"), rs.getString("pic"), rs.getString("phone"), rs.getString("email"), rs.getInt("hourlyPrice"));
            } 
            pStmnt.close();
            cmnt.close();  
            return vb;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return vb;        
    }
        
 public ArrayList<VenueBean> getVenue() {
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<VenueBean> list = new ArrayList();  
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM venue";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                vb = new VenueBean(rs.getInt("venueId"), rs.getString("name"), rs.getString("address"), rs.getString("pic"), rs.getString("phone"), rs.getString("email"), rs.getInt("hourlyPrice"));
                list.add(vb);
            } 
            pStmnt.close();
            cmnt.close();  
            return list; 
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return list;       
    }   
 
     public void deleteVenue(int id) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        String preQueryStatment = null;
        try {
            cmnt = getConnection();
            preQueryStatment = "DELETE FROM venue WHERE venueId = ? ";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,id);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                System.out.println("Somethings deleted");
            }
            pStmnt.close();
            cmnt.close();
        } catch (Exception e) {
            
        }        
    } 
    
    public ArrayList<AccountBean> queryAccount(){
        ArrayList<AccountBean> list = new ArrayList<AccountBean>();
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM account";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new AccountBean(rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("phone"));
                list.add(cb);
            } 
            pStmnt.close();
            cmnt.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return list;
    }    
    
    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection(doUrl, doUser, doPassword);
    }
    
        public boolean holdVenueByTimeSlot(int venueId, String date, String[] startTime, AccountBean ab) {   
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;   
        BookingBean bb = null;
        boolean isSuccess = false;
            
        
        try {
        cmnt = getConnection();
        String preQueryStatment = "UPDATE booking SET available = 0, memberEmail = ? WHERE venueId = ? AND date = ? AND startTime = ? ";
        pStmnt = cmnt.prepareStatement(preQueryStatment);
        
            for(int i=0;i<startTime.length;i++){
                //int int_id = Integer.parseInt(id);
                //bb = bookings.get(i);
                pStmnt.setString(1,ab.getEmail());
                pStmnt.setInt(2,venueId);
                pStmnt.setString(3,date);
                pStmnt.setString(4,startTime[i]);
                //ResultSet rs=null;    
                int row_count = pStmnt.executeUpdate();
                if (row_count>0){
                    isSuccess = true;
                }
//                while (rs.next()) {
//                    vb = new VenueBean(rs.getInt("venueId"), rs.getString("name"), rs.getString("address"), rs.getString("pic"), rs.getString("phone"), rs.getString("email"), rs.getInt("hourlyPrice"));
//                }
            } 
            pStmnt.close();
            cmnt.close();  
            return isSuccess;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return isSuccess;        
        }   
    
        public boolean updateApprove(int id) {   
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;   
        BookingBean bb = null;
        boolean isSuccess = false;
        try {
        cmnt = getConnection();
        String preQueryStatment = "UPDATE booking SET isApproved = true WHERE bookingid = ?";
        pStmnt = cmnt.prepareStatement(preQueryStatment);
        pStmnt.setInt(1, id);
                int row_count = pStmnt.executeUpdate();
                if (row_count>0){
                    isSuccess = true;
                }       
            pStmnt.close();
            cmnt.close();  
            return isSuccess;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return isSuccess;        
        }   
        
        public boolean updateNotApprove(int id) {   
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;   
        BookingBean bb = null;
        boolean isSuccess = false;
        try {
        cmnt = getConnection();
        String preQueryStatment = "UPDATE booking SET isApproved = false WHERE bookingid = ?";
        pStmnt = cmnt.prepareStatement(preQueryStatment);
        pStmnt.setInt(1, id);
                int row_count = pStmnt.executeUpdate();
                if (row_count>0){
                    isSuccess = true;
                }       
            pStmnt.close();
            cmnt.close();  
            return isSuccess;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return isSuccess;        
        }   
        
        public boolean updateVenue(int id, String name, String address, String pic, String phone, String email, int price) {   
        VenueBean vb = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;   
        BookingBean bb = null;
        boolean isSuccess = false;
        try {
        cmnt = getConnection();
        String preQueryStatment = "UPDATE venue SET name=?, address=?, pic=?, phone=?, email=?, hourlyPrice=? WHERE venueId = ?";
        pStmnt = cmnt.prepareStatement(preQueryStatment);
        pStmnt.setString(1, name);
        pStmnt.setString(2,address);
        pStmnt.setString(3, pic);
        pStmnt.setString(4, phone);
        pStmnt.setString(5, email);
        pStmnt.setInt(6, price);
        pStmnt.setInt(7, id);
                int row_count = pStmnt.executeUpdate();
                if (row_count>0){
                    isSuccess = true;
                }       
            pStmnt.close();
            cmnt.close();  
            return isSuccess;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return isSuccess;        
        }
        
        public boolean addGuestList(int bookingId, String memberEmail, String guestName, String guestEmail) {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        String preQueryStatment = null;
        boolean result = false;
        try {
            cmnt = getConnection();
            preQueryStatment = "Insert into guest (bookingId, memberEmail, guestName, guestEmail) Values(?,?,?,?)";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,bookingId);
            pStmnt.setString(2,memberEmail);
            pStmnt.setString(3, guestName);
            pStmnt.setString(4, guestEmail);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                //System.out.println("Somethings deleted");
                result = true;
            }
            pStmnt.close();
            cmnt.close();
        } catch (Exception e) {
            
        }
        return result;        
        }
        

        public ArrayList<GuestBean> getGuestListByBookingId_memberEmail(int bookingId, String memberEmail){
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        String preQueryStatment = null;
        ArrayList<GuestBean> guests = new ArrayList();
        
        try {
            cmnt = getConnection();
            preQueryStatment = "Select * from guest Where bookingId = ? AND memberEmail = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setInt(1,bookingId);
            pStmnt.setString(2,memberEmail);
            
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                //System.out.println("Somethings deleted");
                GuestBean guest = new GuestBean(rs.getInt("bookingId"), rs.getString("memberEmail"), rs.getString("guestName"),rs.getString("guestEmail"));
                guests.add(guest);
            }
            pStmnt.close();
            cmnt.close();
        } catch (Exception e) {
            
        }
        return guests;
        }   
        
        
}

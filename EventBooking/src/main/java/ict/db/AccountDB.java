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
import ict.bean.StaffBean;
import ict.bean.MemberList;

public class AccountDB {
    
        String doUser, doPassword, doUrl;
        AccountBean cb;
        StaffBean sb;
    
    public AccountDB(String doUser, String doPassword, String doUrl) {
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
                    "CREATE TABLE IF NOT EXISTS account ("
                    + "name varchar(25) NOT NULL,"
                    + "password varchar(25) NOT NULL,"
                    + "email varchar(25) NOT NULL,"
                    + "phone varchar(25) NOT NULL,"    
                    + "PRIMARY KEY (email)"
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
  
    public boolean addAccount(String name, String password, String email, String phone) throws SQLException, IOException{
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "INSERT INTO account VALUES (?,?,?,?)";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1, name);
            pStmnt.setString(2, password);
            pStmnt.setString(3, email);
            pStmnt.setString(4, phone);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess=true;
                System.out.println(name + " is added");
            }      
        } catch (SQLException ex) {
            while ( ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
            return isSuccess;        
    }    
    
    public boolean addStaffAccount(String name, String password, String type) throws SQLException, IOException{
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "INSERT INTO staff VALUES (?,?,?,?)";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1, null);
            pStmnt.setString(2, name);
            pStmnt.setString(3, password);
            pStmnt.setString(4, type);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess=true;
                System.out.println(name + " is added");
            }      
        } catch (SQLException ex) {
            while ( ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
            return isSuccess;        
    }        
    public AccountBean queryCustById(String email, String password) {
        ArrayList<AccountBean> list = new ArrayList();
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM account WHERE email = ? AND password = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,email);
            pStmnt.setString(2,password);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new AccountBean(rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("phone"));
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
    
    public StaffBean queryStaffById(String name, String password) {
        ArrayList<StaffBean> list = new ArrayList();
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        AccountBean cb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM staff WHERE name = ? AND password = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,name);
            pStmnt.setString(2,password);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                sb = new StaffBean(rs.getInt("staffid"), rs.getString("name"), rs.getString("password"), rs.getString("type"));
            } 
            pStmnt.close();
            cmnt.close();  
            return sb;   
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }    
        return sb;        
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
    

    public ArrayList<StaffBean> queryStaffAccount(){
        ArrayList<StaffBean> list = new ArrayList<StaffBean>();
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        StaffBean sb =null;     
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM staff";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                sb = new StaffBean(rs.getInt("staffid"), rs.getString("name"), rs.getString("password"), rs.getString("type"));
                list.add(sb);
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
    
    public void edit(String name, String password, String email, String phone){
        PreparedStatement pStmnt = null;
        Connection cmnt = null;
        String preQueryStatement;
        try {
            cmnt = getConnection();
            String preQueryStatment = "UPDATE account SET name=?, password=?, phone=? WHERE email = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,name);
            pStmnt.setString(2,password);
            pStmnt.setString(3,phone);
            pStmnt.setString(4,email);   
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
            System.out.println("EDIT SUCCESEE");
            }
            pStmnt.close();
            cmnt.close(); 
        } catch (Exception e) {
            System.out.println("WRONG EDIT");
        }
    } 
    
    public void editStaff(int id, String name, String password, String type){
        PreparedStatement pStmnt = null;
        Connection cmnt = null;
        String preQueryStatement;
        try {
            cmnt = getConnection();
            String preQueryStatment = "UPDATE staff SET name=?, password=?, type=? WHERE staffid = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,name);
            pStmnt.setString(2,password);
            pStmnt.setString(3,type);
            pStmnt.setInt(4,id);   
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
            System.out.println("EDIT SUCCESEE");
            }
            pStmnt.close();
            cmnt.close(); 
        } catch (Exception e) {
            System.out.println("WRONG EDIT");
        }
    }       
     
    public void delete(String email) {
        Statement stmnt = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        String preQueryStatment = null;
        try {
            cmnt = getConnection();
            preQueryStatment = "DELETE FROM account WHERE email= ? ";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,email);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                System.out.println("Somethings deleted");
            }
            pStmnt.close();
            cmnt.close();
        } catch (Exception e) {
            
        }        
    }   
    
    public void deleteStaff(int id) {
        Statement stmnt = null;
        Connection cmnt = null;
        PreparedStatement pStmnt = null;
        String preQueryStatment = null;
        try {
            cmnt = getConnection();
            preQueryStatment = "DELETE FROM staff WHERE staffid= ? ";
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
    
    public boolean isValidUser(String email, String password)throws SQLException, IOException {
        Connection cmnt = null;
        PreparedStatement pStmnt = null;   
        try {
            cmnt = getConnection();
            String preQueryStatment = "SELECT * FROM account WHERE email = ? AND password = ?";
            pStmnt = cmnt.prepareStatement(preQueryStatment);
            pStmnt.setString(1,email);
            pStmnt.setString(2,password);
            ResultSet rs=null;    
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex = ex.getNextException();
            return false;
        } catch ( IOException ex ) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection(doUrl, doUser, doPassword);
    }
    
    
    
}

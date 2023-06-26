/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

public class StaffBean {
    
    int staffid;
    String name, password, type;
    
    public StaffBean(int staffid, String name, String password, String type) {
        this.staffid=staffid;
        this.name=name;
        this.password=password;
        this.type=type;
    }
    
    public StaffBean() {   
    }
    
    public void setName(String name) {
        this.name=name;
    } 
    public void setPassword(String password) {
        this.password=password;
    }
    public void setStaffid(int staffid) {
        this.staffid=staffid;
    }
    public void setType(String type) {
        this.type=type;
    }    
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getStaffid() {
        return staffid;
    }
    public String getType() {
        return type;
    }        
    
}

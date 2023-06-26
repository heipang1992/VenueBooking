/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author mahei
 */
public class VenueBean implements Serializable{
    int venueId, hourlyPrice;
    String name, address, phone, pic,email;
    
    public VenueBean(){}
    
    public VenueBean(int venueId, String name, String address, String pic,String phone, String email,int hourlyPrice){
        this.venueId = venueId;
        this.name = name;
        this.address = address;
        this.pic = pic;
        this.phone = phone;
        this.email = email;
        this.hourlyPrice = hourlyPrice;
    }
    
    // Getter Method on Venue
    public int getVenueId(){return this.venueId;}
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}
    public String getPic(){return this.pic;}
    public String getEmail(){return this.email;}
    public int getHourlyPrice(){return this.hourlyPrice;}
    
    // Setter Method on Venue
    public void setVenueId(int i){this.venueId = i;}
    public void setName(String n){this.name = n;}
    public void setAddress(String a){this.address = a;}
    public void setPhone(String s){this.phone = s;}
    public void setPic(String p){this.pic = p;}
    public void setEmail(String e){this.email=e;}
    public void setHourlyPrice(int p){this.hourlyPrice = p;}
}

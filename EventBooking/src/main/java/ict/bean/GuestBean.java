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
public class GuestBean implements Serializable{
    int bookingId;
    String memberEmail, guestName, guestEmail;
    
    
    public GuestBean(){}
    
    public GuestBean(int id, String mEmail, String gName, String gEmail){
        this.bookingId = id;
        this.memberEmail = mEmail;
        this.guestName = gName;
        this.guestEmail = gEmail;
    }
    
    // Getter Method on booking record
    public int getBookingId(){return this.bookingId;}
    public String getMemberEmail(){return this.memberEmail;}
    public String getGuestName(){return this.guestName;}
    public String getGuestEmail(){return this.guestEmail;}
    
    // Setter Method on Booking Record
    public void setBookingId(int id){this.bookingId = id;}
    public void setMemberEmail(String m){this.memberEmail = m;}
    public void setGuestName(String n){this.guestName = n;}
    public void setGuestEmail(String m){this.guestEmail = m;}
 
}

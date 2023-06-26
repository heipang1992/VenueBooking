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
public class BookingBean implements Serializable{
    int bookingId, venueId;
    String date, startTime,memberEmail;
    boolean available, isApproved;
    
    public BookingBean(){}
    
    public BookingBean(int bookingId, int venueId, String date, String startTime, String memberEmail, boolean available, boolean isApproved){
        this.bookingId = bookingId;
        this.venueId = venueId;
        this.date = date;
        this.startTime = startTime;
        this.memberEmail = memberEmail;
        this.available = available;
        this.isApproved = isApproved;
    }
    
    // Getter Method on booking record
    public int getBookingId(){return this.bookingId;}
    public int getVenueId(){return this.venueId;}
    public String getDate(){return this.date;}
    public String getStartTime(){return this.startTime;}
    public String getMemberEmail(){return this.memberEmail;}
    public Boolean getAvailable(){return this.available;}
    public Boolean getIsApproved(){return this.isApproved;}
    
    // Setter Method on Booking Record
    public void setBookingId(int id){this.bookingId = id;}
    public void setVenueId(int id){this.venueId = id;}
    public void setDate(String date){this.date = date;}
    public void setStartTime(String time){this.startTime = time;}
    public void setMemberEmail(String email){this.memberEmail = email;}
    public void setAvailable(boolean available){this.available=available;}
    public void setIsApproved(boolean isApproved){this.isApproved=isApproved;}
 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

import java.util.*;
import java.io.Serializable;
/**
 *
 * @author mahei
 */
public class BookingsBean implements Serializable{
    private ArrayList<BookingBean> bookings;
    
    //Getter and Setter of customers
    public void setBookings(ArrayList<BookingBean> list){
        this.bookings = list;
    }
    
    public ArrayList<BookingBean> getBookings(){
        return this.bookings;
    }
    
    //Default Constructor
    public BookingsBean(){
        bookings = new ArrayList<BookingBean>();}
    
    public void addBooking(BookingBean book){
        this.bookings.add(book);
    }
}

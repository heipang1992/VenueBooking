/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import ict.bean.AccountBean;
import ict.bean.BookingBean;
import ict.db.BookingDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahei
 */
@WebServlet(name = "RequestBookingHandler", urlPatterns = {"/RequestBookingHandler"})
public class RequestBookingHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        ArrayList<BookingBean> bookings = (ArrayList<BookingBean>)request.getSession().getAttribute("BookingsBean");
        BookingBean booking = bookings.get(0);
        int venueId = booking.getVenueId();
        String date = booking.getDate();
      
        String[] checkedTime = request.getParameterValues("checkAll");
  
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        BookingDB db = new BookingDB(dbUser, dbPassword, dbUrl);
        AccountBean ab = (AccountBean)request.getSession().getAttribute("cb");

        boolean isHold = db.holdVenueByTimeSlot(venueId, date, checkedTime, ab);
        
        request.setAttribute("checkedTime",checkedTime);
       // request.getSession().setAttribute("totalFee", 400);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Payment.jsp");
        rd.forward(request, response);   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}        

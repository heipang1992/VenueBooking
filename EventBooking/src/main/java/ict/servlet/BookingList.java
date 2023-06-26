/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.db.BookingDB;
import ict.bean.BookingBean;
import java.util.*;
import javax.servlet.RequestDispatcher;
import ict.bean.GuestBean;

@WebServlet(name = "BookingList", urlPatterns = {"/BookingList"})
public class BookingList extends HttpServlet {
    
    BookingDB db;
    BookingBean bb;
    ArrayList<BookingBean> list;
    ArrayList<GuestBean> glist;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
        db = new BookingDB(dbUser, dbPassword, dbUrl);
        String action = request.getParameter("action");
        String id = request.getParameter("bookingid");

        
        if ("list".equals(action)) {
            list = db.queryBookingByBooked();     
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/BookingList.jsp");
            rd.forward(request, response);
        }
        else if ("approve".equals(action)) {
            int abc = Integer.parseInt(id);
            bb = db.queryBookingById(abc);
            if ( bb.getIsApproved() == false ){
                db.updateApprove(abc);
            } else {
            db.updateNotApprove(abc);
            }
            list = db.queryBookingByBooked();     
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/BookingList.jsp"); 
            rd.forward(request, response);
        }
        else if ("detail".equals(action)) {
            int abc = Integer.parseInt(id);
            glist = db.getGuest(abc);
            request.setAttribute("list", glist);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowDetails.jsp"); 
            rd.forward(request, response);            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}

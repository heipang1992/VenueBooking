/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import ict.bean.BookingBean;
import ict.bean.VenueBean;
import ict.db.AccountDB;
import ict.db.BookingDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.security.auth.Subject;
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
@WebServlet(name = "CheckBooking", urlPatterns = {"/CheckBooking"})
public class CheckBooking extends HttpServlet {
    HttpSession session;
    BookingDB db;
    BookingBean bb;
    ArrayList<BookingBean> book_list = new ArrayList();
    VenueBean vb = new VenueBean();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String date = request.getParameter("date");
        String venueId = request.getParameter("venueId");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        db = new BookingDB(dbUser, dbPassword, dbUrl);
        //db.CreateUserInfoTable();
        book_list = db.queryBookingByVenueAndDate(date, venueId);
        vb = db.queryVenueById(venueId);
        
//        try {
//            //boolean new_book_record = db.addBooking(1,"2023-05-25","13","mhp@gmail.com",false);
//        } catch (SQLException ex) {
//            Logger.getLogger(CheckBooking.class.getName()).log(Level.SEVERE, null, ex);
//        }
        request.getSession().setAttribute("BookingsBean",book_list);
        request.getSession().setAttribute("VenueBean",vb);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AvailableTime.jsp");
        rd.forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

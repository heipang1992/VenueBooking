/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import ict.db.BookingDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.db.BookingDB;
import ict.bean.BookingBean;
import java.util.*;
import ict.bean.VenueBean;


@WebServlet(name = "RecordPage", urlPatterns = {"/RecordPage"})
public class RecordPage extends HttpServlet {
    
    BookingDB db;
    BookingBean bb;
    ArrayList<BookingBean> list;
    VenueBean vb;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
        db = new BookingDB(dbUser, dbPassword, dbUrl);
        
        String action = request.getParameter("action");
        String select = request.getParameter("select");
        try {
        if("list".equals(action)) {
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ReportPage.jsp");
            rd.forward(request, response);            
        }
        else if ("List".equals(action)) {
            int abc = Integer.parseInt(select);
            list = db.queryBookingByPlace(abc);
            vb = db.getVenueById(abc);
            request.setAttribute("vb", vb);
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowReportPage.jsp");
            rd.forward(request, response);
        }
        else if ("approve".equals(action)) {
          
        }
        else if ("detail".equals(action)) {
           
        }
    }
    catch (Exception e) {
        
    }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

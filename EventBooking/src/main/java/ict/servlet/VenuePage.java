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
import ict.bean.VenueBean;
import java.util.*;
import ict.db.BookingDB;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "VenuePage", urlPatterns = {"/VenuePage"})
public class VenuePage extends HttpServlet {
    
    ArrayList<VenueBean> list;
    BookingDB db;
    VenueBean vb;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
        db = new BookingDB(dbUser, dbPassword, dbUrl); 
        
        String action = request.getParameter("action");
        String submit = request.getParameter("submit");
        String id =  request.getParameter("id");
        String name =  request.getParameter("name");
        String address =  request.getParameter("address");
        String pic =  request.getParameter("pic");
        String phone =  request.getParameter("phone");
        String email =  request.getParameter("email");
        String price =  request.getParameter("price");
        VenueBean vb;

        
        try {
        if ("list".equals(action)) {
            list = db.getVenue();
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowVenue.jsp");
            rd.forward(request, response);
        } else if ("Add".equals(submit)) {
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AddVenue.jsp");
            rd.forward(request, response);
        } else if ("addsubmit".equals(action)) {
            int d = Integer.parseInt(id);
            int p = Integer.parseInt(price);
            db.addVenue(d, name, address, pic, phone, email, p);
            list = db.getVenue();
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowVenue.jsp");
            rd.forward(request, response);
        }else if ("Edit".equals(submit)) {
            int d = Integer.parseInt(id);
            vb = db.getVenueById(d);
            request.setAttribute("vb", vb);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EditVenue.jsp");
            rd.forward(request, response);              
        } else if ("editsubmit".equals(submit)) {
            int d = Integer.parseInt(id);
            int p = Integer.parseInt(price);
            db.updateVenue(d, name, address, pic, phone, email, p);
            
            list = db.getVenue();
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowVenue.jsp");
            rd.forward(request, response);            
        }else if ("Delete".equals(submit)) {
            int d = Integer.parseInt(id);
            db.deleteVenue(d);
            list = db.getVenue();
            request.setAttribute("list", list);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ShowVenue.jsp");
            rd.forward(request, response);
        } 
        } catch (Exception e) {
            
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}

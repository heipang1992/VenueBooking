/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.db.AccountDB;
import ict.bean.StaffBean;

@WebServlet(name = "StaffHandler", urlPatterns = {"/StaffHandler"})
public class StaffHandler extends HttpServlet {
    
    AccountDB db;
    StaffBean sb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String type = request.getParameter("type");  
            String dbUser = this.getServletContext().getInitParameter("dbUser");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
            db = new AccountDB(dbUser, dbPassword, dbUrl);            
            if ("create".equals(action)) {
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CreateStaffAccount.jsp");
                String temp = "submit";
               request.setAttribute("action",temp);
                rd.forward(request, response);                
            }
            else if ("submit".equals(action)) {
                db.addStaffAccount(name, password, type);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberListHandler");
                rd.forward(request, response);   
            }
            if("edit".equalsIgnoreCase(action)){  
                sb = db.queryStaffById(name, password);
                request.setAttribute("sb", sb);
                String temp = "confirmEdit";
                request.setAttribute("action", temp);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CreateStaffAccount.jsp");
                rd.forward(request, response);    
            } else if ("confirmEdit".equalsIgnoreCase(action)) {
                int abc = Integer.parseInt(id);
                db.editStaff(abc, name, password, type);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberListHandler");
                rd.forward(request, response);                 
            } else if ("delete".equalsIgnoreCase(action)) {
                int abc = Integer.parseInt(id);
                db.deleteStaff(abc);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberListHandler");
                rd.forward(request, response);                 
            }              
        } catch (Exception e) {
            
        }
    }
    
}

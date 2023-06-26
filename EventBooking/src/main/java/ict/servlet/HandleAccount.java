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
import ict.db.AccountDB;
import ict.bean.AccountBean;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "HandleAccount", urlPatterns = {"/HandleAccount"})
public class HandleAccount extends HttpServlet {
    
    AccountDB db;
    AccountBean cb; 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dbUser = this.getServletContext().getInitParameter("dbUser");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
            db = new AccountDB(dbUser, dbPassword, dbUrl);
            String action = request.getParameter("action");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            if("edit".equalsIgnoreCase(action)){  
                cb = db.queryCustById(email, password); 
                request.setAttribute("cb", cb);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EditAccount.jsp");
                rd.forward(request, response);    
            } else if ("confirmEdit".equalsIgnoreCase(action)) {
                db.edit(name, password, email, phone);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberListHandler");
                rd.forward(request, response);                 
            } else if ("delete".equalsIgnoreCase(action)) {
                db.delete(email);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberListHandler");
                rd.forward(request, response);                 
            }          
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

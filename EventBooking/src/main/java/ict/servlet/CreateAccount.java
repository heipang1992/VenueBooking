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
import ict.bean.AccountBean;

@WebServlet(name = "CreateAccount", urlPatterns = {"/CreateAccount"})
public class CreateAccount extends HttpServlet {
    
    AccountDB db;
    AccountBean cb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        db = new AccountDB(dbUser, dbPassword, dbUrl);
        db.CreateUserInfoTable();
        try{
        db.addAccount(name, password, email, phone);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Somethings wrong");
        }
        cb = db.queryCustById(email, password);
        
        request.setAttribute("AccountBean",cb);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);         
        
    }


}

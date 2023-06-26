/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import ict.db.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.db.AccountDB;
import ict.bean.MemberList;
import ict.bean.AccountBean;
import java.util.*;
import ict.bean.StaffBean;

@WebServlet(name = "MemberListHandler", urlPatterns = {"/MemberListHandler"})
public class MemberListHandler extends HttpServlet {
    
    AccountDB db;
    ArrayList<AccountBean> list;
    ArrayList<StaffBean> stafflist;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        db = new AccountDB(dbUser, dbPassword, dbUrl);
        list = db.queryAccount();
        stafflist = db.queryStaffAccount(); 
        request.setAttribute("ArrayList",list);
        request.setAttribute("StaffArrayList",stafflist);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberList.jsp");
        rd.forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    
}

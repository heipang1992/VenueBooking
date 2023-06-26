/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ict.servlet;

import ict.db.AccountDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.bean.AccountBean;
import javax.servlet.RequestDispatcher;
import ict.bean.StaffBean;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginHandler", urlPatterns = {"/LoginHandler"})
public class LoginHandler extends HttpServlet {
    
    AccountDB db;
    AccountBean cb;
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
        String type = request.getParameter("type");
        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            doLogout(request, response);
        }
        if ("member".equals(type)) { 
            if ( !isAuthenticated(request) && !("authenticate".equals(action))) {
                init();
                doLogin(request, response);
                return;
            }
            else {
                doAuthenticate(request, response);
            } 
        }
        else if ("staff".equals(type)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String dbUser = this.getServletContext().getInitParameter("dbUser");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
            db = new AccountDB(dbUser, dbPassword, dbUrl);
            sb = db.queryStaffById(name, password);
            if ( name.equals(sb.getName()) && password.equals(sb.getPassword()) && "staff".equals(sb.getType())) {
                request.setAttribute("StaffBean",sb);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/StaffPage.jsp");
                rd.forward(request, response);             
            }     
            else if ( name.equals(sb.getName()) && password.equals(sb.getPassword()) && "manager".equals(sb.getType())) {
                request.setAttribute("StaffBean",sb);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ManagerPage.jsp");
                rd.forward(request, response);             
            }   
        }
        } catch (Exception e) {
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request, response);  
        }
    } 

    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String targetURL="";   
        if ( email != null && password !=null) {
            cb = db.queryCustById(email, password);
            if ( email.equals(cb.getEmail()) && password.equals(cb.getPassword())) {
                HttpSession session = request.getSession(true);
                session.setAttribute("cb", cb);
                targetURL = "BookingPage.jsp";
            } 
            else {
                targetURL = "ErrorPage.jsp";
            }
        }
        else if (email == null && password ==null) {
            if(isAuthenticated(request)) {
                targetURL = "BookingPage.jsp";
            } else {
                targetURL = "ErrorPage.jsp";
            }
        }
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/" + targetURL);
            rd.forward(request, response);        
    }
    
    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("cb") != null) {
            result = true;
        }
        return result;
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String targetURL = "Login.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
        private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            HttpSession session = request.getSession(false);
            session.removeAttribute("cb");
            session.invalidate();
            String targetURL = "MainPage.jsp";
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/" + targetURL);
            rd.forward(request, response);            
    }
    
    public void init() {
        try {
            String dbUser = this.getServletContext().getInitParameter("dbUser");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
            db = new AccountDB(dbUser, dbPassword, dbUrl);
        } catch (Exception e){       
        }
    }   
}

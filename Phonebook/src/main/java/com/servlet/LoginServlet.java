package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.user;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailid = (String)request.getParameter("emailid");
		String password = (String)request.getParameter("password");
		
		UserDao ud = new UserDao(DbConnect.getConn());
		
		user u = ud.loginUser(emailid, password);
		
		HttpSession session = request.getSession();
		
		if(u!=null) {
			System.out.println("User Exists");
			session.setAttribute("User", u);
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("User does not Exists");
			session.setAttribute("invalidUser", "User does not Exists..!");
			response.sendRedirect("login.jsp");
		}
	}

}

package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import com.conn.DbConnect;
import com.dao.UserDao;
import com.entity.user;

//@WebServlet("register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String)request.getParameter("name");
		String emailid = (String)request.getParameter("emailid");
		String password = (String)request.getParameter("password");
		
		user u = new user(name,emailid,password);
		Connection con = DbConnect.getConn();
		
		UserDao ud = new UserDao(con);
		
		boolean result = ud.userRegister(u);
		
		HttpSession session = request.getSession();
		if(result) {
			System.out.println("Inserted Successfully..!");
			session.setAttribute("succMsg", "Inserted Successfully..!");
			response.sendRedirect("registration.jsp");
		}else {
			System.out.println("Something went wrong..!");
			session.setAttribute("errorMsg", "Something went wrong..!");
			response.sendRedirect("registration.jsp");
		}
	}

}

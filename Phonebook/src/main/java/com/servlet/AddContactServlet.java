package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ContactDao;
import com.entity.contact;
import com.entity.user;
import com.conn.DbConnect;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String emailid = (String)request.getParameter("emailid");
		String phno = (String)request.getParameter("phno");
		String description = (String)request.getParameter("description");
		
		HttpSession session = request.getSession();
		user u = (user) session.getAttribute("User");
		
		contact c = new contact(name,emailid,phno,description,u.getId());
		System.out.println(c.getName());
		ContactDao cd = new ContactDao(DbConnect.getConn());
		
		boolean result = cd.addContact(c);
		if(result) {
			session.setAttribute("succMsg", "Contact Details Inserted Successfully..!");
			response.sendRedirect("addContact.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong..!");
			response.sendRedirect("addContact.jsp");
		}
		
		
	}

}

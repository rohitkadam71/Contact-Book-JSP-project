package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.conn.DbConnect;
import com.dao.ContactDao;

@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		ContactDao cd = new ContactDao(DbConnect.getConn());
		
		boolean result = cd.deleteContact(cid);
		
		HttpSession session = request.getSession();
		if(result) {
			System.out.println("Deleted Successfully..!");
			session.setAttribute("succMsg", "Deleted Successfully..!");
			response.sendRedirect("viewContacts.jsp");
		}else {
			System.out.println("Something went wrong..!");
			session.setAttribute("errorMsg", "Something went wrong..!");
			response.sendRedirect("viewContacts.jsp");
		}
	}

}

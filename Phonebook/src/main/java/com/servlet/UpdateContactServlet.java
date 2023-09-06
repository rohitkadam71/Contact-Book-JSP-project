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
import com.entity.contact;
import com.entity.user;

@WebServlet("/updateContact")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = (String)request.getParameter("name");
		String email = (String)request.getParameter("emailid");
		String phno = (String)request.getParameter("phno");
		String description = (String)request.getParameter("description");
		
		
		contact c = new contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phno);
		c.setAbout(description);
		
		ContactDao cd = new ContactDao(DbConnect.getConn());
		boolean result = cd.updateContact(c);
		
		if(result == true) {
			session.setAttribute("succMsg", "Record Updated Successfully..!");
			response.sendRedirect("editContact.jsp?cid="+cid);
		}else {
			session.setAttribute("errorMsg", "Record did not Updated..!");
			response.sendRedirect("editContact.jsp?cid="+cid);
		}
		
	}

}

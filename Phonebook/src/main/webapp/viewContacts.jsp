<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.dao.ContactDao,com.entity.contact,com.conn.DbConnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	*{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        .body-sec{
        	width: 100%;
            display: flex;
            justify-content: center;
        }
        .card-container{
        	width: 90%;
        	padding: 20px;
        	display: flex;
        	justify-content: start;
        	flex-wrap: wrap;
        	margin-top: 20px;
        	
        }
        .card{
        	border: 1px solid black;
        	margin: 5px 10px;
        	padding: 10px;
        	border-radius: 10px;
        }
        .card h5{
        	font-size: 20px;
        }
        a.btn{
            background-color: rgb(30, 211, 30);
            font-size: 20px;
            border-radius: 5px;
            padding: 10px;
            color: white;
            cursor: pointer;
            text-decoration: none;
        }
        a.btn-reg{
            background-color: rgb(234, 47, 47);
        }
        .btn-container{
        	display: block;
        	margin: 20px 0px;
        	text-align: center;
        }
</style>
</head>
<body>
<%@include file="components/navbar.jsp" %>

<% if(u == null){
	response.sendRedirect("login.jsp");	
}
%>
<div class="body-sec">
        <div class="card-container">
        <%
        
        if(u != null){
        	ContactDao cd = new ContactDao(DbConnect.getConn());
        	List<contact> list = cd.getAllContacts(u.getId());
        	System.out.println(list.size());
        	for(contact c: list){
        		
        		%>
            		
            	<div class="card">
                	<h5>Name: <%=c.getName() %></h5>
                	<p>Ph no: <%=c.getPhone() %></p>
                	<p>Email: <%=c.getEmail() %></p>
                	<p>About: <%=c.getAbout() %></p>
                	<div class="btn-container">
                		<a class="btn btn-succ" href="editContact.jsp?cid=<%= c.getId() %>">Edit</a>
                		<a class="btn btn-reg" href="delete?cid=<%= c.getId() %>">Delete</a>
                	</div>
                </div><%		
        	}
        }
        %>
        </div>
    </div>

</body>
</html>
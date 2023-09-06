<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.entity.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.nav-bar{
            background-color: rgb(69, 157, 192);
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }
        .left-menu{
            width: auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .left-menu .logo h2{
            color: rgb(212, 225, 237);
            font-weight: bolder;
        }
        .left-menu ul{
            /* background-color: blue; */
            list-style: none;
            display: flex;
            /* justify-content: space-between; */
            align-items: center;
            font-size: 20px;
            margin-left: 30px;
            
            /* gap: 20; */
        }
        ul li{
            /* background-color: crimson; */
            margin: 0 10px;
            padding: 10px;
            
        }
        ul li a, .right-menu .row a{
            text-decoration: none;
            color: aliceblue;
        }
        .right-menu .row a.btn-login, .right-menu .row a.btn-reg{
            background-color: rgb(30, 211, 30);
            font-size: 20px;
            border-radius: 5px;
            padding: 10px;
        }
        .right-menu .row a.btn-reg{
            background-color: rgb(234, 47, 47);
        }
</style>
</head>
<body>
<nav class="nav-bar">
        <div class="left-menu">
            <div class="logo">
                <h2>PhoneBook</h2>
            </div>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="addContact.jsp">Add Phone No</a></li>
                <li><a href="viewContacts.jsp">View Contact</a></li>
            </ul>
        </div>
        <div class="right-menu">
        
        <% user u = (user)session.getAttribute("User"); 
        
        	if(u == null){
        		%>
        		<div class="row">
                	<a href="login.jsp" class="btn-login">Login</a>
                	<a href="registration.jsp" class="btn-reg">Register</a>
            	</div>
            	<%	
        	}else{
        		%>
        		<div class="row">
                	<a class="btn-login"><%=u.getName() %></a>
                	<a href="logout" class="btn-reg">Logout</a>
            	</div>
            	<%
        	}
        %>
            
        </div>
    </nav>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dao.ContactDao,com.entity.contact,com.conn.DbConnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	*{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            width: 100%;
        }
        
        .body-sec{
            height: 90vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .body-sec .form-wrapper{
            border: 1px solid rgb(201, 200, 200);
            padding: 20px;
            width: 700px;
        }
        .body-sec .form-wrapper h2{
            text-align: center;
            margin-bottom: 15px;
            color: rgb(30, 211, 30);
        }
        .body-sec .form-wrapper .col-1{
            /* background-color: aqua; */
            width: 100%;
            height: 100%;
        }
        .body-sec .form-wrapper .field-wrapper{
            width: 100%;
            margin: 15px 0px;
        }
        .body-sec .form-wrapper .field-wrapper span{
            width: 100%;
            display: block;
            font-size: 15px;
            margin-bottom: 5px;
            /* background-color: aquamarine; */
        }
        .body-sec .form-wrapper .field-wrapper input, textarea{
            width: 100%;
            padding: 10px;
            font-size: 15px;
        }
        .btn-smt{
        	background-color: rgb(30, 211, 30);
            font-size: 20px;
            border-radius: 5px;
            padding: 10px;
            outline: none;
            border: none;
           color: white;
        }
</style>
</head>
<body>
<%@include file="components/navbar.jsp" %>

<% 
	if(u == null){
		response.sendRedirect("login.jsp");
	}
%>
<div class="body-sec">
        <div class="form-wrapper">
        <%
    				int cid = Integer.parseInt(request.getParameter("cid"));
    				ContactDao cd = new ContactDao(DbConnect.getConn());
                	String succMsg = (String)session.getAttribute("succMsg");
                	String errorMsg = (String)session.getAttribute("errorMsg");
                	
                	if(succMsg!=null){
                		%>
                		<p style="text-align: center;color: green;"><%=succMsg %></p>
                		<%
                		session.removeAttribute("succMsg");
                	}
                	if(errorMsg!=null){
                		%>
                		<p style="text-align: center;color: red;"><%=errorMsg %></p>
                		<%
                		session.removeAttribute("errorMsg");
                	}
                %>
            <form action="updateContact?cid=<%=cid %>" method="post">
                <h2>Edit Contact</h2>
                <%
                	contact c = cd.getContactById(cid);
                	System.out.println(c.getName());
                	
                		%>
                			<div class="col-1">
                    			<div class="field-wrapper">
                        			<span>Enter Name</span>
                        			<input type="text" name="name" id="name" value="<%=c.getName() %>" placeholder="Enter your name">
                    			</div>
                    			<div class="field-wrapper">
                        			<span>Email Address</span>
                        			<input type="email" name="emailid" id="emailid" value="<%=c.getEmail() %>" placeholder="Enter your email id">
                    			</div>
                    			<div class="field-wrapper">
                        			<span>Enter Phone number</span>
                        			<input type="number" name="phno" id="phno" value="<%=c.getPhone() %>" placeholder="Enter phone number">
                    			</div>
                    			<div class="field-wrapper">
                        			<span>Description</span>
                        			<textarea name="description" id="description" placeholder="Description"><%=c.getAbout() %></textarea>
                    			</div>
                    
                			</div>
                			<button type="submit" onsubmit="return validate()" class="btn-smt">Update Contact</button>	
                			
                		<%
                %>
                
            </form>
        </div>
    </div>
</body>
</html>
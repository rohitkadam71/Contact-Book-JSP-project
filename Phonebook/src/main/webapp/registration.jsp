<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        .body-sec .form-wrapper .field-wrapper input{
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
           background-color: rgb(43, 43, 231);
           color: white;
        }
</style>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="body-sec">
        <div class="form-wrapper">
            <form action="register" method="post">
                <h2>Registration Page</h2>
                <% String succMsg = (String)session.getAttribute("succMsg");
                String errorMsg = (String)session.getAttribute("errorMsg");
                
                if(succMsg!=null){
                	%>
                	<p style="text-align: center;color: green;"><%=succMsg %></p>
                	<%
                	
                	session.removeAttribute("succMsg");
                }
                if(errorMsg!=null){
                	%>
                	<p><%=errorMsg %></p>
                	<%
                	session.removeAttribute("errorMsg");
                }
                %>
                <div class="col-1">
                    <div class="field-wrapper">
                        <span>Enter Name</span>
                        <input type="text" name="name" id="name" placeholder="Enter your name">
                    </div>
                    <div class="field-wrapper">
                        <span>Email Address</span>
                        <input type="email" name="emailid" id="emailid" placeholder="Enter your email id">
                    </div>
                    <div class="field-wrapper">
                        <span>Enter Password</span>
                        <input type="password" name="password" id="password" placeholder="Create Password">
                    </div>
                </div>
                <button type="submit" class="btn-smt">Register</button>
            </form>
        </div>
    </div>

</body>
</html>
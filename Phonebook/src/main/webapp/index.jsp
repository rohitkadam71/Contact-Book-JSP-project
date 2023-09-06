<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.Connection,java.sql.DriverManager" %>
    <%@ page import ="com.conn.DbConnect" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            /* position: fixed; */
            background-image: url('https://t4.ftcdn.net/jpg/00/87/29/57/360_F_87295734_GAnt6yRU0gC2eeSoNawXfJw0Y19MLrgR.jpg');
            height: 90vh;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        .body-sec h1{
            /* margin-top: 30px; */
            color: deeppink;
            text-align: center;
        }
    </style>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
    <div class="body-sec">
        <h1>Welcome To Phone Book App</h1>
    </div>
</body>
</html>
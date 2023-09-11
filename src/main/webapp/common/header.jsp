<%@ page import="org.example.model.entity.Account" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <title>Navbar Example</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style>
        .navbar {
            background-color: #f8f9fa;
            border-bottom: solid 1px #707070;
        }

        .navbar-brand {
            color: #aaa;
            font-weight: bold;
        }

        .navbar-icon {
            font-size: 24px;
            color: #aaa;
            margin-right: 5px;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-md">
        <a class="navbar-brand" href="/list">
            <i class="fas fa-user"></i> Employee
        </a>

			<%
				Account account = (Account) session.getAttribute("userLogin");
				if (account == null) {
			%>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/login"
					   class="nav-link">Welcome Guest!</a></li>
				<li><a href="<%=request.getContextPath()%>/login"
					   class="nav-link">Login</a></li>
			</ul>
			<%
				} else {
			%>
        <ul class="navbar-nav navbar-collapse justify-content-end ">
            <li><a href="" class="nav-link mr-3">Welcome <%= account.getAccountName() %>!</a></li>
            <li>
                <a href="/logout" class="nav-link"><i class="fas fa-sign-out-alt logout-icon"></i>Logout</a>
            </li>
        </ul>
    <%   } %>

    </nav>

</body>

</html>


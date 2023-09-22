<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.DAO.UserDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered users List</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f2f4">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<h1 class="text-center">Registered Users</h1>
	<!-- Jstl script -->
	<c:if test="${not empty success}">
		<p class="text-center text-success">${success}</p>
		<c:remove var="success" scope="session" />
	</c:if>

	<c:if test="${not empty failed}">
		<p class="text-center text-danger">${failed}</p>
		<c:remove var="failed" scope="session" />
	</c:if>

	<!-- end of jstl script -->
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Pass Id</th>
				<th scope="col">User Name</th>
				<th scope="col">Email</th>
				<th scope="col">Phone</th>
				<th scope="col">Position</th>
				<th scope="col">Weekly Limit</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			List<User> list = dao.getAllusers();
			for (User us : list) {
			%>
			<tr>
				<td><%=us.getPass_id()%></td>
				<td><%=us.getName()%></td>
				<td><%=us.getEmail()%></td>
				<td><%=us.getPhone()%></td>
				<td><%=us.getPosition()%></td>
				<td><%=us.getW_limit()%></td>
				<td><a
					href="../deleteuser?pass_id=<%=us.getPass_id()%>"
					class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>
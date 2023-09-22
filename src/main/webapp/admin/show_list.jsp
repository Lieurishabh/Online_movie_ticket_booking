<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.DAO.ShowDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.show"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shows List</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f2f4">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<h1 class="text-center">SHOWS</h1>
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
				<th scope="col">Show Id</th>
				<th scope="col">Movie Id</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Start At</th>
				<th scope="col">Upto</th>
				<th scope="col">Date</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			ShowDAOImpl dao = new ShowDAOImpl(DBConnect.getConn());
			List<show> list = dao.getAllshows();
			for (show s : list) {
			%>
			<tr>
				<td><%=s.getShow_id()%></td>
				<td><%=s.getMovie_id()%></td>
				<td><%=s.getSmname()%></td>
				<td><%=s.getStime()%></td>
				<td><%=s.getEtime()%></td>
				<td><%=s.getSdate()%></td>
				<td><a href="editshows.jsp?show_id=<%=s.getShow_id()%>"
					class="btn btn-sm btn-primary">Edit</a> <a
					href="../deleteshow?show_id=<%=s.getShow_id()%>"
					class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>
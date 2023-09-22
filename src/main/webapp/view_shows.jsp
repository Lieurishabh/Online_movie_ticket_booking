<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.DAO.ShowDAOImpl"%>
<%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.show"%>
<%@ page import="com.entity.movie"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shows List</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f2f4">
<%
User us=(User)session.getAttribute("userobj");
%>
	<%@include file="User_profile/user_navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
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
			 int movie_id=Integer.parseInt(request.getParameter("movie_id"));
		      MovieDAOImpl dao1 = new MovieDAOImpl(DBConnect.getConn());
		      movie m = dao1.getMovieById(movie_id);
		      
			ShowDAOImpl dao = new ShowDAOImpl(DBConnect.getConn());
			List<show> list = dao.getAllshows();
			for (show s : list) {
				if (s.getMovie_id() == m.getMovie_id()) {
			%>
			<tr>
				<td><%=s.getShow_id()%></td>
				<td><%=s.getMovie_id()%></td>
				<td><%=s.getSmname()%></td>
				<td><%=s.getStime()%></td>
				<td><%=s.getEtime()%></td>
				<td><%=s.getSdate()%></td>
				<td><a href="select_seats.jsp?show_id=<%=s.getShow_id()%>&&movie_id=<%=m.getMovie_id() %>"
					class="btn btn-sm btn-danger">Select seats</a> 
			</tr>
			<%
				}
			}
			%>

		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.movie"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies List</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f2f4">
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	
	<h1 class="text-center">MOVIES</h1>
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
				<th scope="col">Poster</th>
				<th scope="col">Movie Id</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Certificate</th>
				<th scope="col">Language</th>
				<th scope="col">Type</th>
				<th scope="col">Duration</th>
				<th scope="col">Director</th>
				<th scope="col">Movie Cast</th>
				<th scope="col">Release Date</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			List<movie> list = dao.getAllMovies();
			for (movie m : list) {
			%>
			<tr>
				<td><img src="../movie/<%=m.getMposter()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=m.getMovie_id()%></td>
				<td><%=m.getMname()%></td>
				<td><%=m.getMcertify()%></td>
				<td><%=m.getMlang()%></td>
				<td><%=m.getMtype()%></td>
				<td><%=m.getMdur()%></td>
				<td><%=m.getMdir()%></td>
				<td><%=m.getMcast()%></td>
				<td><%=m.getRdate()%></td>
				
				<td><a href="editmovies.jsp?movie_id=<%=m.getMovie_id()%>" class="btn btn-sm btn-primary">Edit</a> <a
					href="../delete?movie_id=<%=m.getMovie_id()%>" class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>
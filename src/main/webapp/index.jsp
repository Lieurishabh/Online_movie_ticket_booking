<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.movie"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cineclub : Indexpage</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/blwhome.jpg");
	height: 80vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body style="background-color: #f7f7f7">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<h1 class="text-center text-primary">
			<i class="fa-solid fa-ticket"></i> Blw Cinema Ticket Booking
		</h1>
	</div>

	<div class="container mt-1">
		<h2 class="text-center">Movies</h2>
		<div class="row">

			<!-- first movie beg-->
			<%
			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			List<movie> list = dao.getAllMovies();
			for (movie m : list) {
			%>
			<div class="col-md-3 mt-2">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="movie/<%=m.getMposter()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=m.getMname()%></p>
						<p><%=m.getMcast()%></p>
						<p><%=m.getRdate()%></p>
						<div class="row">
							<a href="view_details.jsp?movie_id=<%=m.getMovie_id()%>" class="btn btn-danger btn-sm btn-block">View Details</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<%@include file="all_component/footer.jsp"%>
</body>
</html>
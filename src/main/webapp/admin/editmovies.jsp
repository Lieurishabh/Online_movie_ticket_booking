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
<title>Add Movies</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f2f3">
	<%@include file="navbar.jsp"%>

<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	
	<!-- Form to input movie details -->
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Movie Details</h4>
						

						<!-- database connection -->
						<%
						int movie_id = Integer.parseInt(request.getParameter("movie_id"));
						MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
						movie m = dao.getMovieById(movie_id);
						%>

						<form action="../editmovies" method="post">
						<input type="text" name="movie_id" value="<%=m.getMovie_id()%>">

							<div class="form-group">
								<label>Movie Name</label> <input type="text"
									class="form-control" name="mname" required
									value="<%=m.getMname()%>">
							</div>
							<div class="form-group">
								<label>Movie Certificate</label> <select class="form-control"
									name="mcertify">
									<%
									if ("UA".equals(m.getMcertify())) {
									%>
									<option value="UA">UA</option>
									<option value="U">U</option>
									<option value="A">A</option>
									<option value="S">S</option>
									<%
									} else if ("U".equals(m.getMcertify())) {
									%>
									<option value="U">U</option>
									<option value="UA">UA</option>
									<option value="A">A</option>
									<option value="S">S</option>
									<%
									} else if ("A".equals(m.getMcertify())) {
									%>
									<option value="A">A</option>
									<option value="U">U</option>
									<option value="UA">UA</option>
									<option value="S">S</option>
									<%
									} else {
									%>
									<option value="S">S</option>
									<option value="A">A</option>
									<option value="U">U</option>
									<option value="UA">UA</option>
									<%
									}
									%>
								</select>
							</div>
							<div class="form-group">
								<label>Movie Language</label> <select class="form-control"
									name="mlang">
									<%
									if ("hindi".equals(m.getMcertify())) {
									%>
									<option value="hindi">Hindi</option>
									<option value="english">English</option>
									<option value="hinglish">Hindi/English</option>
									<%
									} else if ("english".equals(m.getMcertify())) {
									%>
									<option value="english">English</option>
									<option value="hindi">Hindi</option>
									<option value="hinglish">Hindi/English</option>
									<%
									} else {
									%>
									<option value="hinglish">Hindi/English</option>
									<option value="hindi">Hindi</option>
									<option value="english">English</option>							
									<%
									}
									%>
								</select>
							</div>
							<div class="form-group">
								<label>Movie Type</label> <select class="form-control"
									name="mtype">
									<%
									if ("action".equals(m.getMtype())) {
									%>
									<option value="action">Action</option>
									<option value="romantic">Romantic</option>
									<option value="thriller">Thriller</option>
									<option value="comedy">Comedy</option>
									<%
									} else if ("thriller".equals(m.getMtype())) {
									%>
									<option value="thriller">Thriller</option>
									<option value="action">Action</option>
									<option value="romantic">Romantic</option>
									<option value="comedy">Comedy</option>
									<%
									} else if ("romantic".equals(m.getMtype())) {
									%>
									<option value="romantic">Romantic</option>
									<option value="action">Action</option>
									<option value="thriller">Thriller</option>
									<option value="comedy">Comedy</option>
									<%
									} else {
									%>
									<option value="comedy">Comedy</option>
									<option value="action">Action</option>
									<option value="romantic">Romantic</option>
									<option value="thriller">Thriller</option>
									<%
									}
									%>
								</select>
							</div>
							<div class="form-group">
								<label>Duration</label> <input type="text" class="form-control"
									name="mdur" required value="<%=m.getMdur()%>">
							</div>
							<div class="form-group">
								<label>Director</label> <input type="text" class="form-control"
									name="mdir" required value="<%=m.getMdir()%>">
							</div>
							<div class="form-group">
								<label>Main Lead</label> <input type="text" class="form-control"
									name="mcast" required value="<%=m.getMcast()%>">
							</div>
							<div class="form-group">
								<label>Release Date</label> <input type="date"
									class="form-control" name="rdate" required
									value="<%=m.getRdate()%>">
							</div>
							<button type="submit" class="btn btn-primary mt-2  btn-block">Update
								Movie</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
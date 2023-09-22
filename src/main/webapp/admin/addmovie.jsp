<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
						<h4 class="text-center">Add Movie Page</h4>
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
						<form action="../addmovie" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label>Movie Poster</label> <input type="file"
									class="form-control" name="mposter" required>
							</div>
							<div class="form-group">
								<label>Movie Name</label> <input type="text"
									class="form-control" name="mname" required>
							</div>
							<div class="form-group">
								<label>Movie Certificate</label> <select class="form-control"
									name="mcertify">
									<option value="UA" selected>U/A</option>
									<option value="A">A</option>
									<option value="U">U</option>
									<option value="S">S</option>
								</select>
							</div>
							<div class="form-group">
								<label>Movie Language</label> <select class="form-control"
									name="mlang">
									<option value="hindi" selected>Hindi</option>
									<option value="english">English</option>
									<option value="hinglish">Hindi/English</option>
								</select>
							</div>
							<div class="form-group">
								<label>Movie Type</label> <select class="form-control"
									name="mtype">
									<option value="comedy" selected>Comedy</option>
									<option value="thriller">Thriller</option>
									<option value="action">Action</option>
									<option value="romantic">Romantic</option>
								</select>
							</div>
							<div class="form-group">
								<label>Duration</label> <input type="text" class="form-control"
									name="mdur" required>
							</div>
							<div class="form-group">
								<label>Director</label> <input type="text" class="form-control"
									name="mdir" required>
							</div>
							<div class="form-group">
								<label>Main Lead</label> <input type="text" class="form-control"
									name="mcast" required>
							</div>
							<div class="form-group">
								<label>Release Date</label> <input type="date"
									class="form-control" name="rdate" required>
							</div>
							<button type="submit" class="btn btn-primary mt-2  btn-block">Add
								Movie</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
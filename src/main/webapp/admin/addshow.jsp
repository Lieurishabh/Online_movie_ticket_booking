<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Shows</title>
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
						<h4 class="text-center">Add Show Page</h4>
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
						<form action="../addshow" method="post">
						<div class="form-group">
								<label>Movie_id</label> <input type="text"
									class="form-control" name="movie_id" required>
							</div>
		
							<div class="form-group">
								<label>Movie Name</label> <input type="text"
									class="form-control" name="smname" required>
							</div>
							<div class="form-group">
								<label>Start Time</label> <input type="time" class="form-control"
									name="stime" required>
							</div>
							<div class="form-group">
								<label>End Time</label> <input type="time" class="form-control"
									name="etime" required>
							</div>
							<div class="form-group">
								<label>Date</label> <input type="date" class="form-control"
									name="sdate" required>
							</div>
							<button type="submit" class="btn btn-primary mt-2  btn-block">Add
								Show</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
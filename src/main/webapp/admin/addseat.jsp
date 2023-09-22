<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Seats</title>
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
						<h4 class="text-center">Add Seat Page</h4>
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
						<form action="../addseat" method="post">
						<div class="form-group">
								<label>Seat Type</label> <input type="text"
									class="form-control" name="seat_type" required>
							</div>
		
							<div class="form-group">
								<label>Seat Price</label> <input type="text"
									class="form-control" name="s_price" required>
							</div>
	
							<button type="submit" class="btn btn-primary mt-2  btn-block">Add
								Seat</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
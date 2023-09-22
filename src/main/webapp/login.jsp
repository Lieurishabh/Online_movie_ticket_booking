<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4 mt-5">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Login Page</h4>
						<!-- Jstl script -->

						<c:if test="${not empty failed}">
							<p class="text-center text-danger">${failed}</p>
							<c:remove var="failed" scope="session" />
						</c:if>

						<!-- end of jstl script -->
						<form action="login" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email" required>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="pass" required>
							</div>


							<button type="submit"
								class="btn btn-primary btn-lg btn-block mt-4">Log-In</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
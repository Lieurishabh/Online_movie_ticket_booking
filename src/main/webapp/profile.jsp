<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.DAO.UserDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f2f3">
	<%@include file="User_profile/user_navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4 mt-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Profile Page</h4>
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
						<form action="updateprofile" method="post">
							<div class="form-group">
							<input type="hidden" name="pass_id" value="${userobj.pass_id}">
								<label for="exampleInputEmail1">Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Full Name"
									name="name" value="${userobj.name}" required>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email" value="${userobj.email}" required> 
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contact Number</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Contact Number"
									name="phone" value="${userobj.phone}" required>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Position</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Position"
									name="position" value="${userobj.position}" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="pass" required>
							</div>
							<button type="submit" class="btn btn-block btn-primary mt-2">Save
								</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
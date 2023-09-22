<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<%@include file="all_css.jsp"%>
<style type="text/css">
a:hover {
	color: black;
}
</style>
</head>
<body style="background-color: #f0f2f3">
	<div>

		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"></h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h4>Do You want to logout?</h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<a href="../logout" type="button" class="btn btn-primary">logout</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<!-- Add movie container -->
	<div class="container mt-5">
		<div class="row">

			<div class="col-md-3">
				<a href="addmovie.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x"></i><br>
							<h4>Add Movie</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- Bookings container -->
			<div class="col-md-3">
				<a href="all_bookings.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-ticket fa-3x"></i><br>
							<h4>Bookings</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- Users container -->
			<div class="col-md-3">
				<a href="all_users.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-users fa-3x"></i><br>
							<h4>Users</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- show list container -->
			<div class="col-md-3">
				<a href="show_list.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-video fa-3x"></i><br>
							<h4>Show List</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- all movie list container -->
			<div class="col-md-3 mt-3">
				<a href="all_movie.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-film fa-3x"></i><br>
							<h4>Movies List</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- Add show container -->
			<div class="col-md-3 mt-3">
				<a href="addshow.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-regular fa-file-video fa-3x"></i><br>
							<h4>Add Show</h4>
						</div>
					</div>
				</a>
			</div>
			
			<!-- Add seat container -->
			<div class="col-md-3 mt-3">
				<a href="addseat.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-chair fa-3x"></i><br>
							<h4>Add Seat</h4>
						</div>
					</div>
				</a>
			</div>

			<!-- log out container -->
			<div class="col-md-3 mt-3">
				<a data-toggle="modal" data-target="#exampleModalCenter" href="">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-right-from-bracket fa-3x"></i><br>
							<h4>Log-out</h4>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>

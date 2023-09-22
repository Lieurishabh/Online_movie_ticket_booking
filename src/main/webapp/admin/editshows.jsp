<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.DAO.ShowDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.show"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit show details</title>
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
						<h4 class="text-center">Edit Show Details</h4>
						

						<!-- database connection -->
						<%
						int show_id = Integer.parseInt(request.getParameter("show_id"));
						ShowDAOImpl dao = new ShowDAOImpl(DBConnect.getConn());
						show s = dao.getShowById(show_id);
						%>

						<form action="../editshows" method="post">
						<input type="text" name="show_id" value="<%=s.getShow_id()%>">
						<div class="form-group">
								<label>Movie Id</label> <input type="text"
									class="form-control" name="movie_id" required
									value="<%=s.getMovie_id()%>">
							</div>

							<div class="form-group">
								<label>Movie Name</label> <input type="text"
									class="form-control" name="smname" required
									value="<%=s.getSmname()%>">
							</div>
							<div class="form-group">
								<label>Start At</label> <input type="text" class="form-control"
									name="stime" required value="<%=s.getStime()%>">
							</div>
							<div class="form-group">
								<label>Upto</label> <input type="text" class="form-control"
									name="etimr" required value="<%=s.getEtime()%>">
							</div>
							<div class="form-group">
								<label>Date</label> <input type="date" class="form-control"
									name="sdate" required value="<%=s.getSdate()%>">
							</div>
							<button type="submit" class="btn btn-primary mt-2  btn-block">Update
								Show</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
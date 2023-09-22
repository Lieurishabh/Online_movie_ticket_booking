<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.entity.User"%>
<%@ page import="com.DAO.CartDAOImpl"%>
<%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entity.cart"%>
<%@ page import="com.entity.movie"%>
<%@ page import="com.entity.show"%>
<%@ page import="com.DAO.ShowDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkout page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="User_profile/user_navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
	</c:if>
	<div class="container">
		<div class="row pd-2">
			<div class="col-md-6">
				<div class="card-bg-white">
					<div class="card-body">
						<h3 class="text-center text success">Your selected seats</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Show Id</th>
									<th scope="col">Seat Id</th>
									<th scope="col">Seat Type</th>
									<th scope="col">Seat Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User us = (User) session.getAttribute("userobj");
								CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
								List<cart> list = dao.getSeatByUser(us.getPass_id());
								int totalPrice = 0;
								int count = 0;
								int showId = 0;
								for (cart c : list) {
									totalPrice = c.getTotal_price();
									showId = c.getShow_id();
								%>
								<tr>
									<th scope="row"><%=c.getShow_id()%></th>
									<th><%=c.getSeat_id()%></th>
									<td><%=c.getMname()%></td>
									<td><%=c.getS_price()%></td>
									<td><a
										href="removeSeat?seat_id=<%=c.getSeat_id()%>&&pass_id=<%=c.getPass_id()%>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>
								<%
								count = count + 1;
								}
								%>
								<tr>
									<th scope="row">Total Amount</th>
									<td></td>
									<td></td>
									<td></td>
									<td><span>&#8377</span><%=totalPrice%></td>
								</tr>
								<tr>
									<th scope="row">Total Seats</th>
									<td></td>
									<td></td>
									<td></td>
									<td><%=count%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6 mt-2">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details</h3>
						<form action="ordernow" method="post">
							<%
							ShowDAOImpl dao1 = new ShowDAOImpl(DBConnect.getConn());
							show sho = dao1.getShowById(showId);
							%>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Pass Id</label> <input type="text" class="form-control"
										placeholder="Pass Id" name="pass_id" value="<%=us.getPass_id()%>" disabled>
								</div>
								<div class="form-group col-md-6">
									<label>Position Level</label> <input type="text"
										class="form-control" placeholder="Position Level" name="position"
										value="<%=us.getPosition()%>" disabled>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Name</label> <input type="text" class="form-control"
										placeholder="Name" name="name" value="<%=us.getName()%>" disabled>
								</div>
								<div class="form-group col-md-6">
									<label>Email</label> <input type="text" class="form-control"
										placeholder="Email" name="email" value="<%=us.getEmail()%>">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Mobile Number</label> <input type="text"
										class="form-control" placeholder="Moblie Number" name="phone"
										value="<%=us.getPhone()%>">
								</div>
								<div class="form-group col-md-6">
									<label>Movie</label> <input type="text" class="form-control" name="smname"
										 value="<%=sho.getSmname()%>" disabled>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label>Date</label> <input type="text" class="form-control" name="sdate"
										value="<%=sho.getSdate()%>" disabled>
								</div>
								<div class="form-group col-md-6">
									<label>Time</label> <input type="text" class="form-control" name="stime"
										value="<%=sho.getStime()%>" disabled>
								</div>
							</div>
							
							<div class="form-group">
								<label>Weekly_limit</label> 
									<input type="text" class="form-control" name="w_limit"
										value="<%=us.getW_limit()%>" disabled>
							
							</div>   

							 		<div class="form-group">
								<label>Payment mode</label> <select class="form-control" name="payment">
									<option value="POE">Pay On Entry</option>
									<option value="UPI">UPI</option>
									<option value="CARD">Card</option>
								</select>
							</div>   
				
							<div class="text-center">
								
									<button type="submit" class="btn btn-warning ">Order Now</button>
								 <a href="select_seats.jsp?show_id=<%=showId%>"
									class="btn btn-success">Select More Seats</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.DAO.SeatDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.seat"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.List"%>
<%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.entity.movie"%>
<%@ page import="com.DAO.ShowDAOImpl"%>
<%@ page import="com.entity.show"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>select seats</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>

<body style="background-color: #f0f2f4">
	<c:if test="${not empty success}">
		<div id="toast">${success}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

	</c:if>

	<c:if test="${not empty failed}">
		<p class="text-center text-danger">${failed}</p>
		<c:remove var="failed" scope="session" />
	</c:if>

	<%
	User us = (User) session.getAttribute("userobj");
	%>
	<%@include file="User_profile/user_navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
	</c:if>

	<h1 class="text-center">Available Seats</h1>
	<!-- Jstl script -->

	<!-- end of jstl script -->
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Show Id</th>
				<th scope="col">Seat Id</th>
				<th scope="col">Seat Type</th>
				<th scope="col">Seat Price</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			
			int show_id = Integer.parseInt(request.getParameter("show_id"));
			 

			SeatDAOImpl dao = new SeatDAOImpl(DBConnect.getConn());
			List<seat> list = dao.getAllSeats();
			for (seat s : list) {
			%>
			<tr>
				<td><%=s.getShow_id()%></td>
				<td><%=s.getSeat_id()%></td>
				<td><%=s.getSeat_type()%></td>
				<td><%=s.getS_price()%></td>
				<td><%=s.getS_status()%></td>
				<td><a
					href="cart?seat_id=<%=s.getSeat_id()%>&&pass_id=<%=us.getPass_id()%>&&show_id=<%=show_id%>"
					class="btn btn-sm btn-danger">Select</a>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>

</html>
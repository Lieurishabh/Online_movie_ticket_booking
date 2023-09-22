<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bookingd</title>
<%@include file="all_css.jsp" %>
</head>
<body style="background-color:#f0f2f4">
<%@include file="navbar.jsp" %>

<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	
<h1 class="text-center">All Bookings</h1>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.No.</th>
      <th scope="col">Movie Name</th>
      <th scope="col">Certificate</th>
      <th scope="col">Language</th>
       <th scope="col">Release Date</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>12/jan/23</td>
      <td>
      <a href="" class="btn btn-sm btn-primary">Edit</a>
      <a href="" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
      <td>12/jan/23</td>
       <td>
      <a href="" class="btn btn-sm btn-primary">Edit</a>
      <a href="" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
      <td>12/jan/23</td>
       <td>
      <a href="" class="btn btn-sm btn-primary">Edit</a>
      <a href="" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
  </tbody>
</table>
</body>
</html>
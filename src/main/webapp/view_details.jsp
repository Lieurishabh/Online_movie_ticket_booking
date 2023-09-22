<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.DAO.MovieDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2">
<%@include file="User_profile/user_navbar.jsp"%>
<c:if test="${empty userobj}">
		<c:redirect url="login.jsp" />
	</c:if>
<div class="container">
<%
      int movie_id=Integer.parseInt(request.getParameter("movie_id"));
      MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
      movie m = dao.getMovieById(movie_id);
      %>
      <h1><%=m.getMname()%></h1>
      <hr>
      
      <div class="row">
        <div class="col">
          <input type="image" class="form-input .img-fluid" src="movie/<%=m.getMposter()%>" alt="Submit" width="400px" height="450px">
        </div>
        <div class="col">
          <table class="table table-bordered">
              <tr>
                <th>Name</th>
                <td><%=m.getMname()%></td>
              </tr>
              <tr>
                <th>Certificate</th>
                <td><%=m.getMcertify()%></td>
              </tr>
              <tr>
                <th>Type</th>
                <td><%=m.getMtype() %></td>
              </tr>
              <tr>
                <th>Language</th>
                <td><%=m.getMlang() %></td>
              </tr>
              <tr>
                <th>Duration</th>
                <td><%=m.getMdur() %></td>
              </tr>
              <tr>
                <th>Director</th>
                <td><%=m.getMdir() %></td>
              </tr>
              <tr>
                <th>Cast</th>
                <td><%=m.getMcast() %></td>
              </tr>
              <tr>
                <th>Release Date</th>
                <td><%=m.getRdate() %></td>
              </tr>
            </table>
            <a href="view_shows.jsp?movie_id=<%=m.getMovie_id()%>" class="btn btn-danger btn-sm btn-block">Book Tickets</a>
        </div>
      </div>
</div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">BLW CineClub</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home1.jsp"><i class="fa-solid fa-house-chimney"></i> Home <span class="sr-only">(current)</span></a>
      </li>
         </ul>
  </div>
  
  
</nav>
<!--<c:if test="${not empty userobj} ">
    <a class="btm btn-primary mr-sm-2 nav-link" href="../login.jsp">${userobj.name}</a>
    </c:if>
    
      <c:if test="${empty userobj} ">
    <a class="btm btn-primary mr-sm-2 nav-link" href="../login.jsp">Login</a>
      <a class="btm btn-primary my-2 my-sm-0 nav-link" href="../registration.jsp">SignUp</a>
    </c:if>
    -->
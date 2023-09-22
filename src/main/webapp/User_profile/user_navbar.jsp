<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">BLW CineClub</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
					class="fa-solid fa-house-chimney"></i> Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item active"><a class="nav-link"
				href="profile.jsp">Profile <span class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link" href="#">About
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="#">Contact
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
		<c:if test="${not empty userobj}">
			<div class="col-md-3">
				<a href="checkout.jsp"><i class="fas fa-cart-plus fa-2x"></i></a> <a
					class="btn btn-success" href="profile.jsp"> <i class="fas fa-user-plus"></i>${userobj.name}</a> <a
					class="btn btn-primary text-white" href="logout"><i class="fas fa-sign-in-alt"></i>logout</a>
			</div>


		</c:if>
	</div>
</nav>
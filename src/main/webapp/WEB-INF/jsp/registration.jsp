<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html style="width:100%;">
<head>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="<c:url value="/"></c:url>" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>
	</form>	
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form:form modelAttribute="user" action="/registration" method="post" class="form-horizontal">
					<h2>Registration Form</h2>
					<div class="form-group">
						<div class="col-sm-9">												
						<form:input type="text" path="username" placeholder="Name" class="form-control" />
						<form:errors path="username" cssClass="text-danger"/>						
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="text" path="email" placeholder="Email"	class="form-control" />
							<form:errors path="email" cssClass="text-danger"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="text" path="password" placeholder="Password" class="form-control" />
							<form:errors path="password" cssClass="text-danger"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register User</button>
						</div>
					</div>
					
					<span style="color: blue;">${successMessage}</span>										
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

</head>
<jsp:directive.page isELIgnored="false"/>

<body>
<div class="container">

	<form:form id="signupform" action="submitsignup.do" method="post" commandName="regVO">
	<spring:hasBindErrors name="regVO">
				
          		<div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="alert alert-danger" role="alert">
			        <ul> 
			          <c:forEach var="error" items="${errors.allErrors}">
			                <li><fmt:message key="${error.code}"/></li>
			            </c:forEach>
			    	 </ul>
			      </div>
			       
			    </div>
			  </div>
			</spring:hasBindErrors>			     
	
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="fName">First Name:</label>
	    <div class="col-sm-3">
	      <form:input class="form-control" placeholder="first name" path="fName"/>
	    </div>
	  </div>
	 <div class="col-sm-12"> </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="lName">Last Name:</label>
	    <div class="col-sm-3">
	      <form:input class="form-control" placeholder="last name" path="lName"/>
	    </div>
	  </div>
	  <div class="col-sm-12"> </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="email">Email:</label>
	    <div class="col-sm-3">
	      <form:input class="form-control" type="email"  placeholder="Enter email" path="emailId"/>
	    </div>
	  </div>
	  <div class="col-sm-12"> </div>
	  <div class="form-group">
	    <label class="control-label col-sm-2" for="Role">Role:</label>
	    <div class="col-sm-3">
	      <form:select class="form-control" placeholder="Enter role" path="roleId">
	      <form:options items="${rolelist}" itemLabel="roleName" itemValue="roleId"/>
		  </form:select>			   
	    </div>
	  </div>
	  <div class="col-sm-12"> &nbsp;</div>
	  <div class="col-sm-12"> &nbsp;</div>
	  <div class="form-group"> 
	    <div class="col-sm-offset-2 col-sm-10">
		<form:button class="btn btn-lg btn-primary">Save</form:button>
	    </div>
	  </div>
	  
	</form:form>
	</div>
</body>
</html>
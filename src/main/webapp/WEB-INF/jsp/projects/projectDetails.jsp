<!DOCTYPE html>n      
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>ESS - Project</title>
</head>
<body>
	<div class="container">
	<h3>Please add environment details </h3>
	<div class="dropdown">
	  <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
	    Select Template
	    <span class="caret"></span>
	  </button>
	  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	  	<li><a href="#">Add Project Basic Details</a></li>
	    <li><a href="#">Add Database Details</a></li>
	    <li><a href="#">Add JVM Details</a></li>
	    <li><a href="#">Add Application Server Details</a></li>
	    <li><a href="#">Add Integration Details</a></li>
	    <li role="separator" class="divider"></li>
   		<li><a href="#">Add Other Category</a></li>
	  </ul>
	</div>

	</div>

</body>
</html>
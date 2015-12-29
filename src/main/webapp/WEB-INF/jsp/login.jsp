<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


</head>
<body >
<div class="container">


  <!-- Trigger the modal with a button -->
  


<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-md">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login</h4>
        </div>
        
        <div class="modal-body">
          
          <form:form id="loginform" class="form-horizontal" role="form" action="validateLogin.do" commandName="loginVO">  
			  
			   
			  <spring:hasBindErrors name="loginVO">
				
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
				
			   <c:if test="${msg ne null}">
			    <div class="form-group"> 
			    	<div class="col-sm-offset-2 col-sm-10">
			      		<div class="alert alert-success" role="alert">
			         	${msg}
			       		</div>
			       
			    	</div>
			 	 </div>  	
			    </c:if>
			      			  
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="loginId">Email:</label>
			    <div class="col-sm-8">
			      <form:input class="form-control" placeholder="Enter email" path="loginId"/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="password">Password:</label>
			    <div class="col-sm-8"> 
			      <form:input type="password" class="form-control" placeholder="Enter password" path="password"/>
			    </div>
			  </div>
			  <!-- <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label><input type="checkbox"> Remember me</label>
			      </div>
			    </div>
			  </div> -->
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			     <form:button class="btn btn-lg btn-primary">Submit</form:button>
				<form:button class="btn btn-lg btn-primary" onClick="newUserSubmit();">Sign Up</form:button>
			    </div>
			  </div>
		</form:form>
		          
          
         
        </div>
      <!--   <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
      
    </div>
  </div>
  </div>

<script type="text/javascript">
    $(window).load(function(){
        $('#myModal').modal('show');
    });
    function newUserSubmit(){
	document.getElementById("loginform").action="registration.do";
	document.getElementById("loginform").submit();}
</script>

</body>
</html>
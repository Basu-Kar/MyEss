<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>ESS - Home</title>
</head>
<body>

  <div class="row">
        <div class="col-sm-20">
        	<form:form class="form-horizontal" role="form" action="" commandName="portfolioVO">  
			  
			  <%--  <spring:hasBindErrors name="loginVO">
				
          		<div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="alert alert-danger" role="alert">
			        <ul> <li><label><form:errors path="loginId"/></label></li>
			        <li><label><form:errors path="password"/></label></li>
			        
			        </ul>
			      </div>
			       
			    </div>
			  </div>
			    </spring:hasBindErrors> --%>
			    
			  
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="projectName">Search Project:</label>
			    <div class="col-sm-3">
			      <form:input class="form-control" placeholder="Project Name" path="portFolioId"/> 
			     
			    </div>
			  </div>
			 <%--  <div class="form-group">
			    <label class="control-label col-sm-3" for="password">Search Value:</label>
			    <div class="col-sm-3"> 
			      <form:input type="password" class="form-control" placeholder="Enter password" path="password"/>
			    </div>
			  </div> --%>
			  <!-- <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label><input type="checkbox"> Remember me</label>
			      </div>
			    </div>
			  </div> -->
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-3">
			       <form:button class="btn btn-lg btn-primary">Search</form:button>
			    </div>
			  </div>
		</form:form>
		
        </div>
        
   </div>     

 <table class="table table-striped">
            <thead>
              <tr>
              	<th>Portfolio Name</th>
                <th>Project Id</th>
                <th>Project Name</th>
                <th>Technology</th>
               
              </tr>
            </thead>
            <tbody>
           
              <tr>
              
               
                <td>IBP</td>
                <td>1</td>
                <td><a href="#" onclick="submitForm('showProjectDetails.do')">VMM</a></td>
                <td>J2EE</td>
              
              </tr>
             
              <tr>
              
                <td>IBP</td>
                <td>2</td>
                <td>EDI</td>
                <td>J2EE</td>
               
              </tr>
              <tr>
             
                <td>IBP</td>
                <td>3</td>
                <td>PSL</td>
                <td>J2EE</td>
               
              </tr>
            </tbody>
          </table>
</body>
</html>
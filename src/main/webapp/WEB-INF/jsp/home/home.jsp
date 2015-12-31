<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>ESS - Home</title>
</head>
<jsp:directive.page isELIgnored="false"/>

<body>

  <div class="row">
        <div class="col-sm-20">
        	<form:form id="home" class="form-horizontal" role="form" action="">  
			  
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
			    
			  
			<%--   <div class="form-group">
			    <label class="control-label col-sm-2" for="projectName">Search Project:</label>
			    <div class="col-sm-3">
			      <form:input class="form-control" placeholder="Project Name" path="portFolioId"/> 
			     
			    </div>
			  </div> --%>
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
	<%-- 		  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-3">
			       <form:button class="btn btn-lg btn-primary">Search</form:button>
			    </div>
			  </div>
			  
			   --%>
	
			    <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-6">
			 
 <c:if test="${userlist ne null}">        
 <table class="table table-striped">
            <thead>
              <tr>
              	<th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>User Status</th>
               
              </tr>
            </thead>
            <tbody>
           
            
             <c:forEach items="${userlist}" var="vo">
              <tr>
                <td>${vo.fName}</td>
                <td>${vo.lName}</td>
                <td>${vo.emailId}</td>
                <td>${vo.userStatusVO.statusName}</td>
                <td><a href="#" onClick="approveUser('${vo.userId}')">Approve</a></td>
				<td><a href="#" onClick="declineUser('${vo.userId}')">Decline</a></td>
               	
              </tr>
              </c:forEach> 
            
            </tbody>
          </table>
          </c:if>
          
			   
			</div>
			  </div>
			 <input type="hidden" name="selecteduserId" id="selecteduserId"/> 
	</form:form>   
			
        </div>
        
   </div>   
     
<!-- 
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
          </table>-->
 
 <script type="text/javascript">
 function approveUser(userId){
		document.getElementById("selecteduserId").value=userId;
		document.getElementById("home").action="approveuser.do";
		document.getElementById("home").submit();

		 }
 function declineUser(userId){
		document.getElementById("selecteduserId").value=userId;
		document.getElementById("home").action="declineuser.do";
		document.getElementById("home").submit();

		}
 </script>       
</body>
</html>
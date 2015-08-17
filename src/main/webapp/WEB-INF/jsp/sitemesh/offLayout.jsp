<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<title>Off Layout</title>
</head>
<body>
<div class="container">
<div class="panel panel-default">
  <div class="panel-body"><jsp:include page="loginHeader.jsp"/></div>
</div>
	
	
      
		<decorator:body />
	
	<jsp:include page="footer.jsp"/>
 </div>
</body>
</html>
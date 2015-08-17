<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="panel panel-default">
  <div class="panel-body"><jsp:include page="header.jsp"/></div>
</div>
	<div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
     <div class="row">
        <div class="col-sm-20">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Home</h3>
            </div>
            <div class="panel-body">
               <decorator:body />
            </div>
          </div>
         
    
      
            </div><!-- /.col-sm-4 -->
      </div>

    </div>
	
      
		
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>
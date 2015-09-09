<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<title>ESS - Login</title>
</head>
<body>
<jsp:include page="scripts.jsp"/>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" data-toggle="modal" data-target="#myModal" href="#">Login</a>
                
            </div>
      
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
        
        
    </nav>

	<decorator:body />
      
		
	
	

</body>
</html>
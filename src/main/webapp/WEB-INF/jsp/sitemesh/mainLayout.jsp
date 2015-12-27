<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<title>Insert title here</title>

<style type="text/css">
.row {
    margin-left: -20px;
    *zoom: 1;
    margin-top: 50px;
}
</style>
</head>
<body>
<jsp:directive.page isELIgnored="false"/>


<jsp:include page="scripts.jsp"/>
<div class="container" >
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
                <a class="navbar-brand" href="#">Home</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Add Project</a>
                    </li>
                    <li>
                        <a href="#">Search Project</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
        
        
    </nav>
	
	<div class="row"></div>
	<div class="row"></div>
	
	<decorator:body />
      
</div>		

</body>
</html>
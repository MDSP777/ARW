<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  	<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/Bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style-admin.css" />" rel="stylesheet">
    
    </head>
    <body>
        <nav class="navbar navbar-default" style = "background: blue;">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
                <a class="navbar-brand" rel="home" href="#" title="Admin Page">
                    <span><img style="max-width:50px; margin-top: -15px; margin-left: -15px" src="<c:url value="/resources/img/logo.jpg" />"></span>
                    Admin Page
                </a>
            </div>
            
              
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="index.html">List of Members<span class="sr-only">(current)</span></a></li>
                <li><a href="#">Revenue</a></li>
                <li><a href="settings.html">Settings</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        
        <!--Main Content-->
        <section class = "main-container">
            <div class = "row totals">
                <div class = "col-lg-6">
                    <h5>Total registered members: ${fn:length(registrants) }</h5>
                </div>
                <div class = "col-lg-6">
                    <h5>Total revenue: P ${totalRevenue }</h5>
                </div>
            </div>
            
            <div>
                <div class = "table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID No.</th>
                                <th>Surname</th>
                                <th>First Name</th>
                                <th>Middle Name</th>
                                <th>Course</th>
                                <th>Contact No.</th>
                                <th>Membership Type</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="registrant" items="${registrants }">
	                            <tr>
	                                <td>${registrant.idNo }</td>
	                                <td>${registrant.surname }</td>
	                                <td>${registrant.firstName }</td>
	                                <td>${registrant.middleName }</td>
	                                <td>${registrant.course }</td>
	                                <td>${registrant.contactNo }</td>
	                                <td>${registrant.membershipType.typeName }</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="Bootstrap/js/bootstrap.min.js"></script>
      
    </body>
    
</html>

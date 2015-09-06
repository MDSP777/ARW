<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>
		<title>LSCS Annual Recruitment Week Registration</title>

		<meta name="description" content="LSCS Annual Recruitment Week Registration">
		<meta name="author" content="La Salle Computer Society">

		<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
	</head>
	
	<script type="text/javascript">
		function validateForm(){
			
			if(document.getElementById("receiptNo").value.length==0 || 
			   document.getElementById("surname").value.length==0 || 
			   document.getElementById("firstName").value.length==0 || 
			   document.getElementById("idNo").value.length==0 || 
			   document.getElementById("course").value.length==0 || 
			   document.getElementById("contactNo").value.length==0 || 
			   document.getElementById("email").value.length==0 || 
			   document.getElementById("membershipType").value.length==0){
				alert("Error submitting. Please fill up all required fields.");
				return false;
			}
			return true;
		}
	</script>
	
	<body>
		<div id="container">

			<div id="header">
				<img src="<c:url value="/resources/img/logo.jpg" />"/>
			</div>

			<form action="RegisterMember" method="post" onsubmit="return validateForm()">

				<div id="content">
					<table>
						<tr>
							<td>Receipt Number</td>
							<td><input name="receiptNo" id="receiptNo"></td>
						</tr>
						<tr>
							<td>Name</td>
							<td>
								<input placeholder="Surname" class="half-input" name="surname" id="surname">
								<div class="half-input-divide">, </div>
								<input placeholder="First Name" class="half-input" name="firstName" id="firstName">
								<div class="half-input-divide"></div>
								<input placeholder="Middle Name" class="half-input" name="middleName" id="middleName">
							</td>
						</tr>
						<tr>
							<td>ID Number</td>
							<td><input name="idNo" id="idNo"></td>
						</tr>
						<tr>
							<td>Course</td>
							<td><input name="course" id="course"></td>
						</tr>
						<tr>
							<td>Contact Number</td>
							<td><input name="contactNo" id="contactNo"></td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td><input name="email" id="email"></td>
						</tr>
						<tr>
							<td>Membership Type</td>
							<td>
								<select name="membershipType" id="membershipType">
									<c:forEach var="regType" items="${regTypes }">
										<option>${regType.typeName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
				</div>

				<div id="footer">
					<input type="submit" value="Register" class="submit"/>
				</div>

			</form>

		</div>
		
		<c:if test="${resultMsg != null }">
			<script>
			var msg = "${resultMsg }";
			alert(msg);
			</script>
		</c:if>
	</body>

</html>
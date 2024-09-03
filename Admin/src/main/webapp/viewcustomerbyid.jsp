<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 
 
</style> 
</head> 
<body> 


<%@ include file="adminnavbar.jsp" %>

ID : ${customer.id}<br>
Name : ${customer.name}<br>
Email : ${customer.email}<br>
Location : ${customer.location}<br>
Contact No : ${customer.contact}<br>

</body>
</html>
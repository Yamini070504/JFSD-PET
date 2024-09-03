<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 
 
</style> 
</head> 
<body> 
 
 <%@ include file="adminnavbar.jsp" %>
 
<br> 
 
<h3 align="center"><u>View All Customers</u></h3> 
 
<table align=center  border=2>  
<tr bgcolor="black" style="color:white"> 
<td>ID</td> 
<td>NAME</td>  
<td>LOCATION</td> 
<td>EMAIL ID</td> 
<td>CONTACT NO</td> 
<td>ACTION</td>
</tr> 
 
<c:forEach items="${customerdata}"  var="customer"> 
<tr> 
<td><c:out value="${customer.id}" /></td> 
<td><c:out value="${customer.name}" /></td> 
<%-- <td><c:out value="${customer.gender}" /></td>  --%>
<%-- <td><c:out value="${customer.dateofbirth}" /></td>  --%>
<%-- <td><c:out value="${customer.salary}" /></td>  --%>
<td><c:out value="${customer.location}" /></td> 
<td><c:out value="${customer.email}" /></td> 
<td><c:out value="${customer.contact}" /></td> 
<td>
<a href='<c:url value="view?id=${customer.id}"></c:url>'>View</a>
</td>
 
</tr> 
</c:forEach> 
 
</table> 
 
</body> 
</html>
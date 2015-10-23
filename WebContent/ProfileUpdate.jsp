<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
</head>
<body>
<h1>Xphase : Search for User Name</h1>
<s:form action="SearchForIDOrUserName.action" method="post">
<s:textfield name="IDOrUserName" label="Enter the Search User Name "/>
<s:submit value="Search"/>
</s:form>

<center><table border="1">
	<tr>
	<th>User ID</th>
	<th>User Name</th>
	<th>First Name</th>
	<th>Middle Name</th>
	<th>Last Name</th>
	<th>Email ID</th>
	<th>Mobile Number</th>
	<th>Address</th>
	<th>City</th>
	</tr>
	<s:iterator value="list">
	<tr>
	<td><s:property value="id"/></td>
	<td><s:property value="UserName"/></td>
	<td><s:property value="First_Name"/></td>
	<td><s:property value="Middle_Name"/></td>
	<td><s:property value="Last_Name"/></td>
	<td><s:property value="Email_ID"/></td>
	<td><s:property value="Mobile_Num"/></td>
	<td><s:property value="Address"/></td>
	<td><s:property value="city"/></td>
	</tr>
	</s:iterator>
</table>
</center>

</body>
</html>
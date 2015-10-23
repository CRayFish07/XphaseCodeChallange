<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Data present in database</title>
</head>
<body>
<h1>Xphase : Showing all User Present in DataBase</h1>
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
<s:a href="logout.action">log out</s:a><br><br>
<s:a href="ProfileUpdate.action">Click here to update</s:a><br><br>
<s:a href="UserImageShort.action">Click here to save image and update</s:a><br><br>
<s:a href="ClickHereToSeeProfilePic.action">Profile Picture Check here</s:a><br><br>
<s:a href=""></s:a>
</body>
</html>
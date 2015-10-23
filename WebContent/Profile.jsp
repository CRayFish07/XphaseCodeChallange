<%@page import="org.xphase.Bean.RegisterBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<STYLE type="text/css">  
.errorMessage{color:red;}  
</STYLE>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
</head>
<body>
<h1>Xphase : Profile page</h1>

<% String s = (String) session.getAttribute("userName"); %>
Welcome, <s:property value="Uname"></s:property>

<s:a href="logout.action">log out</s:a><br><br>
<s:a href="ProfileUpdate.action">Click here to Search</s:a><br><br>
<s:a href="UserImageShort.action">Click here to save image and update</s:a><br><br>
<s:a href="ClickHereToSeeProfilePic.action">Profile Picture Check here</s:a><br><br>
<s:a href="ShowAllData.action">Check here to see all data in DB</s:a><br><br>
<s:a href="ModifyShortCut.action">Click here to Modify Registration</s:a><br><br>
<s:a href="DeleteShortCut">Click here to delete User</s:a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting User from Xphase Technology Org</title>
</head>
<h1>Xphase</h1>
<body>
<s:form action="delete.action" method="post"> 
<s:textfield name="UserNameToDelete" label="Enter the User Name you want to delete"/>
<s:submit value="Delete"/>
</s:form>
</body>
</html>
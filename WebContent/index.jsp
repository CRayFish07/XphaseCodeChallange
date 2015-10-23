<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Xphase Contact based web applications</title>
</head>
<STYLE type="text/css">  
.errorMessage{color:red;}  
</STYLE>
<script>  
function validateform(){  
var name=document.indexPage.Uname.value;  
var password=document.indexPage.Upwd.value;  
  
if (name==null || name==""){  
  alert("User Name can't be blank");  
  return false;  
}else if(password.length < 6){  
  alert("User Password must be at least 6 characters long.");  
  return false;  
  }  
}  
</script>    
<center><h1>Home Page</h1></center>
<body><center>
<s:form action="Login.action" method="post" name="indexPage" onsubmit="return validateform()">
<s:textfield name = "Uname" label="User Name"/>
<s:password name = "Upwd"  label="User Password"/>
<s:submit value="Login"/>
</s:form>
<s:a href="registerShortCut.action">Click here to Register!!!</s:a>
</center></body>
</html>
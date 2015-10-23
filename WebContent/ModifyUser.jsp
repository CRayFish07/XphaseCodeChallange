<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<STYLE type="text/css">  
.errorMessage{color:red;}  
</STYLE>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifying User registration</title>
</head>
<script>  
function validateform(){  
var name=document.registerationForm.UserName.value;
var pwd=document.registerationForm.UserPwd.value;
var conpwd=document.registerationForm.UserConPwd.value;
var fname=document.registerationForm.First_Name.value;
var mname=document.registerationForm.Middle_Name.value;
var lname = document.registerationForm.Last_Name.value;
var email=document.registerationForm.Email_ID.value;
var mobile=document.registerationForm.Mobile_Num.value;
var address=document.registerationForm.Address.value;
var city=document.registerationForm.city.value;
  
if (name==null || name==""){  
	alert("Name can't be blank");  
	return false;
}
else if(pwd.length<6){  
	alert("Password must be at least 6 characters long.");  
	return false;  
}  
else if(conpwd.length<6){  
	alert("Conform password must be at least 6 characters long.");  
	return false;  
}  

else if (fname == null || fname == ""){  
  	alert("First can't be blank");  
  	return false;
}
else if (mname == null || mname == ""){  
	alert("Middle name can't be blank");  
	return false;    
}
else if (lname == null || lname == ""){  
	alert("Last Name can't be blank");  
	return false;  
}
else if (email==null || email==""){  
	alert("Email can't be blank");  
	return false;    
}
else if (mobile == null || mobile == ""){  
	alert("Mobile can't be blank");  
	return false;  
}
else if (address==null || address==""){  
	alert("Address can't be blank");  
	return false;    
}
else if (city == null || city == ""){  
	alert("City can't be blank");  
	return false;  
}
}  
</script>  
<body>
<center><h1>Xphase : Modifying page</h1></center>
<center>
<form action="UserNameModifying.action" method="post" name="registerationForm" onsubmit="return validateform()"><br>
<s:textfield name="UserName" label="User Name"/><br>
<s:password name="UserPwd" label="User Password"/><br>
<s:password name="UserConPwd" label="User Conform Password"/><br>
<s:textfield name="First_Name" label="First Name"/><br>
<s:textfield name="Middle_Name" label="Middle Name"/><br>
<s:textfield name="Last_Name" label="Last Name"/><br>
<s:textfield name="Email_ID" label="Email ID"/><br>
<s:textfield name="Mobile_Num" label="Mobile no"/><br>
<s:textfield name="Address" label="Address"/><br>
<s:textfield name="city" label="City"/>
<s:submit value="Register"/>
<s:a href="LoginShortCut.action">Click here login</s:a>
</form>
</center>
</body>
</html>
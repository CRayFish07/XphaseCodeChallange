<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head><title>Success: Upload User Image</title></head>
	<body>
		<h2>Xphase technology File Upload Example</h2>
		User Image:	<s:property value="userImage" /><br/>
    	Content Type:<s:property value="userImageContentType" /><br/>
		File Name:<s:property value="userImageFileName" /><br/>
		<img src="images/<s:property value="userImageFileName"/>" height="400" width="600" />
	</body>
</html>
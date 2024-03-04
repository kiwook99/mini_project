<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>test_tempPwEmail</h3>
<hr>
<%	
	Object obj = request.getAttribute("msg");
	if (obj == null) return;
	
	String msg = obj.toString();	
	System.out.println("msg >>> : " + msg);
%>
<script>
	let m = '<%= msg %>';
	alert(m)
	

	location.href = "loginForm.b";

</script>
</body>
</html>
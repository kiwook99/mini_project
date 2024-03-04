<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID PW CHECK</title>
<!-- jQuery CDN 불러오기  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
				
		// 이메일 버튼
		$("#emailBtn").click(function(){
			alert("emailBtn 함수 진입 >>> : ");
						
			$('#memForm').attr({			
				"action":"/miniProject/test_tempPwEmail.b",	
				"method":"GET",			
				"enctype":"application/x-www-form-urlencoded" 
		
			}).submit();
		});		
	});

</script>
</head>
<body>
<h3>ID PW CHECK</h3>
<hr>
<form name="memForm" id="memForm">
<table border="1">
	
<tr>
<td>이메일</td>
<td>	
	<input type="text" name="mbaddr" id="mbaddr" placeholder="이메일" style="width:200px" /><br>	
</td>
</tr>
<tr>
<td colspan="2">		
	<input type="button" id="emailBtn" value="이메일_버튼" />		
</td>
</tr>
</table>
</form>
</body>
</html>
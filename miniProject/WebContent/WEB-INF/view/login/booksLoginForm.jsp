<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
	
	div.div2{
		background: white;
		border: 10px solid gray;
		border-style: groove;
		border-radius: 8px;
		padding: 5px;
		width: 300px;
		height: 300px;
		margin: auto;
	}
		
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#kid").attr('placeholder', '아이디 ');
		$("#kpw").attr('placeholder', '비밀번호 ');
		
		$("#btn").click(function(){
			console.log("btn >>> : ");
			
			$('#loginForm').attr({
				'action':"login.b",
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
		
			
			$("#bbtn").click(function(){
				console.log("bbtn >>> : ");
				
				$('#loginForm').attr({
					'action':"booksMemInsertForm.b",
					'method':'GET',
					'enctype':'application/x-www-form-urlencoded'
				}).submit();
			});
	});
	
</script>
</head>
<body>

<div class="div1">
<h1 align="center">
	<a href="">
		<img src="/miniProject/img/k.jpg" width="100" height="100"></a>
</h1>
</div>

<div class="div2">
<form name="loginForm" id="loginForm" align="center">
<tr>
<td><input type="text" name="mbid" id="mbid" size="20" placeholder="아이디" style="font-size:larger;"></td>
</tr>
<tr>
<td><input type="password" name="mbpw" id="mbpw" size="20" placeholder="비밀번호" style="font-size:larger;"></td>
</tr>
<tr>
<td>
<button type="button" id="btn" style="width:200px; background-color : gray;">로그인</button><br>
</td>
</tr>
<tr>
<td align="center">
<a href="idFindForm.b"><font size="2">아이디찾기</font></a> | 
<a href="pwFindForm.b"><font size="2">비밀번호찾기</font></a><br><br><br>
<button type="button" id="bbtn" style="width:200px; background-color : gray;">회원가입</button>
</td>
</tr>
</form>
</div>
</body>
</html>
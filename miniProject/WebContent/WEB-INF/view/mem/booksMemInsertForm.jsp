<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viweport" content="width=device-width, iitail-scale=1">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 아이디 중복체크 Ajax 비동기 방식
		$(document).on("click", "#mbidbtn", function(){
			
			let idCheckURL = "booksIdCheck.b";
			let reqType = "POST";
			let dataParam = { mbid: $("#mbid").val(), };
			
			$.ajax({
				url: idCheckURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){
				
				if("ID_YES" == resData){
					alert("사용 가능한 아이디입니다.");
					
					$("#mbid").css('background-color', 'dimgrey');
					$("#mbid").attr("readonly", true);
					$("#mbpw").focus();	
				}else if ("ID_NO" == resData){
					alert("이미 아이디 사용중입니다.");
					$("#mbid").val('');
					$("#mbid").focus();
				};				
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});
		
		// 비밀번호 체크
		$("#pwCheck").click(function(){
			console.log("pwCheck 함수 진입");
			
			var mbpw = $("#mbpw").val();
			var mbpw_r = $("#mbpw_r").val();	
			if(mbpw == mbpw_r) {
				alert("비밀번호가 같습니다.");
				$("#mbpw_r").val();				
				$("#mbtel").focus();						
				return true;
			} else {
				alert("비밀번호가 다릅니다.");
				$("#mbpw").val('');
				$("#mbpw_r").val('');			
				$("#mbpw").focus();							
				return false;
			}
		});	
		
		$(document).on("click", "#loadBtn", function(){
			
			if(!$("#mbname").val()){
				alert("이름을 입력하세요.");
				return;
			} else if(!$("#mbtel").val()){
				alert("번호을 입력하세요.");
				return;
			} else if(!$("#mbaddr").val()){
				alert("메일을 입력하세요.");
				return;
			} else if(!$("#mbid").val()){
				alert("아이디를 입력하세요.");
				return;
			} else if(!$("#mbpw").val()){
				alert("비밀번호를 입력하세요.");
				return;
			}  
			
			
			alert("회원가입 합니다.");
			console.log("loadBtn >>>");
			
			$("#booksMemInsert").attr({
				'action' : 'booksMemInsert.b',
				'method' : 'GET',
				'enctype' : 'application/x-www-form-urlencoded'
			}).submit();
		});
	});
</script>

<style type ="text/css">
	div.mdd{
		background: white;
		border: 5px solid gray;
		border-style: groove;
		border-radius: 8px;
		padding: 3px;
		width: 70px;
		height: 20px;
		margin: 10px auto;
	}
	
	div.mddd{
		background: white;
		border: 10px solid gray;
		border-style: groove;
		border-radius: 8px;
		padding: 5px;
		width: 300px;
		height: 250px;
		margin: auto;
	}
		

</style>

</head>
<body class="body">

<header id="topbar">
<div class="md" align="center">
<a href="loginForm.b">
	<img src="/miniProject/img/k.jpg" width="70" heigh="30" alt="image">
</a>
</div>
</header>

<div class="mdd">

<table class="mt">
	<tr>
		<td colspan="2">회원가입</td>
	</tr>
</table>

</div>
<form name="booksMemInsert" id="booksMemInsert">
<div class="mddd">
<table class="mtt">
	<tr>
		<td><input type="hidden" name="mbnum" id="mbnum" /></td>
	</tr>
	<tr>
		<td><input type="text" name="mbname" id="mbname" size="20" placeholder="이름"/></td>
	</tr>
	<tr>
		<td><input type="text" name="mbid" id="mbid" size="20" placeholder="아이디"/>
			<input type="button" name="mbidbtn" id="mbidbtn" value="중복체크"/></td>
	</tr>
	<tr>
		<td><input type="password" name="mbpw" id="mbpw" size="20" placeholder="비밀번호"/></td>
	</tr>
	<tr>
		<td><input type="password" name="mbpw_r" id="mbpw_r" size="20" placeholder="비밀번호확인"/>
			<input type="button" id="pwCheck" value="비밀번호확인"></td>
	</tr>
		<tr>
		<td><input type="text" name="mbtel" id="mbtel" size="20" placeholder="휴대폰번호"/></td>
	</tr>
	<tr>
		<td><input type="text" name="mbaddr" id="mbaddr" size="20" placeholder="이메일"/></td>
	</tr>
	<tr>
		<td style= "text-align: -webkit-center;" ><br>
			<input type="image" name="loadBtn" id="loadBtn" src="/miniProject/img/member.png" width="90px" >
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>
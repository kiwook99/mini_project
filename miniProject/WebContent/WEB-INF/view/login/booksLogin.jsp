<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="a.b.c.com.books.mem.vo.BooksMemVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
	div,h3  {
		 text-align: center;
	}
			
	/* a 태그 밑줄 없애기 */
	a { text-decoration:none }
	
	div {text-align: center;}

</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<h3>메인화면으로 돌아가기</h3>
<hr>
<div>
<a href="booksProductSelectAll.b">
	<img src="/miniProject/img/k.jpg" width="70" heigh="30" alt="image">
</a>
</div>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listLogin");
	if (obj == null) return;
	List<BooksMemVO> list = (List<BooksMemVO>)obj;
	int nCnt = list.size();

	Object remoteInfoObj = request.getAttribute("remoteInfo");
	List<String> riObj = (List<String>)remoteInfoObj;
	
	if (nCnt == 1){
		String mbid = list.get(0).getMbid();
		
		String remoteIp = riObj.get(0);
		String remoteBrowser = riObj.get(1);
%>
		<script>
			alert("<%= mbid %> 님 로그인 성공 \n"
					+ "접속 아이피 : <%= remoteIp %> \n"
					+ "접속 브라우저 : <%= remoteBrowser %>");
			
		</script>
<% 		
	}
%>
		<script>
		location.href = "booksProductSelectAll.b";
			
		</script>
</body>
</html>
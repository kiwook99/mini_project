<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>   
    
<%@ page import="a.b.c.com.books.mem.vo.BooksMemVO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	h3 {
		text-align:center;
	}
	
	div {
		text-align:center;
	}
	

</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("booksSelect.jsp >>> : ");
%>
<!-- 
			<div>
			<a href="loginForm.b">
			<img src="./img/k.jpg" width="50px" height="50px" title="초기화면">
			</a>
			</div>
 -->
<hr>
<h3>아이디 찾기 성공</h3>
<hr>

<form name="booksList" id="booksList">
<table border="1" align="center">
<thead>
<tr>	
	<th><input type="checkbox" name="chkAll" id="chkAll"></th>	

	<th>아이디</th>

</tr>
</thead>
<%

	Object obj = request.getAttribute("fileloadList");
	if (obj == null){ return; }
	
	List<BooksMemVO> list = (List<BooksMemVO>)obj;
	if (list.size() > 0){
		for (int i=0; i < list.size(); i++){
			BooksMemVO bmvo = list.get(i);
			
%>
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="mbnum" name="mbnum" class="mbnum" value=<%= bmvo.getMbnum() %> >
	</td>		

	<td class="tt"><%= bmvo.getMbid() %></td>
						
</tr>	
<%
		} // end of for
	
	}//end of if
%>	
</tbody>	
</table>
</form>

<br>
<div>
<a href="loginForm.b">로그인 창으로 돌아가기</a>	
</div>
</body>
</html>
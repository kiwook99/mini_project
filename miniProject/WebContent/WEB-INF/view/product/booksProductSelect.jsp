<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.books.product.vo.BooksProductVO" %> 
<%@ page import="a.b.c.com.books.rboard.vo.BooksRboardVO" %> 
<%@ page import="java.util.List" %>  

<%@ page import="a.b.c.com.books.util.NumUtil" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("booksProductSelectAll.jsp 페이지 >>> : ");
	
	Object obj = request.getAttribute("listAll");
	List<BooksProductVO> list = (List)obj;
	
	String pbprice ="";
	BooksProductVO bpvo = null;
	if (list.size()==1) {
		bpvo = list.get(0);
		pbprice = bpvo.getPbprice();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	$(document).ready(function(){

	let pbprice = '<%= pbprice %>';
	console.log(pbprice);
	
	$(document).on('change', '#pbcnt', function(){
		alert('pbcnt >>> : ')
		let cntS = $('#pbcnt').val();
		alert("cntS >>> : " + cntS);			
		let pbpriceSum = pbprice * cntS;			
		$('#pbpricesum').val(pbpriceSum);
	});
	
	$(document).on('click', '#buyBtn', function(){
		alert('buyBtn >>> : ');
		
		let pbcntV = $('#pbcnt').val();
		alert("pbcntV >>> : " + pbcntV);
		let priceSum = $('#pbpricesum').val();
		alert("priceSum >>> : " + priceSum);
		
		if (pbcntV == 0 && priceSum == 0){
			alert("상품을 수량을 선택하시오 !!!");
			return;
		}
		
		$('#productList').attr({
			"action":"booksOrderInsertForm.b", 
			"method":"GET"}).submit();
	});
	
	$(document).on('click', '#cartBtn', function(){
		alert('cartBtn >>> : ');
		
		let pbcntV = $('#pbcnt').val();
		alert("pbcntV >>> : " + pbcntV);
		let priceSum = $('#pbpricesum').val();
		alert("priceSum >>> : " + priceSum);
		
		if (pbcntV == 0 && priceSum == 0){
			alert("상품을 수량을 선택하시오 !!!");
			return;
		}
		
		$('#productList').attr({
			"action":"booksCartInsert.b", 
			"method":"GET"}).submit();
	});
});
</script>

<style type="text/css">


	th {
		text-align: center;
	}
	
	table {
		margin: 20px auto;
		width: 750px;
		border: 1px solid #bcbcbc
	}
	
	input {
	outline: none;
	
	}
	
	.btn_1 {
		width: 150px;
		height: 40px;
		display: inline-block;
	}
	
	#board {
		word-break: keep-all;
		width: 750px;
		border: none;
		font-size: larger;
	}
	
	textarea{
	height: 200px;
	width: 750px;
	resize: none;
	}
</style>

</head>
<body>
	<h3 align="center">
		<a href="booksProductSelectAll.b">
			<img src="/miniProject/img/k.jpg" width="70" heigh="30" alt="image">
		</a>
	</h3><hr>
	<div>
<form name="productList" id="productList">
<table>
<tr>
<td rowspan="7" align="center" vertical-align="middle" style="width:300px;">
<img src="/miniProject/fileupload/product/<%= bpvo.getPbfile() %>" width="250" height="250">
</td>
<td align="center" colspan="4" >
<input 	type="text" name="pbname" id="pbname" size="45" value="<%= bpvo.getPbname() %>" 
		style="text-align:center; border: none; font-size: larger; "  readonly />	
<hr>
</td>
</tr>
<tr>
<td align="center" colspan="2">
<input type="text" name="pbcompany" id="pbcompany" value="저자 : <%= bpvo.getPbcompany() %> , "
		style="text-align:right; border: none; backgroud: bransparent;" readonly />
<input type="text" name="updatedate" id="updatedate" value="출판일 : <%= bpvo.getUpdatedate() %>"
		style="text-align:letf; border: none; backgroud: bransparent;" readonly />
<hr>
</td>
</tr>
<tr>
<td>
<input 	type="text" name="pbprice" id="pbprice" size="2" maxlength="30" style="ime-mode:disabled;" value="<%= pbprice %>" readonly />&nbsp;원
</td>
</tr>
<tr>
<td><label align="left">수량 :</label>
	<select name="pbcnt" id="pbcnt">
		<option value="0" selected>0</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select>
</td>
</tr>
<tr>
<td><label align="left">총 금액 :</label>
<input 	type="text" name="pbpricesum" id="pbpricesum" size="2" maxlength="30" value="0" style="ime-mode:disabled;"  readonly />&nbsp;원
</td>
</tr>
<tr>
<td align="left" colspan="2">

<input type="hidden" name="pbfile" id="pbfile" value="<%= bpvo.getPbfile() %>" >
<input type="hidden" name="pbid" id="pbid" value=" <%= bpvo.getPbname() %>" >
<input type="hidden" name="pbnum" id="pbnum" value="<%= bpvo.getPbnum()%>" >
<input type="hidden" name="kmnum" id="kmnum" value="<%= 1234 %>" >

<div class="div_btn">
	<input type="button" id="buyBtn" value="바로구매" class="btn_1" />
	<input type="button" id="cartBtn" value="장바구니" class="btn_1" />
</div>
</td>
</tr>
</table>

</form>
</div>
<div>
<form>
<table id="board">
<tr>
	<td><label>책 소개</label><br>
	<textarea id="textarea" spellcheck="false" readonly><%=bpvo.getPbdesc()%></textarea>
</td>
</tr>

</table>
</form>
</div>
</body>
</html>
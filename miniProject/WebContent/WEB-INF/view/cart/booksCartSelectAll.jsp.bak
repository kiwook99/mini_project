<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.books.cart.vo.BooksCartVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page import="a.b.c.com.books.util.NumUtil" %>

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("booksCartSelectAll.jsp 페이지 >>> : ");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/miniProject/js/common.js"></script>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$(document).on('click','#chek',function(){
		if($(this).prop('checked')){
			$('.Cbnum').prop('checked',true);
		}else{
			$('.Cbnum').prop('checked',false);
		}
	});
	// 삭제
	$(document).on('click','.delBtn',function(){
		alert("delBtn >>> : ");
		let CbnumV = $(this).val();
		alert("CbnumV >>> : " + CbnumV);
		
		location.href="booksCartDelete.b?CbnumV="+CbnumV;
	});
	
	// 선택 삭제
	$(document).on('click','#delsBtn',function(){
		alert("선택 삭제 >>> : ");
		cart_delete();	
	});
	

	
	function cart_delete(){
		
		if ($('.Cbnum:checked').length == 0){
			alert("삭제할 상품을 선택 하세요.");
			return;
		}
		
		var Cbnum = [];
		$("input:checkbox[name='Cbnum']:checked").each(function(){
			Cbnum.push($(this).val());		// 체크 된 것만 뽑아서 배열에 
			console.log(Cbnum);
		});
		
		$('#productList').attr({"action":"booksCartDeleteArray.b", "method":"GET"}).submit();
	}
	
	// 쇼핑하기
	$(document).on('click','#shopingBtn',function(){
		alert("shopingBtn >>> : ");
		location.href="booksProductSelectAll.b";
	});
	
	// 주문하기
	$(document).on('click','#buyBtn',function(){
		alert("준비중 입니다.");
	});
	});
		
</script>
<style type="text/css">
	
	table, th, td {
		border: 1px solid #bcbcbc;
		text-align: center;
	}	
	
	th {
		text-align: center;
	}
	
	table {
		margin: 20px auto;
		width: 900px;
	}
</style>
</head>
<body>
	<h3 align="center">
		<a href="booksProductSelectAll.b">
			<img src="/miniProject/img/k.jpg" width="70" height="70" alt="image">
		</a>
	</h3>
<hr>
<form name="productList" id="productList">
	<table>
		<thead>
		<tr>
			<td colspan=5 align="center"> 
			<font size="4" style="color:blue;">장바구니</font>
			<img src="/miniProject/img/img_mandu/ase.gif" width="25" height="25" alt="image">
			 </td>
		</tr>
		<tr>
			<td align="center">
				<input type="checkbox" name="chek" id="chek" class="chek">
			</td>
			<td align="center">상품명</td>
			<td align="center">주문상품 금액</td>
			<td align="center">주문상품 수량</td>

			<td align="center">총 금액 합계</td>
		</tr>
		</thead>
<tbody>
<%
String pbnum = "";
String pbprice = "";
String pbpricesum = "";
int sum = 0;
String sumV = "";

Object obj = request.getAttribute("cartListAll");
if (obj == null){	
%>
<tr>
<td colspan="8" align="center">
	<h2>장바구니에 상품을 담으세요</h2> 
</td>
</tr>
<%	
}else{
	List<BooksCartVO> list = (List<BooksCartVO>)obj;
	int nCnt = list.size();

	logger.info("list.size() >>> : " + list.size());	
	
	for(int i=0; i < nCnt; i++){		
		BooksCartVO _bcvo = list.get(i);
		pbprice = NumUtil.comma(_bcvo.getPbprice());
		pbpricesum = NumUtil.comma(_bcvo.getPbpricesum());
		sum += Integer.parseInt(_bcvo.getPbpricesum());
%>
<tr>
	<td align="center">
		<input type="checkbox" name="Cbnum" id="Cbnum" class="Cbnum" value=<%= _bcvo.getCbnum() %> >
	</td>		
	<td class="tt">
		<img src="/miniProject/fileupload/product/<%= _bcvo.getPbfile() %>" width="50" height="50">
		<%= _bcvo.getPbname() %> 
	</td>
	<td class="tt"><%= pbprice %> </td>
	<td class="tt"><%= _bcvo.getPbcnt() %> </td>
	<td class="tt"><%= pbpricesum %> </td>
<!-- 
	<td class="tt" align="center">		
		
		<button type="button" class="delBtn" name="delBtn" id="delBtn" value=<%= _bcvo.getCbnum() %> >삭제</button><br>
 -->
	</td>	
</tr>	
<%
	} // end of for
} // end of else	
	
%>	
<tr>
<td colspan="8" style="text-align: right">총 구매 금액  <%= NumUtil.comma(String.valueOf(sum)) %>원</td>
</tr>
<tr>
<td colspan="8" style="text-align: right">
	결제 예정금액 <font size="5" style="color:red;"> <%= NumUtil.comma(String.valueOf(sum)) %></font>원
</td>
</tr>
<tr>
	<td colspan="8" align="left">		
		<input type="button" value="선택삭제" id='delsBtn'>	
		
		 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<input type="button" value="쇼핑하기" id='shopingBtn'>							
		<input type="button" value="주문하기" id='buyBtn'>							
	</td>
</tr>					
</tbody>			
	</table>
</form>
</body>

</html>
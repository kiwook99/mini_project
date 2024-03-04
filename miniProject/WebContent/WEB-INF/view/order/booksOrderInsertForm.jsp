<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.books.util.NumUtil" %>    
  
<% request.setCharacterEncoding("UTF-8"); %>    
<%
	String pbfile = request.getParameter("pbfile");
	String pbid = request.getParameter("pbid");
	String pbname = request.getParameter("pbname");
	String pbcnt = request.getParameter("pbcnt");
	String pbprice = request.getParameter("pbprice");
	String pbpricesum = request.getParameter("pbpricesum");
	pbpricesum = NumUtil.comma_replace(pbpricesum);
	String pbnum = request.getParameter("pbnum");
	String kmnum = request.getParameter("kmnum");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Iamport 결제 api   -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 다음 우편번호 주소 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/kosmoSprng/js/common.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		var pbname = '<%= pbname %>';
		var pbpricesum = '<%= pbpricesum %>';		
		alert(pbname + " : " + pbpricesum);
		
		// 이메일 
		$('#boemail2').change(function(){	
			$("#boemail2 option:selected").each(function () {
				if($(this).val()== '1'){ //직접입력일 경우 
						var aa = $("#boemail1").val();						
						$("#boemail1").val(''); //값 초기화 
						$("#boemail1").attr("readonly",false); //활성화 				
				}else{ //직접입력이 아닐경우 
						$("#boemail1").val($(this).text()); //선택값 입력 
						$("#boemail1").attr("readonly",true); //비활성화 
				}
			}); 
		}); 	
		
		// 우편번호	
		$("#zoneBtn").click(function(){
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#bozone").val(data.zonecode); //5자리 새우편번호 사용
				    $("#boroad").val(data.roadAddress); //도로명 주소
				    $("#bojibun").val(data.jibunAddress); //지번주소			
				}
			}).open();
		});
		
		
		$(document).on('click', '#orderBtn', function(){			
			$("#orderForm").attr({"action":"booksProductSelectAll.b","method":"GET"}).submit();	
		});
		
		$(document).on('click', '#cardBtn', function(){			
			
			//가맹점 식별코드
			IMP.init('imp23814146');
			IMP.request_pay({
			    pg : 'TC0ONETIME',
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : pbname , //결제창에서 보여질 이름
			    amount : pbpricesum , //실제 결제되는 가격
			    buyer_email : '',
			    buyer_name : '홍길동',
			    buyer_tel : '010-1234-5678',
			    buyer_addr : '서울 양찬구 목동',
			    buyer_postcode : '123-456'
			}, function(rsp) {
				console.log(rsp);
			    if ( rsp.success ) {
			    	var msg = '결제가 완료되었습니다.';
			        msg += '고유ID : ' + rsp.imp_uid;
			        msg += '상점 거래ID : ' + rsp.merchant_uid;
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '카드 승인번호 : ' + rsp.apply_num;
			    } else {
			    	 var msg = '결제에 실패하였습니다.';
			         msg += '에러내용 : ' + rsp.error_msg;
			    }
			    alert(msg);
			});			
		});
	});
</script>

<style type="text/css">

	table, th, td {
	    border: 1px solid #bcbcbc;	    
	}

	th {
		text-align: center;
	}
	
	table {
		margin: 20px auto;
		width: 900px;
	}
	

</style>
<style type="text/css">

	

</style>
</head>
<body>
	<h3 align="center">
		<a href="booksProductSelectAll.b">
			<img src="/miniProject/img/k.jpg" width="70" height="70" alt="image">
		</a>
	</h3>
	<hr>


<form name="orderForm" id="orderForm">
<table border="1" align="center">
<tr>
<td colspan="6" align="center">					
	<font size="4" style="color:blue;">상품 주문하기</font> 
	<img src="/miniProject/img/img_mandu/ase.gif" width="25" height="25" alt="image">
</td>
</tr>
<tr>
<td colspan="6" align="left"><font size="3" style="color:blue;">1. 주문확인</font></td>
</tr>
<tr>
<td class="mem">주문 상품명</td>
<td class="mem">수량</td>
<td class="mem">주문금액</td>
<td class="mem">배송비</td>
<td class="mem">적립금</td>
<td class="mem">주문금액합계</td>
</tr>
<tr>
<td class="mem">
<img src="/miniProject/fileupload/product/<%= pbfile %>" width="50" height="50">
<%= pbname %>
</td>
<td class="mem"><%= pbcnt %>개</td>
<td class="mem"><%= pbprice %>원</td>
<td class="mem">0원</td>
<td class="mem">1000원</td>
<td class="mem"><%= pbpricesum %>원</td>
<tr>
<td colspan="6" align="left"><font size="3" style="color:blue;">2. 배송지 정보</font></td>
</tr>
<tr>
	<td class="mem">배송방법</td>
	<td colspan="5">
		<input type="radio" name="bodelivery" id="bodelivery_01" value="01" checked/>일반택배
		<input type="radio" name="bodelivery" id="bodelivery_02" value="02"/>편의점택배
		<input type="radio" name="bodelivery" id="bodelivery_03" value="03"/>해외배송
	</td>
</tr>
<tr>
	<td class="mem">받은실 분</td>
	<td colspan="5"><input type="text" name="kmname" id="kmname"/></td>
</tr>
<tr>
	<td class="mem">핸드폰</td>
	<td colspan="5">
		<select name="bohp" id="bohp">
        	<option value="010">010</option>
        	<option value="011">011</option>
        	<option value="016">016</option>
        	<option value="017">017</option>		        	
         </select>
         - <input type="text" name="bohp1" id="bohp1" size="2" maxlength="4" />
         - <input type="text" name="bohp1" id="bohp1" size="2" maxlength="4" />
	</td>
</tr>
<tr>
	<td class="mem">이메일</td>
	<td  colspan="5">		
		<input type="text" name="boemail"  id="boemail" style="width:100px"/>
		@ <input type="text" name="boemail1" id="boemail1" style="width:100px" placeholder="직접입력" />
		<select name="boemail2" id="boemail2">
        	 <option value="1" selected>직접입력</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
 	<td class="mem">주소</td>
 	<td  colspan="5">
 		<input type="text" name="bozone" id="bozone" placeholder="우편번호" style="width:50px" maxlength="6" >
 		<input type="button" name="zoneBtn" id="zoneBtn" value="우편번호 찾기"><br>	 	
 		<input type="text" name="boroad" id="boroad" placeholder="도로명주소" style="width:250px"><br>	 	
 		<input type="text" name="boroad2" id="boroad2" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
 		<input type="text" name="bojibun" id="bojibun" placeholder="지번주소" style="width:250px">
 	</td>
</tr>	 
 <tr>
	<td  colspan="6" align="center"> 			
		<button type="button" id="cardBtn">결제</button>
		<button type="button" id="orderBtn">취소</button>
	</td>				
</tr>
</table>				 		        		     
</form>	

</body>
</html>
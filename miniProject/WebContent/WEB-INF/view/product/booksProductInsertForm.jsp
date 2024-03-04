<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$(document).on("click", "#pbbtn", function(){
			console.log("pbbtn >>> : ");
			// 파일 보내기
			$('#productForm').attr({
				'action' : 'booksProductInsert.b',
				'method' : 'POST',
				'enctype' : 'multipart/form-data'
			}).submit();
		});
	});

</script>
<style>
	div {text-align: center;}
</style>
</head>
<body>
<div class="md">
<a href="booksProductSelectAll.b">
	<img src="/miniProject/img/k.jpg" width="70" heigh="30" alt="image">
</a>
</div>
<hr>
<form name = "productForm" id="productForm">
	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center">상품등록</td>
		</tr>
		<tr>
			<td>상품번호</td>
			<td><input type="text" name="pbnum" id="pbnum" style="width:150px"></td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text" name="pbname" id="pbname" style="width:300px" ></td>
		</tr>
		<tr>
			<td>장르</td>
			<td><input type="text" name="pbgenre" id="pbgenre" style="width:300px" ></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="pbcompany" id="pbcompany" style="width:300px"></td>
		</tr>
		<tr>
			<td>상품이미지</td>
			<!-- 파일 보내기 -->
			<td><input type="file" name="pbfile" id="pbfile"></td>
		</tr>
		<tr>
			<td>상품수량</td>
			<td><input type="text" name="pbcnt" id="pbcnt" style="width:50px"></td>
		</tr>
		<tr>
			<td>상품가격</td>
			<td><input type="text" name="pbprice" id="pbprice" style="width:150px"></td>
		</tr>
		<tr>
			<td>출판일</td>
			<td><input type="text" name="updatedate" id="updatedate" style="width:150px"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea name="pbdesc" id="pbdesc" cols="50" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="button" value="상품등록" id="pbbtn">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
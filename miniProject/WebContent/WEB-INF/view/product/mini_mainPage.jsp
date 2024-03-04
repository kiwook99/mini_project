<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="a.b.c.com.books.product.vo.BooksProductVO" %> 
<%@ page import="java.util.List" %>  

<%@ page import="a.b.c.com.books.util.NumUtil" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("메인 페이지 >>> : ");

	
	Object obj = request.getAttribute("listAll");	
	
	
	List<BooksProductVO> list = (List<BooksProductVO>)obj;		
	int nCnt = list.size();
		
%>

<!DOCTYPE html>
<html>
	<head>
	<!-- 슬라이드 CDN -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
	
	<meta charset="UTF-8">
	<title>MAIN</title>
	
	<style>
	* {
	  box-sizing: border-box;
	}
	
	body {
	  margin : 0;
	  padding : 0;
	  font-family: Arial;
	  text-align: center;
	}
	
	/* Header/Blog Title */
	.header {
	  padding: 20px;
	  text-align: center;
	  background: white;
	}
	
	.header h1 {
	  font-size: 30px;
	}
	
	h2 {
		text-align: left;
	}		
	
	/* Create two unequal columns that floats next to each other */
	/* Left column */
	.leftcolumn {   
	  margin: 0 auto;
	  width: 80%;
	}
	
	/* Add a card effect for articles */
	.card {
	  background-color: white;
	  padding: 30px;
	  margin-top: 20px;
	}
	
	/* Fake image */
	.fakeimg {
	  background-color: #aaa;
	  width: 100%;
	  padding: 20px;
	}
	
	/* Clear floats after the columns */
	.row::after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
	/* Footer */
	.footer {
	  padding: 70px;
	  text-align: left;
	  background: #ddd;
	  margin-top: 30px;  
	}
	
	.footer_left {
	  float: left;
	  margin-left: 400px;
	  font-weight : bold;
	  font-size: 30px; 
	}
	
	.footer_right {
	  float: right;
	  margin-right: 400px;
	  font-size: 15px;
	}
	

	
	/* 로그아웃 */
	#login {
	 	float: right;
	 	
	 }
	
	
	/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
	/* 반응형 웹 디자인*/
	@media screen and (max-width: 800px) {
	  .leftcolumn {   
	    width: 100%;
	    padding: 0;
	  }
	}
	
	
	/*카테고리*/
	#topMenu { 
	 height: 50px; 
	 width: 100%; 
	 margin: 0 auto;
	 }
	 
	 #topMenu ul{
		 list-style-type: none;
		 margin: 0px;
		 padding: 0px; 
		 font-size : 20px;
	 }
	 
	 #topMenu ul li 
	 { 
	 list-style: none; 
	 display: inline-block;
	 line-height: 30px; 
	 vertical-align: middle; 
	 text-align: center;
	 position: relative;
	 }
	 
	 .submenuLink{
		 text-decoration:none;
		 display: block;
		 width: 150px;
		 font-size: 12px;
		 font-weight: bold;
		 font-family: "Trebuchet Ms", Dotum;
	 }
	 
	  #topMenu { 
	 color: white; 
	 background-color: #aaa; }
	
	 .submenuLink{
		 color: white;
		 background-color: #aaa;
		 border: solid 1px white;
		 margin-top: -1px;
	 }
	 
	 .sb{
		 position: absolute;
		 height: 0px;
		 overflow: hidden;
		 transition: height .2s;
	 }
	 
	 .topMenuLi:hover .sb{
		 height: 100px;
	 }
	 
	 .submenuLink:hover { 
	 color: black;
	 background-color: #aaa;
	 }
	 
	 
	/* 스와이프 */
	 .swiper-container {
		height:400px;
	}
	
	.swiper-slide {
		text-align:center;
		display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
		align-items:center; /* 위아래 기준 중앙정렬 */
		justify-content:center; /* 좌우 기준 중앙정렬 */
	}
	
	.swiper-slide img {
		max-width:100%; /* 이미지 최대너비를 제한, 슬라이드에 이미지가 여러개가 보여질때 필요 */
	}
	

	</style>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function(){
		      console.log("메인 페이지 접속");
		      
		      $("#search_btn").click(function(){
		         alert('검색합니다.');
		         
		         $("#miniSearchForm").attr({
		            "method":"GET",
		            "action":"booksSearch.b"
		         }).submit();
		      });

		   });
	</script>
	</head>
	<body>
	
	
		<div class="header">
			<!-- 이미지 아이콘 -->
			<a href="booksProductSelectAll.b">
			<img src="./img/k.jpg" width="50px" height="50px" title="초기화면">
			</a>
			<!-- 제목 -->
			<h1>기욱이네 책방</h1>
			<!-- 조건 검색 --> 	
			<form name="miniSearchForm" id="miniSearchForm"> 
			<select id="searchFilter" name="searchFilter" style="width:100px;font-size:15px;">
				<option value="key_01">도서명</option>
				<option value="key_02">출판사</option>
				<option value="key_03">장르</option>
			</select>
			<input type="text" id="keyword" name="keyword" placeholder="검색어 입력" 
			style="width:200px;height:30px;font-size:15px;">
			<input type="button" id="search_btn" name="search_btn" value="검색">
			

			<input type="button" name="logout" id="logoutBtn" value="로그아웃"  
			onclick="location.href='loginForm.b'" >

			 
			</form>
			<div class="product">
			<a href="booksProductInsertForm.b">코스모 상품 입력</a><br>
			</div>
		</div>
			
			
		<div class="topnav">
			<!--메뉴-->
			<nav id="topMenu" >
				 <ul>
					 <li class="topMenuLi">
					 <a class="menuLink" href="#content1">카테고리</a>
					 	 <ul class ="sb">
							  <li><a href="#mystery" class="submenuLink " >미스터리</a></li>
							  <li><a href="#fantasy" class="submenuLink " >판타지</a></li>
							  <li><a href="#romance" class="submenuLink " >로맨스</a></li>
					  	</ul>
							  </li>							  
					  <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>					  
					 <li class="topMenuLi">
					 <a class="menuLink" href="#content4">게시판</a>
					 	<ul class ="sb">
							 <li><a href="boardSelect.b" class="submenuLink" >FAQ</a></li> 
							 <li><a href="#" class="submenuLink" >문의게시판</a></li>
							 <li><a href="#" class="submenuLink" >후기게시판</a></li>
					 	</ul>
					 </li>
				 </ul> 
			 </nav>
		</div>

		<div class="row">
			<div class="leftcolumn">
				<div class="card">
					<h2>올해의 베스트셀러</h2>
					<div class="fakeimg"style="height:400px;">
						<!-- 클래스명은 변경하면 안 됨 -->
						<div class="swiper-container">
							<div class="swiper-wrapper">			
																	<%
					for(int i=0; i < nCnt; i++){		
						BooksProductVO _bpvo = list.get(i);		
					
					%>
					<div class="swiper-slide">
					<a href="booksProductSelect.b?pbnum=<%= _bpvo.getPbnum() %>">
					<img src="/miniProject/fileupload/product/<%= _bpvo.getPbfile() %>" width="200px">
					</a>
					</div>
					<%
					}//end of for
					%>		 
					</div>
					<!-- 네비게이션 -->
					<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
					<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
					
						</div>
					</div>
				</div>

						
				<div class="card">
					<a name= "mystery"></a>
					<h2>미스터리</h2>
						<div class="fakeimg"style="height:400px;">
						<!-- 클래스명은 변경하면 안 됨 -->
						<div class="swiper-container">
						<div class="swiper-wrapper">
						<%
						for(int i=0; i<4; i++){		
							BooksProductVO _bpvo = list.get(i);		
						
						%>
						<div class="swiper-slide">
						<a href="booksProductSelect.b?pbnum=<%= _bpvo.getPbnum() %>">
							<img src="/miniProject/fileupload/product/<%= _bpvo.getPbfile() %>" width="200px"></a>
						</div>
						<%
						}//end of for
						%>		
							</div>    
						</div>
					</div>
				</div>
			
			<div class="card">
				<a name= "fantasy"></a>
					<h2>판타지</h2>
					<div class="fakeimg"style="height:400px;">
						<!-- 클래스명은 변경하면 안 됨 -->
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<%
								for(int i=4; i<8; i++){		
									BooksProductVO _bpvo = list.get(i);		
								
								%>
								<div class="swiper-slide">
								<a href="booksProductSelect.b?pbnum=<%= _bpvo.getPbnum() %>">
									<img src="/miniProject/fileupload/product/<%= _bpvo.getPbfile() %>" width="200px">
								</a>
								</div>
								
								<%
								}//end of for
								%>	
						</div>    
					</div>
				</div>
			</div>				
								<div class="card">
								<a name= "romance"></a>
								 <h2>로맨스</h2>
								 <div class="fakeimg"style="height:400px;">
								<!-- 클래스명은 변경하면 안 됨 -->
								<div class="swiper-container">
								<div class="swiper-wrapper">
								<%
								for(int i=8; i<12; i++){		
									BooksProductVO _bpvo = list.get(i);		
								
								%>
								<div class="swiper-slide">
									<a href="booksProductSelect.b?pbnum=<%= _bpvo.getPbnum() %>">
									<img src="/miniProject/fileupload/product/<%= _bpvo.getPbfile() %>" width="200px">
									</a>
								</div>
								<%
								}//end of for
								%>	
						</div>    
					</div>
				</div>
			</div>				
								
		</div>
	</div>

		<div class="footer">

			<div class="footer_left">
				기욱이네 책방
				</div>
			<div class="footer_right">
				  회사소개 : 기욱이네 책방 한라원앤원점	<br>
				  대표 : 박기욱<br>
				 Tel : 010 - 1234 - 5678 | Email : parkki4483@naver.com<br> 
			</div>

		</div>
			
	
		<!-- top 아이콘 -->
		<div style="position:fixed; bottom: 20px; right:25px;">
			<a href="#"><img src="./img/topbutton.png" width="50" height="50" title="상단으로"></a>
		</div>
	
	
		<!-- 스와이프 스크립트 -->
		<script>
		
		new Swiper('.swiper-container', {
		
			slidesPerView : 4, // 동시에 보여줄 슬라이드 갯수
			spaceBetween : 30, // 슬라이드간 간격
			slidesPerGroup : 4, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
		
			// 그룹수가 맞지 않을 경우 빈칸으로 메우기
			// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
			loopFillGroupWithBlank : true,
		
			loop : false, // 무한 반복 여부
		
			pagination : { // 페이징
				el : '.swiper-pagination',
				clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
			},
			navigation : { // 네비게이션
				nextEl : '.swiper-button-next', // 다음 버튼 클래스명
				prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
			},
		});
		
		</script>
	</body>
</html>
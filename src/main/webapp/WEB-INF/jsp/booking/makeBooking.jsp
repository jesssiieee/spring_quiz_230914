<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예약하기 페이지</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<%-- AJAX를 사용하려면 jquery 원본이 필요하다. (slim으로 사용하면 에러) --%>
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		
		<%-- 내가 만든 외부 스타일시트 --%>
		<link rel="stylesheet" type="text/css" href="/css/booking/bookingstyle.css">
	</head>
	<body>
		
		<div id="wrap">
			
			<div class="">
				<div class="text-center" style="font-size: 50px;">통나무 팬션</div>
				
				<nav>
					<ul class="nav nav-fill">
						 <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
						 <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
						 <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약하기</a></li>
						 <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약목록</a></li>
					</ul>
				</nav>
				
				<section class="main">
					
					<div class="text-center">
						<div style="font-size: 30px;" class="font-weight-bold mt-4 mb-4">예약하기</div>
					</div>
					
					<div class="contents d-flex justify-content-center">
						
						<div class="sign-up-box">
					
							<div class="form-group">
								<label for="name">이름</label>
								<input type="text" id="name" name="name" class="form-control col-12">
							</div>
							<div class="form-group">
								<label for="yyyymmdd">생년월일</label>
								<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-4" placeholder="예) 19991212">
							</div>
							<div class="form-group">
								<label for="email">이메일</label>
								<input type="text" id="email" name="email" class="form-control col-4">
							</div>
							
						</div>
						
					</div>
				
				</section>
				
				<footer><div class="copyright ml-4">
					<small class="text-secondary"> 
						제주특별자치도 제주시 애월읍<br>
						사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
						Copyright 2025 tongnamu. All right reserved.
					</small>
				</footer>
				
			</div>
			
		</div>
			
	</body>
</html>
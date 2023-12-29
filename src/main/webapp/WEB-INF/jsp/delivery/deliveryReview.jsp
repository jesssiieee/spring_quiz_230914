<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>배달삼겹 - 리뷰</title>
		
		<!-- bootstrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		
		<!-- css -->
		<link rel="stylesheet" type="text/css" href="/css/delivery/style.css">
	</head>
	<body>
		<div id="wrap">
			<div class="contents">
			
				<header class="d-flex">
					<div class="mt-4 ml-4">
						<h1 style="color: white">배탈의 민족</h1>
					</div>
				</header>
				
				<nav>
					<div>
						<p>우리동네 가게</p>
					</div>
				</nav>
				
				<div class="main">
				
					<c:forEach items="${deliveryJoin }" var="drlist">
							<div class="line mt-3">
								<div class="ml-3 mt-3">
									<b>${drlist.userName }</b>
									
									<c:choose>
										<c:when test="${drlist.point eq 5.0 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 4.5 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_half.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 4.0 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 3.5 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_half.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 3.0 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 2.5 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_half.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 2.0 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
										<c:when test="${drlist.point eq 1.5 }">
											<img src="/img/star_fill.jpg" style="width:16px;" >
											<img src="/img/star_half.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
											<img src="/img/star_empty.jpg" style="width:16px;" >
										</c:when>
									</c:choose>
									<br>
									<small style="color: grey">2021년 4월 3일</small><br>
									<small> ${drlist.review }</small><br>
									<div class="menuStyle">
										<small>${drlist.menu }</small><br>
									</div>
								</div>
							</div>
					</c:forEach>
				
				</div>
				
				<hr>
				<footer class="d-flex">
					<div class="ml-3">
						<b>(주)우와한형제</b><br>
						<small>고객센터: 1500-1500</small>
					</div>
				</footer>
			</div>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>배탈의 민족</title>
		
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

		  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		  
		  <link rel="stylesheet" type="text/css" href="/css/lesson05/quiz06_style.css">
	</head>
	<body>
		<div id="wrap">
		
			<header class="bg-info d-flex align-items-center">
				<h1 class="text-white font-weight-bold ml-4">배탈의 민족</h1>
			</header>
			
			<section>
				<div class="display-4 my-3">배발삼겹 - 리뷰</div>
				
				<%-- 리뷰 영역 --%>
				<c:if test="${empty reviewList }">
					<div class="display-4 font-weight-bold">작성된 리뷰가 없습니다.</div>
				</c:if>
				
				<c:if test="${not empty reviewList }">
					<c:forEach items="${reviewList }" var="review">
					<div class="review mb-3">
						<div class="border border-info p-3">
							<span class="font-weight-bold">이정재</span>
							
							<%-- 별 표시 --%>
							<div class="star-area d-inline">
								<c:set var="point" value="${review.point }" />
								<c:forEach begin="1" end="5">
									<c:choose>
										<c:when test="${point > 0.5 }">
											<img src="/img/star_fill.jpg" width="20" alt="star" >
											<c:set var="point" value="${point - 1 }" /> 
										</c:when>
										<c:when test="${point == 0.5 }">
											<img src="/images/review/star_half.png" width="20">
											<c:set var="point" value="${point - 0.5}" />
										</c:when>
										<c:when test="${point == 0}">
											<img src="/images/review/star_empty.png" width="20">
										</c:when>
									</c:choose>
								</c:forEach>
							</div>
							
							<small class="text-secondary d-block my-2">2021년 4월 3일</small>
							<div class="my-2">${review.review}</div>
							<small class="menu-box rounded p-1">${review.menu}</small>
							
						</div>
					
					</div>
					</c:forEach>
				</c:if>
				
			</section>
			
			<footer>
				<hr>
				<h2>(주) 우와한형제</h2>
				<h4 class="text-secondary">고객센터: 1500-1500</h4>
			</footer>
			
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>날씨 정보</title>
		<link href="/css/weather_history/weatherStyle.css" rel="stylesheet" type="text/css" /> 
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="">
			<div class="main d-flex">
				<aside class="menu col-2">
      				<img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      				기상청
					<ul class="navbar-nav">
						<li class="nav-item">
         			 		<a class="nav-link active" href="#">날씨</a>
        				</li>
        				<li class="nav-item">
         			 		<a class="nav-link active" href="#">날씨입력</a>
        				</li>
        				<li class="nav-item">
         			 		<a class="nav-link active" href="#">테마날씨</a>
        				</li>
        				<li class="nav-item">
         			 		<a class="nav-link active" href="#">관측 기후</a>
        				</li>
					</ul>
				</aside>
				<div class="view col-10 container">
					<h3>과거 날씨</h3>
					<table class="table text-center">
						<thead>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${weatherList}" var="weather">
							<tr>
								<td>
									<fmt:parseDate value="${weather.getDate()}" var="Usedday" pattern="yyyy-MM-dd" />
									<fmt:formatDate value="${Usedday}" pattern="yyyy년 M월 d일"/>
								</td>
								<td>
									<c:choose>
										<c:when test="${weather.getWeather() eq '비'}">
											<img src="/img/rainy.jpg">
										</c:when>
										<c:when test="${weather.getWeather() eq '흐림'}">
											<img src="/img/cloudy.jpg">
										</c:when>
										<c:when test="${weather.getWeather() eq '구름조금'}">
											<img src="/img/partlyCloudy.jpg">
										</c:when>
										<c:when test="${weather.getWeather() eq '맑음'}">
											<img src="/img/sunny.jpg">
										</c:when>
										<c:otherwise>
											${weather.getWeather()}
										</c:otherwise>
									</c:choose>
								</td>
								<td>${weather.getTemperatures()}</td>
								<td>${weather.getPrecipitation()}mm</td>
								<td>${weather.getMicroDust()}</td>
								<td>${weather.getWindSpeed()}km/h</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<footer class=""></footer>
		</div>
	</body>
</html>
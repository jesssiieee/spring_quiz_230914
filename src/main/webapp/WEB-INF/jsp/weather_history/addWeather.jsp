<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<aside class="menu col-3">
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
				<div class="view col-9 container">
					<h1>날씨 입력</h1>
					<form action="get" action="/weather-history/weather-list-view">
						<div class="form-group">
							<label for="date">날짜:</label>
							<input type="text" id="date" name="date" class="form-control col-4">
							날씨 : 
							<select name="weather" class="form-select" aria-label="Disabled select example"> 
								<option value="맑음" selected>맑음</option>
								<option value="흐림">흐림</option>
								<option value="비">비</option>
								<option value="구름조금">구름조금</option>
							</select> <br>
							<label for="microDust">미세먼지:</label>
							<input type="text" id="microDust" name="microDust" class="form-control col-4">
							<label for="temperatures">기온:</label>
							<input type="text" id="temperatures" name="temperatures" class="form-control col-4">
							<label for="precipitation">강수량:</label>
							<input type="text" id="precipitation" name="precipitation" class="form-control col-4">
							<label for="windSpeed">풍속:</label>
							<input type="text" id="windSpeed" name="windSpeed" class="form-control col-4">
						</div>
					</form>
				</div>
			</div>
			<footer class=""></footer>
		</div>
	</body>
</html>
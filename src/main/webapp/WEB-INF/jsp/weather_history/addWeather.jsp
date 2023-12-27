<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>날씨 정보</title>
		<!-- css  -->
		<link href="/css/weather_history/weatherStyle.css" rel="stylesheet" type="text/css" /> 
		<!-- bootstrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		<!-- jQuery -->
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<body>
		<div class="">
			<div class="main d-flex">
				<aside class="menu col-3">
				<img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      				<span class="active ml-2">기상청</span>
					<ul class="navbar-nav ml-4">
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
				<div class="view col-9 container mt-5 ml-3">
					<h1>날씨 입력</h1>
					<form action="get" action="/weather-history/weather-list-view">
						<div class="form-group">
						
						<div class="d-flex mt-5">
								<div class="d-flex">
									<label for="date" class="mr-2">날짜 </label>
									<script>
									      $(function(){
									         $('#datepicker').datepicker();
									      })
									</script>
									<input type="text" id="datepicker" name="date" class="form-control col-9">
								</div>
								
								<div>
									날씨 
									<select name="weather" class="form-select option-style" aria-label="Disabled select example">
									  	<option value="맑음" selected>맑음</option>
										<option value="흐림">흐림</option>
										<option value="비">비</option>
										<option value="구름조금">구름조금</option>
									</select>
								</div>
								
								<div class="ml-3">
									미세먼지
									<select name="microDust" class="form-select option-style" aria-label="Disabled select example">
									  	<option value="좋음" selected>좋음</option>
										<option value="보통">보통</option>
										<option value="나쁨">나쁨</option>
									</select>
								</div>
							</div>
							
							<div class="d-flex mt-5">
								<div class="input-group mb-3">
									<label for="temperatures">기온 </label>
								  	<input type="text" id="temperatures" name="temperatures" class="form-control col-6 ml-2">
								  	<span class="input-group-text" id="basic-addon1">℃</span>
								</div>
								
								<div class="input-group mb-3">
									<label for="precipitation">강수량 </label>
								  	<input type="text" id="precipitation" name="precipitation" class="form-control col-6 ml-2">
								  	<span class="input-group-text" id="basic-addon1">mm</span>
								</div>
								
								<div class="input-group mb-3">
									<label for="windSpeed">풍속 </label>
								  	<input type="text" id="windSpeed" name="temperatwindSpeedures" class="form-control col-6 ml-2">
								  	<span class="input-group-text" id="basic-addon1">km/h</span>
								</div>
							</div>
							
						</div>
						<div style="float: right;">
							<input type="submit" value="저장" class="btn btn-success">
						</div>
					</form>
				</div>
			</div>
			<footer class="f-style d-flex">
				<img src="/img/logo.jpg" alt="기상청 로고 이름" width="400px" height="150px"> 
				<div class="f-style mt-4 ml-2">
					(07062) 서울시 동작구 여의대방로16길 61 <br>
					Copyright@20XX KMA. All Rights ERSERVED.
				</div>
			</footer>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>즐겨 찾기 추가하기</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<%-- AJAX를 사용하려면 jquery 원본이 필요하다. (slim으로 사용하면 에러) --%>
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
	
		<div class="container">
			<h1>즐겨찾기 추가하기</h1>
			
			<div class="mt-3">
				<b><span>제목</span></b>
				<input type="text" id="name" class="form-control">
			</div>
			<div class="mt-3">
				<b><span>주소</span></b>
				<div class="d-flex">
					<input type="text" id="url" class="form-control">
					<input type="button" id="checkBtn" class="btn btn-primary" value="중복 체크" style="">
				</div>
				<small id="urlStatusArea"></small>
				
			</div>	
			<div class="mt-3">
				<input type="button" id="addbtn" class="btn btn-success" value="추가" style="width:930px;">
			</div>		
		</div>
		
	</body>
	
	<script>
		
		$(document).ready(function() {
			
			// '추가' 버튼 클릭
			$("#addbtn").on('click', function() {
				
				let id = $("#id").val();
				
				let name = $("#name").val();
				if (name == "") {
					alert("즐겨찾기 항목을 입력하세요.");
					return;
				}
				
				let url = $("#url").val();
				if(url == "") {
					alert("주소를 입력하세요.");
					return;
				}
				
				// http 또는 https 프로토콜까지 모두 입력되었는지 확인
				if (url.startsWith("http://") == false
						&& url.startsWith("https://") == false) {
					alert("주소 형식이 잘못 되었습니다.");
				}
				
				
				$.ajax ({
					type:"POST"
					, url:"/lesson06/add-ing-bookmark"
					, data:{"id":id, "name":name, "url":url}
				
					, success:function(data) { // data :  JSON String => parsing(jquery ajax 함수) => dictionary
						alert(data.code);
						/*
						if (data ==  "성공") {
							location.href = "/lesson06/after-add-bookmark";
						}
						*/
						
						if (data.code == 200) {
							// 목록 화면으로 이동
							location.href = "/lesson06/after-add-bookmark";
						}
						
						
					}
					, error:function(request, status, error) {
						alert("추가하는데 실패했습니다. 관리자에게 문의해주세요.")
						<%--
						alert(request);
						alert(status);
						alert(error);
						--%>
					} 
				});
			}); // click
			
			// 중복확인 버튼을 클릭했을 때
			$('#checkBtn').on('click', function() {
				
				// alert("중복확인"); ok
				
				// urlStatusArea 태그의 하위 태그 초기화 
				$('#urlStatusArea').empty();
				
				let url = $("#url").val().trim();
				
				// validation
				// url이 비어있는지 확인
				if (!url) {
					$('#urlStatusArea').append('<span>url이 입력되지 않았습니다.</span>');
					return;
				}
				
				// AJAX 통신
				$.ajax ({
					
					// request
					type:"GET"
					, url:"/lesson06/is-duplication-url"
					, data:{"url":url}
				
					// response
					, success:function(data) {
						// {"code":200, "is_duplication":true}
						if (data.is_duplication) {
							// 중복일 경우
							$('#urlStatusArea').append('<span class="text-danger">중복된 url입니다.</span>');
						} else {
							// 중복이 아닐 경우
							$('#urlStatusArea').append('<span class="text-success">저장 가능한 URL 입니다.</span>');
						}
					}
					
					, error:function(request, status, error) {
						alert("url 중복 체크에 실패했습니다.");
					}
					
				}); // ajax
				
			}); // checkBtn
			
		}); // ready
	
	</script>
	
</html>
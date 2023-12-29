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
				<input type="text" id="url" class="form-control">
			</div>	
			<div class="mt-3">
				<input type="button" id="addbtn" class="btn btn-success" value="추가" style="width:930px;">
			</div>		
		</div>
		
	</body>
	
	<script>
		
		$(document).ready(function() {
			
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
				
				$.ajax ({
					type:"POST"
					, url:"/lesson06/quiz01/add-ing-bookmark"
					, data:{"id":id, "name":name, "url":url}
				
					, success:function(data) {
						alert(data);
						if (data == "성공") {
							location.href = "/lesson06/quiz01/after-add-bookmark";
						}
					}
					, error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					} 
				});
			}); // click
		}); // ready
	
	</script>
	
</html>
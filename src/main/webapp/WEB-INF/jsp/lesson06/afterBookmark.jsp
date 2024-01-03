<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>즐겨찾기 목록</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<%-- AJAX를 사용하려면 jquery 원본이 필요하다. (slim으로 사용하면 에러) --%>
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container">
			<b><h1>즐겨찾기 목록</h1></b>
			
			<table class="table">
			
				<thead>
					<tr>
						<th>No.</th>
						<th>이름</th>
						<th>주소</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${bookmarklist }" var="blist">
						<tr>
							<td>${blist.getId() }</td>
							<td>${blist.name }</td>
							<td><a href = "${blist.url }" target="_blank">${blist.url }</a></td>
							<td><button class="btn btn-danger" id="deleteBtn">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
		
		</div>
		
		<script>
		
			$(document).ready(function () {
				
				// 삭제버튼 클릭
				$('#deleteBtn').on('click', function () {
					// alert("삭제버튼");
					
					let id = $("#id").val();
					
					$.ajax({
						
						type:"POST"
						, url:"/lesson06/delete-url"
						, data:{"id":id}
					
						, success:funciont(data) {
							if(data.delete_url) {
								
							}
						}
						
						
					}); // ajax
					
				}); // deleteBtn
				
			}); // ready
		
		</script>
		
	</body>
</html>
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
							<td>
								<!-- 1) value로 값 넣기 -->
								<!-- <button type="button" class="del-btn btn btn-danger" value="${blist.getId() }" >삭제</button>  -->
								
								<!--  2) data로 값 넣기 ★★★data는 대문자로 이름 설정 안됨!★★★-->
								<button type="button" class="del-btn btn btn-danger" data-bookmark-id=${blist.getId() } >삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
		
		</div>
		
		<script>
		
			$(document).ready(function () {
				
				// 삭제버튼 클릭
				$('.del-btn').on('click', function (e) {
					// 1) button value에 담은 값 가져오기
					// let id = $(this).val();
					// let id = $(this).attr("value");
					// let id = e.target.value;
					
					// 2) data를 이용해서 값 가져오기
					// 태그 영역: data-bookmark-id
					// 스크립트 영역: .data('bookmark-id')
					let id = $(this).data('bookmark-id');
					// alert(id);
					
					$.ajax({
						
						// request
						type:"DELETE"
						, url:"/lesson06/delete-url"
						, data:{"id":id}
						
						// response
						, success:function(data) {
							if(data.code == 200) {
								// 성공
								location.reload(); // 새로고침
								
								
							} else if(data.code == 500) {
								// 실패
								alert("error_message");
							}
						}
						, error:function(request, status, error) {
							alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
						}
						
					}); // ajax
					
				}); // deleteBtn
				
			}); // ready
		
		</script>
		
	</body>
</html>
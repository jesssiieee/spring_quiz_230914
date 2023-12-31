<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Quiz04 - JSTL fn 라이브러리</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container">
			<h1>회원 정보 리스트</h1>
			<table class="table text-center">
				<thead>
					<tr>
						<th>No</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>국적</th>
						<th>이메일</th>
						<th>자기소개</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${members }" var="member" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${member.getName() }</td>
						<td>
							<c:choose>
								<c:when test="${fn:split(member.getPhoneNumber(), '-')[0] ne '010' }">
									유효하지 않은 전화번호		
								</c:when>
								<c:otherwise>
									${member.getPhoneNumber() }
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							${fn:substring(member.getNationality(), 0, 2) } - 
							${ fn:split(member.getNationality(), " ")[1] }
						</td>
						<td>
							<b>${fn:split(member.getEmail(), '@')[0] }</b>@${fn:split(member.getEmail(), '@')[1] }
						</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(member.getIntroduce()) >= 15 }">
									<c:out value="${fn:substring(member.getIntroduce(), 0, 15) }" /> ...
								</c:when>
								<c:otherwise>
									${member.getIntroduce()}
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
	</body>
</html>
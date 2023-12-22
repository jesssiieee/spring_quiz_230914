<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL Core 라이브러리 (1)</title>
	</head>
	<body>
	
		<h1>1. JSTL core 변수</h1>
		<c:set var="number1" value="36" />
		<c:set var="number2" value="3"  />
		<c:out value="첫번째 숫자: ${number1}" /> <br>
		<c:out value="두번째 숫자: ${number2}" /> <br>
		
		<h1>2. JSTL core 연산</h1>
		<c:out value="더하기: ${number1 + number2}" /> <br>
		<c:out value="빼기: ${number1 - number2}" /> <br>
		<c:out value="곱하기: ${number1 * number2}" /> <br>
		<c:out value="나누기: ${number1 / number2}" /> <br>
		
		<h1>3. JSTL core out</h1>
		<c:out value="<title>core out</title>" />
		
		<h1>4. JSTL core if</h1>
		<c:set var="avg" value="${(number1 + number2) / 2 }" />
		<c:choose>
			<c:when test="${avg >= 10}" >
				<h1><c:out value="${avg}" /></h1>
			</c:when>
			<c:otherwise>
				<h3><c:out value="${avg}" /></h3>
			</c:otherwise>
		</c:choose>
		
		<h1>5. JSTL core if</h1>
		<c:set var="mul" value="${number1 * number2}" />
		<c:if test="${mul > 100}" >
			<%-- <c:out value="<script>alert('너무 큰 수입니다.')</script>" escapeXml="false" /> --%>
		</c:if>
		
	</body>
</html>
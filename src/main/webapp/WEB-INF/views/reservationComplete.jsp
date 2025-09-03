<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>예매 완료</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reservationComplete.css'/>">
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="container">
    <h2>🎉 예매가 완료되었습니다!</h2>
    <p>예매 내역은 아래와 같습니다.</p>

<c:forEach items="${reservationDto}" var="reservationDto">
    <table>
        <tr>
            <td><strong>예매번호</strong></td>
            <td>${reservationDto.reservationid}</td>
        </tr>
        <tr>
            <td><strong>회원 ID</strong></td>
            <td>${reservationDto.memberid}</td>
        </tr>
        <tr>
            <td><strong>영화 제목</strong></td>
            <c:forEach items="${reservationDto.movieDto}" var="movie">
    			<td>${movie.moviename}</td>
			</c:forEach>
        </tr>
        <tr>
            <td><strong>상영 시간</strong></td>
            <c:forEach items="${reservationDto.scheduleDto}" var="schedule">
   				<td>${schedule.startTime}</td>
			</c:forEach>
        </tr>
        <tr>
            <td><strong>좌석 번호</strong></td>
            <td>${reservationDto.seat_number}</td>
        </tr>
        <tr>
            <td><strong>가격</strong></td>
            <c:forEach items="${reservationDto.scheduleDto}" var="schedule">
   				<td>${schedule.price}원</td>
			</c:forEach>
        </tr>
        <tr>
        	<td>
        		<input type="button" class="btn" value="삭제" onclick="location.href='deletereservation?reservationid=${reservationDto.reservationid}'">
        	</td>
        </tr>
    </table>
</c:forEach>
    <a href="index" class="btn">홈으로 가기</a>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
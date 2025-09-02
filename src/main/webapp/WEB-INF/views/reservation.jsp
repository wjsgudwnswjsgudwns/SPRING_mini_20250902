<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>영화 예매</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/reservation.css' />">
</head>
<body>
    <h1>영화 예매</h1>
    
    <form action="reserveOk" method="post">
        <!-- 1. 영화 선택 -->
        <label for="movie">영화 선택:</label>
        <select id="movie" name="movieid" required>
            <c:forEach var="movie" items="${movieList}">
                <option value="${movie.movieid}">${movie.moviename}</option>
            </c:forEach>
        </select>
        <br><br>

        <!-- 2. 상영 일정 선택 -->
        <label for="schedule">상영 시간:</label>
        <select id="schedule" name="scheduleid" required>
            <c:forEach var="schedule" items="${scheduleList}">
                <option value="${schedule.scheduleid}">
                    ${schedule.start_time} ~ ${schedule.end_time} (상영관: ${schedule.theatername})
                </option>
            </c:forEach>
        </select>
        <br><br>

        <!-- 3. 좌석 선택 -->
        <label for="seat">좌석 선택:</label>
        <select id="seat" name="seat_number" required>
            <c:forEach var="seat" items="${seatList}">
                <option value="${seat.seat_number}">${seat.seat_number}</option>
            </c:forEach>
        </select>
        <br><br>

        <input type="submit" value="예매하기">
    </form>
</body>
<%@ include file="footer.jsp" %>
</html>

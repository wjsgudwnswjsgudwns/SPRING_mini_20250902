<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>영화 예매 시스템</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <div class="logo">
        <a href="index">🎬 MyCinema</a>
    </div>
    <nav>
        <ul>
            <li><a href="#">영화</a></li>
            <li><a href="reservation">예매</a></li>
            <li><a href="boardlist">게시판</a></li>
            <li><a href="#">오시는 길</a></li>
            <c:choose>
            	<c:when test="">
            		<li><a href="login">로그인</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="logout">로그아웃</a></li>
            	</c:otherwise>
            </c:choose>
            <c:if test="${empty sessionScope.sessionid }">
            	<li><a href="join">회원가입</a></li>
            </c:if>
        </ul>
    </nav>
</header>
<main>
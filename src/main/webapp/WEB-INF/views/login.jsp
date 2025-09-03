<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 - MyCinema</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="login-container">
    <div class="login-box">
        <div class="logo">
            <!-- 이미지 폴더에 로고 PNG 저장 후 경로 지정 -->
            <img src="${pageContext.request.contextPath}/resources/images/lotte-logo.png" alt="MyCinema 로고">
        </div>
        <form action="loginOk" method="post" class="login-form">
            <h2>로그인</h2>
            <div class="input-group">
                <label for="memberid">아이디</label>
                <input type="text" id="memberid" name="memberid" placeholder="아이디 입력">
            </div>
            <div class="input-group">
                <label for="memberpw">비밀번호</label>
                <input type="password" id="memberpw" name="memberpw" placeholder="비밀번호 입력">
            </div>
            <button type="submit">로그인</button>
            <div class="links">
                <a href="join">회원가입</a> | <a href="findpw">비밀번호 찾기</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</html>
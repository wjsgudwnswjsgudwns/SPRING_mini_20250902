<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 - MyCinema</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">
</head>
<body>
<div class="join-container">
    <div class="join-box">
        <h2>회원가입</h2>
        <form action="joinOk" method="post" class="join-form">
            <div class="input-group">
                <label for="memberid">아이디</label>
                <input type="text" id="memberid" name="memberid" placeholder="아이디 입력" required>
            </div>
            <div class="input-group">
                <label for="memberpw">비밀번호</label>
                <input type="password" id="memberpw" name="memberpw" placeholder="비밀번호 입력" required>
            </div>
            <div class="input-group">
                <label for="membername">이름</label>
                <input type="text" id="membername" name="membername" placeholder="이름 입력" required>
            </div>
            <div class="input-group">
                <label for="memberemail">이메일</label>
                <input type="email" id="memberemail" name="memberemail" placeholder="example@domain.com" required>
            </div>
            <div class="input-group">
                <label for="memberphone">전화번호</label>
                <input type="tel" id="memberphone" name="memberphone" placeholder="010-1234-5678" required>
            </div>
            <div class="input-group">
                <label for="memberage">나이</label>
                <input type="number" id="memberage" name="memberage" min="1" max="120" required>
            </div>
            <button type="submit">회원가입</button>
            <div class="links">
                <a href="login">이미 계정이 있으신가요? 로그인</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
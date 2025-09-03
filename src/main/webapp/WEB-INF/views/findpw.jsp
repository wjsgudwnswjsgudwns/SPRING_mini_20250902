<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/findpw.css'/>">
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="findpw-container">
    <h2>🔑 비밀번호 찾기</h2>
    <p>가입 시 등록한 정보를 입력하세요.</p>

    <form action="findpwOk" method="post">
        <div class="form-group">
            <label for="memberid">회원 ID</label>
            <input type="text" id="memberid" name="memberid" placeholder="회원 ID 입력" required>
        </div>

        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="memberemail" name="memberemail" placeholder="이메일 입력" required>
        </div>
        
        <div class="form-group">
            <label for="email">핸드폰</label>
            <input type="text" id="memberphone" name="memberphone" placeholder="01012345678" required>
        </div>

        <button type="submit" class="btn-submit">비밀번호 찾기</button>
    </form>

    <div class="links">
        <a href="login">로그인</a> | <a href="join">회원가입</a>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

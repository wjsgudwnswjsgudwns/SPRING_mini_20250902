<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호 변경</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/changepw.css'/>">
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="changepw-container">
    <h2>🔑 비밀번호 변경</h2>
    <p>새로운 비밀번호를 입력해주세요.</p>

    <form action="changepwOk" method="post">
        <div class="form-group">
            <label for="newpw">새 비밀번호</label>
            <input type="password" id="newpw" name="newpw" placeholder="새 비밀번호 입력" required>
        </div>

        <div class="form-group">
            <label for="confirmpw">비밀번호 확인</label>
            <input type="password" id="confirmpw" name="confirmpw" placeholder="비밀번호 확인" required>
        </div>

        <input type="hidden" name="memberid" value="${param.memberid}">

        <button type="submit" class="btn-submit">비밀번호 변경</button>
    </form>

    <div class="links">
        <a href="login">로그인</a> | <a href="index">홈으로</a>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

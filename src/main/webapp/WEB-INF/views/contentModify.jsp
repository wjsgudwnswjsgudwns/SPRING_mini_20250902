<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/contentModify.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <div class="board-container">
        <h2>글 수정</h2>
        <form action="contentModifyOk" method="post">
            <input type="hidden" name="bnum" value="${boardDto.bnum}">
            <div class="form-group">
                <label for="bName">작성자:</label>
                <input type="text" id="memberid" name="memberid" value="${boardDto.memberid}" readonly>
            </div>
            <div class="form-group">
                <label for="bTitle">제목:</label>
                <input type="text" id="btitle" name="btitle" value="${boardDto.btitle}">
            </div>
            <div class="form-group">
                <label for="bContent">내용:</label>
                <textarea id="bcontent" name="bcontent">${boardDto.bcontent}</textarea>
            </div>
            <div class="action-buttons">
                <button type="submit">수정 완료</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
    
    <%@ include file="footer.jsp" %>
</body>
</html>
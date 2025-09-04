<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/contentView.css">

</head>
<body>
<%@ include file="header.jsp" %>
    <div class="board-container">
        <h2></h2>
        <div class="post-info">
            <span>작성자: ${boardDto.btitle}</span>
            <span>작성일: ${boardDto.bdate}</span>
            <span>조회수: ${boardDto.bhit}</span>
        </div>
        <hr>
        <div class="post-content">
            <p>${boardDto.bcontent}</p>
        </div>
        <div class="action-buttons">
            <c:if test="${sessionid eq boardDto.memberid}">
            	<button onclick="location.href='contentModify?bnum=${boardDto.bnum}'">수정</button>
            	<input type="button" value="삭제" onclick="javascript:window.location.href='deleteContent?bnum=${boardDto.bnum}'">
            </c:if>
            <button onclick="location.href='boardlist'">목록으로</button>
        </div>
    </div>
    

    <div class="comments-container">
    <h3>댓글</h3>

    <!-- 기존 댓글 목록 -->
    <c:forEach var="comment" items="${commentList}">
        <div class="comment">
            <div class="comment-info">
                <span class="comment-author">${comment.memberid}</span>
                <span class="comment-date">${comment.cdate}</span>
                <c:if test="${sessionid eq comment.memberid}">
                    <button onclick="location.href='deleteComment?cnum=${comment.cnum}&bnum=${boardDto.bnum}'">삭제</button>
                </c:if>
            </div>
            <div class="comment-content">
                <p>${comment.ccontent}</p>
            </div>
        </div>
    </c:forEach>

    <!-- 댓글 작성 폼 -->
    <c:if test="${not empty sessionid}">
        <form action="addComment" method="post" class="comment-form">
            <input type="hidden" name="bnum" value="${boardDto.bnum}">
            <textarea name="ccontent" rows="3" placeholder="댓글을 입력하세요" required></textarea>
            <button type="submit">댓글 작성</button>
        </form>
    </c:if>
    <c:if test="${empty sessionid}">
        <p>댓글을 작성하려면 <a href="login">로그인</a>이 필요합니다.</p>
    </c:if>
	</div>

    
    
    <%@ include file="footer.jsp" %>
</body>

</html>
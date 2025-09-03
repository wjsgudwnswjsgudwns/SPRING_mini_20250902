<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/boardlist.css">
</head>
<body>
    <div class="container">
        <h1>게시판 목록</h1>
        <table class="board-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>글제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${boardDtos}" var="boardDto" varStatus="status">
					<tr>
						<td>${boardCount - ((pageNum - 1) * 10) - status.index}</td>
						<td>
							<a href="boardView?bnum=${boardDto.bnum}">${boardDto.btitle}</a>
						</td>
						<td>${boardDto.memberid}</td>
						<td>
							<fmt:formatDate value="${boardDto.bdate}" pattern="yyyy-MM-dd"/> 
						</td>
						<td>${boardDto.bhit}</td>
					</tr>
				</c:forEach>
            </tbody>
        </table>
        
        <div class="pagination">
    <c:if test="${pageNum>1}">
      <a href="boardlist?pageNum=1">&laquo;</a>
      <a href="boardlist?pageNum=${startPage-1}">&lsaquo;</a>
    </c:if>

      <c:forEach var="i" begin="${startPage}" end="${endPage}">
      	<c:choose>
	      	<c:when test="${i==pageNum}">
				<a href="#" class="active">${i}</a>
			</c:when>
			<c:otherwise>
				<a href="boardlist?pageNum=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
      </c:forEach>
      <c:if test="${pageNum < totalPage }">
      	<a href="boardlist?pageNum=${endPage+1}">&rsaquo;</a>
      	<a href="boardlist?pageNum=${totalPage}">&raquo;</a>
      </c:if>
    </div>
  </div>
        
</body>

<%@ include file="footer.jsp" %>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<main>
    <!-- Hero 영역 -->
    <section class="hero">
        <h2>Welcome to MyCinema</h2>
        <p>최신 영화와 예매 서비스를 제공합니다 🎥</p>
        <a href="reservation" class="btn">예매하기</a>
    </section>

    <!-- 상영중인 영화 -->
    <section class="movie-list">
        <h3>상영중인 영화</h3>
        <div class="grid">
            <div class="card">
                <img src="https://picsum.photos/200/300" alt="영화 포스터">
                <h4>영화 제목 1</h4>
                <button class="btn">예매</button>
            </div>
            <div class="card">
                <img src="https://picsum.photos/200/300" alt="영화 포스터">
                <h4>영화 제목 2</h4>
                <button class="btn">예매</button>
            </div>
            <div class="card">
                <img src="https://picsum.photos/200/300" alt="영화 포스터">
                <h4>영화 제목 3</h4>
                <button class="btn">예매</button>
            </div>
        </div>
    </section>
</main>

<%@ include file="footer.jsp" %>

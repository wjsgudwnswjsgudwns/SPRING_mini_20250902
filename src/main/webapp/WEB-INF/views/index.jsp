<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>

<section class="main-banner">
    <h1>Welcome to MyCinema</h1>
    <p>최신 영화와 예매 서비스를 제공합니다 🎥</p>
    <a href="#" class="btn">예매하기</a>
</section>

<section class="movies">
    <h2>상영중인 영화</h2>
    <div class="movie-list">
        <div class="movie-card">
            <img src="https://picsum.photos/200/300" alt="영화 포스터">
            <h3>영화 제목 1</h3>
            <button>예매</button>
        </div>
        <div class="movie-card">
            <img src="https://picsum.photos/200/300" alt="영화 포스터">
            <h3>영화 제목 2</h3>
            <button>예매</button>
        </div>
        <div class="movie-card">
            <img src="https://picsum.photos/200/300" alt="영화 포스터">
            <h3>영화 제목 3</h3>
            <button>예매</button>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

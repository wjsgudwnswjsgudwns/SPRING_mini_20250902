package com.jhj.cinema.dao;

import java.util.List;

import com.jhj.cinema.dto.BoardDto;

public interface BoardDao {

	public List<BoardDto> pageBoardListDao(int startRow,int endRow); // 게시판 글 목록 보기 -> 페이징 됨
	
	public void contentWriteDao(String btitle, String memberid, String bcontent); // 글 작성
	
	public int bhitDao(int bnum); // 조회수
	
	public BoardDto contentViewDao(int bnum); // 게시글 보기
	
	public void deleteContentDao(int bnum); // 글 삭제
	
	public void contentModifyDao(String btitle, String memberid, String bcontent, int bnum); // 글 수정
	
	public int allBoardCountDao();
}

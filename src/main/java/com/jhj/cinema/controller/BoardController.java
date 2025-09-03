package com.jhj.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.cinema.dao.BoardDao;
import com.jhj.cinema.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;

    @RequestMapping(value = "/boardlist")
    public String boardlist(HttpServletRequest request, Model model) {
    	int pageSize = 10; // 게시판 목록에 표시될 글 수
		int pageNum = 1; // 유저가 클릭한 페이지 번호 (초기값은 1페이지)
		int blocksize = 5; // 페이지 블럭에 표시될 페이지의 수
		
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // 유저가 선택한 페이지 번호
		} 
		int startRow = (pageNum*pageSize)-9; // 페이징 되었을때 시작 행의 번호
		int endRow = (pageNum * pageSize);
    	
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	List<BoardDto> boardDtos = boardDao.pageBoardListDao(startRow, endRow);

    	int totalCount = boardDao.allBoardCountDao();
		
		int startPage;
		int endPage;
		int totalPage; // 총 페이지 수
		
		startPage = (((pageNum-1)/blocksize)*blocksize)+1;
		endPage = startPage + blocksize -1; 
		totalPage = (int) (Math.ceil((double) totalCount / pageSize));
		
		if(totalPage < endPage) {
			endPage = totalPage;
		}
    	
    	model.addAttribute("boardDtos", boardDtos);
    	model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boardCount", totalCount);
		model.addAttribute("totalPage", totalPage);
    	
    	return "boardlist";
    }
    
    @RequestMapping(value = "/contentWrite")
    public String contentWrite(HttpServletRequest request, Model model) {
    
    	return "contentWrite";
    }
    
    @RequestMapping(value = "/contentWriteOk")
    public String contentWriteOK(HttpServletRequest request, Model model) {
    	String btitle = request.getParameter("btitle");
    	String memberid = request.getParameter("memberid");
    	String bcontent = request.getParameter("bcontent");
    	
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	boardDao.contentWriteDao(btitle, memberid, bcontent);
    	
    	return "redirect:boardlist";
    }
    
    @RequestMapping(value = "/contentView")
    public String contentView(HttpServletRequest request, Model model) {
    	int bnum = Integer.parseInt(request.getParameter("bnum"));
    	
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	BoardDto boardDto = boardDao.contentViewDao(bnum);
    	
    	model.addAttribute("boardDto", boardDto);
    	
    	return "contentView";
    }
    
    @RequestMapping(value = "/deleteContent")
    public String deleteContent(HttpServletRequest request, Model model) {
    	int bnum = Integer.parseInt(request.getParameter("bnum"));
    	
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	boardDao.deleteContentDao(bnum);
    	
    	return "redirect:boardlist";
    }
    
    @RequestMapping(value = "/contentModify")
    public String contentModify(HttpServletRequest request, Model model) {
    	
    	return "contentModify";
    }
    
    @RequestMapping(value = "/contentModifyOk")
    public String contentModifyOk(HttpServletRequest request, Model model) {
    	int bnum = Integer.parseInt(request.getParameter("bnum"));
    	String btitle = request.getParameter("btitle");
    	String memberid = request.getParameter("memberid");
    	String bcontent = request.getParameter("bcontent");
    	
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	boardDao.contentModifyDao(btitle, memberid, bcontent, bnum);
    	
    	return "contentModifyOk";
    }
}

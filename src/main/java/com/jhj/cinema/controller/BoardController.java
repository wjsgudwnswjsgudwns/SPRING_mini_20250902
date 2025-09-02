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
    	BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
    	List<BoardDto> boardDtos = boardDao.boardlistDao();
    	
    	model.addAttribute("boardDtos", boardDtos);
    	
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

package com.jhj.cinema.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhj.cinema.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;

    @RequestMapping(value = "/joinOk", method = RequestMethod.POST)
    public String joinOk(HttpServletRequest request, Model model) {
    	String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		String membername = request.getParameter("membername");
		String memberemail = request.getParameter("memberemail");
		String memberphone = request.getParameter("memberphone");
		int memberage = Integer.parseInt(request.getParameter("memberage"));
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.joinMemberDao(memberid, memberpw, membername, memberemail, memberphone, memberage);
        
		return "login";
    }
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(Model model, HttpServletRequest request,HttpSession session) {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("memberpw");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int result = memberDao.loginDao(memberid, memberpw);
		
		if(result == 1) {
			session.setAttribute("sessionid", memberid);
		} else {
			model.addAttribute("msg", "잘못된 아이디 또는 비밀번호입니다.");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}
		
		
		return "index";
	}
	
	
}

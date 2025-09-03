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
	
	@RequestMapping(value = "/findpw")
	public String findpw() {
		return "findpw";
	}
	
	@RequestMapping(value = "/findpwOk")
	public String findpwOk(Model model, HttpServletRequest request) {
		String memberid = request.getParameter("memberid");
		String memberemail = request.getParameter("memberemail");
		String memberphone = request.getParameter("memberphone");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int result = memberDao.findpwDao(memberid, memberemail, memberphone);
		
		if(result == 1) {
			
			return "changepw";
		} else {
			model.addAttribute("msg", "존재하지 않는 아이디입니다.");
			model.addAttribute("url", "findpw");
			
			return "alert/alert";
		}
		
	}
	
	@RequestMapping(value = "/changepw")
	public String changepw(Model model, HttpServletRequest request) {
		
		return "changepw";
	}
	
	@RequestMapping(value = "/changepwOk")
	public String changepwOk(Model model, HttpServletRequest request) {
		String memberid = request.getParameter("memberid");
		String memberpw = request.getParameter("newpw");
		String confirmpw = request.getParameter("confirmpw");
		
		if(memberpw.equals(confirmpw)) {
			MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
			int result = memberDao.changePwDao(memberpw, memberid);
			
			if(result == 1) {
				model.addAttribute("msg", "비밀번호가 변경되었습니다");
				model.addAttribute("url", "login");	
				
				return "alert/alert";
			} else {
				model.addAttribute("msg", "다시 시도해주세요");
				model.addAttribute("url", "changepw");	
				
				return "alert/alert";
			}
		} else {
			model.addAttribute("msg", "비밀번호 확인이 잘못 입력되었습니다.");
			model.addAttribute("url", "changepw");	
			
			return "alert/alert";
		}

	}
	
}

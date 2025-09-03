package com.jhj.cinema.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.cinema.dao.TheaterDao;
import com.jhj.cinema.dto.TheaterDto;

@Controller
public class TheaterController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value="/theater/reservation")
	public String reservation(Model model) {
		TheaterDao theaterDao = sqlSession.getMapper(TheaterDao.class);
		List<TheaterDto> theaterDtos = theaterDao.getAllTheaters();
		
		model.addAttribute("theaterList", theaterDtos);
		
		return "reservation";
	}
}

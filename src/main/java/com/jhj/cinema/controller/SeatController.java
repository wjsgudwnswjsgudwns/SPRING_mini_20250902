package com.jhj.cinema.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.cinema.dao.SeatDao;
import com.jhj.cinema.dto.SeatDto;

@Controller
public class SeatController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value = "/reservation")
	public String reservation(Model model) {
		SeatDao seatDao = sqlSession.getMapper(SeatDao.class);
		List<SeatDto> seatDtos = seatDao.getAllSeats();
		
		model.addAttribute("seatList", seatDtos);
		
		return "reservation";
	}
}

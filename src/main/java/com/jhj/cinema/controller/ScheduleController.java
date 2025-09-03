package com.jhj.cinema.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.cinema.dao.ScheduleDao;
import com.jhj.cinema.dto.ScheduleDto;

@Controller
public class ScheduleController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value="/schedule/reservation")
	public String reservation(Model model) {
		ScheduleDao scheduleDao = sqlSession.getMapper(ScheduleDao.class);
		List<ScheduleDto> scheduleDtos = scheduleDao.getAllSchedules();
		
		model.addAttribute("scheduleList", scheduleDtos);
		
		return "reservation";
	}
	
	
}

package com.jhj.cinema.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.cinema.dao.MovieDao;
import com.jhj.cinema.dto.MovieDto;

@Controller
public class MovieController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value="/movie/reservation")
	public String reservation(Model model) {
		MovieDao movieDao = sqlSession.getMapper(MovieDao.class);
		List<MovieDto> moiveDtos = movieDao.getAllMovies();
		
		model.addAttribute("moiveList", moiveDtos);
		
		return "reservation";
	}
}

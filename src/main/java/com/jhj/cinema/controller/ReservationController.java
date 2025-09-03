package com.jhj.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhj.cinema.dao.MovieDao;
import com.jhj.cinema.dao.ReservationDao;
import com.jhj.cinema.dao.ScheduleDao;
import com.jhj.cinema.dao.SeatDao;
import com.jhj.cinema.dao.TheaterDao;
import com.jhj.cinema.dto.MovieDto;
import com.jhj.cinema.dto.ScheduleDto;
import com.jhj.cinema.dto.SeatDto;
import com.jhj.cinema.dto.TheaterDto;

@Controller
public class ReservationController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public String reservation(Model model) {
		MovieDao movieDao = sqlSession.getMapper(MovieDao.class);
		ScheduleDao scheduleDao = sqlSession.getMapper(ScheduleDao.class);
		SeatDao seatDao = sqlSession.getMapper(SeatDao.class);
		TheaterDao theaterDao = sqlSession.getMapper(TheaterDao.class);
		
	    List<MovieDto> movieList = movieDao.getAllMovies();
	    List<ScheduleDto> scheduleList = scheduleDao.getAllSchedules();
	    List<SeatDto> seatList = seatDao.getAllSeats();
	    List<TheaterDto> theaterList = theaterDao.getAllTheaters();
	    
	    model.addAttribute("movieList", movieList);
	    model.addAttribute("scheduleList", scheduleList);
	    model.addAttribute("seatList", seatList);
	    model.addAttribute("theaterList", theaterList);
	    
	    return "reservation";
	}	

	@RequestMapping(value="/reserveOk", method=RequestMethod.POST)
	public String reserveOk(HttpServletRequest request, HttpSession session) {
	    String memberid = (String) session.getAttribute("memberid");
	    int movieid = Integer.parseInt(request.getParameter("movieid"));
	    int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
	    String seat_number = request.getParameter("seat_number");
	    
	    ReservationDao reservationDao = sqlSession.getMapper(ReservationDao.class);
	    reservationDao.reservationMovieDao(memberid, scheduleid, seat_number);
	    
	    ScheduleDao scheduleDao = sqlSession.getMapper(ScheduleDao.class);
	    scheduleDao.reservationScheduleDao(scheduleid, movieid);
	    
	   return "redirect:/reservationComplete";
	}
}

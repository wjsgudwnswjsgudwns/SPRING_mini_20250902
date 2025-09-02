package com.jhj.cinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public String reservation() {
	    //List<Movie> movieList = movieService.getAllMovies();
	    //List<Schedule> scheduleList = scheduleService.getAllSchedules();
	    //List<Seat> seatList = seatService.getAvailableSeats();
	    
	    //model.addAttribute("movieList", movieList);
	    //model.addAttribute("scheduleList", scheduleList);
	    //model.addAttribute("seatList", seatList);
	    
	    return "reservation";
	}

	//@RequestMapping(value="/reserveOk", method=RequestMethod.POST)
	//public String reserveOk(HttpServletRequest request, HttpSession session) {
	    //String memberid = (String) session.getAttribute("memberid");
	    //int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
	    //String seat_number = request.getParameter("seat_number");
	    
	    //reservationService.reserveTicket(memberid, scheduleid, seat_number);
	    
	    //return "redirect:/reservationComplete";
	//}
}

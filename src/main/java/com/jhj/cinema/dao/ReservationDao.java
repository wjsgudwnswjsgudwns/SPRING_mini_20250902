package com.jhj.cinema.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhj.cinema.dto.ReservationDto;

public interface ReservationDao {

	public void reservationMovieDao(@Param("memberid") String memberid, 
            @Param("scheduleid") int scheduleid, 
            @Param("seat_number") String seat_number,
            @Param("movieid") int movieid);
	
	public List<ReservationDto> reservationCheck(@Param("memberid") String memberid);
	
	public void deleteReservation(int reservationid);
	
}
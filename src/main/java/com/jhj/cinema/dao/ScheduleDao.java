package com.jhj.cinema.dao;

import java.util.List;

import com.jhj.cinema.dto.ScheduleDto;


public interface ScheduleDao {

	public List<ScheduleDto> getAllSchedules();
	
	public void reservationScheduleDao(int scheduleid,int movieid);
}

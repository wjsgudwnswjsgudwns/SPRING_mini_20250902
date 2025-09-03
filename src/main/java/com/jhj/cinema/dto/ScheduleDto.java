package com.jhj.cinema.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

	private int scheduleid;
	private int movieid;
	private int theaterId;
	private Timestamp startTime;
	private Timestamp endTime;
	private int price;
	private int reserved_seat;
	
	private List<MovieDto> movieDtos;
	private List<ReservationDto> reservationDtos;
}

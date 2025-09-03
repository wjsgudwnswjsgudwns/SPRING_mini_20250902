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
public class ReservationDto {

	private int reservationid;
	private String memberid;
	private int scheduleid;
	private String seat_number;
	private Timestamp reservation_date;
	private String status;
	private int movieid;
	
	private List<ScheduleDto> scheduleDto;
	private List<MovieDto> movieDto;
}

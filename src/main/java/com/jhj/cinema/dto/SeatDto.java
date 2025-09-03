package com.jhj.cinema.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {

	private int seatid;
	private int theaterid;
	private String seat_number;
}

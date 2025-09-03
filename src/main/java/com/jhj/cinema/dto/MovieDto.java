package com.jhj.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
	
	private int movieid;
	private String moviename;
	private String genre;
	private String director;
	private int duration;
	private String rating;
	
}

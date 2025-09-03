package com.jhj.cinema.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int rnum; // rownum 값 필드
	
	private int bnum;
	private String btitle;
	private String bcontent;
	private String memberid;
	private int bhit;
	private Timestamp bdate;
	
	private MemberDto memberDto;
}

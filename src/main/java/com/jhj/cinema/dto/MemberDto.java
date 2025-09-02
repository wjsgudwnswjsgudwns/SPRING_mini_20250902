package com.jhj.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private String memberid;
	private String memberpw;
	private String membername;
	private String memberemail;
	private String memberphone;
	private int memberage;
}

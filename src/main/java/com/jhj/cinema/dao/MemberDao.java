package com.jhj.cinema.dao;

import com.jhj.cinema.dto.MemberDto;

public interface MemberDao {

	public int joinMemberDao(String memberid,String memberpw,String membername,String memberemail,String memberphone,int age);
	
	public int loginDao(String memberid, String memberpw);
}

package com.jhj.cinema.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDao {

	public int joinMemberDao(String memberid,String memberpw,String membername,String memberemail,String memberphone,int age);
	
	public int loginDao(String memberid, String memberpw);
	
	public int findpwDao(@Param("memberid") String memberid,
		    @Param("memberemail") String memberemail,
		    @Param("memberphone") String memberphone);
	
	public int changePwDao(String pw, String memberid);
}

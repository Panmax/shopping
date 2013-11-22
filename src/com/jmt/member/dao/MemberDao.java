package com.jmt.member.dao;

import com.jmt.member.po.Member;

public interface MemberDao {
	public boolean addMember(Member member);
	public boolean updateMember(Member member);
	public Member getMember(int id);
	public boolean deleteMember(int id);//删除成功返回true，失败返回false
	public boolean isExsit(String memberName);
}

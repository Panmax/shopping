package com.jmt.member.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jmt.member.dao.MemberDao;
import com.jmt.member.po.Member;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

public class MemberDaoImpl implements MemberDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	@Override
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_Member(MemberID,MemberName,MemberPassword,MemberEmail,MemberGrade,CreateDate,UpdateDate) " +
					"values(seq_T_Member.nextVal,?,?,?,?,?,?)");
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberPassword());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setInt(4, member.getMemberGrade());
//			pstmt.setDouble(5, member.getMemberAmount());
//			pstmt.setString(6, member.getMemberStatus());
			pstmt.setDate(5, Date.valueOf(DateUtil.dateToString(member.getCreateDate())));
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(member.getUpdateDate())));
			int b = pstmt.executeUpdate();
			if(b>0){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateMember(Member member) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("update T_Member set MemberName = ?,MemberPassword = ?,MemberEmail =?," +
					"MemberGrade = ?,MemberAmount = ?,MemberStatus = ?,CreateDate = ?,UpdateDate = ? where MemberID = ? ");
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberPassword());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setInt(4, member.getMemberGrade());
			pstmt.setDouble(5, member.getMemberAmount());
			pstmt.setString(6, member.getMemberStatus());
			pstmt.setDate(7, Date.valueOf(DateUtil.dateToString(member.getCreateDate())));
			pstmt.setDate(8, Date.valueOf(DateUtil.dateToString(member.getUpdateDate())));
			pstmt.setInt(9, member.getMemberID());
			int b = pstmt.executeUpdate();
			if(b>0){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Member where MemberID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Member member = new Member();
				member.setMemberID(rs.getInt(1));
				member.setMemberName(rs.getString(2));
				member.setMemberPassword(rs.getString(3));
				member.setMemberEmail(rs.getString(4));
				member.setMemberGrade(rs.getInt(5));
				member.setMemberAmount(rs.getDouble(6));
				member.setMemberStatus(rs.getString(7));
				member.setCreateDate(rs.getDate(8));
				member.setUpdateDate(rs.getDate(9));
				return member;
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteMember(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete from T_Member where MemberID = ?");
			pstmt.setInt(1, id);
			int b = pstmt.executeUpdate();
			if(b>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isExsit(String memberName) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select MemberName from T_Member");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(memberName.equals(rs.getString(1))){
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkMember(String memberName, String memberPassword) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select MemberName,MemberPassword from T_Member");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(memberName.equals(rs.getString(1))|| memberPassword.equals(rs.getString(2))){
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

package com.jmt.memberAddressBook.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jmt.memberAddressBook.dao.MemberAddressBookDao;
import com.jmt.memberAddressBook.po.MemberAddressBook;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

public class MemberAddressBookDaoImpl implements MemberAddressBookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean addMemberAddressBook(MemberAddressBook memberAddressBook) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_MemberAddressBook values(seq_T_MemberAddressBook,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, memberAddressBook.getMemberID());
			pstmt.setString(2, memberAddressBook.getMemberTrueName());
			pstmt.setString(3, memberAddressBook.getMemberAddress());
			pstmt.setString(4, memberAddressBook.getProvinceCode());
			pstmt.setString(5, memberAddressBook.getCityCode());
			pstmt.setString(6, memberAddressBook.getAreaCode());
			pstmt.setString(7, memberAddressBook.getMemberPostcode());
			pstmt.setString(8, memberAddressBook.getMemberTelephone());
			pstmt.setDate(9, Date.valueOf(DateUtil.dateToString(memberAddressBook.getCreateDate())));
			pstmt.setDate(10, Date.valueOf(DateUtil.dateToString(memberAddressBook.getUpdateDate())));
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
	public boolean updateMemberAddressBook(MemberAddressBook memberAddressBook) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("update T_MemberAddressBook set MemberID = ?,MemberTrueName = ?,MemberAddress = ?,ProvinceCode = ?" +
					"CityCode = ?,AreaCode = ?,MemberPostcode = ?,MemberTelephone = ?,CreateDate = ?,UpdateDate = ? where ID = ?");
			pstmt.setInt(1, memberAddressBook.getMemberID());
			pstmt.setString(2, memberAddressBook.getMemberTrueName());
			pstmt.setString(3, memberAddressBook.getMemberAddress());
			pstmt.setString(4, memberAddressBook.getProvinceCode());
			pstmt.setString(5, memberAddressBook.getCityCode());
			pstmt.setString(6, memberAddressBook.getAreaCode());
			pstmt.setString(7, memberAddressBook.getMemberPostcode());
			pstmt.setString(8, memberAddressBook.getMemberTelephone());
			pstmt.setDate(9, Date.valueOf(DateUtil.dateToString(memberAddressBook.getCreateDate())));
			pstmt.setDate(10, Date.valueOf(DateUtil.dateToString(memberAddressBook.getUpdateDate())));
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
	public boolean deleteMemberAddressBook(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete * from T_MemberAddressBook where ID = ?");
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
	public MemberAddressBook getMemberAddressBook(int memberID) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_MemberAddressBook where MemberID = ?");
			pstmt.setInt(1, memberID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				MemberAddressBook memberAddressBook = new MemberAddressBook();
				memberAddressBook.setId(rs.getInt(1));
				memberAddressBook.setMemberID(rs.getInt(2));
				memberAddressBook.setMemberTrueName(rs.getString(3));
				memberAddressBook.setMemberAddress(rs.getString(4));
				memberAddressBook.setProvinceCode(rs.getString(5));
				memberAddressBook.setCityCode(rs.getString(6));
				memberAddressBook.setAreaCode(rs.getString(7));
				memberAddressBook.setMemberPostcode(rs.getString(8));
				memberAddressBook.setMemberTelephone(rs.getString(9));
				memberAddressBook.setCreateDate(rs.getDate(10));
				memberAddressBook.setUpdateDate(rs.getDate(11));
				return memberAddressBook;
			}else{
				
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

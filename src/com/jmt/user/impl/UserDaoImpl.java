package com.jmt.user.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;
import com.jmt.user.dao.UserDao;
import com.jmt.user.po.User;

public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_User values(seq_T_User.nextVal,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserTrueName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getIsValid());
			pstmt.setString(5, user.getUserlevel());
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(user.getCreateDate())));
			pstmt.setDate(7, Date.valueOf(DateUtil.dateToString(user.getUpdateDate())));
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
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("update T_User set UserName = ?,UserTrueName = ?,UserPassword = ?," +
								"isVaild = ?,userlevel = ?,CreateDate = ?,UpdateDate = ? where UserID = ?");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserTrueName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getIsValid());
			pstmt.setString(5, user.getUserlevel());
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(user.getCreateDate())));
			pstmt.setDate(7, Date.valueOf(DateUtil.dateToString(user.getUpdateDate())));
			pstmt.setInt(8, user.getUserID());
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
	public User getUser(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_User where UserID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserTrueName(rs.getString(3));
				user.setUserPassword(rs.getString(4));
				user.setIsValid(rs.getString(5));
				user.setUserlevel(rs.getString(6));
				user.setCreateDate(rs.getDate(7));
				user.setUpdateDate(rs.getDate(8));
				return user;
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
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete from T_User where UserID = ?");
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
	public boolean isExsit(String userName) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select UserName from T_User");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(userName.equals(rs.getString(1))){
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
	public boolean checkUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select userName,userPassword from T_User");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(userName.equals(rs.getString(1))||userPassword.equals(rs.getString(2))){
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

}

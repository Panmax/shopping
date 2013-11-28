package com.jmt.favorits.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmt.favorits.dao.FavoritsDao;
import com.jmt.favorits.po.Favorits;
import com.jmt.system.db.DB;

public class FavoritsDaoImpl implements FavoritsDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	@Override
	public boolean addFavorits(Favorits favorits) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_Favorits values(seq_T_Favorits,?,?)");
			pstmt.setInt(1, favorits.getMemberID());
			pstmt.setInt(2, favorits.getGoodsID());
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
	public boolean deleteFavorits(int ID) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delect from T_Favorits where ID=?");
			pstmt.setInt(1, ID);
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
	public List<Favorits> getFavoritsByMemberID(int MemberID) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Favorits where MemberID=?");
			pstmt.setInt(1, MemberID);
			rs = pstmt.executeQuery();
			List<Favorits> favoritsList = new ArrayList<Favorits>();
			while(rs.next()){
				Favorits favorits = new Favorits();
				favorits.setID(rs.getInt(1));
				favorits.setMemberID(rs.getInt(2));
				favorits.setGoodsID(rs.getInt(3));
				favoritsList.add(favorits);
			}
			return favoritsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isExsit(Favorits favorits) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Favorits where MemberID = ? and GoodsID = ?");
			pstmt.setInt(1, favorits.getMemberID());
			pstmt.setInt(2, favorits.getGoodsID());
			rs = pstmt.executeQuery();
			if(rs.next()){
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

}

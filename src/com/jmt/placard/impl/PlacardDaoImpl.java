package com.jmt.placard.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmt.placard.dao.PlacardDao;
import com.jmt.placard.po.Placard;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

public class PlacardDaoImpl implements PlacardDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs =null;

	@Override
	public boolean addPlacard(Placard placard) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_Placard values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, placard.getPlacardID());
			pstmt.setString(2, placard.getPlacardTitle());
			pstmt.setString(3, placard.getPlacardContent());
			pstmt.setDate(4, Date.valueOf(DateUtil.dateToString(placard.getIssueDate())));
			pstmt.setDate(5, Date.valueOf(DateUtil.dateToString(placard.getExpireDate())));
			pstmt.setString(6, placard.getCreater());
			pstmt.setDate(7, Date.valueOf(DateUtil.dateToString(placard.getCreateDate())));
			pstmt.setString(8, placard.getUpdater());
			pstmt.setDate(9, Date.valueOf(DateUtil.dateToString(placard.getUpdateDate())));
			int count = pstmt.executeUpdate();
			if(count >0){
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
	public boolean updatePlacard(Placard placard) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("update T_Placard set PlacardTitle=?," +
					"PlacardContent= ?,IssueDate= ?,ExpireDate=?,Creater=?," +
					"CreateDate=?, Updater=?,UpdateDate=? where  PlacardID=?");
			pstmt.setString(1, placard.getPlacardTitle());
			pstmt.setString(2, placard.getPlacardContent());
			pstmt.setDate(3,  Date.valueOf(DateUtil.dateToString(placard.getIssueDate())));
			pstmt.setDate(4,  Date.valueOf(DateUtil.dateToString(placard.getExpireDate())));
			pstmt.setString(5, placard.getCreater());
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(placard.getCreateDate())));
			pstmt.setString(7, placard.getUpdater());
			pstmt.setDate(8, Date.valueOf(DateUtil.dateToString(placard.getUpdateDate())));
			pstmt.setInt(9, placard.getPlacardID());
			int count = pstmt.executeUpdate();
			if(count >0){
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
	public Placard getPlacard(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Placard where  PlacardID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Placard placard = new Placard();
				placard.setPlacardID(rs.getInt(1));
				placard.setPlacardTitle(rs.getString(2));
				placard.setPlacardContent(rs.getString(3));
				placard.setIssueDate(rs.getDate(4));
				placard.setExpireDate(rs.getDate(5));
				placard.setCreater(rs.getString(6));
				placard.setCreateDate(rs.getDate(7));
				placard.setUpdater(rs.getString(8));
				placard.setUpdateDate(rs.getDate(9));
				return placard;
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
	public boolean deletePlacard(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete  from T_Placard where  PlacardID=?");
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			if(count>0){
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
	public List<Placard> getAllPlacard() {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Placard");
			List<Placard> placardList = new ArrayList<Placard>();
			rs = pstmt.executeQuery();
			while(rs.next()){
				Placard placard = new Placard();
				placard.setPlacardID(rs.getInt(1));
				placard.setPlacardTitle(rs.getString(2));
				placard.setPlacardContent(rs.getString(3));
				placard.setIssueDate(rs.getDate(4));
				placard.setExpireDate(rs.getDate(5));
				placard.setCreater(rs.getString(6));
				placard.setCreateDate(rs.getDate(7));
				placard.setUpdater(rs.getString(8));
				placard.setUpdateDate(rs.getDate(9));
				placardList.add(placard);
			}
			return placardList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isExsit(String placardTitle) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Placard  where PlacardTitle=?");
			pstmt.setString(1, placardTitle);
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

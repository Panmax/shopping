package com.jmt.advertise.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmt.advertise.dao.AdvertiseDao;
import com.jmt.advertise.po.Advertise;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

public class AdvertiseDaoImpl implements AdvertiseDao {
	private Connection conn = null;
	private PreparedStatement  pstmt= null;
	private ResultSet rs =null;

	@Override
	public boolean addAdvertise(Advertise advertise) {
		// TODO Auto-generated method stub
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement("insert into T_Advertise  values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, advertise.getAdvertiseID());
			pstmt.setString(2, advertise.getAdvertiseTitle());
			pstmt.setString(3,advertise.getAdvertiseProvider());
			pstmt.setString(4,advertise.getAdvertisePath());
			pstmt.setInt(5, advertise.getAdvertise());
			pstmt.setDate(6,Date.valueOf(DateUtil.dateToString(advertise.getCreateDate())));
			pstmt.setDate(7, Date.valueOf(DateUtil.dateToString(advertise.getExpireDate())));
			pstmt.setString(8, advertise.getUpdater());
			int count = pstmt.executeUpdate();
			if(count > 0){
				return true;
			} else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAdvertise(Advertise advertise) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			String sql = "update T_Advertise set  AdvertiseTitle = ?,"+
			    "advertiseProvider=?,AdvertisePath=?,Advertise=?,CreateDate=?,"+
			    "ExpireDate=?, Updater =? where AdvertiseID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, advertise.getAdvertiseTitle());
			pstmt.setString(2, advertise.getAdvertiseProvider());
			pstmt.setString(3, advertise.getAdvertisePath());
			pstmt.setInt(4, advertise.getAdvertise());
			pstmt.setDate(5, Date.valueOf(DateUtil.dateToString(advertise.getCreateDate())));
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(advertise.getExpireDate())));
			pstmt.setString(7, advertise.getUpdater());
			pstmt.setInt(8, advertise.getAdvertiseID());
			int count = pstmt.executeUpdate();
            if (count>0) {
                return true;
            }
            else {
                return false;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Advertise getAdvertise(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt= conn.prepareStatement("select * from T_Advertise where AdvertiseID=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				Advertise advertise = new Advertise();
				advertise.setAdvertiseID(rs.getInt(1));
				advertise.setAdvertiseTitle(rs.getString(2));
				advertise.setAdvertiseProvider(rs.getString(3));
				advertise.setAdvertisePath(rs.getString(4));
				advertise.setAdvertise(rs.getInt(5));
				advertise.setCreateDate(rs.getDate(6));
				advertise.setExpireDate(rs.getDate(7));
				advertise.setUpdater(rs.getString(8));
				return advertise;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteAdvertise(int id) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete from T_Advertise where AdvertiseID =?");
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
            if (count>0) {
                return true;
            }
            else {
                return false;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isExsit(String advertiseTitle) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try { 
			pstmt = conn.prepareStatement("select * from T_Advertise where AdvertiseTitle=?");
			pstmt.setString(1,advertiseTitle);
			rs = pstmt.executeQuery();
			if(rs.next()){
			    return true;
			} else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}

	}

	@Override
	public List<Advertise> getValiAdvertise() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Advertise> getAllAdvertise() {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_Advertise");
			rs = pstmt.executeQuery();
			List<Advertise> advertiseList = new ArrayList<Advertise>();
			while(rs.next()){
				Advertise advertise = new Advertise();
				advertise.setAdvertiseID(rs.getInt(1));
				advertise.setAdvertiseTitle(rs.getString(2));
				advertise.setAdvertiseProvider(rs.getString(3));
				advertise.setAdvertisePath(rs.getString(4));
				advertise.setAdvertise(rs.getInt(5));
				advertise.setCreateDate(rs.getDate(6));
				advertise.setExpireDate(rs.getDate(7));
				advertise.setUpdater(rs.getString(8));
				advertiseList.add(advertise);
			}
			return advertiseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}

package com.jmt.goodsComment.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmt.goodsComment.dao.GoodsCommentDao;
import com.jmt.goodsComment.po.GoodsComment;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

public class GoodsCommentDaoImpl implements GoodsCommentDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean addGoodsComment(GoodsComment goodsComment) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("insert into T_GoodsComment values(seq_T_GoodsComment,?,?,?,?,?,?)");
			pstmt.setInt(1, goodsComment.getMemberId());
			pstmt.setInt(2, goodsComment.getGoodsID());
			pstmt.setString(3, goodsComment.getMembername());
			pstmt.setString(4, goodsComment.getCommentContent());
			pstmt.setInt(5, goodsComment.getCommentRank());
			pstmt.setDate(6, Date.valueOf(DateUtil.dateToString(goodsComment.getCommentCreateDate())));
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
	public boolean deleteGoodscomment(int commentID) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("delete from T_GoodsComment where CommentID = ?");
			pstmt.setInt(1, commentID);
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
	public List<GoodsComment> getGoodsCommentByGoodsId(int goodsID) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_GoodsComment where GoodsID = ?");
			pstmt.setInt(1, goodsID);
			rs = pstmt.executeQuery();
			List<GoodsComment> goodsCommentList = new ArrayList<GoodsComment>();
			while(rs.next()){
				GoodsComment goodsComment = new GoodsComment();
				goodsComment.setCommentID(rs.getInt(1));
				goodsComment.setMemberId(rs.getInt(2));
				goodsComment.setGoodsID(rs.getInt(3));
				goodsComment.setMembername(rs.getString(4));
				goodsComment.setCommentContent(rs.getString(5));
				goodsComment.setCommentRank(rs.getInt(6));
				goodsComment.setCommentCreateDate(rs.getDate(7));
				goodsCommentList.add(goodsComment);
			}
			return goodsCommentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isExsit(GoodsComment goodsComment) {
		// TODO Auto-generated method stub
		conn = DB.getConn();
		try {
			pstmt = conn.prepareStatement("select * from T_GoodsComment where MemberId = ? and GoodsID = ?");
			pstmt.setInt(1, goodsComment.getMemberId());
			pstmt.setInt(2, goodsComment.getGoodsID());
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

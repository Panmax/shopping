package com.jmt.favorits.po;

import java.io.Serializable;

public class Favorits implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7813968451766288023L;
	private Integer ID; // 收藏ID
	private Integer MemberID; // 会员ID ---引用用户表的id设为外键
	private Integer GoodsID; // 商品ID ---引用用户表的id设为外键

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getMemberID() {
		return MemberID;
	}

	public void setMemberID(Integer memberID) {
		MemberID = memberID;
	}

	public Integer getGoodsID() {
		return GoodsID;
	}

	public void setGoodsID(Integer goodsID) {
		GoodsID = goodsID;
	}

}

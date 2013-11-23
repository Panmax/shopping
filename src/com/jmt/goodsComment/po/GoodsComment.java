package com.jmt.goodsComment.po;

import java.io.Serializable;
import java.util.Date;

public class GoodsComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1059702276825713897L;
	private Integer commentID;
	private Integer memberId;
	private Integer goodsID;
	private String membername; // 评论用户的姓名，
	private String commentContent;
	private Integer commentRank;
	private Date commentCreateDate;

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getCommentRank() {
		return commentRank;
	}

	public void setCommentRank(Integer commentRank) {
		this.commentRank = commentRank;
	}

	public Date getCommentCreateDate() {
		return commentCreateDate;
	}

	public void setCommentCreateDate(Date commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}

}

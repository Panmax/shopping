package com.jmt.orderDetail.po;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -599807392646996926L;
	private Integer id; // 订单明细ID
	private String orderID; // 订单ID
	private Integer goodsID; // 商品ID
	private String goodsName; // 商品名称
	private Double goodsPrice; // 商品单价
	private Integer goodsCount; // 商品数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

}

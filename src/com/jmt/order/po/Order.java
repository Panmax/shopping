package com.jmt.order.po;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -790557011412110781L;
	private String orderID; // 订单ID ---订单号是否要用varchar型
	private Integer memberID; // 会员ID --引用会员表的id
	private String memberTrueName; // 收货人
	private String memberAddress; // 收货地址 ---
	private String memberProvince; // 所在省份 --是否要关联那省份和市的表
	private String memberCity; // 所在城市
	private String memberArea; // 所在地区
	private String memberPostcode; // 邮政编码
	private String memberTelephone; // 联系电话
	private Double orderAmount; // 订单总金额--------------订单金额是否要小数？？？？？？？？？？
	private Integer orderPay; // 付款方式 ---是否要关联---订单付款方式表-- ？？？？？？？？
	private Integer orderInvoice; // 开具发票
	private Integer orderCarry; // 送货方式
	private Integer orderCarryTime; // 送货时间
	private String orderRemark; // 订单备注
	private Integer orderStatus; // 订0表示新订单 1.表示已配送
	private Date createDate; // 创建时间单状态
	private Date updateDate; // 修改时间

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getMemberTrueName() {
		return memberTrueName;
	}

	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberProvince() {
		return memberProvince;
	}

	public void setMemberProvince(String memberProvince) {
		this.memberProvince = memberProvince;
	}

	public String getMemberCity() {
		return memberCity;
	}

	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}

	public String getMemberArea() {
		return memberArea;
	}

	public void setMemberArea(String memberArea) {
		this.memberArea = memberArea;
	}

	public String getMemberPostcode() {
		return memberPostcode;
	}

	public void setMemberPostcode(String memberPostcode) {
		this.memberPostcode = memberPostcode;
	}

	public String getMemberTelephone() {
		return memberTelephone;
	}

	public void setMemberTelephone(String memberTelephone) {
		this.memberTelephone = memberTelephone;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderPay() {
		return orderPay;
	}

	public void setOrderPay(Integer orderPay) {
		this.orderPay = orderPay;
	}

	public Integer getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(Integer orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	public Integer getOrderCarry() {
		return orderCarry;
	}

	public void setOrderCarry(Integer orderCarry) {
		this.orderCarry = orderCarry;
	}

	public Integer getOrderCarryTime() {
		return orderCarryTime;
	}

	public void setOrderCarryTime(Integer orderCarryTime) {
		this.orderCarryTime = orderCarryTime;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

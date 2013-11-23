package com.jmt.orderPayMode.po;

import java.io.Serializable;

public class OrderPayMode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 923434175374449183L;
	private Integer payID; // 支付方式ID
	private String payContent; // 支付方式内容
	private String payDesc; // 描述

	public Integer getPayID() {
		return payID;
	}

	public void setPayID(Integer payID) {
		this.payID = payID;
	}

	public String getPayContent() {
		return payContent;
	}

	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}

	public String getPayDesc() {
		return payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

}

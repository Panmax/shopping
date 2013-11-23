package com.jmt.orderCarryMode.po;

import java.io.Serializable;

public class OrderCarryMode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381797001059741629L;
	private Integer carryID; // 送货方式ID
	private String carryContent; // 送货方式内容
	private Integer carryDay; // 送货天数
	private String carryDesc; // 描述

	public Integer getCarryID() {
		return carryID;
	}

	public void setCarryID(Integer carryID) {
		this.carryID = carryID;
	}

	public String getCarryContent() {
		return carryContent;
	}

	public void setCarryContent(String carryContent) {
		this.carryContent = carryContent;
	}

	public Integer getCarryDay() {
		return carryDay;
	}

	public void setCarryDay(Integer carryDay) {
		this.carryDay = carryDay;
	}

	public String getCarryDesc() {
		return carryDesc;
	}

	public void setCarryDesc(String carryDesc) {
		this.carryDesc = carryDesc;
	}

}

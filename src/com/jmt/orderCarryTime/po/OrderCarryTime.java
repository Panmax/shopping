package com.jmt.orderCarryTime.po;

import java.io.Serializable;

public class OrderCarryTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6502982807771219092L;
	private Integer carryTimeID; // 送货时间ID
	private String carryTimeContent;

	public Integer getCarryTimeID() {
		return carryTimeID;
	}

	public void setCarryTimeID(Integer carryTimeID) {
		this.carryTimeID = carryTimeID;
	}

	public String getCarryTimeContent() {
		return carryTimeContent;
	}

	public void setCarryTimeContent(String carryTimeContent) {
		this.carryTimeContent = carryTimeContent;
	}

}

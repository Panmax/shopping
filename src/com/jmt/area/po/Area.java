package com.jmt.area.po;

import java.io.Serializable;

public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5892429171950446469L;
	private Integer areaID; // 地区ID
	private String areaCode; // 地区编码
	private String area; // 地区名称
	private Integer cityID; // 城市ID --这估计要引用城市表-的id

	public Integer getAreaID() {
		return areaID;
	}

	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

}

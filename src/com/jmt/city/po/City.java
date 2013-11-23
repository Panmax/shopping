package com.jmt.city.po;

import java.io.Serializable;

public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -951772009153003692L;
	private Integer cityID; // 城市ID
	private Integer provinceID; // 省份ID 做省份的外键
	private String cityCode; // 城市编码
	private String city; // 城市名称

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public Integer getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

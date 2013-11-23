package com.jmt.province.po;

import java.io.Serializable;

public class Province implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4114042113602986619L;
	private Integer provinceID; // 省份ID
	private String provinceCode; // 省份编码
	private String province; // 省份名称

	public Integer getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}

package com.jmt.memberAddressBook.po;

import java.io.Serializable;
import java.util.Date;

public class MemberAddressBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6385241533114150295L;
	private Integer id; // 地址薄ID
	private Integer memberID; // 会员ID
	private String memberTrueName; // 会员姓名
	private String memberAddress; // 收货地址
	private String provinceCode; // 所在省份
	private String cityCode; // 所在城市
	private String areaCode; // 所在地区
	private String memberPostcode; // 邮政编码
	private String memberTelephone; // 联系电话
	private Date createDate; // 创建时间
	private Date updateDate; // 修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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

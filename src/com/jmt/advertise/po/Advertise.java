package com.jmt.advertise.po;

import java.io.Serializable;
import java.util.Date;

public class Advertise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4304289355919764713L;
	   private  Integer  advertiseID ;       //广告ID
	   private  String    advertiseTitle ;    //广告主题
	   private  String    advertiseProvider ; //广告的商家
	   private  String    advertisePath ;    //广告图片
	   private  Integer  advertise ;   //广告的位子
	   private  Date     createDate;         //创建时间
	   private  Date     expireDate ;        //失效时间        新增字段
	   private String    updater ;   //上传人-----------是否要用管理员得名字
	public Integer getAdvertiseID() {
		return advertiseID;
	}
	public void setAdvertiseID(Integer advertiseID) {
		this.advertiseID = advertiseID;
	}
	public String getAdvertiseTitle() {
		return advertiseTitle;
	}
	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}
	public String getAdvertiseProvider() {
		return advertiseProvider;
	}
	public void setAdvertiseProvider(String advertiseProvider) {
		this.advertiseProvider = advertiseProvider;
	}
	public String getAdvertisePath() {
		return advertisePath;
	}
	public void setAdvertisePath(String advertisePath) {
		this.advertisePath = advertisePath;
	}
	public Integer getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Integer advertise) {
		this.advertise = advertise;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	   
}

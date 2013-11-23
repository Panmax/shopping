package com.jmt.goods.po;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6793930614298841331L;
	   private Integer   goodsID  ;       
	   private String    goodsName;                    
	   private String    goodsIntroduce  ;            
	   private Double   goodsNormalPrice  ;
	   private Double   goodsMemberPrice   ;
	   private Double   goodsRebate  ;
	   private String    typeCode ;  
	   private Integer   goodsNumber ;          
	   private Integer   goodsGrade   ;         
	   private Integer   isSale  ;       
	   private Integer   isValid  ;   
	   private String    goodsPicture  ;         
	   private Integer   buycount  ;
	   private String    creater  ;     
	   private Date      createDate   ; 
	   private String    updater   ;  
	   private Date      updateDate  ;
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
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	public Double getGoodsNormalPrice() {
		return goodsNormalPrice;
	}
	public void setGoodsNormalPrice(Double goodsNormalPrice) {
		this.goodsNormalPrice = goodsNormalPrice;
	}
	public Double getGoodsMemberPrice() {
		return goodsMemberPrice;
	}
	public void setGoodsMemberPrice(Double goodsMemberPrice) {
		this.goodsMemberPrice = goodsMemberPrice;
	}
	public Double getGoodsRebate() {
		return goodsRebate;
	}
	public void setGoodsRebate(Double goodsRebate) {
		this.goodsRebate = goodsRebate;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Integer getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public Integer getGoodsGrade() {
		return goodsGrade;
	}
	public void setGoodsGrade(Integer goodsGrade) {
		this.goodsGrade = goodsGrade;
	}
	public Integer getIsSale() {
		return isSale;
	}
	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public Integer getBuycount() {
		return buycount;
	}
	public void setBuycount(Integer buycount) {
		this.buycount = buycount;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	   
}

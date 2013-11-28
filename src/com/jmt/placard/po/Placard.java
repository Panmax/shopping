package com.jmt.placard.po;

import java.io.Serializable;
import java.util.Date;

public class Placard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8855364502054265179L;
	      private Integer placardID   ;          //公告ID              
	      private String  placardTitle ;         //公告主题
	      private String  placardContent ;       //公告内容
	      private Date    issueDate  ;           //发布时间      
	      private String  creater ;              //创建人
	      private Date    createDate ;             //创建时间
	      private String  updater ;             //修改人
	      private Date  updateDate;                             //修改时间
	      private Date expireDate;
		public Date getExpireDate() {
			return expireDate;
		}
		public void setExpireDate(Date expireDate) {
			this.expireDate = expireDate;
		}
		public Integer getPlacardID() {
			return placardID;
		}
		public void setPlacardID(Integer placardID) {
			this.placardID = placardID;
		}
		public String getPlacardTitle() {
			return placardTitle;
		}
		public void setPlacardTitle(String placardTitle) {
			this.placardTitle = placardTitle;
		}
		public String getPlacardContent() {
			return placardContent;
		}
		public void setPlacardContent(String placardContent) {
			this.placardContent = placardContent;
		}
		public Date getIssueDate() {
			return issueDate;
		}
		public void setIssueDate(Date issueDate) {
			this.issueDate = issueDate;
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

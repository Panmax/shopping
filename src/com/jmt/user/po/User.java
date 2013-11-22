package com.jmt.user.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4981376350707687638L;
	                private Integer   userID  ;           //管理员ID
	                private  String   userName ;          //管理员名
	                private  String   userTrueName ;      //   真实姓名
	                private  String   userPassword ;       //密码
	                private  String   isValid ;           // 是否有效  --0表示无效  --1表示有效
	                private  String   userlevel ;         //  用户级别  --0表示普通用户（） 1表示管理员
	                private  Date     createDate ;        //创建时间
	                private  Date    updateDate   ;       // 修改时间
					public Integer getUserID() {
						return userID;
					}
					public void setUserID(Integer userID) {
						this.userID = userID;
					}
					public String getUserName() {
						return userName;
					}
					public void setUserName(String userName) {
						this.userName = userName;
					}
					public String getUserTrueName() {
						return userTrueName;
					}
					public void setUserTrueName(String userTrueName) {
						this.userTrueName = userTrueName;
					}
					public String getUserPassword() {
						return userPassword;
					}
					public void setUserPassword(String userPassword) {
						this.userPassword = userPassword;
					}
					public String getIsValid() {
						return isValid;
					}
					public void setIsValid(String isValid) {
						this.isValid = isValid;
					}
					public String getUserlevel() {
						return userlevel;
					}
					public void setUserlevel(String userlevel) {
						this.userlevel = userlevel;
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

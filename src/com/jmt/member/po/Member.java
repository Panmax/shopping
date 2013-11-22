package com.jmt.member.po;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4437571498321708135L;
             private  Integer  memberID ;        //会员ID
             private  String   memberName ;        //会员名
             private  String   memberPassword;     //会员密码
             private  String   memberEmail ;    //Email
             private  Integer  memberGrade;      // 会员等级
             private  Integer  memberAmount;     //消费额
             private  String   memberStatus ;    //会员状态 0表示冻结，1表示解冻
             private  Date     createDate  ;      //创建时间
             private   Date    updateDate  ;        //修改时间
			public Integer getMemberID() {
				return memberID;
			}
			public void setMemberID(Integer memberID) {
				this.memberID = memberID;
			}
			public String getMemberName() {
				return memberName;
			}
			public void setMemberName(String memberName) {
				this.memberName = memberName;
			}
			public String getMemberPassword() {
				return memberPassword;
			}
			public void setMemberPassword(String memberPassword) {
				this.memberPassword = memberPassword;
			}
			public String getMemberEmail() {
				return memberEmail;
			}
			public void setMemberEmail(String memberEmail) {
				this.memberEmail = memberEmail;
			}
			public Integer getMemberGrade() {
				return memberGrade;
			}
			public void setMemberGrade(Integer memberGrade) {
				this.memberGrade = memberGrade;
			}
			public Integer getMemberAmount() {
				return memberAmount;
			}
			public void setMemberAmount(Integer memberAmount) {
				this.memberAmount = memberAmount;
			}
			public String getMemberStatus() {
				return memberStatus;
			}
			public void setMemberStatus(String memberStatus) {
				this.memberStatus = memberStatus;
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

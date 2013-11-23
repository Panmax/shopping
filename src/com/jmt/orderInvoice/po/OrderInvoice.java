package com.jmt.orderInvoice.po;

import java.io.Serializable;

public class OrderInvoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7588919455058475675L;
	private Integer invoiceID; // 发票ID
	private String invoiceTitle; // 发票抬头
	private String invoiceContent; // 发票内容
	private Integer invoiceAmount; // 发票金额 --是购买的商品金额还是发票那张纸的价钱
	private String orderID; // 订单ID

	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public Integer getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Integer invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}

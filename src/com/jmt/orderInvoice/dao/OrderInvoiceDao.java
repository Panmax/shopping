package com.jmt.orderInvoice.dao;

import com.jmt.orderInvoice.po.OrderInvoice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午6:11
 * To change this template use File | Settings | File Templates.
 */
public interface OrderInvoiceDao {
    public boolean addOrderInvoice(OrderInvoice orderInvoice);
    public boolean deleteOrderInvoice(int invoiceID);
    public boolean updateOrderInvoice(OrderInvoice orderInvoice);
    public OrderInvoice getOrderInvoice(int invoiceID);
    public List<OrderInvoice> getAllOrderInvoice();
}

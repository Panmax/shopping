package com.jmt.orderDetail.dao;

import com.jmt.orderDetail.po.OrderDetail;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-27
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDetailDao {
    public boolean addOrderDetail(OrderDetail orderDetail);
    public boolean deleteOrderDetail(int id);
    public OrderDetail getOrderDetail(int id);
}

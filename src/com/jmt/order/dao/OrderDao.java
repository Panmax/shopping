package com.jmt.order.dao;

import com.jmt.order.po.Order;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午7:15
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {
    public boolean addOrder(Order order);
    public boolean deleteOrder(int OrderID);
}

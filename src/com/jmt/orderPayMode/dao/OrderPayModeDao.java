package com.jmt.orderPayMode.dao;

import com.jmt.orderPayMode.po.OrderPayMode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public interface OrderPayModeDao {
    public List<OrderPayMode> getAllOrderPayMode();
    public OrderPayMode getOrderPayMode(int payID);
}

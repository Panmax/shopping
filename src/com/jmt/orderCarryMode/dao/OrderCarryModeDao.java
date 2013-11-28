package com.jmt.orderCarryMode.dao;

import com.jmt.orderCarryMode.po.OrderCarryMode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午5:21
 * To change this template use File | Settings | File Templates.
 */
public interface OrderCarryModeDao {
    public List<OrderCarryMode> getAllOrderCarryMode();
    public OrderCarryMode getOrderCarryMode(int carryID);
}

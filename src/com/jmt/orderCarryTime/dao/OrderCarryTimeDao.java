package com.jmt.orderCarryTime.dao;

import com.jmt.orderCarryTime.po.OrderCarryTime;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */
public interface OrderCarryTimeDao {
    public List<OrderCarryTime> getAllOrderCarryTime();
    public OrderCarryTime getOrderCarryTime(int carryTimeID);
}

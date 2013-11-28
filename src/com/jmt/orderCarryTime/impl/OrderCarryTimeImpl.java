package com.jmt.orderCarryTime.impl;

import com.jmt.orderCarryTime.dao.OrderCarryTimeDao;
import com.jmt.orderCarryTime.po.OrderCarryTime;
import com.jmt.system.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
public class OrderCarryTimeImpl implements OrderCarryTimeDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<OrderCarryTime> getAllOrderCarryTime() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderCarryTime");
            rs = pstmt.executeQuery();
            List<OrderCarryTime> orderCarryTimes = new ArrayList<OrderCarryTime>();
            while (rs.next()) {
                OrderCarryTime orderCarryTime = new OrderCarryTime();
                orderCarryTime.setCarryTimeID(rs.getInt(1));
                orderCarryTime.setCarryTimeContent(rs.getString(2));
                orderCarryTimes.add(orderCarryTime);
            }
            return orderCarryTimes;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public OrderCarryTime getOrderCarryTime(int carryTimeID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderCarryTime where CarryTimeID=?");
            pstmt.setInt(1, carryTimeID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                OrderCarryTime orderCarryTime = new OrderCarryTime();
                orderCarryTime.setCarryTimeID(rs.getInt(1));
                orderCarryTime.setCarryTimeContent(rs.getString(2));
                return orderCarryTime;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;

        }
    }
}

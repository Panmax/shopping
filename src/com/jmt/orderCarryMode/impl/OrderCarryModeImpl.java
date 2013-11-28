package com.jmt.orderCarryMode.impl;

import com.jmt.orderCarryMode.dao.OrderCarryModeDao;
import com.jmt.orderCarryMode.po.OrderCarryMode;
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
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class OrderCarryModeImpl implements OrderCarryModeDao {
    private Connection conn  = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<OrderCarryMode> getAllOrderCarryMode() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderCarryMode");
            rs = pstmt.executeQuery();
            List<OrderCarryMode> orderCarryModes = new ArrayList<OrderCarryMode>();
            while (rs.next()) {
                OrderCarryMode orderCarryMode = new OrderCarryMode();
                orderCarryMode.setCarryID(rs.getInt(1));
                orderCarryMode.setCarryContent(rs.getString(2));
                orderCarryMode.setCarryDay(rs.getInt(3));
                orderCarryMode.setCarryDesc(rs.getString(4));
                orderCarryModes.add(orderCarryMode);
            }
            return orderCarryModes;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public OrderCarryMode getOrderCarryMode(int carryID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderCarryMode where CarryID=?");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                OrderCarryMode orderCarryMode = new OrderCarryMode();
                orderCarryMode.setCarryID(rs.getInt(1));
                orderCarryMode.setCarryContent(rs.getString(2));
                orderCarryMode.setCarryDay(rs.getInt(3));
                orderCarryMode.setCarryDesc(rs.getString(4));
                return orderCarryMode;
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

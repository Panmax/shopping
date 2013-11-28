package com.jmt.orderPayMode.impl;

import com.jmt.orderCarryMode.dao.OrderCarryModeDao;
import com.jmt.orderCarryMode.po.OrderCarryMode;
import com.jmt.orderPayMode.dao.OrderPayModeDao;
import com.jmt.orderPayMode.po.OrderPayMode;
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
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */
public class OrderPayModeImpl implements OrderPayModeDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<OrderPayMode> getAllOrderPayMode() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderPayMode");
            rs = pstmt.executeQuery();
            List<OrderPayMode> orderPayModes = new ArrayList<OrderPayMode>();
            while (rs.next()) {
                OrderPayMode orderPayMode = new OrderPayMode();
                orderPayMode.setPayID(rs.getInt(1));
                orderPayMode.setPayContent(rs.getString(2));
                orderPayMode.setPayDesc(rs.getString(3));
            }
            return orderPayModes;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public OrderPayMode getOrderPayMode(int payID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderPayMode where PayID=?");
            pstmt.setInt(1, payID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                OrderPayMode orderPayMode = new OrderPayMode();
                orderPayMode.setPayID(rs.getInt(1));
                orderPayMode.setPayContent(rs.getString(2));
                orderPayMode.setPayDesc(rs.getString(3));
                return orderPayMode;
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

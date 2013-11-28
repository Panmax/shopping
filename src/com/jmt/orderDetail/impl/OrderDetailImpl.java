package com.jmt.orderDetail.impl;

import com.jmt.orderDetail.dao.OrderDetailDao;
import com.jmt.orderDetail.po.OrderDetail;
import com.jmt.system.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-27
 * Time: 上午11:02
 * To change this template use File | Settings | File Templates.
 */
public class OrderDetailImpl implements OrderDetailDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("insert into T_OrderDetail values (seq_T_OrderDetail.nextVal, ?,?,?,?,?)");
            pstmt.setString(1, orderDetail.getOrderID());
            pstmt.setInt(2, orderDetail.getGoodsID());
            pstmt.setString(3, orderDetail.getGoodsName());
            pstmt.setDouble(4, orderDetail.getGoodsPrice());
            pstmt.setInt(5, orderDetail.getGoodsCount());

            int count = pstmt.executeUpdate();
            if (count>0) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
    }

    @Override
    public boolean deleteOrderDetail(int id) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("delete from T_OrderDetail where ID=?");
            pstmt.setInt(1, id);

            int count = pstmt.executeUpdate();
            if (count>0) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
    }

    @Override
    public OrderDetail getOrderDetail(int id) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderDetail where ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            OrderDetail orderDetail = new OrderDetail();
            if (rs.next()) {
                orderDetail.setId(id);
                orderDetail.setOrderID(rs.getString(2));
                orderDetail.setGoodsID(rs.getInt(3));
                orderDetail.setGoodsPrice(rs.getDouble(4));
                orderDetail.setGoodsCount(rs.getInt(5));
            }
            return orderDetail;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }
}

package com.jmt.order.impl;

import com.jmt.order.dao.OrderDao;
import com.jmt.order.po.Order;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
public class OrderDaoImpl implements OrderDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public boolean addOrder(Order order) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("insert into T_Order values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, order.getOrderID());
            pstmt.setInt(2, order.getMemberID());
            pstmt.setString(3, order.getMemberTrueName());
            pstmt.setString(4, order.getMemberAddress());
            pstmt.setString(5, order.getMemberProvince());
            pstmt.setString(6, order.getMemberCity());
            pstmt.setString(7, order.getMemberArea());
            pstmt.setString(8, order.getMemberPostcode());
            pstmt.setString(9, order.getMemberTelephone());
            pstmt.setDouble(10, order.getOrderAmount());
            pstmt.setInt(11, order.getOrderPay());
            pstmt.setInt(12, order.getOrderInvoice());
            pstmt.setInt(13, order.getOrderCarry());
            pstmt.setInt(14, order.getOrderCarryTime());
            pstmt.setString(15, order.getOrderRemark());
            pstmt.setInt(16, order.getOrderStatus());
            pstmt.setDate(17, Date.valueOf(DateUtil.dateToString(order.getCreateDate())));
            pstmt.setDate(18, Date.valueOf(DateUtil.dateToString(order.getUpdateDate())));

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
    public boolean deleteOrder(int OrderID) {
        //在server层检测是否发货
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("delete from T_Order where OrderID=?");
            pstmt.setInt(1, OrderID);

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
}

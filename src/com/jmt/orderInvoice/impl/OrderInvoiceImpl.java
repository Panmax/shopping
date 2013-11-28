package com.jmt.orderInvoice.impl;

import com.jmt.orderInvoice.dao.OrderInvoiceDao;
import com.jmt.orderInvoice.po.OrderInvoice;
import com.jmt.system.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class OrderInvoiceImpl implements OrderInvoiceDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public boolean addOrderInvoice(OrderInvoice orderInvoice) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("insert into T_OrderInvoice values (?,?,?,?,?)");
            pstmt.setInt(1, orderInvoice.getInvoiceID());
            pstmt.setString(2, orderInvoice.getInvoiceTitle());
            pstmt.setString(3, orderInvoice.getInvoiceContent());
            pstmt.setDouble(4, orderInvoice.getInvoiceAmount());
            pstmt.setString(5, orderInvoice.getOrderID());

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
    public boolean deleteOrderInvoice(int invoiceID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("delete from T_OrderInvoice where InvoiceID=?");
            pstmt.setInt(1, invoiceID);

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
    public boolean updateOrderInvoice(OrderInvoice orderInvoice) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OrderInvoice getOrderInvoice(int invoiceID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_OrderInvoice where InvoiceID=?");
            pstmt.setInt(1, invoiceID);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                OrderInvoice orderInvoice = new OrderInvoice();
                orderInvoice.setInvoiceID(rs.getInt(1));
                orderInvoice.setInvoiceTitle(rs.getString(2));
                orderInvoice.setInvoiceContent(rs.getString(3));
                orderInvoice.setInvoiceAmount(rs.getDouble(4));
                orderInvoice.setOrderID(rs.getString(5));
                return orderInvoice;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public List<OrderInvoice> getAllOrderInvoice() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

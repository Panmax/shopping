package com.jmt.goods.impl;

import com.jmt.goods.dao.GoodsDao;
import com.jmt.goods.po.Goods;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class GoodsDaoImpl implements GoodsDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public boolean addGoods(Goods goods) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("insert into T_Goods values (seq_T_Goods.Nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, goods.getGoodsName());
            pstmt.setString(2, goods.getGoodsIntroduce());
            pstmt.setDouble(3, goods.getGoodsNormalPrice());
            pstmt.setDouble(4, goods.getGoodsMemberPrice());
            pstmt.setDouble(5, goods.getGoodsRebate());
            pstmt.setString(6, goods.getTypeCode());
            pstmt.setInt(7, goods.getGoodsNumber());
            pstmt.setInt(8, goods.getGoodsGrade());
            pstmt.setInt(9, goods.getIsSale());
            pstmt.setInt(10, goods.getIsValid());
            pstmt.setString(11, goods.getGoodsPicture());
            pstmt.setInt(12, goods.getBuycount());
            pstmt.setString(13, goods.getCreater());
            pstmt.setDate(14, Date.valueOf(DateUtil.dateToString(goods.getCreateDate())));
            pstmt.setString(15, goods.getUpdater());
            pstmt.setDate(16, Date.valueOf(DateUtil.dateToString(goods.getUpdateDate())));
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
    public boolean updateGoods(Goods goods) {
        conn = DB.getConn();
        String sql = "update T_Goods set GoodsName=?, GoodsIntroduce=?,GoodsNormalPrice=?, GoodsMemberPrice=?," +
                "GoodsRebate=?, TypeCode=?, GoodsNumber=?, GoodsGrade=?, isSale=?, isValid=?, GoodsPicture=?, buycount=?" +
                "Creater=?, CreateDate=?, Updater=?, UpdateDate=? where GoodsID=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goods.getGoodsName());
            pstmt.setString(2, goods.getGoodsIntroduce());
            pstmt.setDouble(3, goods.getGoodsNormalPrice());
            pstmt.setDouble(4, goods.getGoodsMemberPrice());
            pstmt.setDouble(5, goods.getGoodsRebate());
            pstmt.setString(6, goods.getTypeCode());
            pstmt.setInt(7, goods.getGoodsNumber());
            pstmt.setInt(8, goods.getGoodsGrade());
            pstmt.setInt(9, goods.getIsSale());
            pstmt.setInt(10, goods.getIsValid());
            pstmt.setString(11, goods.getGoodsPicture());
            pstmt.setInt(12, goods.getBuycount());
            pstmt.setString(13, goods.getCreater());
            pstmt.setDate(14, Date.valueOf(DateUtil.dateToString(goods.getCreateDate())));
            pstmt.setString(15, goods.getUpdater());
            pstmt.setDate(16, Date.valueOf(DateUtil.dateToString(goods.getUpdateDate())));
            pstmt.setInt(17, goods.getGoodsID());

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
    public Goods getGoods(int id) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_Goods where GoodsID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsID(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsIntroduce(rs.getString(3));
                goods.setGoodsNormalPrice(rs.getDouble(4));
                goods.setGoodsMemberPrice(rs.getDouble(5));
                goods.setGoodsRebate(rs.getDouble(6));
                goods.setTypeCode(rs.getString(7));
                goods.setGoodsNumber(rs.getInt(8));
                goods.setGoodsGrade(rs.getInt(9));
                goods.setIsSale(rs.getInt(10));
                goods.setIsValid(rs.getInt(11));
                goods.setGoodsPicture(rs.getString(12));
                goods.setBuycount(rs.getInt(13));
                goods.setCreater(rs.getString(14));
                goods.setCreateDate(rs.getDate(15));
                goods.setUpdater(rs.getString(16));
                goods.setUpdateDate(rs.getDate(17));
                return goods;
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
    public boolean deleteGoods(int id) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("delete from T_Goods where GoodsID=?");
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
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isExsit(String goodsName) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_Goods where GoodsName=?");
            pstmt.setString(1, goodsName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return true;
        }
    }


    @Override
    public List<Goods> getSalesGoods() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_Goods where isSale=1 and isValid=1");
            rs = pstmt.executeQuery();
            List<Goods> goodsList = new ArrayList<Goods>();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsID(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsIntroduce(rs.getString(3));
                goods.setGoodsNormalPrice(rs.getDouble(4));
                goods.setGoodsMemberPrice(rs.getDouble(5));
                goods.setGoodsRebate(rs.getDouble(6));
                goods.setTypeCode(rs.getString(7));
                goods.setGoodsNumber(rs.getInt(8));
                goods.setGoodsGrade(rs.getInt(9));
                goods.setIsSale(rs.getInt(10));
                goods.setIsValid(rs.getInt(11));
                goods.setGoodsPicture(rs.getString(12));
                goods.setBuycount(rs.getInt(13));
                goods.setCreater(rs.getString(14));
                goods.setCreateDate(rs.getDate(15));
                goods.setUpdater(rs.getString(16));
                goods.setUpdateDate(rs.getDate(17));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public List<Goods> getValidGoods() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_Goods where isValid=1");
            rs = pstmt.executeQuery();
            List<Goods> goodsList = new ArrayList<Goods>();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsID(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsIntroduce(rs.getString(3));
                goods.setGoodsNormalPrice(rs.getDouble(4));
                goods.setGoodsMemberPrice(rs.getDouble(5));
                goods.setGoodsRebate(rs.getDouble(6));
                goods.setTypeCode(rs.getString(7));
                goods.setGoodsNumber(rs.getInt(8));
                goods.setGoodsGrade(rs.getInt(9));
                goods.setIsSale(rs.getInt(10));
                goods.setIsValid(rs.getInt(11));
                goods.setGoodsPicture(rs.getString(12));
                goods.setBuycount(rs.getInt(13));
                goods.setCreater(rs.getString(14));
                goods.setCreateDate(rs.getDate(15));
                goods.setUpdater(rs.getString(16));
                goods.setUpdateDate(rs.getDate(17));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public List<Goods> getNewGoods() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Goods> getAllGoods() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_Goods");
            rs = pstmt.executeQuery();
            List<Goods> goodsList = new ArrayList<Goods>();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsID(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsIntroduce(rs.getString(3));
                goods.setGoodsNormalPrice(rs.getDouble(4));
                goods.setGoodsMemberPrice(rs.getDouble(5));
                goods.setGoodsRebate(rs.getDouble(6));
                goods.setTypeCode(rs.getString(7));
                goods.setGoodsNumber(rs.getInt(8));
                goods.setGoodsGrade(rs.getInt(9));
                goods.setIsSale(rs.getInt(10));
                goods.setIsValid(rs.getInt(11));
                goods.setGoodsPicture(rs.getString(12));
                goods.setBuycount(rs.getInt(13));
                goods.setCreater(rs.getString(14));
                goods.setCreateDate(rs.getDate(15));
                goods.setUpdater(rs.getString(16));
                goods.setUpdateDate(rs.getDate(17));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }
}

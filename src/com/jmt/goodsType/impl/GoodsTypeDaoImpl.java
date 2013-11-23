package com.jmt.goodsType.impl;

import com.jmt.goodsType.dao.GoodsTypeDao;
import com.jmt.goodsType.po.GoodsType;
import com.jmt.system.db.DB;
import com.jmt.system.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-23
 * Time: 下午5:14
 * To change this template use File | Settings | File Templates.
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public boolean addGoodsType(GoodsType goodsType) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("insert into T_GoodsType values (seq_T_GoodsType.Nextval,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, goodsType.getTypeCode());
            pstmt.setString(2, goodsType.getTypeName());
            pstmt.setString(3, goodsType.getTypeDesc());
            pstmt.setInt(4, goodsType.getIsLeaf());
            pstmt.setInt(5, goodsType.getParentID());
            pstmt.setInt(6, goodsType.getTypeLevel());
            pstmt.setString(7, goodsType.getCreater());
            pstmt.setDate(8, Date.valueOf(DateUtil.dateToString(goodsType.getCreateDate())));
            pstmt.setString(9, goodsType.getUpdater());
            pstmt.setDate(10, Date.valueOf(DateUtil.dateToString(goodsType.getUpdateDate())));

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
    public boolean isExsit(String typeName) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_GoodsType where TypeName=?");
            pstmt.setString(1, typeName);
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
    public boolean deleteGoodsType(int typeId) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("delete from T_GoodsType where TypeID=?");
            pstmt.setInt(1, typeId);

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
    public boolean updateGoodsType(GoodsType goodsType) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("update T_GoodsType set TypeCode=?,TypeName=?,TypeDesc=?,isLeaf=?," +
                    "ParentID=?,TypeLevel=?,Creater=?,CreateDate=?,Updater=?,UpdateDate=? where TypeID=?");
            pstmt.setString(1, goodsType.getTypeCode());
            pstmt.setString(2, goodsType.getTypeName());
            pstmt.setString(3, goodsType.getTypeDesc());
            pstmt.setInt(4, goodsType.getIsLeaf());
            pstmt.setInt(5, goodsType.getParentID());
            pstmt.setInt(6, goodsType.getTypeLevel());
            pstmt.setString(7, goodsType.getCreater());
            pstmt.setDate(8, Date.valueOf(DateUtil.dateToString(goodsType.getCreateDate())));
            pstmt.setString(9, goodsType.getUpdater());
            pstmt.setDate(10, Date.valueOf(DateUtil.dateToString(goodsType.getUpdateDate())));

            pstmt.setInt(11, goodsType.getTypeID());

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
    public List<GoodsType> getBigType() {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_GoodsType where typeLevel=1");
            rs = pstmt.executeQuery();
            List<GoodsType> goodsTypeList = new ArrayList<GoodsType>();
            while (rs.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setTypeID(rs.getInt(1));
                goodsType.setTypeCode(rs.getString(2));
                goodsType.setTypeName(rs.getString(3));
                goodsType.setTypeDesc(rs.getString(4));
                goodsType.setIsLeaf(rs.getInt(5));
                goodsType.setParentID(rs.getInt(6));
                goodsType.setTypeLevel(rs.getInt(7));
                goodsType.setCreater(rs.getString(8));
                goodsType.setCreateDate(rs.getDate(9));
                goodsType.setUpdater(rs.getString(10));
                goodsType.setUpdateDate(rs.getDate(11));
                goodsTypeList.add(goodsType);
            }
            return goodsTypeList;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public List<GoodsType> getLittleType(int typeID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_GoodsType where ParentID=?");
            GoodsType goodsType = getGoodsType(typeID);
            pstmt.setInt(1, goodsType.getTypeID());
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public GoodsType getGoodsType(int typeID) {
        conn = DB.getConn();
        try {
            pstmt = conn.prepareStatement("select * from T_GoodsType where TypeID=?");
            pstmt.setInt(1, typeID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setTypeID(rs.getInt(1));
                goodsType.setTypeCode(rs.getString(2));
                goodsType.setTypeName(rs.getString(3));
                goodsType.setTypeDesc(rs.getString(4));
                goodsType.setIsLeaf(rs.getInt(5));
                goodsType.setParentID(rs.getInt(6));
                goodsType.setTypeLevel(rs.getInt(7));
                goodsType.setCreater(rs.getString(8));
                goodsType.setCreateDate(rs.getDate(9));
                goodsType.setUpdater(rs.getString(10));
                goodsType.setUpdateDate(rs.getDate(11));
                return goodsType;
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

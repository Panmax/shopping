package com.jmt.goodsType.dao;

import com.jmt.goodsType.po.GoodsType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-23
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public interface GoodsTypeDao {
    public boolean addGoodsType(GoodsType goodsType);
    public boolean isExsit(String typeName);
    public boolean deleteGoodsType(int typeId);
    public boolean updateGoodsType(GoodsType goodsType);
    public List<GoodsType> getBigType();//获取大类
    public List<GoodsType> getLittleType(int typeID);//获取大类下的小类
    public GoodsType getGoodsType(int typeID);
}

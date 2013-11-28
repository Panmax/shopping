package com.jmt.area.dao;

import com.jmt.area.po.Area;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-24
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */
public interface AreaDao {
    public List<Area> getAreaByCityID(int cityID);
}

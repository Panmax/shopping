package com.jmt.city.dao;

import com.jmt.city.po.City;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-24
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public interface CityDao {
    public List<City> getCityByProvinceID(int provinceID);
}

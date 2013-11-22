package com.jmt.advertise.dao;

import java.util.List;

import com.jmt.advertise.po.Advertise;

public interface AdvertiseDao {
	public boolean addAdvertise(Advertise advertise);
	public boolean updateAdvertise(Advertise advertise);
	public Advertise getAdvertise(int id);
	public boolean deleteAdvertise(int id);
	public boolean isExsit(String advertiseTitle);
	public List<Advertise> getValiAdvertise();//获取未失效的广告
	public List<Advertise> getAllAdvertise();//获取所有广告
}

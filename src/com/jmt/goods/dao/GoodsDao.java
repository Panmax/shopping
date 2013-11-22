package com.jmt.goods.dao;

import java.util.List;

import com.jmt.goods.po.Goods;

public interface GoodsDao {
	public boolean addGoods(Goods goods);
	public boolean updateGoods(Goods goods);
	public Goods getGoods(int id);
	public boolean deleteGoods(int id);
	public boolean goodsName(String goodsName);
	public List<Goods> getSalesGoods();
	public List<Goods> getValidGoods();
	public List<Goods> getNewGoods();
	public List<Goods> getAllGoods();
}

package com.jmt.favorits.dao;

import com.jmt.favorits.po.Favorits;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-24
 * Time: 上午10:01
 * To change this template use File | Settings | File Templates.
 */
public interface FavoritsDao {
    public boolean addFavorits(Favorits favorits);
    public boolean deleteFavorits(int ID);
    public List<Favorits> getFavoritsByMemberID(int MemberID);
    public boolean isExsit(Favorits favorits);
}

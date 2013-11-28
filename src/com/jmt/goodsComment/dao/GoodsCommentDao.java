package com.jmt.goodsComment.dao;

import com.jmt.goodsComment.po.GoodsComment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-24
 * Time: 上午9:56
 * To change this template use File | Settings | File Templates.
 */
public interface GoodsCommentDao {
    public boolean addGoodsComment(GoodsComment goodsComment);
    public boolean deleteGoodscomment(int commentID);
    public List<GoodsComment> getGoodsCommentByGoodsId(int goodsID);
    public boolean isExsit(GoodsComment goodsComment);
}

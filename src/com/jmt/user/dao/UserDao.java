package com.jmt.user.dao;

import com.jmt.user.po.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public User getUser(int id);
	public boolean deleteUser(int id);//删除成功返回true，失败返回false
	public boolean isExsit(String userName);//存在返回true
	public boolean checkUser(String userName, String userPassword);//检测成功返回true,失败返回false


}

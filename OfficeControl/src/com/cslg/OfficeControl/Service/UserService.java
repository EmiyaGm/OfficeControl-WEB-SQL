package com.cslg.OfficeControl.Service;

import java.util.List;

import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Util.Page;

public interface UserService {
	/**
	 * 用户登录检查
	 * @param user
	 * @return
	 */
	public User login(User user);

	/**
	 * 管理员更改用户的信息
	 * @param user
	 */
	public boolean saveUser(User user);
	/**
	 * 用户更改自己的信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	/**
	 * 显示所有用户
	 * @return
	 */
	public List<User> showAll();

	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 */
	public User findById(int id);

	/**
	 * 根据id删除用户信息
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * 添加新用户
	 * @param user
	 * @throws Exception 
	 */
	public void addUser(User user) ;

	/**
	 * 分页
	 * @param beginPage	开始页数
	 * @param everyPage	每页显示的个数
	 * @return
	 */
	public Page getPage(int beginPage, int everyPage);
}

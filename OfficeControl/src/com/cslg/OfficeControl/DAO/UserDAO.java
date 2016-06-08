package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.User;

public interface UserDAO {
	
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException
	 * @throws Exception 
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteUser(int id) throws SQLException;
	
	/**
	 * 更新用户
	 * @param user
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public void updateUser(User user) throws Exception;
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User findUserById(int id) throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * 查找所有用户
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<User> findAllUser() throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * 根据登录名查找用户
	 * @param userName
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User findUserByUserName(String userName) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * 根据id保存用户信息
	 * @param user
	 * @throws SQLException 
	 */
	public void saveUser(User user) throws SQLException;

	/**
	 * 分页
	 * @param beginPage
	 * @param everyPage
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<User> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * 获得总用户数
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int getCount() throws ClassNotFoundException, SQLException, IOException;
}

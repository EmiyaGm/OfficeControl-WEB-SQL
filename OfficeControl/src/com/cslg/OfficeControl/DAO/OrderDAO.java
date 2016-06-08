package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Order;

public interface OrderDAO {
	
	/**
	 * 添加指令
	 * @param order
	 * @throws SQLException 
	 */
	public void addOrder(Order order) throws SQLException;

	/**
	 * 根据id删除指令
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteOrder(int id) throws SQLException;
	
	/**
	 * 更新指令
	 * @param order
	 * @throws SQLException 
	 */
	public void updateOrder(Order order) throws SQLException;
	
	/**
	 * 查询指令
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Order findOrder(int id) throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * 查询所有指令
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Order> findAllOrder() throws ClassNotFoundException, SQLException, IOException;
}

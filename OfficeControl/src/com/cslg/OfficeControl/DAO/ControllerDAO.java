package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.PO.Order;

public interface ControllerDAO {
	
	/**
	 * 添加控制
	 * @param controller
	 * @throws SQLException 
	 */
	public void addController(Controller controller) throws SQLException;

	/**
	 * 删除控制
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteController(int id) throws SQLException;
	
	/**
	 * 更新控制
	 * @param controller
	 * @throws SQLException 
	 */
	public void updateController(Controller controller) throws SQLException;
	
	public void updateData(Controller controller) throws SQLException;
	
	public Controller findControllerById(int id) throws ClassNotFoundException, SQLException, IOException;
	/**
	 * 查询控制
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Controller> findControllerByUser(int id) throws ClassNotFoundException, SQLException, IOException;
	
	/**
	 * 查询所有控制
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Controller> findAllController() throws ClassNotFoundException, SQLException, IOException;

	public List<Gather> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException;

	public int getCount() throws ClassNotFoundException, SQLException, IOException;

	public void addOrder(Order order) throws SQLException;

	public Controller findControllerByName(String name) throws ClassNotFoundException, SQLException, IOException;

	public void updateDataByName(Controller controller) throws SQLException;
}
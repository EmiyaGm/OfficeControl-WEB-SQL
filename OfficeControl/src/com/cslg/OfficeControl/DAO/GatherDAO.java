package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Gather;

public interface GatherDAO {
	
	/**
	 * 添加采集
	 * @param gather
	 * @throws SQLException 
	 */
	public void addGather(Gather gather) throws SQLException;
	
	/**
	 * 删除采集
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteGather(int id) throws SQLException;
	
	/**
	 * 更新采集
	 * @param gather
	 * @throws SQLException 
	 */
	public void updateGather(Gather gather) throws SQLException;
	
	/**
	 * 查询采集
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	/*public Gather findGather(int id) throws ClassNotFoundException, SQLException, IOException;*/
	
	/**
	 * 查询所有采集
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Gather> findAllGather() throws ClassNotFoundException, SQLException, IOException;

	/**
	 * 查询该用户id所对应的采集器
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Gather> findGatherByUserId(int id) throws ClassNotFoundException, SQLException, IOException;

	public List<Gather> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException;

	public int getCount() throws ClassNotFoundException, SQLException, IOException;

}

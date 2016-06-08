package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.PO.Order;

public class ControllerDAOImpl implements ControllerDAO, RowMapper {

	private JdbcHelper helper;
	
	public ControllerDAOImpl() {
		helper = new JdbcHelper();
	}
	@Override
	public void addController(Controller controller) throws SQLException {
		String sql ="insert into controller (name,userId) value (?,?)";
		Object []args={controller.getName(),controller.getUserId()};
		helper.executeUpdate(sql, args);
	}

	@Override
	public void deleteController(int id) throws SQLException {
		String sql ="delete from controller where id =?";
		Object [] args={id};
		helper.executeUpdate(sql, args);
	}

	@Override
	public void updateController(Controller controller) throws SQLException {
		String sql = "update controller set name = ? where id = ?";
		Object [] args={controller.getName(),controller.getId()};
			helper.executeUpdate(sql, args);
	}
	
	@Override
	public Controller findControllerById(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from controller where id = ?";
		Object []args={id};
		@SuppressWarnings("unchecked")
		List<Controller> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (Controller) list.get(0);  // NOPMD by john on 6/5/16 5:54 PM
	}
		
	@Override
	public List<Controller> findControllerByUser(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from controller where userId = ? ";
		Object []args={id};
		@SuppressWarnings("unchecked")
		List<Controller> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Controller> findAllController() throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from controller";
		Object[]args={};
		return helper.executeQuery(sql, args, this);
	}
	@Override
	public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
		Controller controller =new Controller();
		controller.setId(rs.getInt("controller.id"));
		controller.setName(rs.getString("controller.name"));
		controller.setTemp(rs.getInt("controller.temp"));
		controller.setKind(rs.getInt("controller.kind"));
		controller.setStatus(rs.getInt("controller.status"));
		controller.setUserId(rs.getInt("controller.userId"));
		return controller;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Gather> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException {
		String sql;
	    Object []args={(beginPage-1)*everyPage, everyPage};
	    sql ="select * from controller order by id desc limit ?,?";
		return helper.executeQuery(sql, args, this);
	}
	@Override
	public int getCount() throws ClassNotFoundException, SQLException, IOException {
		String sql = "select count(*) from controller";
		Object []args={};
		return  (int) helper.executeQuery(sql, args, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
				int count;
				count = rs.getInt(1);
				return count;
			}
		}).get(0);
	}
	@Override
	public void updateData(Controller controller) throws SQLException {
		String sql = "update controller set temp = ? ,kind=? , status=?  where id = ?";
		Object [] args={controller.getTemp(),controller.getKind(),controller.getStatus(),controller.getId()};
			helper.executeUpdate(sql, args);
	}
	
	@Override
	
	public void addOrder(Order order) throws SQLException {
		String sql ="insert into `order` (name,comd) value(?,?)";
		Object []args={order.getName(),order.getComd()};
		helper.executeUpdate(sql, args);
	}
	@Override
	public Controller findControllerByName(String name)throws ClassNotFoundException, SQLException, IOException  {
		String sql ="select * from controller where name = ?";
		Object []args={name};
		@SuppressWarnings("unchecked")
		List<Controller> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (Controller) list.get(0);
	}
	@Override
	public void updateDataByName(Controller controller) throws SQLException {
		String sql = "update controller set temp = ? ,kind=? , status=?  where name = ?";
		Object [] args={controller.getTemp(),controller.getKind(),controller.getStatus(),controller.getName()};
			helper.executeUpdate(sql, args);
		
	}
}

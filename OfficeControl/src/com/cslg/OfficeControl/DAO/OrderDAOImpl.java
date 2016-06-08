package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Order;

public class OrderDAOImpl implements OrderDAO, RowMapper {

	private JdbcHelper helper;
	
	public OrderDAOImpl() {
		helper = new JdbcHelper();
	}
	
	@Override
	public void addOrder(Order order) throws SQLException {
		String sql ="insert into `order` (name,comd) value (?,?)";
		Object []args={order.getName(),order.getComd()};
		helper.executeUpdate(sql, args);

	}

	@Override
	public void deleteOrder(int id) throws SQLException {
		String sql ="delete from order where id =?";
		Object [] args={id};
		helper.executeUpdate(sql, args);

	}

	@Override
	public void updateOrder(Order order) throws SQLException {
		String sql = "update order set name = ?,comd = ? ";
		Object [] args={order.getName(),order.getComd()};
			helper.executeUpdate(sql, args);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Order findOrder(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from order where id = ?";
		Object []args={id};
		List<Order> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (Order) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrder() throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from order";
		Object[]args={};
		return helper.executeQuery(sql, args, this);
	}

	@Override
	public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
		Order order =new Order();
		order.setId(rs.getInt("order.id"));
		order.setName(rs.getString("rs.name"));
		order.setComd(rs.getString("rs.comd"));
		return order;
	}

}

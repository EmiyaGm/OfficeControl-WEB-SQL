package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Util.MD5;
import com.cslg.OfficeControl.DAO.RowMapper;

public class UserDAOImpl implements UserDAO, RowMapper {

	private JdbcHelper helper;
	
	public UserDAOImpl() {
		helper = new JdbcHelper();
	}
	
	@Override
	public void addUser(User user) throws Exception {
		String sql ="insert into user (userName,name,addr,phone,password,isSuper) value (?,?,?,?,?,?)";
		Object []args={
				user.getUserName(),
				user.getName(),
				user.getAddress(),
				user.getPhone(),
				MD5.md5(user.getPassword()),
				(user.isSuper()?1:0)};
		helper.executeUpdate(sql, args);
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		String sql ="delete from user where id =?";
		Object [] args={id};
		helper.executeUpdate(sql, args);
	}

	@Override
	public void updateUser(User user) throws Exception {
		String sql = "update user set userName = ?,name = ?,addr = ?,phone = ? where id=?";
		Object [] args={user.getUserName(),user.getName(),user.getAddress(),user.getPhone(),user.getId()};
			helper.executeUpdate(sql, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserById(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from user where id = ?";
		Object []args={id};
		List<User> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (User) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from user";
		Object[]args={};
		return helper.executeQuery(sql, args, this);
	}

	@Override
	public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
		User user =new User();
		user.setId(rs.getInt("user.id"));
		user.setUserName(rs.getString("user.userName"));
		user.setName(rs.getString("user.name"));
		user.setAddress(rs.getString("user.addr"));
		user.setPhone(rs.getString("user.phone"));
		user.setPassword(rs.getString("user.password"));
		user.setSuper((rs.getInt("user.isSuper") == 1)?true:false);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUserName(String userName) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from user where userName = ?";
		Object []args={userName};
		List<User> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (User) list.get(0);
	}

	@Override
	public void saveUser(User user) throws SQLException {
		String sql = "update user set userName = ?,name = ?,addr = ?,phone = ? where id = ?";
		Object [] args={user.getUserName(),user.getName(),user.getAddress(),user.getPhone(),user.getId()};
		helper.executeUpdate(sql, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException {
		String sql;
	    Object []args={0,(beginPage-1)*everyPage, everyPage};
	    sql ="select * from user where isSuper = ? order by id desc limit ?,?";
		return helper.executeQuery(sql, args, this);
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException, IOException {
		String sql = "select count(*) from user where isSuper = ?";
		Object []args={0};
		return  (int) helper.executeQuery(sql, args, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
				int count;
				count = rs.getInt(1);
				return count;
			}
		}).get(0);
	}

}

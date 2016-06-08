package com.cslg.OfficeControl.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.PO.Gather;

public class GatherDAOImpl implements GatherDAO, RowMapper {

	private JdbcHelper helper;
	
	public GatherDAOImpl() {
		helper = new JdbcHelper();
	}
	
	@Override
	public void addGather(Gather gather) throws SQLException {
		String sql ="insert into gather (name,userId) value (?,?)";
		Object []args={
						gather.getName(),
						gather.getUserId()};
		helper.executeUpdate(sql, args);

	}

	@Override
	public void deleteGather(int id) throws SQLException {
		String sql ="delete from gather where id =?";
		Object [] args={id};
		helper.executeUpdate(sql, args);

	}

	@Override
	public void updateGather(Gather gather) throws SQLException {
		String sql = "update gather set name = ? where id = ?";
		Object [] args={
						gather.getName(),
						gather.getId()};
			helper.executeUpdate(sql, args);

	}

	
	public Gather findGather(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from gather where id = ?";
		Object []args={id};
		@SuppressWarnings("unchecked")
		List<Gather> list=helper.executeQuery(sql, args, this);
	    if(list.isEmpty())
	    	return null;
	    else
	    	return (Gather) list.get(0);
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Gather> findAllGather() throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from gather";
		Object[]args={};
		return helper.executeQuery(sql, args, this);
	}

	@Override
	public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException {
		Gather gather =new Gather();
		gather.setId(rs.getInt("gather.id"));
		gather.setName(rs.getString("gather.name"));
		gather.setInTemp(rs.getFloat("gather.inTemp"));
		gather.setOutTemp(rs.getFloat("gather.outTemp"));
		gather.setTemp(rs.getFloat("gather.temp"));
		gather.setHumans(rs.getInt("gather.humans"));
		gather.setHumidity(rs.getFloat("gather.humidity"));
		gather.setLight(rs.getFloat("gather.light"));
		gather.setUserId(rs.getInt("gather.userId"));
		return gather;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gather> findGatherByUserId(int id) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select * from gather where userId = ?";
		Object[]args={id};
		return helper.executeQuery(sql, args, this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gather> getPage(int beginPage, int everyPage) throws ClassNotFoundException, SQLException, IOException {
		String sql;
	    Object []args={(beginPage-1)*everyPage, everyPage};
	    sql ="select * from gather order by id desc limit ?,?";
		return helper.executeQuery(sql, args, this);
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException, IOException {
		String sql = "select count(*) from gather";
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

}

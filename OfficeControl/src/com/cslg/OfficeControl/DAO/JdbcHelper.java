
package com.cslg.OfficeControl.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cslg.OfficeControl.Util.DBFactory;

/**
 * 
 */
public class JdbcHelper {
    private String url;// = "jdbc:mysql://localhost/course11";
    private String user;// = "labcourse";
    private String password;// = "labcourse";   
    private Connection connection;
    private DBFactory dbFactory;
    /**
     * 
     * @param 
     */
    public JdbcHelper(){
    	dbFactory = new DBFactory();
    }
    
    public JdbcHelper(String url,String user, String password ) throws IOException {
//        this.password=password;
//        this.url=url;
//        this.user=user;
    	
    }
    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
        //是否可以建立连接
        	connection = dbFactory.getConnection();
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    public void executeUpdate(String sql, Object[] args) throws SQLException {
        openConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        ps.executeUpdate();
        ps.close();
        closeConnection();
    }
    
    /**
     * 返回刚刚添加进去的那条记录对应的id值
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public int executeUpdateGetId(String sql, Object[] args) throws SQLException {
        openConnection();
        PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int id;
        if(rs.next()){
        	id = rs.getInt(1);
        }
        else {
			id = 0;
		}
        ps.close();
        closeConnection();
        return id;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List executeQuery(String sql, Object[] args, RowMapper rowMapper) throws SQLException, ClassNotFoundException, IOException {
        openConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        List list = new ArrayList();
        while (rs.next()) {
            Object o = rowMapper.mapRow(rs);
            list.add(o);
        }
        rs.close();
        ps.close();
        closeConnection();
        return list;
    }
    
    public int executeCount(String sql ,Object[] args) throws SQLException{
      	 openConnection();
           PreparedStatement ps = connection.prepareStatement(sql);
           if (args != null) {
               for (int i = 0; i < args.length; i++) {
                   ps.setObject(i + 1, args[i]);
               }
           }
           ResultSet rs = ps.executeQuery();
           rs.last();
           return rs.getRow();
      }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

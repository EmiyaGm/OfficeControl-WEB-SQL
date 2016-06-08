package com.cslg.OfficeControl.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBFactory {
	private static DBFactory instance = null;
	  public static Log log = LogFactory.getLog(DBFactory.class);
	   
	  public DBFactory()
	  {
	    try
	    {
	      Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
	    }
	    catch (ClassNotFoundException e)
	    {
	      log.error(e.getLocalizedMessage(), e);
	    }
	  }
	   
	  public static DBFactory getInstance()
	  {
	    if (instance == null) {
	      synchronized (DBFactory.class)
	      {
	        if (instance == null) {
	          instance = new DBFactory();
	        }
	      }
	    }
	    return instance;
	  }
	   
	  public Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      conn = DriverManager.getConnection("proxool.mysql");
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	    return conn;
	  }
	   
	  public static void quietClose(Connection sqlConn)
	  {
	    if (sqlConn != null) {
	      try
	      {
	        sqlConn.close();
	      }
	      catch (SQLException e)
	      {
	        e.printStackTrace();
	        log.error(e.getLocalizedMessage(), e);
	      }
	    }
	  }
}

package com.cslg.OfficeControl.DAO;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * RowMapper
 */
public interface RowMapper {
    public Object mapRow(ResultSet rs) throws SQLException, ClassNotFoundException, IOException;

}

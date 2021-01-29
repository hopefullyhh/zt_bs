package com.zt.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {

	private static DataSource datasource;
	
	private JDBCUtils(){
		
	}
	
	static {
		Properties p=new Properties();
		InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		try {
			p.load(is);
			datasource=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return datasource.getConnection();
	}
}

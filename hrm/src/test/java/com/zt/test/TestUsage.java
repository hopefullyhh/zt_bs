package com.zt.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.junit.jupiter.api.Test;

import com.zt.utils.JDBCUtils;

public class TestUsage {

	@Test
	public void testConn() {
		Connection conn=null;
		try {
			conn = JDBCUtils.getConn();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
	}
}

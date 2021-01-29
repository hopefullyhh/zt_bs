package com.zt.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 使用DBUtils中的QueryRunner改版后的公共DAO
 * @author hopefully
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> {

	private Class<T> clazz = null;

	private QueryRunner queryRunner = new QueryRunner();

	// 获取当前BaseDAO的子类继承父类的类型参数
	{
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		Type[] types = parameterizedType.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		// System.out.println(this);
	}

	/**
	 * 通用的增删改
	 * 
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception 
	 */
	public int universalUpdate(Connection conn, String sql, Object... args) throws Exception {
		return queryRunner.update(conn, sql, args);
	}

	/**
	 * 查询单条记录
	 * 
	 * @param <T>
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception 
	 */
	public T queryOne(Connection conn, String sql, Object... args) throws Exception {
		return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
	}

	/**
	 * 查询多条记录
	 * 
	 * @param <T>
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception 
	 */
	public List<T> queryList(Connection conn, String sql, Object... args) throws Exception {
		return queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
	}

	/**
	 * 查询特殊值，一般结果集为一行一列，如统计数目
	 * 
	 * @param <E>
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception 
	 */
	public <E> E value(Connection conn, String sql, Object... args) throws Exception {
		return (E)queryRunner.query(conn, sql, new ScalarHandler<T>(), args);
	}

}

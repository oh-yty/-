package com.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import xueshengxinxixitong.Course;

public class SelectComm {
	// <T> T 反射
	// T是个类，所以用泛型来写
	/**
	 * 获取多行结果，放在list集合中
	 */
	public static <T> List<T> getFrList(Class<T> clazz, String sql,
			Object... obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取链接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql，返回Statement实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);// 小心参数声明错误
			}
			// 4.执行
			rs = ps.executeQuery();
			// 获取结果集的元数据：ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int columnCount = rsmd.getColumnCount();

			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					// 获取每列的值
					Object columnValue = rs.getObject(i + 1);
					// 获取每个列的列名
					String columnName = rsmd.getColumnName(i + 1);
					// 给t对象指定的columnName属性赋值columnValue，通过反射
					Field field;
					field = clazz.getDeclaredField(columnName);
					// 有的属性是私有的，让属性可访问
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);

			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}

}

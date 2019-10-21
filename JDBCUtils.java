package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 操作数据库的工具类
 * 
 * @author Administrator
 * 
 */
public class JDBCUtils {
	/**
	 * 获取数据库的连接
	 * 
	 * @return
	 * @throws Throwable
	 */
	public static Connection getConnection() throws Throwable {
		// 1.connectionde 必要的四个基本信息
		String driver = "java.sql.Driver";
		String url = "jdbc:mysql://localhost:3306/manage";
		String userName = "root";
		String userpassword = "root";
		// 2.加载驱动
		Class.forName(driver);
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(url, userName,
				userpassword);
		return con;
	}

	/**
	 * 关闭connection和statement的操作
	 * 
	 * @param con
	 * @param ps
	 */
	public static void closeResource(Connection con, Statement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 关闭connection和statement,ResultSet的操作
	 * 
	 * @param con
	 * @param ps
	 */
	public static void closeResource(Connection con, Statement ps, ResultSet rs) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

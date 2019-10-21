package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateComm {
	/**
	 * 针对增删改的通用操作
	 */
	public static void update(String sql, Object... obj) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 1.获取链接
			try {
				conn = JDBCUtils.getConnection();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.预编译sql，返回Statement实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < obj.length; i++) {// sql中占位符个数与可变形参的长度相同
				ps.setObject(i + 1, obj[i]);// 小心参数声明错误
			}
			// 4.执行
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
	}
}

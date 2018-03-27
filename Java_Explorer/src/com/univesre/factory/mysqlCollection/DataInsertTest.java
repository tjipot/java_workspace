package factory.mysqlCollection;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 * @Project: java_demo
 * @PackageName: com.univesre.mysql
 * @CreationDate: 2018-01-19 14:31
 * @Description: 插入百万数据的MySQL测试
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class DataInsertTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String url = "jdbc:mysql://127.0.0.1/data_demo";
		final String name = "com.mysql.jdbc.Driver";
		final String user = "root";
		final String password = "mastermas";

		Connection conn = null;
		Class.forName(name);
		conn = DriverManager.getConnection(url, user, password);
		if (conn != null) {
			System.out.println("连接成功!");
			insertData(conn);
		} else {
			System.out.println("连接创建失败!");
		}
	}

	public static void insertData(Connection conn) {
		Long begin = new Date().getTime();
		String sqlPrefix = "INSERT INTO t_teacher (tch_id, tch_name, tch_password, tch_sex, tch_description, tch_pic_url, " +
				"tch_school_name, tch_date_register, tch_remark) VALUES ";
		try {
			StringBuffer sqlSuffix = new StringBuffer();
			conn.setAutoCommit(false);
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("");
			for (int i = 1; i <= 1; i++) {
				sqlSuffix = new StringBuffer();
				for (int j = 0; j <= 100000; j++) {
					sqlSuffix.append("('" + UUID.randomUUID().toString() + "', '" + i*j + "', '123456'" + ", '男'" + ", '教师'"
						+ ", 'www.baidu.com'" + ", '寰宇大学'" + ", '2018-01-19 14:43:26', '备注'),");
				}

				String sqlMain = sqlPrefix + sqlSuffix.substring(0, sqlSuffix.length() - 1);
				preparedStatement.addBatch(sqlMain);
				preparedStatement.executeBatch();
				conn.commit();
				sqlSuffix = new StringBuffer();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Long end = new Date().getTime();

		System.out.println("1000万条数据插入花费时间: " + (end - begin)/1000 + "s.");
		System.out.println("宇宙完成!");

	}

}

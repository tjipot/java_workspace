package org.fkit.factory;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 测试需要读取'mybatis-config.xml'根配置文件, 根据根配置文件信息创建SqlSessionFactory对象,
 * 再获取SqlSession对象, 这里开发FKSqlSessionFactory工厂类封装以上重复操作的代码;
 * */
public class FKSqlSessionFactory {

	private static SqlSessionFactory sqlSessionFactory = null;

	// 初始化创建SqlSessionFactory对象;
	static{
		try {
			// 读取mybatis-config.xml文件;
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取SqlSession对象的静态方法;
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

	// 获取SqlSessionFactory的静态方法;
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}

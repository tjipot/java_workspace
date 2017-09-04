package org.fkit.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.User;

public class MyBatisTest {

	public static void main(String[] args) throws Exception {
		
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");				// 读取mybatis-config.xml文件;
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	// 通过配置文件初始化mybatis, 创建SqlSessionFactory类的实例;
		SqlSession session = sqlSessionFactory.openSession();										// 创建Session实例;
		User user = new User("Jefferson", "男", 24);														// 创建User对象(映射关系已在配置中配好);
		session.insert("org.fkit.mapper.UserMapper.save", user);									// 插入数据;
		session.commit();																			// 提交事务;
		session.close();																			// 关闭Session;
		
	}
}

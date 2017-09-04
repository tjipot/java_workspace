package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;

public class InsertTest {

	public static void main(String[] args) throws Exception {
		
		// 获取FKSqlSessionFactory工厂封装类;
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// MyBatis的Session:使用框架;
		User user = new User("Heather", "女", 24);					// 创建User对象, varchar只能是小于等于4个英文字符;
		session.insert("org.fkit.mapper.UserMapper.saveUser", user);// 通过SqlSession插入数据;;
		session.commit();											// 提交事务;
		session.close();											// 关闭Session;
	
	}
}

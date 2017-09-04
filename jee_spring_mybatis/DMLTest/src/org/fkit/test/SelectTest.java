package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;

public class SelectTest {

	public static void main(String[] args) throws Exception {
		
		// 获取FKSqlSessionFactory工厂封装类;
		SqlSession session = FKSqlSessionFactory.getSqlSession();					// 获得Session实例;
		User user = session.selectOne("org.fkit.mapper.UserMapper.selectUser",1);	// 根据id查询User对象;
		System.out.println(user);
		session.commit();															// 提交事务;
		session.close();															// 关闭Session;
		
	}
}

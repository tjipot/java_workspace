package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.factory.FKSqlSessionFactory;

public class DeleteTest {

	public static void main(String[] args) throws Exception {
		
		// 获取FKSqlSessionFactory工厂封装类;
		SqlSession session = FKSqlSessionFactory.getSqlSession();		// 获得Session实例;
		session.delete("org.fkit.mapper.UserMapper.removeUser", 1);		// 删除id为1的User对象;
		session.commit();												// 提交事务;
		session.close();												// 关闭Session;

	}
}

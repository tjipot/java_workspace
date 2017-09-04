package org.fkit.test;

import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class TestOneLevelCache {

	public static void main(String[] args) throws Exception {
		
		TestOneLevelCache t = new TestOneLevelCache();
		
		t.testCache1();
//		t.testCache2();
//		t.testCache3();
		
	}
	
	 /* 一级缓存: 也就SqlSession级的缓存(默认开启); */
	public void testCache1() {
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 使用工厂类获得SqlSession对象;
		UserMapper um = session.getMapper(UserMapper.class);		// 获得UserMapping对象;
		User user = um.selectUserById(1);							// 查询id为1的User对象，会执行select语句;
		System.out.println(user);
		// 再次查询id为1的User对象, 因为是同一个SqlSession, 所以会从之前的一级缓存中查找数据;
		User user2 = um.selectUserById(1);							// 相同的查询: id=1;
		System.out.println(user2);
		session.close();											// 关闭SqlSession对象;
	}

	/* 查询, 再删除, 再查询: DML会在执行不同操作时清空SqlSession缓存; */
	public void testCache2() {
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 使用工厂类获得SqlSession对象;
		UserMapper um = session.getMapper(UserMapper.class);		// 获得UserMapping对象;
		User user = um.selectUserById(1);							// 查询id为1的User对象，会执行select语句;
		System.out.println(user);
		um.deleteUserById(5);										// 执行delete操作: id=5;
		session.commit();											// commit提交;
		// 再次查询id为1的User对象, 因为DML操作会清空SqlSession缓存, 所以会再次执行select语句;
		User user2 = um.selectUserById(1);
		System.out.println(user2);
		session.close();											// 关闭SqlSession对象;
	}
	
	/* 查询, 关闭session, 再查询: 再查询时需要再次获取一级缓存(即SqlSession对象); */
	public void testCache3() {
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 使用工厂类获得SqlSession对象;
		UserMapper um = session.getMapper(UserMapper.class);		// 获得UserMapping对象
		User user = um.selectUserById(1);							// 查询id为1的User对象，会执行select语句
		System.out.println(user);
		session.close();											// 关闭一级缓存;
		// 再次访问, 需要再次获取一级缓存, 然后才能查找数据, 否则会抛出异常;
		session = FKSqlSessionFactory.getSqlSession();
		um = session.getMapper(UserMapper.class);					// 再次获得UserMapping对象;
		// 再次访问, 因为现在使用的是一个新的SqlSession对象, 所以会再次执行select语句;
		User user2 = um.selectUserById(1);
		System.out.println(user2);
		session.close();											// 关闭SqlSession对象;
	}
	
}

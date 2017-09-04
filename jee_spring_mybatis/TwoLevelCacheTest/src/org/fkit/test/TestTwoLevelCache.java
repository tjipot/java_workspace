package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;

public class TestTwoLevelCache {

	public static void main(String[] args) throws Exception {
		
		TestTwoLevelCache t = new TestTwoLevelCache();
		
		t.testCache1();
//		t.testCache2();
		
	}
	
	public void testCache1 (){
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 使用工厂类获得SqlSession对象;
		UserMapper um = session.getMapper(UserMapper.class);		// 获得UserMapping对象;
		User user = um.selectUserById(1);							// 查询id为1的User对象, 会执行select语句;
		System.out.println(user);
		um.deleteUserById(5);										// 执行delete操作;
		session.commit();											// commit提交;
		User user2 = um.selectUserById(1);							// 原注释错误, 由于有二级缓存, 故不用再次执行select;
		System.out.println(user2);
		session.close();											// 关闭SqlSession对象;
	}
	
	public void testCache2 (){
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 使用工厂类获得SqlSession对象;
		UserMapper um = session.getMapper(UserMapper.class);		// 获得UserMapping对象;
		User user = um.selectUserById(1);							// 查询id为1的User对象，会执行select语句;
		System.out.println(user);
		session.close();											// 关闭一级缓存;
		session = FKSqlSessionFactory.getSqlSession();				// 再次访问, 需要再次获取一级缓存, 然后才能查找数据, 否则会抛出异常;
		um = session.getMapper(UserMapper.class);					// 再次获得UserMapping对象;
		User user2 = um.selectUserById(1);							// 原注释错误, 由于有二级缓存, 故不用再次执行select;
		System.out.println(user2);
		session.close();											// 关闭SqlSession对象;
	}
	
}

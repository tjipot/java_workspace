package org.fkit.test;

import org.fkit.domain.Person;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;

public class OneToOneTest {

	public static void main(String[] args) throws Exception {
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 获取Session实例;
		PersonMapper pm = session.getMapper(PersonMapper.class);	// 获取PersonMapper实例;
		Person p = pm.selectPersonById(1);							// 根据id查询Person对象，同时需要获得关联的Card对象
		System.out.println(p);										// 查看查询到的Person对象
		System.out.println(p.getCard());							// 查看查询到的关联的Card对象
		session.commit();											// 提交事务
		session.close();											// 关闭Session
	}

}

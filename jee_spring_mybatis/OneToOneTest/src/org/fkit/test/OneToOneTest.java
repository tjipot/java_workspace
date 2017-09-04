package org.fkit.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.Person;
import org.fkit.mapper.PersonMapper;

public class OneToOneTest {

	public static void main(String[] args) throws Exception {
		
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");	// 读取mybatis-config.xml文件;
		// 初始化mybatis，创建SqlSessionFactory类的实例;
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		SqlSession session = sqlSessionFactory.openSession();							// 创建Session实例;
		
		/*Person p 
		= session.selectOne("org.fkit.mapper.PersonMapper.selectPersonById",1);
		System.out.println(p);
		System.out.println(p.getCard().getCode());*/
		
		
		
		/* 通过SqlSession的getMapper()获取mapper接口的代理对象PersonMapper,
		 * 调用selectPersonById()会执行PersonMapper.xml的<select.../>定义的sql语句 */
		PersonMapper pm = session.getMapper(PersonMapper.class);
		// selectPersonById在'PersonMapper.xml'中有配置, 这是调用接口了?!;
		Person p = pm.selectPersonById(1);
		System.out.println(p);								// 打印Peson对象;
		System.out.println(p.getCard());					// 打印Person对象关联的Card对象;

		session.commit();									// 提交事务;
		session.close();									// 关闭Session;
	}

}

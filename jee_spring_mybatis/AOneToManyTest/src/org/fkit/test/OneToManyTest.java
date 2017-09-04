package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.ClazzMapper;

public class OneToManyTest {

	public static void main(String[] args) throws Exception {
		SqlSession session = FKSqlSessionFactory.getSqlSession();	// 通过factory类, 获取Session实例;
		ClazzMapper cm = session.getMapper(ClazzMapper.class);		// 获取ClazzMapper实例;
		Clazz clazz = cm.selectById(1);								// 根据id查询Clazz对象;
		System.out.println(clazz.getId() + " " 
						+ clazz.getCode() + " " + clazz.getName());	// 查看查询到的Clazz对象;
		clazz.getStudents().forEach(student
								->System.out.println(student));		// 查看关联的学生集合，因为配置使用的是LAZY懒加载, 所以当使用时才执行SQL语句;
		session.commit();											// 提交事务;
		session.close();											// 关闭Session;

		/** 结果:
		 * 	DEBUG [main] - ==>  Preparing: SELECT * FROM TB_CLAZZ WHERE ID = ? 
			DEBUG [main] - ==> Parameters: 1(Integer)
			DEBUG [main] - <==      Total: 1
			1 j1601 Java就业班
			DEBUG [main] - ==>  Preparing: SELECT * FROM TB_STUDENT WHERE CLAZZ_ID = ? 
			DEBUG [main] - ==> Parameters: 1(Integer)
			DEBUG [main] - <==      Total: 4
			Student [id=1, name=jack, sex=男, age=23]
			Student [id=2, name=rose, sex=女, age=18]
			Student [id=3, name=tom, sex=男, age=21]
			Student [id=4, name=alice, sex=女, age=20]
		 */
		
	}

}

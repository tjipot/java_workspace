package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Order;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.OrderMapper;

public class ManyToManyTest {

	public static void main(String[] args) throws Exception {
		SqlSession session = FKSqlSessionFactory.getSqlSession();							// 获取Session实例;
		OrderMapper om = session.getMapper(OrderMapper.class);								// 获取OrderMapper实例;
		Order order = om.selectById(1);														// 根据id查询Order对象;
		System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());	// 查看查询到的Order对象;
		System.out.println(order.getUser());												// 查看Order关联的User对象;
		order.getArticles().forEach(article -> System.out.println(article));				// 查看关联的Article集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句;
		session.commit();																	// 提交事务;
		session.close();																	// 关闭Session;
		
		/** Results:
		 * 	DEBUG [main] - ==>  Preparing: SELECT * FROM TB_ORDER WHERE ID = ? 
			DEBUG [main] - ==> Parameters: 1(Integer)
			DEBUG [main] - ====>  Preparing: SELECT * FROM TB_USER WHERE ID = ? 
			DEBUG [main] - ====> Parameters: 1(Integer)
			DEBUG [main] - <====      Total: 1
			DEBUG [main] - <==      Total: 1
			1 6aa3fa359ff14619b77fab5990940a2d 388.6
			
			User [id=1, username=null, loginname=null, password=null, phone=null, address=null]		// 除了id有实际值而其它都是null, 因为并没有将id为1的user的其它属性一一关联起来;
			
			DEBUG [main] - ==>  Preparing: SELECT * FROM tb_article WHERE id IN (SELECT article_id FROM tb_item WHERE order_id = ? ) 
			DEBUG [main] - ==> Parameters: 1(Integer)
			DEBUG [main] - <==      Total: 3
			Article [id=1, name=疯狂Java讲义, price=108.9, remark=李刚老师经典著作]
			Article [id=2, name=疯狂Android讲义, price=99.9, remark=李刚老师经典著作]
			Article [id=3, name=疯狂iOS讲义, price=89.9, remark=李刚老师经典著作]
		 */
		
	}

}

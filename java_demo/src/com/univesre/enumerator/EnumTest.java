package com.univesre.enumerator;

/**
 * @ClassName: EnumTest
 * @Description: 把Enum理解成是一种数据类型, 里面的枚举元素就是普通类的字段
 * @author: UNIVESRE
 * @date: 2017年7月7日 上午10:10:38
 */
public class EnumTest {

	public static void main(String[] args) {
		
		for(EnumDemo e : EnumDemo.values()) {
			System.out.println(e.toString());
			System.out.println();
		}
		
		System.out.println("======Break Line=====");

		EnumDemo eDemo = EnumDemo.FRIDAY;
		switch(eDemo) {
		
			case MONDAY:
				System.out.println("Today Is Monday."); break;
			case FRIDAY:
				System.out.println("Today Is Friday."); break;
			default:
				System.out.println(eDemo); break;
			
		}
		
	}

}

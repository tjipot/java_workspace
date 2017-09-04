package com.univesre.crazy_java_notes.ch14_annotation.s3_testable;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午1:54:03
 */
public class MyTest {
	
	// 仅仅使用注解来标记程序元素是不会有任何影响的, 要让注解起作用, 必须为注解提供一个注解处理工具;
	@Testable
	public static void m1() {
		
	}
	
	public static void m2() {
		
	}
	
	@Testable
	public static void m3() {
		throw new IllegalArgumentException("Parameter Is Wrong!");
	}
	
	public static void m4() {
		
	}
	
	@Testable
	public static void m5() {
		
	}
	
	public static void m6() {
		
	}
	
	@Testable
	public static void m7() {
		throw new RuntimeException("Business Logic Has Exception!");
	}
	
	public static void m8() {
		
	}
	
	
	
	
}

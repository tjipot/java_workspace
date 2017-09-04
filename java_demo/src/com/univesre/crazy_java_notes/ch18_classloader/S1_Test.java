package com.univesre.crazy_java_notes.ch18_classloader;

/**
 * @ClassName: S1_Test
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月22日 下午3:34:13
 */
public class S1_Test {

	static{
		// 使用静态初始化块为变量b指定初始值;
		b = 6;
		System.out.println("--------");
	}
	
	// 声明变量a时指定初始值;
	static int a = 5;
	static int b = 9;
	static int c;

	public static void main(String[] args) {
		
		System.out.println(S1_Test.b);	// 会进入到static代码块进行类初始化: b = 9;

	}

}

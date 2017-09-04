package com.univesre.crazy_java_notes.ch14_annotation;

class Apple_1 {
	
	// 标注info()是过时的了;
	@Deprecated
	public void info() {
		System.out.println("Apple_1 Info Method");
	}
}

public class DeprecatedTest {

	public static void main(String[] args) {
		
		// 使用info()会被编译器警告;
		new Apple_1().info();

	}

}

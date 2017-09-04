package com.univesre.crazy_java_notes.ch14_annotation;

@FunctionalInterface
public interface FunInterface {

	static void foo() {
		System.out.println("foo()");
	}
	
	default void bar() {
		System.out.println("bar() Default");
	}
	
	void test();
	
	// FunctionalInterface只能有一个抽象方法;
	//void abc();
}

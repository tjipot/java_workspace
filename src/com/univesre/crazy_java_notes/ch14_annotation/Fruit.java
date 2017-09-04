package com.univesre.crazy_java_notes.ch14_annotation;

/**
 * @ClassName: Fruit
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月23日 下午5:19:14
 */
public class Fruit {

	public void info() {
		System.out.println("Fruit Class's info method.");
	}
	
}

class Apple extends Fruit {
	
	// @Override 告诉编译器必须重写父类的info方法, 它只能修饰方法;
	@Override
	public void info() {
		System.out.println("Apple Class Overrided Fruit Class's info method.");
	}

}


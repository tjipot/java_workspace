package com.univesre.crazy_java_notes.ch05_obj_a.s1_class_obj;

/**
 * @ClassName: Dog
 * @Description: Demonstrating how to use 'this';
 * @author: UNIVESRE
 * @date: 2017年7月5日 下午6:23:48
 */
public class Dog {

	public void jump() {
		System.out.println("In jump() method.");
	}
	
	public void run() {
		// this也可以省略的, 因为是对象之内的调用(这是Java许可的);
		this.jump();
		System.out.println("In run() method.");
	}
	
	// main()是static方法, 不需要对象(主调:主语调用者)来调用;
	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.run();

	}

}

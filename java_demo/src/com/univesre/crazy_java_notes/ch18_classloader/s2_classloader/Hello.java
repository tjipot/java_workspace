package com.univesre.crazy_java_notes.ch18_classloader.s2_classloader;

/**
 * @ClassName: Hello
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月1日 上午11:54:00
 */
public class Hello {

	public static void main(String[] args) {
		
		for(String arg : args) {
			System.out.print("Params Of Running Hello: " + arg);
		}
	}
}

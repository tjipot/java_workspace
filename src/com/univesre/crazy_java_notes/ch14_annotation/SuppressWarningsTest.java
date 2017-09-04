package com.univesre.crazy_java_notes.ch14_annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SuppressWarningsTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月23日 下午5:33:12
 */
// 关闭整个类的编译器警告
@SuppressWarnings(value="unchecked")
public class SuppressWarningsTest {

	public static void main(String[] args) {
		
		// 已经取消了没有使用泛型的编译器警告;
		List<String> myList = new ArrayList();

	}

}

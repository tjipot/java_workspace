package com.univesre.crazy_java_notes.ch14_annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: ErrorUtils
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月23日 下午6:04:37
 */
public class ErrorUtils {

	public static void faultyMethod(List<String> ... listStrArray) {
		
		// Java不允许创建泛型数组, listArray只能当成List[]处理, 但此时把List<String>赋给了List, 发生了堆污染;
		List[] listArray = listStrArray;
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		
		listArray[0] = myList;
		String s = listStrArray[0].get(0);
	}
	
	
}

package com.univesre.crazy_java_notes.ch14_annotation;

import java.util.Arrays;

/**
 * @ClassName: ErrorUtilsTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月23日 下午6:11:37
 */
public class ErrorUtilsTest {

    public static void main(String[] args) {
        ErrorUtils.faultyMethod(Arrays.asList("Hello"), Arrays.asList("World"));
    }

}

/* Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
 *	at com.univesre.crazy_java_notes.ch14_annotation.ErrorUtils.faultyMethod(ErrorUtils.java:23)
 *	at com.univesre.crazy_java_notes.ch14_annotation.ErrorUtilsTest.main(ErrorUtilsTest.java:8)
 * */


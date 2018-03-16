package com.univesre.crazy_java_notes.ch14_annotation.s3_testable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Testable
 * @Description: 新创建了一个@Testable类的注解
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午1:46:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testable {

}

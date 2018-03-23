package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @File: adAuthor.java
 * @Classname: adAuthor
 * @Description: adAuthor注解
 * @Author: Haoran Ye
 * @CreateDate: 18/3/22 18:23
 * @ModificationHistory: WHAT WHEN WHO
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface adAuthor {

	String name() default "Hello";
	String group() default "World";

}

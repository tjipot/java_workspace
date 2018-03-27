package factory.annoCollection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @File: Reflect.java
 * @Classname: Reflect
 * @Description: 自定义一个注解类
 * @Author: Haoran Ye
 * @CreateDate: 18/3/22 16:18
 * @ModificationHistory: WHAT WHEN WHO
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reflect {
	String name() default "Haoran Ye";
}

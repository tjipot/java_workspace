package factory.annoCollection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @File: adDescription.java
 * @Classname: adDescription
 * @Description: adDescription注解
 * @Author: Haoran Ye
 * @CreateDate: 18/3/22 18:26
 * @ModificationHistory: WHAT WHEN WHO
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface adDescription {

	// Is a "function";
	String value();

}

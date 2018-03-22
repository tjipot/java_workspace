//package com.univesre.annotation;
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @File: ForthThing.java
 * @Classname: ForthThing
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 18/3/22 17:49
 * @ModificationHistory: WHAT WHEN WHO
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ForthThing {

    public String value() default "第四件事";

    public String Property() default "无属性";

}

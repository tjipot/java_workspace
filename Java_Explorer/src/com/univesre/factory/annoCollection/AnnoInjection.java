//package com.univesre.annotation;
package factory.annoCollection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @File: AnnoInjection.java
 * @Classname: AnnoInjection
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 18/3/22 17:49
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class AnnoInjection {

    public static Object getBean(Object obj) {

        try {
            Field f[] = obj.getClass().getDeclaredFields();
            for (Field ff : f) {
                ForthThing ft = ff.getAnnotation(ForthThing.class);

                if (ft != null) {
                    System.err.println("注入" + ff.getName() + "属性ff" + ft.value());
                    obj.getClass().getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1), new Class[]{String.class}).invoke(obj, ft.value());
                }
            }

            Method method[] = obj.getClass().getDeclaredMethods();
            for (Method m : method) {
                ForthThing ft = m.getAnnotation(ForthThing.class);
                if (ft != null) {
                    System.err.println("注入" + m.getName() + "方法ft" + ft.Property());
                    m.invoke(obj, ft.Property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}

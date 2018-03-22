package annotation;

import java.lang.reflect.Method;

/**
 * @Project: java_demo
 * @PackageName: annotation
 * @CreationDate: 2018-03-22 16:21
 * @Description: 注解的使用(核心逻辑)
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ReflectProcessor {

	// 奇巧的语法, 但核心是"clazz"变量在外部被调用时需要被传入;
	public void parseMethod(final Class<?> clazz) throws Exception {
		// 1.在ReflectTest中, 获取到了该类的Class属性;
		final Object obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[]{});
		// 2.Method类, 和Class类一样, 一个用来描述Java中的方法(的概念), 一个用来描述Java中的类(的概念);
		final Method[] methods = clazz.getDeclaredMethods();
		// 3.对所有的"ReflectTest.class"中的方法进行遍历;
		for (final Method method : methods) {
			final Reflect my = method.getAnnotation(Reflect.class); // 传说中的反射??!! "my"是一个Reflect对象;
			if(null != my) {                    // 只对Reflect类型的对象有效;
				method.invoke(obj, my.name());  // 注解"Reflect"也是一个类, 要不然"my"也不可能可以调用注解(Reflect这个类)中的"name()";
			}
		}
	}
}

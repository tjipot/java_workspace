package factory.annoCollection;

import java.lang.reflect.Method;

/**
 * @Project: java_demo
 * @PackageName: annotation
 * @CreationDate: 2018-03-23 09:43
 * @Description: 测试: 1.注解的定义(@interface adAuthor, @interface adDescription), 2.注解的使用(adAnnotationTest)
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class adTest {

	/** 此测试组程序包含annotation包内所有以"ad"为前缀的4个".java"文件 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazzType = Class.forName("annoCollection.adAnnotationTest");      // 1.获取某个类(这个类使用注解);
		if (clazzType.isAnnotationPresent(adDescription.class)) {               // 2.判断此类有没有使用"adDescription"注解;
			System.out.println("Implemented Description Annotation!");
			adDescription adDes = clazzType.getAnnotation(adDescription.class); // 3.创建一个类型为"adDescription"的对象adDes;
			System.out.println("adDes's value: " + adDes.value());              // 4.获取该注解对象的值;
		}

		Method[] methods = clazzType.getDeclaredMethods();                      // 5.获取"adAnnotationTest"类内的方法;
		for (Method method : methods) {
			if (method.isAnnotationPresent(adAuthor.class)) {                   // 6.判断一个方法是否被"adAuthor"注解(类)修饰;
				adAuthor adAu = (adAuthor)method.getAnnotation(adAuthor.class); // 7.创建注解对象;
				System.out.println("Author's name: " + adAu.name());            // 8.获取该类(即注解)内的(属性)值;
				System.out.println("Author's group: " + adAu.group());
			}
		}

	}

}

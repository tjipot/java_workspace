package com.univesre.crazy_java_notes.ch18_classloader.s2_classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @ClassName: ClassLoaderPropTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月1日 上午11:29:18
 */
public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {

        // 获取`系统类`加载器;
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("System Class Loader: " + systemLoader);

		/* 获取系统类加载器的加载路径, 通常由CLASSPATH环境变量指定,
		 * 如果系统中没有指定CLASSPATH环境变量, 则默认以当前路径作为系统类加载器的加载路径. */
        Enumeration<URL> eml = systemLoader.getResources("");
        while (eml.hasMoreElements()) {
            System.out.println(eml.nextElement());
        }

        // 获取系统类加载器的父类加载器, 得到扩展类加载器;
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("扩展类加载器: " + extensionLader);
        System.out.println("扩展类加载器的加载路径: " + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent: " + extensionLader.getParent());

		/*	System Class Loader: sun.misc.Launcher$AppClassLoader@4554617c
			file:/Users/UNIVESRE/Documents/workspace_neon_3/UNIVESRE_JAVA_TEST/bin/
			扩展类加载器: sun.misc.Launcher$ExtClassLoader@677327b6
			扩展类加载器的加载路径: /Users/UNIVESRE/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java
			扩展类加载器的parent: null (p.s. 跟类加载器不是JAVA写的,故无法用java对象来表示,故用null)
		 */
    }
}

package com.univesre.crazy_java_notes.ch18_classloader;

/**
 * @ClassName: Tester
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月22日 下午3:44:17
 */
class Tester {

    /* 	如果Tester类放在主类'S1_ClassLoaderTest'之后: 会有如下报错(说明Java是按顺序展开的):
     * 	Exception in thread "main" java.lang.ClassNotFoundException: Tester
     *		at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
     *		at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
     *		at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
     *		at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
     *		at com.univesre.crazy_java_notes.unit18.S1_ClassLoaderTest.main(S1_ClassLoaderTest.java:16) */
    static {
        System.out.println("Tester类静态初始化块");
    }

}

/**
 * @ClassName: S1_ClassLoaderTest
 * @Description: '加载类'不等同于'初始化类'
 * @author: UNIVESRE
 * @date: 2017年6月22日 下午3:35:00
 */
public class S1_ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        // 仅仅加载Tester类(但不初始化);
        cl.loadClass("Tester");
        System.out.println("系统加载Tester类");

        // 下面的语句才会初始化Tester类;
        Class.forName("Tester");
    }

}

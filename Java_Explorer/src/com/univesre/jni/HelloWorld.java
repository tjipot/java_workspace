package com.univesre.jni;

/**
 * @ClassName: HelloWorld
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月12日 上午9:45:28
 */
public class HelloWorld {

    // 本地化函数声明, 只声明不定义, main函数里直接调用;
    public static native String sayHello(String name);

//    static {  
//        // 加载C模块，window下是hello.dll文件，mac下是libhello.jnilib文件
//        // 由下面的操作生成
//        System.loadLibrary("hello");  
//    }  

    public static void main(String[] args) {

        String text = sayHello("WEDNESDAY");
        System.out.println(text);

        // 调用上面声明的本地化方法;
        // new HelloWorld().displayHelloWorld(); 

        // System.out.println(System.getProperty("java.library.path"));
    }

    static {
        System.loadLibrary("HelloWorld");
    }

}  

/* Exception in thread "main" java.lang.UnsatisfiedLinkError: no hello in java.library.path
    at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1867)
	at java.lang.Runtime.loadLibrary0(Runtime.java:870)
	at java.lang.System.loadLibrary(System.java:1122)
	at com.univesre.jni.HelloWorld.<clinit>(HelloWorld.java:17)
 */

/* System.out.println(System.getProperty("java.library.path")):
 * 
 * /Users/UNIVESRE/Library/Java/Extensions:
 * /Library/Java/Extensions:
 * /Network/Library/Java/Extensions:
 * /System/Library/Java/Extensions:
 * /usr/lib/java:
 * .
 */

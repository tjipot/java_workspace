package factory.thread;

/**Java支持多线程的基础: The Java Virtual Machine allows an application to have multiple threads of
 * execution running concurrently. */

/**
 * @File: ThreadMain.java
 * @Classname: ThreadMain
 * @Description: 多线程演示入口类
 * @Author: Haoran Ye
 * @CreateDate: 18/3/19 11:46
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class ThreadMain {

	public static void main(String[] args) {

		// System.out.println("So");
		ThreadSync threadSync = new ThreadSync();

		/** 如果"ThreadSync"已经"implements Runnable": Casting 'threadSync' to 'Runnable' is redundant */
		Thread t01 = new Thread((Runnable) threadSync, "ThreadSync01");

		/** 如果"ThreadSync"没有"implements Runnable": 可以把一个对象(threadSync)Cast成一个接口(静态阶段),
		 *  但在程序动态执行时还是会exception一下: Exception in thread "main" java.lang.ClassCastException:
		 *  factory.thread.ThreadSync cannot be cast to java.lang.Runnable */
		Thread t02 = new Thread(threadSync, "ThreadSync02");

		// "start()"是某段代码(run()中的代码)以线程方式执行的入口;
		t01.start();
		t02.start();
		/*  Rult:
			SyncThread01: 0
			SyncThread01: 1
			SyncThread01: 2
			SyncThread01: 3
			SyncThread01: 4
			SyncThread02: 5
			SyncThread02: 6
			SyncThread02: 7
			SyncThread02: 8
			SyncThread02: 9 */

	}
}



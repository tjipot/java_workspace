package factory.thread;

/**
 * @Project: java_demo
 * @PackageName: factory.thread
 * @CreateDate: 18/3/19 13:52
 * @Description: 一个实现Runnable接口的自定义线程类
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ThreadSync implements Runnable {

	/**Note: The Runnable interface should be implemented by any class whose instances are intended to be executed
	 * "by a thread". The class must define a method of no arguments called "run". Thread类本身也implements了Runnable,
	 * 而Runnable里面只有一个方法, 即抽象方法run(), 可以说Thread是多线程, Runnable是多线程, 但Thread或是自定义的"多线程类"最终
	 * 都要implements Runnable的run(), 在执行的时候, 则以Thread中的start()作为入口(thread.start()中的thread对象必须要有实现
	 * 了的run()方法);
	 *
	 * void run(): When an object implementing interface "java.lang.Runnable" is used to create a thread,
	 * "starting the thread" causes the object's run method to be called in that separately executing thread.
	 * */
	private static int count;

	public ThreadSync() {   // 初始化private static int count为0;
		count = 0;
	}

	public void run() {
		synchronized (this) {   // 同步this: 维护this对象范围内的同步(变量等..);
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ": " + count++);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getCount() {
		return count;
	}

}
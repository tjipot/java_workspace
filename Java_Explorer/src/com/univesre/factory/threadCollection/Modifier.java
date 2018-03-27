package factory.threadCollection;

/**
 * @File: Modifier.java
 * @Classname: Modifier
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 18/3/19 11:46
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class Modifier {

	public static void main(String[] args) {

		// System.out.println("So");
		SyncThread syncThread = new SyncThread();
		Thread thread01 = new Thread(syncThread, "SyncThread01");
		Thread thread02 = new Thread(syncThread, "SyncThread02");
		thread01.start();
		thread02.start();
		/*  SyncThread01: 0
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

/**
 * @File: Modifier.java
 * @Classname: SyncThread
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 18/3/19 13:52
 * @ModificationHistory: WHAT WHEN WHO
 **/
class SyncThread implements Runnable {

	/**Note: The Runnable interface should be implemented by any class
	 * whose instances are intended to be executed "by a thread". The class must define
	 * a method of no arguments called "run".
	 *
	 * void run(): When an object implementing interface "java.lang.Runnable" is used to create a thread,
	 * "starting the thread" causes the object's run method to be called in that separately executing thread.
	 * */
	private static int count;

	public SyncThread() {
		count = 0;
	}

	public void run() {
		synchronized (this) {
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

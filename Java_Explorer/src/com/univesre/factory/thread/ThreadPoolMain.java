package factory.thread;

import java.util.Date;
import java.util.concurrent.*;
/** 关于Executors类: Factory and utility methods for 1.Executor, 2.ExecutorService, 3.ScheduledExecutorService,
 *  4.ThreadFactory, and 5.Callable classes defined in this package.
 *
 *  关于ExecutorService接口: An Executor that provides methods to manage termination and methods that can produce
 *  a Future for tracking progress of one or more asynchronous tasks.
 * */

/**
 * @Project: java_demo
 * @PackageName: factory.thread
 * @CreationDate: 2018-03-30 14:58
 * @Description: 演示线程池(没搞懂)
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ThreadPoolMain {

	public static void main(String[] args) throws InterruptedException {
		// cachedThreadPool();
		// fixedThreadPool();
		scheduledThreadPool();
		// workStealingPool();
	}

	/**
	 * @Title: cachedThreadPool, 带缓存的线程池
	 * @Description: newCachedThreadPool()会根据任务来临的需要决定是否创建新的线程, 如果来了新任务又没有空闲线程, 它就会新建一个线程
	 * @Parameter: None
	 * @Return: void
	 * @Throws: InterruptedException
	 **/
	private static void cachedThreadPool() throws InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();

		/*
		 * 关于submit(): <T> Future<T> submit(Callable<T> task), Submits a value-returning task for execution
		(即提交一个执行, 即Runnable) and returns a Future representing the pending results of the task. The Future's
		get method will return the task's result upon successful completion.

		 * 关于Future: 是个Interface, A Future represents the result of an asynchronous computation. Methods are
		provided to check if the computation is complete, to wait for its completion, and to retrieve the result
		of the computation.

		 * 总结: submit()函数, 1.执行一个Runnable, 2.返回一个Future.
		*/

		for (int i = 1; i <= 10; i++) {
			final int count  = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					// synchronized (this) { System.out.println("线程: " + Thread.currentThread() + "负责了" + count + "次任务."); }
					System.out.println("线程: " + Thread.currentThread() + "负责了" + count + "次任务.");
				}
			});
			/** 未注释掉的Rult分析, 由于没有注释掉"Thread.sleep(1)", 导致在每次for循环之间有间断, 而newCachedThreadPool创建的
			 *  executorService会依据需求创建线程, 在下一个"run()"任务来之前, executorService无需创建新的线程来执行"run()";
			 *  线程: Thread[pool-1-thread-1,5,main]负责了1次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了2次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了3次任务.
			    线程: Thread[pool-1-thread-2,5,main]负责了5次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了4次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了6次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了7次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了8次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了9次任务.
			    线程: Thread[pool-1-thread-1,5,main]负责了10次任务.
			 * */

			// 下面这行代码注释的话, for循环之间没有间隔, 线程池会按需创建多个线程,
			// 不注释的话, for循环之间有间断, executorService会减少新线程的创建, 转而复用老线程;
			// Thread.sleep(1);
			/** 注释掉的Rult:
			 *  线程: Thread[pool-1-thread-1,5,main]负责了1次任务.
			    线程: Thread[pool-1-thread-3,5,main]负责了3次任务.
			    线程: Thread[pool-1-thread-2,5,main]负责了2次任务.
			    线程: Thread[pool-1-thread-4,5,main]负责了4次任务.
			    线程: Thread[pool-1-thread-5,5,main]负责了5次任务.
			    线程: Thread[pool-1-thread-3,5,main]负责了7次任务.
			    线程: Thread[pool-1-thread-4,5,main]负责了8次任务.
			    线程: Thread[pool-1-thread-3,5,main]负责了9次任务.
			    线程: Thread[pool-1-thread-4,5,main]负责了10次任务.
			    线程: Thread[pool-1-thread-5,5,main]负责了6次任务.
			 * */
		}
	}

	/**
	 * @Title: fixedThreadPool, 固定个数的线程池
	 * @Description: newFixedThreadPool()创建一个固定大小的、可重用是线程池
	 * @Parameter: None
	 * @Return: void
	 * @Throws: InterruptedException
	 **/
	private static void fixedThreadPool() throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for(int i = 1; i <= 10; i++) {
			final int count = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程: " + Thread.currentThread() + "负责了" + count + "次任务.");
				}
			});
			/** 线程: Thread[pool-1-thread-  1  ,5,main]负责了1次任务.
			    线程: Thread[pool-1-thread-  2  ,5,main]负责了2次任务.
			    线程: Thread[pool-1-thread-  3  ,5,main]负责了3次任务.
			    线程: Thread[pool-1-thread-  4  ,5,main]负责了4次任务.  // 最多4个线程(构造函数参数传了4);
			    线程: Thread[pool-1-thread-  1  ,5,main]负责了5次任务.
			    线程: Thread[pool-1-thread-  2  ,5,main]负责了6次任务.
			    线程: Thread[pool-1-thread-  3  ,5,main]负责了7次任务.
			    线程: Thread[pool-1-thread-  4  ,5,main]负责了8次任务.
			    线程: Thread[pool-1-thread-  1  ,5,main]负责了9次任务.
			    线程: Thread[pool-1-thread-  2  ,5,main]负责了10次任务.
			 * */

			Thread.sleep(1000);
		}
	}

	/**
	 * @Title: scheduledThreadPool, 支持定时任务的线程池..
	 * @Description: newScheduledThreadPool()创建一个定长线程池, 支持定时及周期性任务执行
	 * @Parameter: None
	 * @Return: void
	 * @Throws: InterruptedException
	 **/
	private static void scheduledThreadPool() throws InterruptedException {

		// 指定大小为4;
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Date now = new Date();
				System.out.println("线程" + Thread.currentThread() + "报时: " + now);
			}
		}, 2, 1, TimeUnit.SECONDS);     // 定时执行: 延迟2S秒执行，每隔1S执行一次;

		/** 线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:51 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:52 CST 2018
		    线程Thread[pool-1-thread-2,5,main]报时: Fri Mar 30 16:09:53 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:54 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:55 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:56 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:57 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:58 CST 2018
		    线程Thread[pool-1-thread-1,5,main]报时: Fri Mar 30 16:09:59 CST 2018
		    ...
		    (手动停止)
		    Process finished with exit code 130
		 */

	}

	/**
	 * @Title: workStealingPool
	 * @Description: newWorkStealingPool()创建一个带并行级别的线程池, 并行级别决定了同一时刻最多有多少个线程在执行
	 * @Parameter: None
	 * @Return: void
	 * @Throws: InterruptedException
	 **/
	private static void workStealingPool() throws InterruptedException {

		/* 1.设置并行数量为2个, 每时每刻最多只有2个线程同时执行: Creates a thread pool that maintains enough threads to support
		 * the given parallelism level, and may use multiple queues to reduce contention. A work-stealing pool makes
		 * no guarantees about the order in which submitted tasks are executed;
		 * 2.ExecutorService中是不会有明显的并行数的字段的, 因为它的并行数保存字段在ForkJoinPool中, ForkJoinPool 实现了
		 * (implementing) ExecutorService;
		 * 3.返回的是ForkJoinPool对象(内存), 但JVM允许其父类索引(executorService变量)指向ForkJoinPool对象的内存: 通过内存来理解
		 * 这类子类父类的关系就好多了: 假如父类中有5个fields, 而子类中有8个fields, 这时父类的变量就可以索引到子类的内存区域, 因为
		 * 这样不会引起信息丢失, 而假如子类变量索引父类内存, 则父类内存(5个fields)没有子类变量(8个fields)中那么多的fields信息会
		 * 引起信息丢失. */
		ExecutorService executorService = Executors.newWorkStealingPool(2);
		// 关于跨类的对象赋值, 见下;
		// Object obj = new String("Hello");    // 可以: "父类" <- "子类";
		// String str = new Object();           // 错误: "子类" <- "父类";
		for (int i = 1; i <= 10; i++) {
			final int count = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					Date now = new Date();
					System.out.println("线程" + Thread.currentThread() + "完成任务: " + count + ", 时间为:" + now.getSeconds());
					try {
						Thread.sleep(1000); // 此任务耗时1s;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		while(true) {
			// 主线程陷入死循环, 来观察结果, 否则是看不到结果的;
		}

		/** 线程Thread[ForkJoinPool-1-worker-1,5,main]完成任务: 1, 时间为:31
		    线程Thread[ForkJoinPool-1-worker-0,5,main]完成任务: 2, 时间为:31
		    线程Thread[ForkJoinPool-1-worker-0,5,main]完成任务: 3, 时间为:32
		    线程Thread[ForkJoinPool-1-worker-1,5,main]完成任务: 4, 时间为:32
		    线程Thread[ForkJoinPool-1-worker-0,5,main]完成任务: 5, 时间为:33
		    线程Thread[ForkJoinPool-1-worker-1,5,main]完成任务: 6, 时间为:33
		    线程Thread[ForkJoinPool-1-worker-0,5,main]完成任务: 7, 时间为:34
		    线程Thread[ForkJoinPool-1-worker-1,5,main]完成任务: 8, 时间为:34
		    线程Thread[ForkJoinPool-1-worker-0,5,main]完成任务: 9, 时间为:35
		    线程Thread[ForkJoinPool-1-worker-1,5,main]完成任务: 10, 时间为:35
		    (手动停止)
		    Process finished with exit code 130
		 * */

	}
}

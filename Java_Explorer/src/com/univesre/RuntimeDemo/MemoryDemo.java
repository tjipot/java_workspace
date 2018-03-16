package com.univesre.RuntimeDemo;

/**
 * @ClassName: MemoryDemo
 * @Description: Java提供了无用单元自动收集机制, 通过totalMemory()和freeMemory()方法可以知道对象的堆内存有多大,
 * 还剩多少; Java会周期性的回收垃圾对象(未使用的对象), 以便释放内存空间, 但是如果想先于收集器的下一次指定周期来收
 * 集废弃的对象, 可以通过调用gc()方法来根据需要运行无用单元收集器. 一个很好的试验方法是先调用gc()方法, 然后调用f-
 * reeMemory()方法来查看基本的内存使用情况, 接着执行代码, 然后再次调用freeMemory()方法看看分配了多少内存, 下
 * 面的程序演示了这个构想.
 * @author: UNIVESRE
 * @date: 2017年7月14日 下午4:09:30
 */
public class MemoryDemo {

    public static void main(String[] args) {

        // 取得一个Runtime对象;
        Runtime r = Runtime.getRuntime();
        long mem1, mem2;
        Integer someints[] = new Integer[1000];
        System.out.println("Total memory is: " + r.totalMemory());
        // 空闲的内存大小;
        mem1 = r.freeMemory();
        System.out.println("Initial free is: " + mem1);
        r.gc();
        mem1 = r.freeMemory();
        System.out.println("Free memory after garbage collection: " + mem1);

        // Allocate Integers: 使用掉一些内存;
        for (int i = 0; i < 1000; i++) someints[i] = new Integer(i);
        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation: " + mem2);
        System.out.println("Memory used by allocation: " + (mem1 - mem2));

        // Discard Intergers: 将内存置为null以使`垃圾回收`了;
        for (int i = 0; i < 1000; i++) {
            someints[i] = null;
        }

        // Request Garbage Collection;
        r.gc();
        mem2 = r.freeMemory();
        System.out.println("Free memory after collecting " + "discarded integers : " + mem2); 

        /*	Total memory is: 257425408
            Initial free is: 254741016
			Free memory after garbage collection: 257079312
			Free memory after allocation: 255737088
			Memory used by allocation: 1342224
			Free memory after collecting discarded integers : 257091064
         */

    }

}

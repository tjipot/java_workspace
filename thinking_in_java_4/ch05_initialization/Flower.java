/* @UNIVESRE.COM_20170114_HYE
 * Demo: calling 'this' constructors, p85. */

import static net.mindview.util.Print.*;

/* 5.4.2注: static方法就是没有this的方法, 即static方法和数据
 * 不隶属于任何对象, 是类共有的; 虽然和全局变量在功效上有重合的
 * 地方, 但它们不是同一个东西. */

public class Flower {

    int petalCount = 0;     // 花瓣数量;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        print("Constructor w/ int arg only, petalCount = " + petalCount);
    }

    Flower(String ss) {
        print("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);   // 1.Constructor call should be the first statement;
//        this(s);        // 2.Can't call two! "错误: 对this的调用必须是构造器中的第一个语句";
        this.s = s;     // 3.Using "this" to avoid ambiguity;
        print("String & int args");
    }

    Flower() {
        this("hi", 47);
        print("default constructor (no args)");
    }

    void printPetalCount() {
        /* 4.Can't inside non-constructor! It's a compiler's rule, 
         * just like you can't call Flower() in printPetalCount(), 
         * either. "错误: 对this的调用必须是构造器中的第一个语句"; */
//        this(11);
        print("petalCount = " + petalCount + ", s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}



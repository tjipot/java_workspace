/* @UNIVESRE.COM_20170115_HYE
 * Demo: 非静态实例初始化, p98. */

import static net.mindview.util.Print.*;

class Mug {

    Mug(int maker) {
        print("Mug(" + maker + ")");
    }

    void f(int maker) {
        print("f(" + maker + ")");
    }

}


public class Mugs {

    Mug mug1;
    Mug mug2;

    /* 少static: 匿名内部类第十章, 也保证了这些操作一定会发生, 
     * 和static块不一样, 这个块不会就有一个; */
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        print("mug1 & mug2 initialized.");
    }

    Mugs() {
        print("Mugs()");
    }

    Mugs(int i) {
        print("Mugs(int)");
    }

    public static void main(String[] args){
        print("Inside main()");
        new Mugs();
        print("new Mugs() completed.");
        new Mugs(1);
        print("new Mugs(1) completed.");
    }

}

/* Result:
 * Inside main()
 * Mug(1)
 * Mug(2)
 * mug1 & mug2 initialized.
 * Mugs()
 * new Mugs() completed.
 * Mug(1)
 * Mug(2)
 * mug1 & mug2 initialized.
 * Mugs(int)
 * new Mugs(1) completed.
 */



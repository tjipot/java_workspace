/* @UNIVESRE.COM_20170115_HYE
 * Demo: 显式的静态初始化 with static clause, 
 * 静态子句, 静态块, p97. */

import static net.mindview.util.Print.*;

class Cup {
    Cup(int maker) {
        print("Cup(" + maker + ")");
    }
    void f(int maker) {
        print("f(" + maker + ")");
    }
}

class Cups {
    static Cup cup1;    // null;
    static Cup cup2;    // null;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        print("Cups()");
    }
}


public class ExplicitStatic {
    public static void main(String[] args) {
        print("Inside main()");
        // 并没有创建Cups的对象, 故不会调用Cups()构造函数并打印"Cups()";
        Cups.cup1.f(99);    // (1)
    }
    // static Cups cups1 = new Cups();  //(2)
    // static Cups cups2 = new Cups();  //(2)
}
/* Result:
 * Inside main()
 * Cup(1)
 * Cup(2)
 * f(99)
 */



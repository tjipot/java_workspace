/* @UNIVESRE.COM_20170116_HYE
 * Demo: 构造器的调用关系,
 * ch7.2.1初始化基类, p129. */

import static net.mindview.util.Print.*;

class Art {
    Art() { print("Art constructor."); }
}

class Drawing extends Art {
    Drawing() { print("Drawing constructor."); }
}

public class Cartoon extends Drawing {

    // 没有public也可以运行, 但这里为什么要加?!;
    public Cartoon() { print("Cartoon constructor."); }
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}



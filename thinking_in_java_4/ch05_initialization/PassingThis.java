/* @UNIVESRE.COM_20170114_HYE
 * Demo: how this passes, p85. */

//int j = 0;  // 错误: 需要class, interface或enum;

class Person {

    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();   // 没有用new, 但把main里那个new Apple()的ref传给了peeled对象;
        System.out.println("Yummy");
    }

}

class Apple {

    Apple getPeeled() {
        return Peeler.peel(this);           // Passing this;
    }
}

class Peeler {

    static Apple peel(Apple apple) {
        // ... remove peel;
        return apple;   // Peeled;
    }
}


public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());      // Shit, 什么语法, 只有理解成new操作符有比'.'号更高的优先级才行得通, 或从左向右进行表达式计算(new必须和后面的'操作对象'空一格啊, 但逻辑上它们是一个操作符和操作数就行了);
    }
}



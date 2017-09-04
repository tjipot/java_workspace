/* @UNIVESRE.COM_20170114_HYE
 * Demonstration of a simple constructor, 
 * 用构造器确保初始化. p76. */

class Rock {    // 一个".java"文件中只能有一个public class;

    Rock() {    // Constructor;
        System.out.print("Rock ");
    }

}

public class SimpleConstructor {

    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
            new Rock();
            System.out.println(i+1);
        }
    }
}




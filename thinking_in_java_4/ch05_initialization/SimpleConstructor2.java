/* @UNIVESRE.COM_20170114_HYE
 * Constructor with argument,
 * 用构造器确保初始化. p77. */

class Rock2 {       // 一个".java"文件中只能有一个public class;

    Rock2(int i) {  // Constructor;
        System.out.print("Rock " + i + " ");
    }

}

public class SimpleConstructor2 {

    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
            new Rock2(i);
        }
        System.out.println();
    }
}




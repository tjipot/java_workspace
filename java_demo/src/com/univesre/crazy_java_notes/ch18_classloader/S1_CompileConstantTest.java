package com.univesre.crazy_java_notes.ch18_classloader;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月22日 下午4:09:21
 */
class MyTest {

    static {
        System.out.println("MyTest类被初始化了!");
    }

    /* 使用一个字符串直接量为static final的类变量赋值:
     * 在编译时可以被确定, 会被当成'宏'使用; */
    static final String compileConstant = "疯狂JAVA讲义";

	/* 在运行时才能确定的值, 使用它要进行类初始化; */
    //static final String compileConstant = System.currentTimeMillis() + "";
}

/**
 * @ClassName: S1_CompileConstantTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月22日 下午4:09:27
 */
public class S1_CompileConstantTest {

    public static void main(String[] args) {

        // 访问,输出MyTest中的compileConstant类变量;
        System.out.println(MyTest.compileConstant);

    }

}

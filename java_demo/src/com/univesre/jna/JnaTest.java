package com.univesre.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @ClassName: JnaTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月11日 下午2:16:16
 */
public class JnaTest {

    // 继承Library, 用于加载库文件;
    public interface Clibrary extends Library {

        // 加载`libhello.so`链接库;
        Clibrary INSTANCE = (Clibrary) Native.loadLibrary("hello", Clibrary.class);

        // 此方法为链接库中的方法;
        void test();
    }

    public static void main(String[] args) {
        Clibrary.INSTANCE.test();
        System.out.println(System.getProperty("java.library.path"));
    }
}

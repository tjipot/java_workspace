package com.univesre.RuntimeDemo;

/**
 * @ClassName: ExecDemoFini
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月14日 下午4:47:06
 */
public class ExecDemoFini {

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("notepad");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
        System.out.println("Notepad returned " + p.exitValue());
        /*	Error executing notepad.Exception in thread "main" java.lang.NullPointerException
            at com.univesre.RuntimeDemo.ExecDemoFini.main(ExecDemoFini.java:21)
			因为压根就没有`notepad`对应的程序, p对象也没法有引用到;
         */

    }

}

package com.univesre.crazy_java_notes.ch18_classloader.s2_classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName: CompileClassLoader
 * @Description: 自定义的ClassLoader
 * @author: UNIVESRE
 * @date: 2017年7月1日 上午11:47:10
 */
public class CompileClassLoader extends ClassLoader {

    // 读取: 文件的内容;
    private byte[] getBytes(String filename) throws IOException {

        File file = new File(filename);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try (FileInputStream fin = new FileInputStream(file)) {
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部文件: " + r + " != " + len);
            }
            return raw;
        }
    }

    // 定义编译指定Java文件的方法;
    private boolean compile(String javaFile) throws IOException {

        System.out.println("CompileClassLoader: 正在编译 " + javaFile + "...");
        // Process是一个操作系统进程, Runtime类封装了运行时环境, 每个Java应用程序都有一个Runtime类的实例, 使应用程序能与其运行时环境相连接;
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            // Other threads should wait this thread;
            p.waitFor();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }

        return p.exitValue() == 0;
    }

    // 重写CLassLoader的findClass方法;
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String fileStub = name.replace(".", "/");        // 将包路径中的'.'换成'/';
        String javaFilename = fileStub + ".java";
        String classFilename = fileStub + ".class";
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);

        // 重新编译的判断条件: 源文件存在且(class文件不存在或源文件更改时间(时间戳)大于class文件的时间戳);
        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
            try {
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException: " + javaFilename);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // If class file exists, system will transform this file into Class obj;
        if (classFile.exists()) {
            try {
                // 将Class文件的二进制数据读入数组;
                byte[] raw = getBytes(classFilename);
                // 调用ClassLoader的defineClass方法将二进制数据转换成Class对象(有自己的格式);
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

        // If clazz is null, then the loading is failed;
        if (clazz == null) {            // 任何类都是Java中Class类的实例;
            throw new ClassNotFoundException(name);
        }

        return clazz;
    }

    // 主方法;
    public static void main(String[] args) throws Exception {

        // 没有参数, 即没有目标类;
        if (args.length < 1) {
            System.out.println("Lacking of underlying Class, run java source file in the following format: ");
            System.out.println("java CompileClassLoader ClassName");
        }

        // 第一个参数是需要运行的类;
        String progClass = args[0];
        // 剩下的参数将作为运行目标类时的参数复制到一个新数组中;
        String[] progArgs = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);

        // 扩展(extends)自ClassLoader;
        CompileClassLoader ccl = new CompileClassLoader();
        Class<?> clazz = ccl.loadClass(progClass);

        // 获取需要运行的类的主方法: 反射调用(我的理解: 通过编译环境查找到类信息并调用);
        Method main = clazz.getMethod("main", (new String[0].getClass()));
        Object argsArray[] = {progArgs};
        main.invoke(null, argsArray);
    }
}

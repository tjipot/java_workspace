/* @UNIVESRE.COM_20170114_HYE
 * HelloDate.java: print's simple version, p38. */

/* 要将下面的pachage注释掉, 否则会有如下错误:
 * POSIX:CH03_CODE HY$ javac HelloDate.java
 * POSIX:CH03_CODE HY$ java HelloDate
 * 错误: 找不到或无法加载主类 HelloDate
 * 分析: javac没有报错, 而java报错了, 可能是因为package命令告诉编译器生成的class文件是
 * 归属于package命令后面的包(即文件夹)的, 而执行时, java命令的jvm没在那个包中发现那个class
 * 文件(HelloDate.class), 于是报错. */
//package net.mindview.util;                // 语义: 告诉java命令这个class属于哪个包;

import java.util.*;
import static net.mindview.util.Print.*;    // 修改环境变量之后要重启Terminal.app;

public class HelloDate{
	public static void main(String[] args){
		print("Hello, it's: ");             // Simple version of print();
		print(new Date());                  // Simple version of print();
	}
}
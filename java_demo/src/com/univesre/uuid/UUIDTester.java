package com.univesre.uuid;

import java.io.*;
import java.util.*;

/**
 * @File: UUIDTester.java
 * @Classname: UUIDTester
 * @Description: 一个工厂类, 产生各种 Haoran 想要的数据, 噫哈!
 * @Author: Haoran Ye
 * @CreateDate: 18/1/22 17:03
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class UUIDTester {

	public static void main(String[] args) {

		// 产生UUID;
		// UUID uuid = UUID.randomUUID();
		// System.out.println(uuid);
		// System.out.println(uuid.toString());
		//	060d1093-e0cb-4608-b82f-57b90b98ab28
		uuidStr2TxtFile("/Users/UNIVESRE/Desktop/uuidStr.txt", 10000);

		// 产生时间;
		// System.out.println(new Date().getTime());

		// 测试6位兑换码是否重复: 看输出;
		// verifyCouponCode("/Users/UNIVESRE/Desktop/pureSixChars.txt");

	}

	public static void uuidStr2TxtFile(String filePath, int uuidAmount) {
		try {
			// 产生UUID;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < uuidAmount; i++) {
				sb.append(UUID.randomUUID().toString() + "\n");    // "\n";
			}
			// 文件IO;
			File file = new File(filePath);
			if (!file.exists()) { file.createNewFile(); }
			// System.out.println("sb.toString(): " + sb.toString());
			PrintStream printStream = new PrintStream(new FileOutputStream(file));
			printStream.print(String.valueOf(sb));
			printStream.close();

			// 注释掉的都不能把内容写入文件, 只能创建出txt文件;
			// FileWriter fw = new FileWriter(file.getName());
			// fw.write(String.valueOf(sb));

			// BufferedWriter bw = new BufferedWriter(fw);
//			PrintWriter pw = new PrintWriter(fw);
//			pw.print(String.valueOf(sb));
//			pw.close();
			// System.out.print("String.valueOf(sb): " + String.valueOf(sb));
			// bw.write(String.valueOf(sb));
			// bw.write("Test");
			// bw.flush();
			// bw.close();
			//file();
			// fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// 测试6位兑换码是否重复: 看输出;
	public static void verifyCouponCode(String filePath) {
		File file = new File(filePath);
		Set<String> codeSet = new HashSet<String>();
		String codeStr = text2String(file); // vq5giw|eh53cx| ... |8edwve|fhfq35;
		// List<String> codeList = new ArrayList<String>();
		// System.out.println("codeStr: " + codeStr);
		String[] codeArray = codeStr.split(",");    // 用"|"就会错: codeArray's length: 349999;
		// System.out.println("codeArray's length: " + codeArray.length);
		int codeCountDup = 0;
		int codeCountIndup = 0;
		for (String str : codeArray) {
			boolean b = codeSet.add(str);
			if (!b) {
				codeCountDup ++;
				System.out.println(str);
			} else {
				codeCountIndup ++;
			}
		}
		System.out.println("codeCountDup is: " + codeCountDup + ", codeCountIndup is: " + codeCountIndup + ".");
	}

	// 从文本文件中读取字串;
	public static String text2String(File file) {
		StringBuilder result = new StringBuilder();
		String perfectFormat = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while((s = br.readLine()) != null) {    // 使用readLine方法, 一次读一行;
				result.append(s + ",");             // System.lineSeparator() => '\n';
			}
			perfectFormat = result.toString();
			perfectFormat = perfectFormat.substring(0, result.length()-1);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return perfectFormat;   // result.toString();
	}

}

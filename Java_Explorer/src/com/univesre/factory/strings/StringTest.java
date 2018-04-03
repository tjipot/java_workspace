package factory.strings;

/**
 * @File: StringTest.java
 * @Classname: StringTest
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 18/3/27 10:56
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class StringTest {

	public static void main(String args[]) {
		String str1 = "STRINGS";
		String str2 = "Strings";
		String str3 = "Strings123";

		// 不区分大小写的比较;
		int result = str1.compareToIgnoreCase(str2);
		System.out.println(result);

		result = str2.compareToIgnoreCase(str3);
		System.out.println(result);    // 3个空对比"123": 3个'-1';

		result = str3.compareToIgnoreCase(str1);
		System.out.println(result);

		// 哈希码测试;
		String Str = new String("www.runoob.com");
		System.out.println("字符串的哈希码为 :" + Str.hashCode());

		// intern()测试;
		String s = "Hello world!";
		String t = "Hello World!";
		System.out.println("Equals: " + s.equals(t));
	}
}

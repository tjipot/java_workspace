package factory.strings;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * @Project: java_demo
 * @PackageName: factory.strings
 * @CreationDate: 2018-04-24 11:11
 * @Description: 过滤非utf8的字符
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class FilterOfNonUtf8 {

	/**
	 * @Title: filterOfNonUtf8
	 * @Description: 过滤非utf8字符
	 * @Parameter: String text
	 * @Return: String(过滤后的utf8字串)
	 * @Throws: UnsupportedEncodingException
	 **/
	public static String filterOfNonUtf8(String text) throws UnsupportedEncodingException {

		/* 参考自(ref01: https://zhuanlan.zhihu.com/p/26726273): 过滤4字节的utf8字符, 另外: "经过测试第二段代码是错的, 因为它固定右
		 * 移4位导致遇到ф等字符时出现了死循环, 因为大家代码都是抄来抄去, 请大家一定注意用第一段代码.
		 * ref01的参考(ref02: http://www.cnblogs.com/mlj007/p/4325798.html), "如果想要保存任意的utf8字符, 数据必须用utf8mb4字
		 * 符集, 有些情况下, 不能变更已选定的字符集".
		 * 另外, 还可以参考(看原理, 未验证)ref03: https://www.cnblogs.com/jiu0821/p/6371544.html. */
		byte[] bytes = text.getBytes("utf-8");
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		int i = 0;
		while (i < bytes.length) {
			short b = bytes[i];
			if (b > 0) {
				buffer.put(bytes[i++]);
				continue;
			}

			b += 256; // 去掉符号位;

			if (((b >> 5) ^ 0x06) == 0) {
				buffer.put(bytes, i, 2);
				i += 2;
				// System.out.println("2");
			} else if (((b >> 4) ^ 0x0E) == 0) {
				buffer.put(bytes, i, 3);
				i += 3;
				// System.out.println("3");
			} else if (((b >> 3) ^ 0x1E) == 0) {
				i += 4;
				// System.out.println("4");
			} else if (((b >> 2) ^ 0xBE) == 0) {
				i += 5;
				// System.out.println("5");
			} else {
				i += 6;
				// System.out.println("6");
			}
		}
		buffer.flip();
		return new String(buffer.array(), "utf-8");

		// 前一次使用时有问题的参考(ref00: https://blog.csdn.net/dunkbird/article/details/51591810): 不能退出;
		/* byte[] bytes = text.getBytes("utf-8");
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		int i = 0;
		while (i < bytes.length) {
			short b = bytes[i];
			if (b > 0) {
				buffer.put(bytes[i++]);
				continue;
			}
			b += 256;
			if ((b ^ 0xC0) >> 4 == 0) {
				buffer.put(bytes, i, 2);
				i += 2;
			} else if ((b ^ 0xE0) >> 4 == 0) {
				buffer.put(bytes, i, 3);
				i += 3;
			} else if ((b ^ 0xF0) >> 4 == 0) {
				i += 4;
			}
		}
		buffer.flip();
		return new String(buffer.array(), "utf-8"); */

	}
}

package factory;

import factory.strings.FilterOfNonUtf8;
import factory.strings.ReaderOfTextFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Project: java_demo
 * @PackageName: factory
 * @CreationDate: 2018-04-24 11:15
 * @Description: 作为factory包中的主"引导"程序, 启动其它代码, 避免在Run Configuration中设置过多项目
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class MainClass {

	/**
	 * @Description: factory包下的程序"引导"入口
	 * @Throws: IOException
	 **/
	public static void main(String[] args) throws IOException {

		// 读取一个文本文件内的所有内容;
		ReaderOfTextFile readerOfTextFile = new ReaderOfTextFile();
		String strContainsNonUtf8 = readerOfTextFile.readTxtToString("/Users/UNIVESRE/Desktop/22洛书.TXT");   // 所有字串: 有可能含有非utf8的;
		// System.out.println("strContainsNonUtf8 >>> " + strContainsNonUtf8);
		String strContainsOnlyUtf8 = FilterOfNonUtf8.filterOfNonUtf8(strContainsNonUtf8);                     // 除去非utf8的字串后的字串(看实际使用的方法, 只能去除4个字节的utf8字符);
		// System.out.println("strContainsOnlyUtf8 >>> " + strContainsOnlyUtf8);

	}

}

package factory.strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Project: java_demo
 * @PackageName: factory.strings
 * @CreationDate: 2018-04-24 11:20
 * @Description: 从文件中读取内容
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ReaderOfTextFile {

	/**
	 * @Title: readTxtToString
	 * @Description: 读取一个文本文件(所有字符), ref: https://www.cnblogs.com/wylblogs/p/readFile.html
	 * @Parameter: String fileName
	 * @Return: String(文本文件内的字串)
	 * @Throws: IOException
	 **/
	public String readTxtToString(String fileName) throws IOException {
		String encoding = "UTF-8";
		File file = new File(fileName);
		Long fileLength = file.length();
		byte[] fileContent = new byte[fileLength.intValue()];
		FileInputStream in = new FileInputStream(file);
		try {
			// FileInputStream in = new FileInputStream(file);
			in.read(fileContent);
			return new String(fileContent, encoding);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			in.close();
		}
	}

}

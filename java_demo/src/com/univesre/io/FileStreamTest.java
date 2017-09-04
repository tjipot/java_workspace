package com.univesre.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamTest {

	public static void main(String[] args) {
		
		try {
			byte[] byteWriter = {11, 21, 3, 40, 5, 72, 69, 76, 76, 79, 41};
			
			//没有文件就直接创建该文件, 另一种方式是传入文件'File'对象;
			OutputStream os = new FileOutputStream("/users/univesre/desktop/FileStreamTest.txt");
			for(int i = 0; i < byteWriter.length; i++) { os.write(byteWriter[i]); }
			os.close();
			
			InputStream is = new FileInputStream("/users/univesre/desktop/FileStreamTest.txt");
			int size = is.available();
			for(int i = 0; i < size; i++) { System.out.print((char)is.read() + " "); }
			is.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}

package com.univesre.crazy_java_notes.ch17_net.s2;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName: URLDecoderTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午5:02:16
 */
public class URLDecoderTest {

	public static void main(String[] args) throws Exception{
		
		// 疯狂JAVA
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82JAVA", "utf-8");
		System.out.println(keyWord);
		
		// https://zhidao.baidu.com/question/360372487984586452.html, 喜爱夜蒲3...;
		System.out.println(URLDecoder.decode("%CF%B2%B0%AE%D2%B9%C6%D13", "GBK"));
		
		// %D3%D0%C3%BB%D3%D0%D2%BB%CA%D7%B8%E8%C4%DC%C8%C3%C4%E3%CF%EB%C6%F0%CE%D2
		String urlStr = URLEncoder.encode("有没有一首歌能让你想起我", "GBK");
		System.out.println(urlStr);

	}

}

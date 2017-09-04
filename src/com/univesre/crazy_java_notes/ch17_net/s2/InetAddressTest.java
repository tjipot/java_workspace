package com.univesre.crazy_java_notes.ch17_net.s2;

import java.net.InetAddress;

/**
 * @ClassName: InetAddressTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午5:02:10
 */
public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		
		// 根据域名获取JAVA中对应的InetAddress实例;
		InetAddress ip = InetAddress.getByName("www.crazyiter.com");
		System.out.println("Crazyit Is Reachable: " + ip.isReachable(3000));
		// 获取实例的IP字符串;
		System.out.println(ip.getHostAddress());
		
		
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("Local Machine Is Reachable: " + local.isReachable(500));
		// 获取该InetAddress实例对应的全限定域名;
		System.out.println(local.getCanonicalHostName());
		
	}
}

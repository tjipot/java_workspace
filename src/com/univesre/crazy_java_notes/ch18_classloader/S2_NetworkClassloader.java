package com.univesre.crazy_java_notes.ch18_classloader;

public class S2_NetworkClassloader extends ClassLoader{
	  
	String host;
	int port;
	
	public Class findClass(String name) {
		byte[] b = loadClassData(name);
		return defineClass(name, b, 0, b.length);
	}
	
	private byte[] loadClassData(String name) {
		// load the class data from the connection
		
		return new byte[8];
	}
}

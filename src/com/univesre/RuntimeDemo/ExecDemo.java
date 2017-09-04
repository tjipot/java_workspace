package com.univesre.RuntimeDemo;

/**
 * @ClassName: ExecDemo
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月14日 下午4:31:52
 */
public class ExecDemo {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try{
			// 应该是系统中已注册了的命令才能执行;
			p = r.exec("notepad");
		}catch(Exception e) {
			System.out.println("Error Executing notepad.");
		}

	}

}

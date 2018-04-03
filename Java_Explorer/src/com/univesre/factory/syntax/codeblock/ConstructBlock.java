package factory.syntax.codeblock;

/**
 * @Project: java_demo
 * @PackageName: factory.syntax.codeblock
 * @CreationDate: 2018-04-02 18:34
 * @Description: 演示构造代码块的使用
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ConstructBlock {

	// 作用: 将构造函数的共同代码放此块里面, 即便使用不同的构造函数创建对象, 也能共用块里面的代码(即不同构造函数的一些相同的构造操作);
	private String name;
	private int age;

	{
		System.out.println("ConstructBlock Code!");
		System.out.println("Hello..");      // 相同的代码, 移到了这里;
	}

	ConstructBlock() {
		System.out.println("Constructor Without Parameter Run..");
		// System.out.println("Hello..");   // 相同代码, 移到构造代码块中;
	}

	ConstructBlock(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Constructor With Parameter Run.. " + this.name + ", " + this.age + ".");
		// System.out.println("Hello..");   // 相同代码, 移到构造代码块中;
	}

}

class ConstructBlockDemo {

	public static void main(String[] args) {
		ConstructBlock constructBlock01 = new ConstructBlock();
		ConstructBlock constructBlock02 = new ConstructBlock("Haoran", 25);
		/*  ConstructBlock Code!
			Hello..
			Constructor Without Parameter Run..
			ConstructBlock Code!
			Hello..
			Constructor With Parameter Run.. Haoran, 25.
		* */

	}
}
